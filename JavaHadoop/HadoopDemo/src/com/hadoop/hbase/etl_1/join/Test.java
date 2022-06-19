package com.hadoop.hbase.etl_1.join;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class Test {

	public static void main(String[] args) {
		Configuration conf=new Configuration();
		conf.set("fs.defaultFS", "file:///");
		try {
			Job job=Job.getInstance(conf);
			job.setJarByClass(Test.class);
			job.setMapperClass(JoinMapper.class);
			job.setMapOutputKeyClass(OrderDimention.class);
			job.setMapOutputValueClass(NullWritable.class);
			job.setReducerClass(JoinReducer.class);
			job.setGroupingComparatorClass(JoinGroup.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(NullWritable.class);
			FileInputFormat.setInputPaths(job, new Path("D:/data/order"));
			FileOutputFormat.setOutputPath(job, new Path("D:/data/join"));
			if(job.waitForCompletion(true))
			{
				System.out.println("³É¹¦!!!");
			}
			else
			{
				System.out.println("lllllllllllllll");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
