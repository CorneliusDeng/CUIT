package com.hadoop.mr.secondSort8;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;
public class GroupReducer extends Reducer<Tempture, NullWritable, Tempture, NullWritable> {
	@Override
	protected void reduce(Tempture key, Iterable<NullWritable> it,//�����Ϊ2012�Ķ�����reduce ��it�������
			Reducer<Tempture, NullWritable, Tempture, NullWritable>.Context context) throws IOException, InterruptedException {
		it.iterator().next();
		context.write(key, NullWritable.get());//����ʱ�õ���һ��������¶��Ǹ�
		
		//һ���һ��reduce ��ÿ�г�һ�飬����MyGroupWritable���ж�������
		
	}
}
