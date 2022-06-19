package com.hadoop.hdfs.JavaApi.SequenceFile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import java.net.URI;
import java.util.Properties;

/**
 * SequenceFile–¥≤Ÿ◊˜
 */
public class SequenceFileWriter {
    private static Configuration configuration = new Configuration();
    private static String url = "hdfs://master:9000";

    private static String[] data ={"a,b,c,d,e,f,g","e,f,g,h,i,j,k","l,m,n,o,p,q,r,s","t,u,v,w,x,y,z"};

    public static void main(String[] args) throws Exception{
    	 Properties properties = System.getProperties();     //≈‰÷√
    	 properties.setProperty("HADOOP_USER_NAME", "root");//¥´»Î∑√Œ ’À∫≈
        FileSystem fs = FileSystem.get(URI.create(url), configuration);
        Path outputPath = new Path("MySequenceFile.seq");

        IntWritable key = new IntWritable();
        Text value = new Text();

        SequenceFile.Writer writer = SequenceFile.createWriter(fs, configuration, outputPath, IntWritable.class, Text.class);

        for (int i = 0; i < 10; i++) {
            key.set(10-i);
            value.set(data[i%data.length]);
            writer.append(key, value);
        }

        IOUtils.closeStream(writer);
    }
}
