package com.hadoop.mr.callSequence4;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

/**
 * 对key做序列化
 * 
 *  相同key表示两个属性值必须都相同，两个key才相同。
 * Text
 */
public class CallDimentioin implements WritableComparable<CallDimentioin> {

	private String date;
	private String phoneNumber;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// 序列化 out表示 写的顺序要与读的顺序必须一致
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(date);
		out.writeUTF(phoneNumber);

	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.date = in.readUTF();
		this.phoneNumber = in.readUTF();

	}

	// 比较 shuffle调用（分组）  
	@Override
	public int compareTo(CallDimentioin o) {
		
		int tmp = this.date.compareTo(o.date);//1 表示this.date>o.date   -1  0 
		if (tmp != 0) {
			return tmp;
		}
		tmp=this.phoneNumber.compareTo(o.phoneNumber);
		if(tmp!=0)
		{
			return tmp;
		}
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.date+"\t"+this.phoneNumber;
	}
}
