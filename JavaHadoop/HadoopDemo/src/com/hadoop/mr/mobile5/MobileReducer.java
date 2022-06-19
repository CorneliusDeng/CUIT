package com.hadoop.mr.mobile5;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class MobileReducer extends Reducer<MobileDimention, IntWritable, MobileDimention, IntWritable> {

	@Override
	protected void reduce(MobileDimention arg0, Iterable<IntWritable> arg1,
			Reducer<MobileDimention, IntWritable, MobileDimention, IntWritable>.Context arg2)
			throws IOException, InterruptedException {
		int sum = 0;
		for (IntWritable i : arg1) {
			sum += i.get();
		}
		arg2.write(arg0, new IntWritable(sum));
	}
}
