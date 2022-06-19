package com.hadoop.mr.callSequence4;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class CallSeqReducer extends Reducer<CallDimentioin, IntWritable, CallDimentioin, IntWritable> {

	@Override
	protected void reduce(CallDimentioin key, Iterable<IntWritable> values,
			Reducer<CallDimentioin, IntWritable, CallDimentioin, IntWritable>.Context arg2)
			throws IOException, InterruptedException {

		int sum = 0;
		for (IntWritable i : values) {
			sum += i.get();
		}
		arg2.write(key, new IntWritable(sum));
	}
}
