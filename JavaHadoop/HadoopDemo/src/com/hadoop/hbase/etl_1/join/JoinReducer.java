package com.hadoop.hbase.etl_1.join;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<OrderDimention, NullWritable, Text, NullWritable> {

	@Override
	protected void reduce(OrderDimention arg0, Iterable<NullWritable> arg1,
			Reducer<OrderDimention, NullWritable, Text, NullWritable>.Context arg2)
			throws IOException, InterruptedException {
		Iterator<NullWritable> it= arg1.iterator();
		it.next();
		String key=arg0.getCustomerInfo();
		while(it.hasNext())
		{
			it.next();
			String line=key+" "+arg0.getOrderInfo();
			arg2.write(new Text(line), NullWritable.get());			
		}
	}
}
