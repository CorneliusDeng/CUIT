package com.hadoop.mr.RecordReader;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import java.io.IOException;

/**
 * �Զ���InputFormat
 */
public class MyInputFormat extends FileInputFormat<LongWritable, Text> {

    @Override
    public RecordReader<LongWritable, Text> createRecordReader(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
        //�����Զ����RecordReader
        return new RecordReaderApp.MyRecordReader();
    }

    /**
     * Ϊ��ʹ���з����ݵ�ʱ���кŲ��������ң���������Ϊ�������з�
     */
    protected boolean isSplitable(FileSystem fs, Path filename) {
        return false;
    }

}