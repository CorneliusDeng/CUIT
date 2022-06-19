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
		//��ȡһ���ı���Ϣ
		String lineMsg = value.toString();
		//�Զ�ȡ��¼�����з�
		String arrLine[] = lineMsg.split(" ");
		Flow flow = new Flow(arrLine[0],Integer.parseInt(arrLine[1]),Integer.parseInt(arrLine[2]));
		//ָ��map����ļ�ֵ
		context.write(flow, NullWritable.get());
	}
}