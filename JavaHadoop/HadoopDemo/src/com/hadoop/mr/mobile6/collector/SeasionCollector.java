package com.hadoop.mr.mobile6.collector;

import java.sql.PreparedStatement;

import com.hadoop.mr.mobile6.Sequence.MDimention;
import com.hadoop.mr.mobile6.Sequence.MDimentionValue;

public class SeasionCollector implements ICollector {

	@Override
	public void bindSql(MDimention key, MDimentionValue value, PreparedStatement ps) {
		// TODO Auto-generated method stub
		try
		{
			ps.setString(1, key.getSeasion());
		ps.setString(2, key.getPhoneNumber());
		ps.setInt(3, value.getSum());
		ps.setString(4, key.getSeasion());
		ps.setString(5, key.getPhoneNumber());
		ps.addBatch();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	
}
