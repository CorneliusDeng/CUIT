package com.hadoop.hdfs.JavaApi.SequenceFile;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.io.compress.BZip2Codec;
import org.apache.hadoop.util.ReflectionUtils;

import java.net.URI;

/**
 * SequenceFileÑ¹Ëõ·½Ê½Ð´²Ù×÷
 */
public class SequenceFileCompression {

    static Configuration configuration = null;
    private static String url = "hdfs://master:9000";

    static {
        configuration = new Configuration();
    }

    private static String[] data = {"a,b,c,d,e,f,g", "e,f,g,h,i,j,k",
            "l,m,n,o,p,q,r,s", "t,u,v,w,x,y,z"};

    public static void main(String[] args) throws Exception {
        FileSystem fs = FileSystem.get(URI.create(url), configuration);
        Path outputPath = new Path("MySequenceFileCompression.seq");

        IntWritable key = new IntWritable();
        Text value = new Text();

        SequenceFile.Writer writer = SequenceFile.createWriter(fs,
                configuration, outputPath, IntWritable.class, Text.class,
                SequenceFile.CompressionType.RECORD, new BZip2Codec());

        for (int i = 0; i < 10; i++) {
            key.set(10 - i);
            value.set(data[i % data.length]);
            writer.append(key, value);
        }

        IOUtils.closeStream(writer);


        Path inputPath = new Path("MySequenceFileCompression.seq");
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
