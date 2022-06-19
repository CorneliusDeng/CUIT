package com.hadoop.mr.CallMultiKey3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class CallMultiKeyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable,
			Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String values[]=value.toString().split("\t");
		context.write(new Text(values[0]+" "+values[1]),
				new IntWritable(Integer.parseInt(values[2].trim())));
	}

}
