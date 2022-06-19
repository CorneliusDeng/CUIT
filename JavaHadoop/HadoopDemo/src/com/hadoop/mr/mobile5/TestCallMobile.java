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
			job1.setJarByClass(TestCallMobile.class);//���һ��Ҫд�������ڼ�Ⱥ���Ҳ�����
			job1.setMapperClass(MobileMapper.class);//������ҵ����mapper��
			job1.setMapOutputKeyClass(MobileDimention.class);
			job1.setMapOutputValueClass(IntWritable.class);
			job1.setReducerClass(MobileReducer.class);
			job1.setOutputKeyClass(MobileDimention.class);
			job1.setOutputValueClass(IntWritable.class);			//
			FileInputFormat.setInputPaths(job1, new Path("d:/data/mobile.dat"));
			FileOutputFormat.setOutputPath(job1,new Path("d:/data/mobile"));//��reduce���������浽fff�ļ�����
		    boolean bool=job1.waitForCompletion(true);//�ύ��ҵ
			 System.out.println(bool);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

