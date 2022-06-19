package com.hadoop.mr.phFlow;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class TestFlow {
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "file:///");
		try {
			Job job = Job.getInstance(conf);
			job.setJarByClass(TestFlow.class);
			//����map-reduce��
			job.setMapperClass(FlowMapper.class);
			job.setReducerClass(FlowReducer.class);
			//����map�����ֵ������
			job.setMapOutputKeyClass(Flow.class);
			job.setMapOutputValueClass(NullWritable.class);
			//����reduce�����ֵ������
			job.setOutputKeyClass(Flow.class);
			job.setOutputValueClass(NullWritable.class);
			//���ñ����������·��
			FileInputFormat.setInputPaths(job, new Path("d:/data/phflow.txt"));
			FileOutputFormat.setOutputPath(job, new Path("d:/data/phflow"));	
			//���Զ�̬����·������
//		FileInputFormat.setInputPaths(job, new Path(args[0]));
//		FileOutputFormat.setOutputPath(job, new Path(args[1]));		
			boolean bool=job.waitForCompletion(true);
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