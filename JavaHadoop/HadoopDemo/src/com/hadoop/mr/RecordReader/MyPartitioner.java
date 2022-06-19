package com.hadoop.mr.RecordReader;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * �Զ���Partitioner
 */
public class MyPartitioner extends Partitioner<LongWritable, Text> {

    @Override
    public int getPartition(LongWritable key, Text value, int numPartitions) {
        //ż���ŵ��ڶ����������м���
        if (key.get() % 2 == 0) {
            //�����뵽reduce�е�key����Ϊ1
            key.set(1);
            return 1;
        } else {//�������ڵ�һ���������м���
            //�����뵽reduce�е�key����Ϊ0
            key.set(0);
            return 0;
        }
    }

}
