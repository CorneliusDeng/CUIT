package com.hadoop.hdfs.JavaApi.CloudDisk;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class UserFile {
	public boolean uploadFile(User user, String path) throws IOException {
		boolean isSuccessed = false;
		if (user != null) {
			Configuration conf = new Configuration();
			FileSystem fs = FileSystem.get(conf);
			Path src = new Path(path);
			Path dst = new Path("/clouddisk/" + user.id); // 生成上传目标位置
			try {
				fs.copyFromLocalFile(src, dst);
				isSuccessed = true;
			} catch (IOException ex) {
			}
			fs.close();
		}
		return isSuccessed;
	}

	// 获取指定用户的专属目录中的所有文件名
	public String[] getAllFiles(String userid) throws IOException {
		String files[] = null;
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path dst = new Path("/clouddisk/" + userid); // 定位到用户专属目录
		FileStatus status[] = fs.listStatus(dst); // 返回指定Path的所有文件
		files = new String[status.length];
		for (int i = 0; i < status.length; i++) {
			files[i] = status[i].getPath().getName();
		}
		fs.close();
		return files;
	}

	// 获取指定用户的满足查询条件的所有文件
	// filter参数用来指定查询条件，一般用通配符表示，例如：a*表示字母a大头的所有文件
	public String[] searchFiles(String userid, String filter) throws IOException {
		String files[] = null;
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path dst = new Path("/clouddisk/" + userid + "/" + filter); // 生成查询模板的完整路径
		FileStatus status[] = fs.globStatus(dst); // 匹配查询
		files = new String[status.length];
		for (int i = 0; i < status.length; i++) {
			files[i] = status[i].getPath().getName();
		}
		fs.close();
		return files;
	}

	//删除指定用户已选定的所有文件
	public String delete(String userid, String[] files) throws IOException {
		String msg = "";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		for (int i = 0; i < files.length; i++) {
			Path dst = new Path("/clouddisk/" + userid + "/" + files[i]); // 生成删除对象的完整路径
			if (!fs.delete(dst, false))
				msg += "目标文件" + files[i] + "不存在，无法删除！\n";
			else
				msg += "目标文件" + files[i] + "已被删除！\n";
		}
		fs.close();
		return msg;
	}
	
	// 下载指定用户已选定的文件
	public void  download(String userid, String sfile, String dfile) throws IOException {
		String msg = "";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path src = new Path("/clouddisk/" + userid + "/" + sfile); // 生成下载对象的完整路径
		Path dst = new Path(dfile); // 生成下载后的目标存放位置
		fs.copyToLocalFile(src, dst);
		fs.close();
	}
}