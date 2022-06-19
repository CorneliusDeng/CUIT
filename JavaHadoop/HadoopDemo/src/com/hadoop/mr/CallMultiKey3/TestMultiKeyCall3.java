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
			job1.setJarByClass(TestMultiKeyCall3.class);//���һ��Ҫд�������ڼ�Ⱥ���Ҳ�����
			job1.setMapperClass(CallMultiKeyMapper.class);//������ҵ����mapper��
			job1.setMapOutputKeyClass(Text.class);
			job1.setMapOutputValueClass(IntWritable.class);
			job1.setReducerClass(CallMultiKeyReducer.class);
//		job1.setPartitionerClass(CallPartition.class);
			job1.setOutputKeyClass(Text.class);
			job1.setOutputValueClass(IntWritable.class);
//			job1.setNumReduceTasks(3);//	
			FileInputFormat.setInputPaths(job1, new Path("d:/data/call_phone.log"));
			FileOutputFormat.setOutputPath(job1,new Path("d:/data/callmulti1"));//��reduce���������浽fff�ļ�����
		    boolean bool=job1.waitForCompletion(true);//�ύ��ҵ
		    if(bool)
		    {
		    	System.out.println("���гɹ�!!!");
		    }
		    else
		    {
		    	System.out.println("����ʧ��!!!");
		    }
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}