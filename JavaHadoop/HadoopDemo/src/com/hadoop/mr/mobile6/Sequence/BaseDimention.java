package com.hadoop.mr.mobile6.Sequence;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public abstract class BaseDimention implements WritableComparable<BaseDimention> {//–Ú¡–ªØ∏∏¿‡
	

	@Override
	public  abstract void write(DataOutput out) throws IOException ;

	@Override
	public abstract void  readFields(DataInput in) throws IOException ;
	@Override
	public abstract int compareTo(BaseDimention o) ;

}
