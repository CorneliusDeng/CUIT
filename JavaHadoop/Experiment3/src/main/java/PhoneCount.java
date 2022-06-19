import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.util.GenericOptionsParser;

public class PhoneCount
{
    public static class Map extends Mapper<Object, Text, Text, Text>
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
                String PriNo= tokenizerArticle.nextToken();  // 个人号码
                String PubNo = tokenizerArticle.nextToken(); // 公共号码
                Text pub = new Text(PubNo);
                Text pri = new Text(PriNo);
                // 输出公共号码和个人号码
                context.write(pub, pri);
            }
        }
    }

    public static class Reduce extends Reducer<Text, Text, Text, Text>
    {
        // 实现reduce函数
        @Override
        public void reduce(Text PubNo, Iterable<Text> PriNo, Context context) throws IOException, InterruptedException
        {
            String result = "";
            Iterator<Text> iterator = PriNo.iterator();  //循环遍历私人号码
            while (iterator.hasNext())
            {
                result = result + iterator.next().toString() + "  ";
            }
            Text RESULT = new Text(result);
            context.write(PubNo, RESULT);
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
        Job job = new Job(conf, "PhoneCount");
        job.setJarByClass(PhoneCount.class);
        // 设置Map、Combine和Reduce处理类
        job.setMapperClass(PhoneCount.Map.class);
        job.setCombinerClass(PhoneCount.Reduce.class);
        job.setReducerClass(PhoneCount.Reduce.class);
        // 设置输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        // 设置输入和输出目录
        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
