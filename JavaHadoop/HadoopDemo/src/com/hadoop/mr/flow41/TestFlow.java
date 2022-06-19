package com.hadoop.mr.flow41;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class TestFlow {
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(TestFlow.class);
		//设置map-reduce类
		job.setMapperClass(FlowMapper.class);
		job.setReducerClass(FlowReducer.class);
		//设置map输出键值对类型
		job.setMapOutputKeyClass(Flow.class);
		job.setMapOutputValueClass(NullWritable.class);
		//设置reduce输出键值对类型
		job.setOutputKeyClass(Flow.class);
		job.setOutputValueClass(NullWritable.class);
		//设置本地输入输出路径
		FileInputFormat.setInputPaths(job, new Path("d:/data/source.txt"));
		FileOutputFormat.setOutputPath(job, new Path("d:/data/source"));	
		//可以动态设置路径参数
//		FileInputFormat.setInputPaths(job, new Path(args[0]));
//		FileOutputFormat.setOutputPath(job, new Path(args[1]));		
		job.waitForCompletion(true);
	}
}
     