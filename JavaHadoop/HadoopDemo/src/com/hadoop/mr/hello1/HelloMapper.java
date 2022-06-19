package com.hadoop.mr.hello1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

/**
 * ��hadoop�д�����������ʱ��һ��Ҫдhadoop���ͣ����л����� ��Text,IntWritable,LognWriable DoubleBy
 * @author 
  */

public class HelloMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String values[]=value.toString().split(" ");
		for(String word:values)
		{
//			context��������� �����shuffle
			context.write(new Text(word), new IntWritable(1));
		}
		
	}

}
