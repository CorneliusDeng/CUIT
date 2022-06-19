package com.hadoop.mr.RecordReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.LineReader;

import java.io.IOException;
import java.net.URI;

/**
 * 自定义RecordReader在MapReduce中的使用
 */
public class RecordReaderApp {

    public static class MyRecordReader extends RecordReader<LongWritable, Text> {

        //起始位置(相对整个分片而言)
        private long start;

        //结束位置(相对整个分片而言)
        private long end;

        //当前位置
        private long pos;

        //文件输入流
        private FSDataInputStream fin = null;
        //key、value
        private LongWritable key = null;
        private Text value = null;
        //定义行阅读器(hadoop.util包下的类)
        private LineReader reader = null;

        @Override
        public void initialize(InputSplit split, TaskAttemptContext context) throws IOException {

            //获取分片
            FileSplit fileSplit = (FileSplit) split;
            //获取起始位置
            start = fileSplit.getStart();
            //获取结束位置
            end = start + fileSplit.getLength();
            //创建配置
            Configuration conf = context.getConfiguration();
            //获取文件路径
            Path path = fileSplit.getPath();
            //根据路径获取文件系统
            FileSystem fileSystem = path.getFileSystem(conf);
            //打开文件输入流
            fin = fileSystem.open(path);
            //找到开始位置开始读取
            fin.seek(start);
            //创建阅读器
            reader = new LineReader(fin);
            //将当期位置置为1
            pos = 1;

        }

        @Override
        public boolean nextKeyValue() throws IOException, InterruptedException {
            if (key == null) {
                key = new LongWritable();
            }
            key.set(pos);
            if (value == null) {
                value = new Text();
            }
            if (reader.readLine(value) == 0) {
                return false;
            }
            pos++;

            return true;

        }

        @Override
        public LongWritable getCurrentKey() throws IOException, InterruptedException {
            return key;
        }

        @Override
        public Text getCurrentValue() throws IOException, InterruptedException {
            return value;
        }

        @Override
        public float getProgress() throws IOException, InterruptedException {

            return 0;
        }

        @Override
        public void close() throws IOException {
            fin.close();

        }

    }




    public static class MyMapper extends Mapper<LongWritable, Text, LongWritable, Text> {
        @Override
        protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, LongWritable, Text>.Context context) throws IOException,
                InterruptedException {
            // 直接将读取的记录写出去
            context.write(key, value);
        }
    }

    public static class MyReducer extends Reducer<LongWritable, Text, Text, LongWritable> {

        // 创建写出去的key和value
        private Text outKey = new Text();
        private LongWritable outValue = new LongWritable();

        protected void reduce(LongWritable key, Iterable<Text> values, Reducer<LongWritable, Text, Text, LongWritable>.Context context) throws IOException,
                InterruptedException {

            System.out.println("奇数行还是偶数行：" + key);

            // 定义求和的变量
            long sum = 0;
            // 遍历value求和
            for (Text val : values) {
                // 累加
                sum += Long.parseLong(val.toString());
            }

            // 判断奇偶数
            if (key.get() == 0) {
                outKey.set("奇数之和为：");
            } else {
                outKey.set("偶数之和为：");

            }
            // 设置value
            outValue.set(sum);

            // 把结果写出去
            context.write(outKey, outValue);
        }
    }

    // driver
    public static void main(String[] args) throws Exception {

        String INPUT_PATH = "hdfs://hadoop000:8020/recordreader";
        String OUTPUT_PATH = "hdfs://hadoop000:8020/outputrecordreader";

        Configuration conf = new Configuration();
        final FileSystem fileSystem = FileSystem.get(new URI(INPUT_PATH), conf);
        if (fileSystem.exists(new Path(OUTPUT_PATH))) {
            fileSystem.delete(new Path(OUTPUT_PATH), true);
        }

        Job job = Job.getInstance(conf, "RecordReaderApp");

        // run jar class
        job.setJarByClass(RecordReaderApp.class);

        // 1.1 设置输入目录和设置输入数据格式化的类
        FileInputFormat.setInputPaths(job, INPUT_PATH);
        job.setInputFormatClass(MyInputFormat.class);

        // 1.2 设置自定义Mapper类和设置map函数输出数据的key和value的类型
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);

        // 1.3 设置分区和reduce数量(reduce的数量，和分区的数量对应，因为分区为一个，所以reduce的数量也是一个)
        job.setPartitionerClass(MyPartitioner.class);
        job.setNumReduceTasks(2);

        // 2.1 Shuffle把数据从Map端拷贝到Reduce端。
        // 2.2 指定Reducer类和输出key和value的类型
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 2.3 指定输出的路径和设置输出的格式化类
        FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));
        job.setOutputFormatClass(TextOutputFormat.class);


        // 提交job
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}