package com.hadoop.hbase.etl_1.etl;

import java.io.IOException;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import com.hadoop.hbase.etl_1.constants.EventLogConstants;

public class EtlTest {
	public static void main(String[] args) {
		Configuration conf=new Configuration();
		conf.set("fs.defaultFS", "file:///");
		conf.set("hbase.zookeeper.quorum", "192.168.1.100:2181,192.168.1.108:2181,192.168.1.109:2181");//zk和hbase位置
		try {
			Job job=Job.getInstance(conf);
			job.setJarByClass(EtlTest.class);
			job.setMapperClass(LogEtl.class);
			job.setMapOutputKeyClass(NullWritable.class);
			job.setMapOutputValueClass(Put.class);
			TableMapReduceUtil.initTableReducerJob(EventLogConstants.HBASE_NAME_EVENT_LOGS, null, job);//存到hbase
			FileInputFormat.setInputPaths(job, new Path("D:/data/log"));
			if(job.waitForCompletion(true))
		    {
				System.out.println("成功!!");
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
