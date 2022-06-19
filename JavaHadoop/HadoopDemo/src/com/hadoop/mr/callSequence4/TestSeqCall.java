package com.hadoop.mr.callSequence4;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 
 *�����ں��ֻ��� �����������ĺ�
 *���º��ֻ���������������
 */
public class TestSeqCall {

	public static void main(String[] args) {		
		Configuration conf=new Configuration();		
		conf.set("fs.defaultFS", "file:///");
		try {
			Job job1=Job.getInstance(conf);
			job1.setJarByClass(TestSeqCall.class);//���һ��Ҫд�������ڼ�Ⱥ���Ҳ�����
			job1.setMapperClass(CallSeqMapper.class);//������ҵ����mapper��
			job1.setMapOutputKeyClass(CallDimentioin.class);
			job1.setMapOutputValueClass(IntWritable.class);
			job1.setReducerClass(CallSeqReducer.class);
			job1.setOutputKeyClass(CallDimentioin.class);
			job1.setOutputValueClass(IntWritable.class);			
			FileInputFormat.setInputPaths(job1, new Path("d:/data/call_phone.log"));
			FileOutputFormat.setOutputPath(job1,new Path("d:/data/call_phone1"));//��reduce���������浽fff�ļ�����
		    boolean bool=job1.waitForCompletion(true);//�ύ��ҵ
			 System.out.println(bool);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
