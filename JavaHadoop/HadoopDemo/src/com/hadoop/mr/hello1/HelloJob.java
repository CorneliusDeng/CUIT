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
				job.setJarByClass(HelloJob.class);// ����������
				job.setMapperClass(HelloMapper.class);//����mapper
				job.setMapOutputKeyClass(Text.class);//maper��key�������
				job.setMapOutputValueClass(IntWritable.class);//mapper�����ֵ������
				job.setReducerClass(HelloReducer.class);//����reducer
				job.setOutputKeyClass(Text.class);//reducer�����key������
				
				job.setOutputValueClass(IntWritable.class);

				// FileInputFormat.setInputPaths(job, new
				// Path("hdfs://192.168.38.100:9000/a.txt"));
				FileInputFormat.setInputPaths(job, new Path("d:/data/hello.txt"));
				FileOutputFormat.setOutputPath(job, new Path("d:/data/output/hello1"));

				if (job.waitForCompletion(true)) {
					System.out.println("���гɹ�!!!");
				} else {
					System.out.println("����ʧ��!!!");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
