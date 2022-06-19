package com.hadoop.mr.secondSort8;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class MyGroupWritable extends WritableComparator {
	public MyGroupWritable() {
		super(Tempture.class,true);
	}
	
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		
		Tempture t1=(Tempture)a;
		Tempture t2=(Tempture)b;
		
		return t1.getYear().compareTo(t2.getYear());//同一年的放到一组
	}
	
}
