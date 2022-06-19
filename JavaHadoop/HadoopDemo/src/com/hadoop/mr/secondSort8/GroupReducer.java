package com.hadoop.mr.secondSort8;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;
public class GroupReducer extends Reducer<Tempture, NullWritable, Tempture, NullWritable> {
	@Override
	protected void reduce(Tempture key, Iterable<NullWritable> it,//如年份为2012的都传给reduce ，it代表个数
			Reducer<Tempture, NullWritable, Tempture, NullWritable>.Context context) throws IOException, InterruptedException {
		it.iterator().next();
		context.write(key, NullWritable.get());//降序时拿到第一个即最高温度那个
		
		//一组调一次reduce 则每行成一组，采用MyGroupWritable进行二次排序
		
	}
}
