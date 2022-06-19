package com.hadoop.mr.caller2;

import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
/**
 * 2019-12-12  19
 * 2019-12-12  13
 * 2019-12-12  19
 * 2019-12-13  10
 * 2019-12-13  19
 */
public class TestCall {

	public static void main(String[] args) {	
		Properties properties = System.getProperties();     //����
   	 properties.setProperty("HADOOP_USER_NAME", "root");//��������˺�
		Configuration conf=new Configuration();
		conf.set("fs.defaultFS", "file:///");//��ʾ�ӱ��ض�ȡ�ļ�����ļ�
		try {
			
			Job job1=Job.getInstance(conf);
			job1.setJarByClass(TestCall.class);//���һ��Ҫд�������ڼ�Ⱥ���Ҳ�����
			job1.setMapperClass(CallMapper.class);//������ҵ����mapper��
			job1.setMapOutputKeyClass(Text.class);
			job1.setMapOutputValueClass(IntWritable.class);
			job1.setReducerClass(CallReducer.class);
			job1.setOutputKeyClass(Text.class);
			job1.setOutputValueClass(IntWritable.class);			//
			FileInputFormat.setInputPaths(job1, new Path("d:/data/call.log"));
			//FileOutputFormat.setOutputPath(job1,new Path("d:/data/call/call_result"));//��reduce���������浽ָ���ļ�����
			FileOutputFormat.setOutputPath(job1,new Path("hdfs://192.168.1.100:9000/call_result"));
			boolean bool=job1.waitForCompletion(true);//�ύ��ҵ
			 System.out.println(bool);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}