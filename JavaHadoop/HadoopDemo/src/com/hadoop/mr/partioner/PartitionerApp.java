package com.hadoop.mr.partioner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.net.URI;

/**
 * 自定义Partitoner在MapReduce中的应用
 */
public class PartitionerApp {

    private static class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        @Override
        protected void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            String[] s = value.toString().split(" ");
            context.write(new Text(s[0]), new IntWritable(Integer.parseInt(s[1])));
        }

    }

    private static class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

        @Override
        protected void reduce(Text key, Iterable<IntWritable> value, Context context)
                throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : value) {
                sum += val.get();
            }
            context.write(key, new IntWritable(sum));
        }

    }

    public static class MyPartitioner extends Partitioner<Text, IntWritable> {

        //转发给4个不同的reducer
        @Override
        public int getPartition(Text key, IntWritable value, int numPartitons) {
            if (key.toString().equals("xiaomi"))
                return 0;
            if (key.toString().equals("huawei"))
                return 1;
            if (key.toString().equals("iphone7"))
                return 2;
            return 3;
        }
    }


    // driver
    public static void main(String[] args) throws Exception {

        String INPUT_PATH = "d:/data/partitioner.txt";
        String OUTPUT_PATH = "d:/data/outputpartitioner";

        Configuration conf = new Configuration();
//        final FileSystem fileSystem = FileSystem.get(new URI(INPUT_PATH), conf);
//        if (fileSystem.exists(new Path(OUTPUT_PATH))) {
//            fileSystem.delete(new Path(OUTPUT_PATH), true);
//        }

        Job job = Job.getInstance(conf, "PartitionerApp");

        // run jar class
        job.setJarByClass(PartitionerApp.class);

        // 设置map
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 设置reduce
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //设置Partitioner
        job.setPartitionerClass(MyPartitioner.class);
        //设置4个reducer，每个分区一个
        job.setNumReduceTasks(4);


        // input formart
        job.setInputFormatClass(TextInputFormat.class);
        Path inputPath = new Path(INPUT_PATH);
        FileInputFormat.addInputPath(job, inputPath);

        // output format
        job.setOutputFormatClass(TextOutputFormat.class);
        Path outputPath = new Path(OUTPUT_PATH);
        FileOutputFormat.setOutputPath(job, outputPath);

        // 提交job
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
