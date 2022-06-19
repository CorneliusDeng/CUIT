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
			Path dst = new Path("/clouddisk/" + user.id); // �����ϴ�Ŀ��λ��
			try {
				fs.copyFromLocalFile(src, dst);
				isSuccessed = true;
			} catch (IOException ex) {
			}
			fs.close();
		}
		return isSuccessed;
	}

	// ��ȡָ���û���ר��Ŀ¼�е������ļ���
	public String[] getAllFiles(String userid) throws IOException {
		String files[] = null;
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path dst = new Path("/clouddisk/" + userid); // ��λ���û�ר��Ŀ¼
		FileStatus status[] = fs.listStatus(dst); // ����ָ��Path�������ļ�
		files = new String[status.length];
		for (int i = 0; i < status.length; i++) {
			files[i] = status[i].getPath().getName();
		}
		fs.close();
		return files;
	}

	// ��ȡָ���û��������ѯ�����������ļ�
	// filter��������ָ����ѯ������һ����ͨ�����ʾ�����磺a*��ʾ��ĸa��ͷ�������ļ�
	public String[] searchFiles(String userid, String filter) throws IOException {
		String files[] = null;
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path dst = new Path("/clouddisk/" + userid + "/" + filter); // ���ɲ�ѯģ�������·��
		FileStatus status[] = fs.globStatus(dst); // ƥ���ѯ
		files = new String[status.length];
		for (int i = 0; i < status.length; i++) {
			files[i] = status[i].getPath().getName();
		}
		fs.close();
		return files;
	}

	//ɾ��ָ���û���ѡ���������ļ�
	public String delete(String userid, String[] files) throws IOException {
		String msg = "";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		for (int i = 0; i < files.length; i++) {
			Path dst = new Path("/clouddisk/" + userid + "/" + files[i]); // ����ɾ�����������·��
			if (!fs.delete(dst, false))
				msg += "Ŀ���ļ�" + files[i] + "�����ڣ��޷�ɾ����\n";
			else
				msg += "Ŀ���ļ�" + files[i] + "�ѱ�ɾ����\n";
		}
		fs.close();
		return msg;
	}
	
	// ����ָ���û���ѡ�����ļ�
	public void  download(String userid, String sfile, String dfile) throws IOException {
		String msg = "";
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path src = new Path("/clouddisk/" + userid + "/" + sfile); // �������ض��������·��
		Path dst = new Path(dfile); // �������غ��Ŀ����λ��
		fs.copyToLocalFile(src, dst);
		fs.close();
	}
}