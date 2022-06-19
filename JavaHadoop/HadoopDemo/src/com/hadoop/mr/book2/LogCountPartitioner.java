package com.hadoop.mr.book2;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;
public class LogCountPartitioner extends Partitioner<MemberLogTime, IntWritable> {
	@Override
	public int getPartition(MemberLogTime key, IntWritable value, int numPartitions) {
		String date=key.getLogTime();
		if(date.contains("2016-01")){
			return 0%numPartitions;
		}else{
			return 1%numPartitions;
		}
	}
}
