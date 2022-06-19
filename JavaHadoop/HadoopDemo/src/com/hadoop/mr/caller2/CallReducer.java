package com.hadoop.mr.caller2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CallReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context k) throws IOException, InterruptedException {
		
		int sum=0;
		for(IntWritable val:values)
		{
			sum+=val.get();
		}
		k.write(key, new IntWritable(sum));
	}
}
