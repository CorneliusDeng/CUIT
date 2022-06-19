import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCount
{
    public static class MyMapper extends Mapper<Object, Text, Text, IntWritable>
    {
        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException
        {
            //获取每一行的内容并进行拆分
            String[] content = value.toString().split("\t");

            //给每个类别后面加上标记“<>L”
            String label = content[0] + "<>L";
            //获取当前行的特征集合
            String[] features = content[1].split(" ");

            //输出一次类别计数，每一条实例都会有一个类别
            context.write(new Text(label), new IntWritable(1));
            //遍历features的内容
            for (String feature : features)
            {
                //获取特征：feature，给一个标记“<>f”
                feature = feature + "<>F";
                //输出一次该特征计数
                context.write(new Text(feature), new IntWritable(1));
                //取出一次类别下该特征计数
                context.write(new Text(label + feature), new IntWritable(1));
            }
        }
    }

    public static class MyReducer extends Reducer<Text, IntWritable, Text, IntWritable>
    {
        private IntWritable result = new IntWritable();

        @Override
        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
        {
            int sum = 0;
            for (IntWritable val : values)
            {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
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
        Job job = new Job(conf, "WordCount");
        job.setJarByClass(WordCount.class);
        // 设置Map、Combine和Reduce处理类
        job.setMapperClass(WordCount.MyMapper.class);
        job.setCombinerClass(WordCount.MyReducer.class);
        job.setReducerClass(WordCount.MyReducer.class);
        // 设置输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        // 设置输入和输出目录
        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
