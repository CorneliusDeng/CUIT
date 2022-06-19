package com.hadoop.mr.mobile5;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MobileMapper extends Mapper<LongWritable, Text, MobileDimention, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, MobileDimention, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String values[] = value.toString().split("##");
		MobileDimention mobileDimention=new MobileDimention();
		mobileDimention.setDate(DateUtils.toDate(values[0]));
		mobileDimention.setPhoneNumber(values[1]);
		context.write(mobileDimention, new IntWritable(Integer.parseInt(values[8])));
	}
}
