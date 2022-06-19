package com.hadoop.hdfs.JavaApi.test2;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Properties;

import java.net.URI;

/**
 * Java API操作HDFS
 */
public class HDFSApp {
	
    public static final String HDFS_PATH = "hdfs://192.168.1.100:9000"; 
    

    Configuration configuration = null;
    FileSystem fileSystem = null;
   

    @Before
    public void setUp() throws Exception {
    	 Properties properties = System.getProperties();     //
    	 properties.setProperty("HADOOP_USER_NAME", "root");//传入访问账号
        System.out.println("HDFSApp.setUp()");
        configuration = new Configuration();
        fileSystem = FileSystem.get(new URI(HDFS_PATH), configuration);
    }

    @After
    public void tearDown() throws Exception {
        fileSystem = null;
        configuration = null;
        System.out.println("HDFSApp.tearDown()");
    }


    /**
     * 创建目录
     */
    @Test
    public void mkdir() throws Exception {
        fileSystem.mkdirs(new Path("/hdfsgbj"));
    }

    /**
     * 创建文件
     */
    @Test
    public void create() throws Exception {
        FSDataOutputStream output = fileSystem.create(new Path("/hdfsapi/a.txt"));
        output.write("hello world".getBytes());
        output.flush();
        output.close();
    }

    /**
     * 重命名
     */
    @Test
    public void rename() throws Exception {
        Path oldPath = new Path("/hdfsapi/test/a.txt");
        Path newPath = new Path("/hdfsapi/test/b.txt");
        System.out.println(fileSystem.rename(oldPath, newPath));
    }

    /**
     * 上传本地文件到HDFS
     */
    @Test
    public void copyFromLocalFile() throws Exception {
        Path src = new Path("d:/data/word.txt");
        Path dist = new Path("/hdfsapi/test/");
        fileSystem.copyFromLocalFile(src, dist);
    }

    /**
     * 查看某个目录下的所有文件
     */
    @Test
    public void listFiles() throws Exception {
        FileStatus[] listStatus = fileSystem.listStatus(new Path("/hdfsapi/test"));
        for (FileStatus fileStatus : listStatus) {
            String isDir = fileStatus.isDirectory() ? "文件夹" : "文件";  //文件/文件夹
            String permission = fileStatus.getPermission().toString(); //权限
            short replication = fileStatus.getReplication(); //副本系数
            long len = fileStatus.getLen(); //长度
            String path = fileStatus.getPath().toString(); //路径
            System.out.println(isDir + "\t" + permission + "\t" + replication + "\t" + len + "\t" + path);
        }
    }

    /**
     * 查看文件块信息
     */
    @Test
    public void getFileBlockLocations() throws Exception {
        FileStatus fileStatus = fileSystem.getFileStatus(new Path("/hdfsapi/test/b.txt"));
        BlockLocation[] blocks = fileSystem.getFileBlockLocations(fileStatus, 0, fileStatus.getLen());
        for (BlockLocation block : blocks) {
            for (String host : block.getHosts()) {
                System.out.println(host);
            }
        }
    }
    
}
