package com.hadoop.hbase.etl_1.join;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class JoinMapper extends Mapper<LongWritable, Text, OrderDimention, NullWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, OrderDimention, NullWritable>.Context context)
			throws IOException, InterruptedException {
		String values[]=value.toString().split(" ");
		OrderDimention order=new OrderDimention();
		if(values.length==3)
		{
			order.setCustomerInfo(values[1]+" "+values[2]);
			order.setFlag(1);
			order.setUserId(values[0]);
			context.write(order, NullWritable.get());
		}
		if(values.length==5)
		{
			order.setOrderInfo(values[0]+" "+values[1]+" "+values[2]);
			order.setUserId(values[3]);
			order.setFlag(2);
			context.write(order, NullWritable.get());
		}
		
	}
}
