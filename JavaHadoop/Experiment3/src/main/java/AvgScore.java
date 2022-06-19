import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.util.GenericOptionsParser;

public class AvgScore
{
    public static class Map extends Mapper<Object, Text, Text, IntWritable>
    {
        // 实现map函数
        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException
        {
            // 将输入的纯文本文件的数据转化成String
            String line = value.toString();
            // 将输入的数据首先按行进行分割
            StringTokenizer tokenizerArticle = new StringTokenizer(line);  //以空格分隔字符串
            // 分别对每一行进行处理
            while (tokenizerArticle.hasMoreElements())
            {
                String strName= tokenizerArticle.nextToken();  // 学生姓名部分
                String strScore = tokenizerArticle.nextToken();// 成绩部分
                Text name = new Text(strName);
                int scoreInt = Integer.parseInt(strScore);
                // 输出姓名和成绩
                context.write(name, new IntWritable(scoreInt));
            }
        }
    }

    public static class Reduce extends Reducer<Text, IntWritable, Text, IntWritable>
    {
        // 实现reduce函数
        @Override
        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
        {
            int sum = 0;
            int count = 0;
            Iterator<IntWritable> iterator = values.iterator();  //循环遍历成绩
            while (iterator.hasNext())
            {
                sum += iterator.next().get();// 计算总分
                count++;// 统计总的科目数
            }
            int average = (int) sum / count;// 计算平均成绩
            context.write(key, new IntWritable(average));
        }
    }

    public static void main(String[] args) throws Exception
    {
        Configuration conf = new Configuration();
        // 指定带运行参数的目录为输入输出目录
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        /*
         * 指定工程下的input2为文件输入目录 output2为文件输出目录 String[] ioArgs = new String[] {
         * "input2", "output2" };
         *
         * String[] otherArgs = new GenericOptionsParser(conf, ioArgs)
         * .getRemainingArgs();
         */

        if (otherArgs.length != 2)
        { // 判断路径参数是否为2个
            System.err.println("Usage: Data Deduplication <in> <out>");
            System.exit(2);
        }

        // set maprduce job name
        Job job = new Job(conf, "Score Average");
        job.setJarByClass(AvgScore.class);
        // 设置Map、Combine和Reduce处理类
        job.setMapperClass(Map.class);
        job.setCombinerClass(Reduce.class);
        job.setReducerClass(Reduce.class);
        // 设置输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        // 设置输入和输出目录
        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}