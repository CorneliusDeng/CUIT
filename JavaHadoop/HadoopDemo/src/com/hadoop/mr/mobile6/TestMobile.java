package com.hadoop.mr.mobile6;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.hadoop.mr.mobile6.Sequence.MDimention;
import com.hadoop.mr.mobile6.Sequence.MDimentionValue;

public class TestMobile implements Tool {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		//conf.set("fs.defaultFS", "file:///");
		try {
			int result = ToolRunner.run(conf, new TestMobile(), args);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Configuration conf;
	//�����xml����Configuration,�Ϳ������������У�������Ϣ��conf.get("")
	@Override
	public void setConf(Configuration conf) {
		this.conf=conf;
		this.conf.addResource("jdbc.xml");
		this.conf.addResource("mobile_sql.xml");
		this.conf.addResource("param.xml");
	}
	@Override
	public Configuration getConf() {
		// TODO Auto-generated method stub
		return conf;
	}
	@Override
	public int run(String[] args) throws Exception {
		try {
		
			Job job1=Job.getInstance(conf);
			job1.setJarByClass(TestMobile.class);//���һ��Ҫд�������ڼ�Ⱥ���Ҳ�����
			job1.setMapperClass(MMapper.class);//������ҵ����mapper��
			job1.setMapOutputKeyClass(MDimention.class);
			job1.setMapOutputValueClass(MDimentionValue.class);
			job1.setReducerClass(MReducer.class);
			job1.setOutputKeyClass(MDimention.class);
			job1.setOutputValueClass(MDimentionValue.class);	
			FileInputFormat.setInputPaths(job1, new Path("d:/data/mobile.dat"));
//			FileInputFormat.setInputPaths(job1, new Path("d:/data/mobile.dat"));
			job1.setOutputFormatClass(MySqlOutputFormat.class);
 	//FileOutputFormat.setOutputPath(job1,new Path("d:/data/mmmm"));//��reduce���������浽fff�ļ�����
		    boolean bool=job1.waitForCompletion(true);//�ύ��ҵ
			 if(bool)
			 {
				 return 1;
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
