package com.hadoop.mr.book1;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
/*
 * 按访问次排序
 */
public class accessTimesSort {
	
public static class MyMapper 
extends Mapper<Object, Text,IntWritable,Text>{

public void map(Object key, Text value, Context context
             ) throws IOException, InterruptedException {
	
	 String lines = value.toString();  
	 String array[] = lines.split("\t");         //指定tab为分隔符，组成数组
	 int keyOutput = Integer.parseInt(array[1]); //提取访问次数做为Key
	 String valueOutput = array[0];              //提取访问日期做为Values
	 context.write(new IntWritable(keyOutput), new Text(valueOutput)); 
 }
}

public static class MyReducer 
extends Reducer<IntWritable,Text,Text,IntWritable> {

public void reduce(IntWritable key, Iterable<Text> values, 
                Context context
                ) throws IOException, InterruptedException {
    for(Text value : values){
        context.write(value, key);
    }
  }
}

	public static void main(String[] args) throws Exception{
	    Configuration conf = new Configuration();
	    String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
	    if (otherArgs.length < 2) {
	      System.err.println("Usage: wordcount <in> [<in>...] <out>");
	      System.exit(2);
	    }
	    Job job = new Job(conf, "Access Time Sort");
	    job.setJarByClass(accessTimesSort.class);
	    job.setMapperClass(MyMapper.class);
	    job.setReducerClass(MyReducer.class);
	    job.setMapOutputKeyClass(IntWritable.class);
	    job.setMapOutputValueClass(Text.class);
	    
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);
	    
	    for (int i = 0; i < otherArgs.length - 1; ++i) {
	      FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
	    }
	    FileOutputFormat.setOutputPath(job,
	      new Path(otherArgs[otherArgs.length - 1]));
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
