package com.hadoop.hdfs.JavaApi.serialize;

import org.apache.hadoop.io.Writable;

import java.io.*;

/**
 * 序列化操作
 */
public class HadoopSerializationUtil {

    public static byte[] serialize(Writable writable) throws IOException {//序列化
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream dataout = new DataOutputStream(out);
        writable.write(dataout);
        dataout.close();
        return out.toByteArray();
    }

    public static void deserialize(Writable writable, byte[] bytes)//反序列化
            throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        DataInputStream datain = new DataInputStream(in);
        writable.readFields(datain);
        datain.close();
    }

}
