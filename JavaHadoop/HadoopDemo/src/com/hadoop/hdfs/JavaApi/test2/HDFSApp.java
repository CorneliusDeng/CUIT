package com.hadoop.hdfs.JavaApi.test2;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Properties;

import java.net.URI;

/**
 * Java API����HDFS
 */
public class HDFSApp {
	
    public static final String HDFS_PATH = "hdfs://192.168.1.100:9000"; 
    

    Configuration configuration = null;
    FileSystem fileSystem = null;
   

    @Before
    public void setUp() throws Exception {
    	 Properties properties = System.getProperties();     //
    	 properties.setProperty("HADOOP_USER_NAME", "root");//��������˺�
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
     * ����Ŀ¼
     */
    @Test
    public void mkdir() throws Exception {
        fileSystem.mkdirs(new Path("/hdfsgbj"));
    }

    /**
     * �����ļ�
     */
    @Test
    public void create() throws Exception {
        FSDataOutputStream output = fileSystem.create(new Path("/hdfsapi/a.txt"));
        output.write("hello world".getBytes());
        output.flush();
        output.close();
    }

    /**
     * ������
     */
    @Test
    public void rename() throws Exception {
        Path oldPath = new Path("/hdfsapi/test/a.txt");
        Path newPath = new Path("/hdfsapi/test/b.txt");
        System.out.println(fileSystem.rename(oldPath, newPath));
    }

    /**
     * �ϴ������ļ���HDFS
     */
    @Test
    public void copyFromLocalFile() throws Exception {
        Path src = new Path("d:/data/word.txt");
        Path dist = new Path("/hdfsapi/test/");
        fileSystem.copyFromLocalFile(src, dist);
    }

    /**
     * �鿴ĳ��Ŀ¼�µ������ļ�
     */
    @Test
    public void listFiles() throws Exception {
        FileStatus[] listStatus = fileSystem.listStatus(new Path("/hdfsapi/test"));
        for (FileStatus fileStatus : listStatus) {
            String isDir = fileStatus.isDirectory() ? "�ļ���" : "�ļ�";  //�ļ�/�ļ���
            String permission = fileStatus.getPermission().toString(); //Ȩ��
            short replication = fileStatus.getReplication(); //����ϵ��
            long len = fileStatus.getLen(); //����
            String path = fileStatus.getPath().toString(); //·��
            System.out.println(isDir + "\t" + permission + "\t" + replication + "\t" + len + "\t" + path);
        }
    }

    /**
     * �鿴�ļ�����Ϣ
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
