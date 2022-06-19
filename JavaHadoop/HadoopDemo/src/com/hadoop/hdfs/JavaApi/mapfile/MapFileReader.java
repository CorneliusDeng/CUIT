package com.hadoop.hdfs.JavaApi.mapfile;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.MapFile;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.util.ReflectionUtils;

import java.net.URI;

/**
 * MapFile¶ÁÎÄ¼þ
 */
public class MapFileReader {

    static Configuration configuration = new Configuration();
    private static String url = "hdfs://hadoop000:8020";

    public static void main(String[] args) throws Exception {

        FileSystem fs = FileSystem.get(URI.create(url), configuration);
        Path inPath = new Path("MyMapFile.map");

        MapFile.Reader reader = new MapFile.Reader(fs, inPath.toString(),
                configuration);

        Writable keyclass = (Writable) ReflectionUtils.newInstance(
                reader.getKeyClass(), configuration);
        Writable valueclass = (Writable) ReflectionUtils.newInstance(
                reader.getValueClass(), configuration);

        while (reader.next((WritableComparable) keyclass, valueclass)) {
            System.out.println(keyclass);
            System.out.println(valueclass);
        }
        IOUtils.closeStream(reader);
    }

}
