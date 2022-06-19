package com.hadoop.mr.inner9;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class UserCityDemo {

	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		conf.set("fs.defaultFS", "file:///");
		Job job=Job.getInstance(conf);
		job.setJarByClass(UserCityDemo.class);
		job.setMapperClass(ReduceJoinMapper.class);
		job.setMapOutputKeyClass(UserWritable.class);
		job.setMapOutputValueClass(NullWritable.class);
		job.setReducerClass(ReducerJoinReduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);
		FileInputFormat.setInputPaths(job, new Path("d:/data/info"));
		FileOutputFormat.setOutputPath(job, new Path("d:/data/cus_order"));
		job.setGroupingComparatorClass(UserGroupByUserid.class);
		System.out.println(job.waitForCompletion(true));
	}

}
