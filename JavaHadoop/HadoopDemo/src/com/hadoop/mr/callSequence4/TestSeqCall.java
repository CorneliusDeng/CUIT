package com.hadoop.mr.callSequence4;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 
 *按日期和手机号 求上行流量的和
 *按月和手机号求上行流量和
 */
public class TestSeqCall {

	public static void main(String[] args) {		
		Configuration conf=new Configuration();		
		conf.set("fs.defaultFS", "file:///");
		try {
			Job job1=Job.getInstance(conf);
			job1.setJarByClass(TestSeqCall.class);//大家一定要写，否则在集群下找不到类
			job1.setMapperClass(CallSeqMapper.class);//设置作业对象mapper类
			job1.setMapOutputKeyClass(CallDimentioin.class);
			job1.setMapOutputValueClass(IntWritable.class);
			job1.setReducerClass(CallSeqReducer.class);
			job1.setOutputKeyClass(CallDimentioin.class);
			job1.setOutputValueClass(IntWritable.class);			
			FileInputFormat.setInputPaths(job1, new Path("d:/data/call_phone.log"));
			FileOutputFormat.setOutputPath(job1,new Path("d:/data/call_phone1"));//把reduce的输出结果存到fff文件夹下
		    boolean bool=job1.waitForCompletion(true);//提交作业
			 System.out.println(bool);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
