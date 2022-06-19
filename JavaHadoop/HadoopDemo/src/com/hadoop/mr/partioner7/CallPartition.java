package com.hadoop.mr.partioner7;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Partitioner;

//map�������Text, IntWritable
public class CallPartition extends Partitioner<Text, IntWritable> {

	@Override
	public int getPartition(Text key, IntWritable value, int numPartitions) {
		// TODO Auto-generated method stub
//		System.out.println(numPartitions);
		
		return Math.abs(key.toString().hashCode())%2;//����hash����������2������ 0��1
	}

}
