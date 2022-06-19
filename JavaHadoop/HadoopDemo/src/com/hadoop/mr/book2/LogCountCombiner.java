package com.hadoop.mr.book2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class LogCountCombiner extends Reducer<MemberLogTime, IntWritable, MemberLogTime, IntWritable> {
	@Override
	protected void reduce(MemberLogTime key, Iterable<IntWritable> value,
			Reducer<MemberLogTime, IntWritable, MemberLogTime, IntWritable>.Context context)
					throws IOException, InterruptedException {
		int sum=0;
		for (IntWritable val : value) {
			sum+=val.get();
		}
		context.write(key, new IntWritable(sum));
	}
}
