package com.hadoop.mr.CallMultiKey3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CallMultiKeyReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context arg2) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int sum = 0;
		for (IntWritable w : values) {
			sum += w.get();
		}
		

		arg2.write(key, new IntWritable(sum));
	}
}
