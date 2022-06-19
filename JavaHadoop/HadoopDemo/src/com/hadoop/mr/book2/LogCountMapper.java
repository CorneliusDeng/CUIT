package com.hadoop.mr.book2;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class LogCountMapper extends Mapper<Text, Text, MemberLogTime, IntWritable> {
	private MemberLogTime mt=new MemberLogTime();
	private IntWritable one=new IntWritable(1);
	enum LogCounter{
		January,
		February
	}
	@Override
	protected void map(Text key, Text value, Mapper<Text, Text, MemberLogTime, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String member_name=key.toString();
		String logTime=value.toString();
		if(logTime.contains("2016-01")){
			context.getCounter(LogCounter.January).increment(1);;
		}else if(logTime.contains("2016-02")){
			context.getCounter(LogCounter.February).increment(1);;
		}
		mt.setMember_name(member_name);
		mt.setLogTime(logTime);
		context.write(mt, one);
	}	
}
