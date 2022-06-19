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
	//如果把xml加入Configuration,就可以在整环境中，访问信息。conf.get("")
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
			job1.setJarByClass(TestMobile.class);//大家一定要写，否则在集群下找不到类
			job1.setMapperClass(MMapper.class);//设置作业对象mapper类
			job1.setMapOutputKeyClass(MDimention.class);
			job1.setMapOutputValueClass(MDimentionValue.class);
			job1.setReducerClass(MReducer.class);
			job1.setOutputKeyClass(MDimention.class);
			job1.setOutputValueClass(MDimentionValue.class);	
			FileInputFormat.setInputPaths(job1, new Path("d:/data/mobile.dat"));
//			FileInputFormat.setInputPaths(job1, new Path("d:/data/mobile.dat"));
			job1.setOutputFormatClass(MySqlOutputFormat.class);
 	//FileOutputFormat.setOutputPath(job1,new Path("d:/data/mmmm"));//把reduce的输出结果存到fff文件夹下
		    boolean bool=job1.waitForCompletion(true);//提交作业
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
