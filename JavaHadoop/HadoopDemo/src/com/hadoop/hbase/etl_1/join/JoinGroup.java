package com.hadoop.hbase.etl_1.join;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class JoinGroup extends WritableComparator {

	public JoinGroup() {
		super(OrderDimention.class,true);
	}
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		// TODO Auto-generated method stub
		OrderDimention o1=(OrderDimention)a;
		OrderDimention o2=(OrderDimention)b;
		return o1.getUserId().compareTo(o2.getUserId());
	}
}
