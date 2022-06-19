package com.hadoop.mr.mobile5;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class TestCallMobile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf=new Configuration();
		conf.set("fs.defaultFS", "file:///");
		try {
			Job job1=Job.getInstance(conf);
			job1.setJarByClass(TestCallMobile.class);//大家一定要写，否则在集群下找不到类
			job1.setMapperClass(MobileMapper.class);//设置作业对象mapper类
			job1.setMapOutputKeyClass(MobileDimention.class);
			job1.setMapOutputValueClass(IntWritable.class);
			job1.setReducerClass(MobileReducer.class);
			job1.setOutputKeyClass(MobileDimention.class);
			job1.setOutputValueClass(IntWritable.class);			//
			FileInputFormat.setInputPaths(job1, new Path("d:/data/mobile.dat"));
			FileOutputFormat.setOutputPath(job1,new Path("d:/data/mobile"));//把reduce的输出结果存到fff文件夹下
		    boolean bool=job1.waitForCompletion(true);//提交作业
			 System.out.println(bool);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

