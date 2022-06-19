package com.hadoop.mr.caller2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CallMapper extends Mapper<LongWritable, Text, Text, IntWritable>
{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.
			Context context)
			throws IOException, InterruptedException {
		   String call[]=value.toString().split("\t");//call[0] call[1]
		   context.write(new Text(call[0]), new IntWritable(Integer.parseInt(call[1].trim())));
	}

}
