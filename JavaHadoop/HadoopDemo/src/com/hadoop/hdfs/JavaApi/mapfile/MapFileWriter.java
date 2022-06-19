package com.hadoop.hdfs.JavaApi.mapfile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.MapFile;
import org.apache.hadoop.io.Text;

import java.net.URI;
import java.util.Properties;

/**
 * MapFileд�ļ�
 */
public class MapFileWriter {

    static Configuration configuration = new Configuration();
    private static String url = "hdfs://master:9000";

    public static void main(String[] args) throws Exception {
    	 Properties properties = System.getProperties();     //����
    	 properties.setProperty("HADOOP_USER_NAME", "root");//��������˺�

        FileSystem fs = FileSystem.get(URI.create(url), configuration);
        Path outPath = new Path("MyMapFile.map");

        Text key = new Text();
        key.set("mymapkey");
        Text value = new Text();
        value.set("mymapvalue");

        MapFile.Writer writer = new MapFile.Writer(configuration, fs,
                outPath.toString(), Text.class, Text.class);

        writer.append(key, value);
        IOUtils.closeStream(writer);
    }

}
