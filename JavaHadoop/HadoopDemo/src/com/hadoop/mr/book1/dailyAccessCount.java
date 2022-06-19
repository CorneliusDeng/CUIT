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
 * 按日期统计用户访问次数
 */
public class dailyAccessCount {

  public static class MyMapper 
       extends Mapper<Object, Text, Text, IntWritable>{
	    
	private final static IntWritable one = new IntWritable(1);    
      
    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
    	 String line = value.toString();  
         String array[] = line.split(",");  //指定空格为分隔符，组成数组
         String keyOutput = array[1];       //提取数组中的访问日期做为Key
         context.write(new Text(keyOutput), one); //组成键值对
      }
    }
  
  public static class MyReducer 
       extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values, 
                       Context context
                       ) throws IOException, InterruptedException {
      int sum = 0; //定义累加器，初始值为0
      for (IntWritable val : values) {
        sum += val.get(); // 将相同键的所有值进行累加
      }
      result.set(sum);
      context.write(key,result); 
    }
  }
  
  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
    if (otherArgs.length < 2) {
      System.err.println("Usage: wordcount <in> [<in>...] <out>");
      System.exit(2);
    }
    Job job = new Job(conf, "Daily Access Count");
    job.setJarByClass(dailyAccessCount.class);
    job.setMapperClass(MyMapper.class);
    job.setReducerClass(MyReducer.class);
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(IntWritable.class);
    
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
