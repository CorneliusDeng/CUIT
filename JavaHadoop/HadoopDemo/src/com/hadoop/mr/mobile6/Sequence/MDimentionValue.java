package com.hadoop.mr.mobile6.Sequence;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class MDimentionValue implements Writable {//value的序列化，不需要比较
	private int upflow;//上行流量
	private int downflow;//下行流量
	private int sum;
	public int getUpflow() {
		return upflow;
	}
	public void setUpflow(int upflow) {
		this.upflow = upflow;
	}
	public int getDownflow() {
		return downflow;
	}
	public void setDownflow(int downflow) {
		this.downflow = downflow;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeInt(downflow);
		out.writeInt(upflow);
		out.writeInt(sum);
		
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.downflow=in.readInt();
		this.upflow=in.readInt();
		this.sum=in.readInt();
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.downflow+"\t"+this.upflow+"\t"+this.sum;
	}

}
