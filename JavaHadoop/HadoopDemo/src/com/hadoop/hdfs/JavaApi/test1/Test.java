package com.hadoop.hdfs.JavaApi.test1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public class Test {

	/**
	 * @param args
	 * JavaApi
	 */
	//alt+?���벹ȫ
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������hadoop �������ļ�
		 Properties properties = System.getProperties();     //����
    	 properties.setProperty("HADOOP_USER_NAME", "root");//��������˺�
     
   
		
		Configuration conf=new Configuration();
		//conf.set("fs.defaultFS", "file:///");
		 try {
			FileSystem fs=FileSystem.get(new URI("hdfs://192.168.1.100:9000"), conf);
		   FSDataOutputStream  out= fs.create(new Path("/a.txt"));//hadoop /
           IOUtils.copyBytes(new FileInputStream("d:/data/test.txt"), out, conf,true);//�Զ��ر�
			fs.copyFromLocalFile(new Path("d:/data/test.txt"), new Path("/JavaApi/k.txt"));
			fs.delete(new Path("/bigdata"), true);//true�ݹ�ɾ��
//			FSDataInputStream  in=fs.open(new Path("/a.txt"));
//  		  IOUtils.copyBytes(in, new FileOutputStream("d:/data/123.txt"), conf);
  	//	fs.delete(f)
			
   		//in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
//				//�����Ǽ��飬50070,9000

	}

}
