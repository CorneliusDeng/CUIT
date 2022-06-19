package com.hadoop.mr.phFlow;
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class FlowMapper extends Mapper<LongWritable, Text, Flow, NullWritable> {
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, Flow, NullWritable>.Context context)
			throws IOException, InterruptedException {
		//读取一行文本信息
		String lineMsg = value.toString();
		//对读取记录进行切分
		String arrLine[] = lineMsg.split(" ");
		Flow flow = new Flow(arrLine[0],Integer.parseInt(arrLine[1]),Integer.parseInt(arrLine[2]));
		//指定map输出的键值
		context.write(flow, NullWritable.get());
	}
}