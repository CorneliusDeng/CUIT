package com.hadoop.mr.inner9;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class ReduceJoinMapper extends Mapper<LongWritable, Text, UserWritable, NullWritable> {
		
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, UserWritable, NullWritable>.Context context)
			throws IOException, InterruptedException {
		
		String info[] = value.toString().split("\t");		
		UserWritable userWritable = new UserWritable();
		FileSplit split=(FileSplit)context.getInputSplit();
		String name=split.getPath().getName();	//得到文件名	
		if (name.equals("A.txt")) {
			userWritable.setUserId(info[0]);
			userWritable.setUserInfo(value.toString());
			userWritable.setFlag(Constants.A);//A类型
			context.write(userWritable, NullWritable.get());
		}		
		if (name.equals("B.txt")) {
			userWritable.setUserId(info[0]);
			userWritable.setOrderInfo(value.toString());
			userWritable.setFlag(Constants.B);
			context.write(userWritable, NullWritable.get());//发给shuffle
		}
	
	}
}
