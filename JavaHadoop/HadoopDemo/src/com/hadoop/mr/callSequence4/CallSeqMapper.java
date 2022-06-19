package com.hadoop.mr.callSequence4;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CallSeqMapper extends Mapper<LongWritable, Text, CallDimentioin, IntWritable> {
	@Override
	protected void map(LongWritable key, Text value,//key是序列化对象
			Mapper<LongWritable, Text, CallDimentioin, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String values[]=value.toString().split("\t");
	
		
		CallDimentioin call=new CallDimentioin();
		call.setDate(values[0]);
		call.setPhoneNumber(values[1]);
		
		
		context.write(call, new IntWritable(Integer.parseInt(values[2])));
		
	}
}
