package com.hadoop.mr.secondSort8;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class Test implements Tool {

	public static void main(String[] args) {
		try {
			int flag = ToolRunner.run(new Test(), args);
			System.out.println(flag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Configuration conf = new Configuration();

	@Override
	public void setConf(Configuration conf) {
		this.conf = conf;
	}

	@Override
	public Configuration getConf() {
		// TODO Auto-generated method stub
		conf.set("fs.defaultFS", "file:///");
		return conf;
	}

	@Override
	//二次排序解决的是利用key进行对值进行排序，再利用二次排序对数据重新分组
	public int run(String[] args) throws Exception {
		//求每年当中的最高温度，hadoop不能对value进行排序（shuffle只对key进行排序）
		Job job = Job.getInstance(getConf());
		job.setJarByClass(Test.class);
		job.setMapperClass(GroupMapper.class);
		job.setMapOutputKeyClass(Tempture.class);
		job.setMapOutputValueClass(NullWritable.class);
		job.setReducerClass(GroupReducer.class);
		job.setOutputKeyClass(Tempture.class);
		job.setOutputValueClass(NullWritable.class);
	    job.setGroupingComparatorClass(MyGroupWritable.class);
	    FileOutputFormat.setOutputPath(job, new Path("d:/data/temptureout"));
	    FileInputFormat.setInputPaths(job, new Path("d:/data/tempture.txt"));
		if (job.waitForCompletion(true))
			return 1;
		else
			return 0;
	}

}
