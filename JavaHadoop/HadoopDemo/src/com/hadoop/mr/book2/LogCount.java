package com.hadoop.mr.book2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileAsTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
public class LogCount extends Configured implements Tool{
	public static void main(String[] args){
		String[] myArgs={
				"/user/root/user_login/JanFeb/part-m-00000",
				"/user/root/user_login/logcount"
		};
		
		try {
			ToolRunner.run(LogCount.getMyConfiguration(), new LogCount(), myArgs);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	@Override
	public int run(String[] args) throws Exception {
		Configuration conf=LogCount.getMyConfiguration();
		Job job=Job.getInstance(conf, "logcount");
		job.setJarByClass(LogCount.class);
		job.setMapperClass(LogCountMapper.class);
		job.setReducerClass(LogCountReducer.class);
		job.setCombinerClass(LogCountCombiner.class);
		job.setPartitionerClass(LogCountPartitioner.class);
		job.setNumReduceTasks(2);
		job.setOutputKeyClass(MemberLogTime.class);
		job.setOutputValueClass(IntWritable.class);
		job.setInputFormatClass(SequenceFileAsTextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileSystem.get(conf).delete(new Path(args[1]), true);
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		return job.waitForCompletion(true)?-1:1;
	}
	public static Configuration getMyConfiguration(){
		//声明配置
		Configuration conf = new Configuration();
		conf.setBoolean("mapreduce.app-submission.cross-platform",true);
		conf.set("fs.defaultFS", "hdfs://master:9000");// 指定namenode
		conf.set("mapreduce.framework.name","yarn"); // 指定使用yarn框架
		String resourcenode="master";
		conf.set("yarn.resourcemanager.address", resourcenode+":8032"); // 指定resourcemanager
		conf.set("yarn.resourcemanager.scheduler.address",resourcenode+":8030");// 指定资源分配器
		conf.set("mapreduce.jobhistory.address",resourcenode+":10020");
		conf.set("mapreduce.job.jar",JarUtil.jar(LogCount.class));
		return conf;	
	}
}
