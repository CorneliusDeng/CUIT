package com.hadoop.hdfs.JavaApi.SequenceFile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ReflectionUtils;

import java.net.URI;
import java.util.Properties;

/**
 * SequenceFile??????
 */
public class SequenceFileReader {

    static Configuration configuration = new Configuration();
    private static String url = "hdfs://master:9000";

    public static void main(String[] args) throws Exception{
    	Properties properties = System.getProperties();     //????
   	 properties.setProperty("HADOOP_USER_NAME", "root");//?????????˺?
        FileSystem fs = FileSystem.get(URI.create(url), configuration);
        Path inputPath = new Path("MySequenceFile.seq");

        SequenceFile.Reader reader = new SequenceFile.Reader(fs,inputPath,configuration);

        Writable keyClass = (Writable) ReflectionUtils.newInstance(reader.getKeyClass(), configuration);
        Writable valueClass = (Writable) ReflectionUtils.newInstance(reader.getValueClass(), configuration);
        while(reader.next(keyClass, valueClass)){
            System.out.println("key : " + keyClass);
            System.out.println("value : " + valueClass);
            System.out.println("position : " + reader.getPosition());
        }

        IOUtils.closeStream(reader);
    }
}
