package com.hadoop.mr.hello1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

/**
 * 在hadoop里，写输入输出类型时，一定要写hadoop类型（序列化类型 ）Text,IntWritable,LognWriable DoubleBy
 * @author 
  */

public class HelloMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String values[]=value.toString().split(" ");
		for(String word:values)
		{
//			context用来做输出 输出给shuffle
			context.write(new Text(word), new IntWritable(1));
		}
		
	}

}
