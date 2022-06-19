package com.hadoop.mr.inner9;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReducerJoinReduce extends Reducer<UserWritable, NullWritable, Text, NullWritable> {
	@Override
	protected void reduce(UserWritable key, Iterable<NullWritable> values,
			Reducer<UserWritable, NullWritable, Text, NullWritable>.Context context)
			throws IOException, InterruptedException
	{
		Iterator<NullWritable> it = values.iterator();
		it.next();
		String user = key.getUserInfo();
		while (it.hasNext()) {
			it.next();
			String age = key.getOrderInfo();
			context.write(new Text(user + "\t" + age), NullWritable.get());		//用户信息和订单信息拼接	
		}
		
	}
}
