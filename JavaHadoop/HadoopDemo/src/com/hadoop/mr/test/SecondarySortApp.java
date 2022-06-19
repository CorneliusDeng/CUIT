package com.hadoop.mr.test;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class SecondarySortApp {

    public static class MyMapper extends Mapper<LongWritable, Text, IntPair, IntWritable> {

        private final IntPair key = new IntPair();
        private final IntWritable value = new IntWritable();

        @Override
        public void map(LongWritable inKey, Text inValue,
                        Context context) throws IOException, InterruptedException {
            StringTokenizer itr = new StringTokenizer(inValue.toString());
            int left = 0;
            int right = 0;
            if (itr.hasMoreTokens()) {
                left = Integer.parseInt(itr.nextToken());
                if (itr.hasMoreTokens()) {
                    right = Integer.parseInt(itr.nextToken());
                }
                key.set(left, right);
                value.set(right);
                context.write(key, value);
            }
        }
    }

    /**
     * �ڷ���Ƚϵ�ʱ��ֻ�Ƚ�ԭ����key�����������key��
     */
    public static class GroupingComparator implements RawComparator<IntPair> {
        @Override
        public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
            return WritableComparator.compareBytes(b1, s1, Integer.SIZE/8, b2, s2, Integer.SIZE/8);
        }

        @Override
        public int compare(IntPair o1, IntPair o2) {
            int first1 = o1.getFirst();
            int first2 = o2.getFirst();
            return first1 - first2;
        }
    }

    public static class MyReducer extends Reducer<IntPair, IntWritable, Text, IntWritable> {
        private static final Text SEPARATOR = new Text("------------------------------------------------");
        private final Text first = new Text();

        @Override
        public void reduce(IntPair key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            context.write(SEPARATOR, null);
            first.set(Integer.toString(key.getFirst()));
            for(IntWritable value: values) {
                context.write(first, value);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String INPUT_PATH = "d:/data/secondsort.txt";
        String OUTPUT_PATH = "d:/data/secondsort";
        Properties properties = System.getProperties();     //����
      	 properties.setProperty("HADOOP_USER_NAME", "root");//��������˺�
   		
   		

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "file:///");//��ʾ�ӱ��ض�ȡ�ļ�����ļ�
//        final FileSystem fileSystem = FileSystem.get(new URI(INPUT_PATH), conf);
//        if (fileSystem.exists(new Path(OUTPUT_PATH))) {
//            fileSystem.delete(new Path(OUTPUT_PATH), true);
//        }

        Job job = Job.getInstance(conf, "SecondarySortApp");

        // ��������
        job.setJarByClass(SecondarySortApp.class);

        // ����·��
        FileInputFormat.setInputPaths(job, new Path(INPUT_PATH));
        // ���·��
        FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));

        //����Map��Reduce������
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);

        // ���麯��
        job.setGroupingComparatorClass(GroupingComparator.class);

        job.setMapOutputKeyClass(IntPair.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // ���������ʽ
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
