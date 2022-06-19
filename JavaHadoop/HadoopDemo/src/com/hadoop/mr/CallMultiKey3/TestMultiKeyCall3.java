package com.hadoop.mr.CallMultiKey3;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class TestMultiKeyCall3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf=new Configuration();
		conf.set("fs.defaultFS", "file:///");
		try {
			Job job1=Job.getInstance(conf);
			job1.setJarByClass(TestMultiKeyCall3.class);//大家一定要写，否则在集群下找不到类
			job1.setMapperClass(CallMultiKeyMapper.class);//设置作业对象mapper类
			job1.setMapOutputKeyClass(Text.class);
			job1.setMapOutputValueClass(IntWritable.class);
			job1.setReducerClass(CallMultiKeyReducer.class);
//		job1.setPartitionerClass(CallPartition.class);
			job1.setOutputKeyClass(Text.class);
			job1.setOutputValueClass(IntWritable.class);
//			job1.setNumReduceTasks(3);//	
			FileInputFormat.setInputPaths(job1, new Path("d:/data/call_phone.log"));
			FileOutputFormat.setOutputPath(job1,new Path("d:/data/callmulti1"));//把reduce的输出结果存到fff文件夹下
		    boolean bool=job1.waitForCompletion(true);//提交作业
		    if(bool)
		    {
		    	System.out.println("运行成功!!!");
		    }
		    else
		    {
		    	System.out.println("运行失败!!!");
		    }
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}