package com.hadoop.mr.hello1;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.*;


public class HelloJob {
	
		public static void main(String[] args) {
			Configuration conf = new Configuration();
			try {
				Job job = Job.getInstance(conf);
				job.setJarByClass(HelloJob.class);// 设置主方法
				job.setMapperClass(HelloMapper.class);//设置mapper
				job.setMapOutputKeyClass(Text.class);//maper的key输出类型
				job.setMapOutputValueClass(IntWritable.class);//mapper的输出值的类型
				job.setReducerClass(HelloReducer.class);//设置reducer
				job.setOutputKeyClass(Text.class);//reducer的输出key的类型
				
				job.setOutputValueClass(IntWritable.class);

				// FileInputFormat.setInputPaths(job, new
				// Path("hdfs://192.168.38.100:9000/a.txt"));
				FileInputFormat.setInputPaths(job, new Path("d:/data/hello.txt"));
				FileOutputFormat.setOutputPath(job, new Path("d:/data/output/hello1"));

				if (job.waitForCompletion(true)) {
					System.out.println("运行成功!!!");
				} else {
					System.out.println("运行失败!!!");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
