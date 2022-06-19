package com.hadoop.mr.hello1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

  public class HelloReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
		protected void reduce(Text key, Iterable<IntWritable> it,
				Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {

			int sum = 0;
			for (IntWritable elm : it) {
				
				sum += elm.get();
			}
//			context输出到hadoop或数据库hbase
			context.write(key, new IntWritable(sum));
			
		}

	}
