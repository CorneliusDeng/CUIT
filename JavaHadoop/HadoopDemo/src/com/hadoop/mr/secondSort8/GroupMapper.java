package com.hadoop.mr.secondSort8;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class GroupMapper extends Mapper<LongWritable, Text, Tempture, NullWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Tempture, NullWritable>.Context context)
			throws IOException, InterruptedException {		
		String values[] = value.toString().split(" ");//读一行
		Tempture temp=new Tempture();
		temp.setYear(values[0]);
		temp.setTemp(Integer.parseInt(values[1]));
		context.write(temp, NullWritable.get());//value为空，输出到shuffle
	}
}
