package com.hadoop.mr.mobile6;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.hadoop.mr.mobile6.Sequence.MDimention;
import com.hadoop.mr.mobile6.Sequence.MDimentionValue;



//date phonenumber
//month phonenumber
//seasion phone
public class MMapper extends Mapper<LongWritable, Text, MDimention, MDimentionValue> {
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, MDimention, MDimentionValue>.Context context)
			throws IOException, InterruptedException {
		String values[] = value.toString().split("##");
		MDimention mdimention = new MDimention();
		
		MDimentionValue mdimentionValue=new MDimentionValue();
		mdimentionValue.setDownflow(Integer.parseInt(values[9]));
		mdimentionValue.setUpflow(Integer.parseInt(values[8]));
		
		
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				mdimention.setDate(DateUtils.toDate(values[0]));
				mdimention.setPhoneNumber(values[1]);
				mdimention.setMonth(MobileConstants.DEFAULT);
				mdimention.setSeasion(MobileConstants.DEFAULT);
				mdimention.setFlag(MobileConstants.DATE);
			}
			if(i==1)
			{
				mdimention.setDate(MobileConstants.DEFAULT);
				mdimention.setPhoneNumber(values[1]);
				mdimention.setMonth(DateUtils.toMonth(values[0]));
				mdimention.setSeasion(MobileConstants.DEFAULT);
				mdimention.setFlag(MobileConstants.MONTH);
			}
			if(i==2)
			{
				mdimention.setDate(MobileConstants.DEFAULT);
				mdimention.setPhoneNumber(values[1]);
				mdimention.setMonth(MobileConstants.DEFAULT);
				mdimention.setSeasion(DateUtils.toSesion(values[0]));
				mdimention.setFlag(MobileConstants.SEASIOIN);
			}
			
			context.write(mdimention, mdimentionValue);//每条记录输出三次
		}
	}

}
