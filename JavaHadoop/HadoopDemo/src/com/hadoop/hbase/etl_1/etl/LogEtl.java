package com.hadoop.hbase.etl_1.etl;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.hadoop.hbase.etl_1.util.LogUtils;
import com.hadoop.hbase.etl_1.constants.EventLogConstants;

public class LogEtl extends Mapper<LongWritable, Text, NullWritable, Put> 
{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, NullWritable, Put>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		HashMap<String, String> maps = new HashMap<>();
		LogUtils.handler(line, maps);
		if (maps.size() > 0) {
			processMaps(maps, context);
		}
	}

	public String formatPartion(int part) {
		DecimalFormat dft = new DecimalFormat("00");
		return dft.format(part);
	}

	public String getPartitions(String event) {
		int part = Math.abs(event.hashCode() % 3);//三台服务器
		return formatPartion(part);
	}

	public String toDate(String clientTime) {
		
		if (!clientTime.equals("ctime")) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");			
			clientTime=sdf.format(new Date(Long.parseLong(clientTime)));
		}
		return clientTime;
	}

	public void processMaps(HashMap<String, String> maps,
			Mapper<LongWritable, Text, NullWritable, Put>.Context context) {
		String en = maps.get(EventLogConstants.LOG_COLUMN_NAME_EVENT_NAME) == null ? "no_event"
				: maps.get(EventLogConstants.LOG_COLUMN_NAME_EVENT_NAME);
		String part = getPartitions(en);
		String uid = maps.get(EventLogConstants.LOG_COLUMN_NAME_UUID) == null ? "uid"
				: maps.get(EventLogConstants.LOG_COLUMN_NAME_UUID);
		String sid = maps.get(EventLogConstants.LOG_COLUMN_NAME_SESSION_ID) == null ? "sid"
				: maps.get(EventLogConstants.LOG_COLUMN_NAME_SESSION_ID);
		String time = toDate(maps.get(EventLogConstants.LOG_COLUMN_NAME_CLIENT_TIME) == null ? "ctime"
				: maps.get(EventLogConstants.LOG_COLUMN_NAME_CLIENT_TIME));
		String key=part+","+en+","+time+","+uid+","+sid;//rowkey
		//要想把数据存到hbase：需要主键rowkey，主键对应的值
		//盐析法避免热点问题（防止所有数据都在一个服务器，需要打散，带来查询效率问题）
		Put put=new Put(Bytes.toBytes(key));
		for(String k:maps.keySet())
		{//每列的值都存到hbase中
			put.addColumn(Bytes.toBytes(EventLogConstants.EVENT_LOGS_FAMILY_NAME), Bytes.toBytes(k), Bytes.toBytes(maps.get(k)));
		}
		try {
			System.err.println(key+"============================================");
			context.write(NullWritable.get(), put);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
