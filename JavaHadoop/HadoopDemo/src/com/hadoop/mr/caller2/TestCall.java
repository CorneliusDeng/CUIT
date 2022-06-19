package com.hadoop.mr.caller2;

import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
/**
 * 2019-12-12  19
 * 2019-12-12  13
 * 2019-12-12  19
 * 2019-12-13  10
 * 2019-12-13  19
 */
public class TestCall {

	public static void main(String[] args) {	
		Properties properties = System.getProperties();     //配置
   	 properties.setProperty("HADOOP_USER_NAME", "root");//传入访问账号
		Configuration conf=new Configuration();
		conf.set("fs.defaultFS", "file:///");//表示从本地读取文件输出文件
		try {
			
			Job job1=Job.getInstance(conf);
			job1.setJarByClass(TestCall.class);//大家一定要写，否则在集群下找不到类
			job1.setMapperClass(CallMapper.class);//设置作业对象mapper类
			job1.setMapOutputKeyClass(Text.class);
			job1.setMapOutputValueClass(IntWritable.class);
			job1.setReducerClass(CallReducer.class);
			job1.setOutputKeyClass(Text.class);
			job1.setOutputValueClass(IntWritable.class);			//
			FileInputFormat.setInputPaths(job1, new Path("d:/data/call.log"));
			//FileOutputFormat.setOutputPath(job1,new Path("d:/data/call/call_result"));//把reduce的输出结果存到指定文件夹下
			FileOutputFormat.setOutputPath(job1,new Path("hdfs://192.168.1.100:9000/call_result"));
			boolean bool=job1.waitForCompletion(true);//提交作业
			 System.out.println(bool);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}