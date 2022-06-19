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
 * �Զ���RecordReader��MapReduce�е�ʹ��
 */
public class RecordReaderApp {

    public static class MyRecordReader extends RecordReader<LongWritable, Text> {

        //��ʼλ��(���������Ƭ����)
        private long start;

        //����λ��(���������Ƭ����)
        private long end;

        //��ǰλ��
        private long pos;

        //�ļ�������
        private FSDataInputStream fin = null;
        //key��value
        private LongWritable key = null;
        private Text value = null;
        //�������Ķ���(hadoop.util���µ���)
        private LineReader reader = null;

        @Override
        public void initialize(InputSplit split, TaskAttemptContext context) throws IOException {

            //��ȡ��Ƭ
            FileSplit fileSplit = (FileSplit) split;
            //��ȡ��ʼλ��
            start = fileSplit.getStart();
            //��ȡ����λ��
            end = start + fileSplit.getLength();
            //��������
            Configuration conf = context.getConfiguration();
            //��ȡ�ļ�·��
            Path path = fileSplit.getPath();
            //����·����ȡ�ļ�ϵͳ
            FileSystem fileSystem = path.getFileSystem(conf);
            //���ļ�������
            fin = fileSystem.open(path);
            //�ҵ���ʼλ�ÿ�ʼ��ȡ
            fin.seek(start);
            //�����Ķ���
            reader = new LineReader(fin);
            //������λ����Ϊ1
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
            // ֱ�ӽ���ȡ�ļ�¼д��ȥ
            context.write(key, value);
        }
    }

    public static class MyReducer extends Reducer<LongWritable, Text, Text, LongWritable> {

        // ����д��ȥ��key��value
        private Text outKey = new Text();
        private LongWritable outValue = new LongWritable();

        protected void reduce(LongWritable key, Iterable<Text> values, Reducer<LongWritable, Text, Text, LongWritable>.Context context) throws IOException,
                InterruptedException {

            System.out.println("�����л���ż���У�" + key);

            // ������͵ı���
            long sum = 0;
            // ����value���
            for (Text val : values) {
                // �ۼ�
                sum += Long.parseLong(val.toString());
            }

            // �ж���ż��
            if (key.get() == 0) {
                outKey.set("����֮��Ϊ��");
            } else {
                outKey.set("ż��֮��Ϊ��");

            }
            // ����value
            outValue.set(sum);

            // �ѽ��д��ȥ
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

        // 1.1 ��������Ŀ¼�������������ݸ�ʽ������
        FileInputFormat.setInputPaths(job, INPUT_PATH);
        job.setInputFormatClass(MyInputFormat.class);

        // 1.2 �����Զ���Mapper�������map����������ݵ�key��value������
        job.setMapperClass(MyMapper.class);
        job.setMapOutputKeyClass(LongWritable.class);
        job.setMapOutputValueClass(Text.class);

        // 1.3 ���÷�����reduce����(reduce���������ͷ�����������Ӧ����Ϊ����Ϊһ��������reduce������Ҳ��һ��)
        job.setPartitionerClass(MyPartitioner.class);
        job.setNumReduceTasks(2);

        // 2.1 Shuffle�����ݴ�Map�˿�����Reduce�ˡ�
        // 2.2 ָ��Reducer������key��value������
        job.setReducerClass(MyReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        // 2.3 ָ�������·������������ĸ�ʽ����
        FileOutputFormat.setOutputPath(job, new Path(OUTPUT_PATH));
        job.setOutputFormatClass(TextOutputFormat.class);


        // �ύjob
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}