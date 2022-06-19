package com.hadoop.mr.callSequence4;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

/**
 * ��key�����л�
 * 
 *  ��ͬkey��ʾ��������ֵ���붼��ͬ������key����ͬ��
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

	// ���л� out��ʾ д��˳��Ҫ�����˳�����һ��
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

	// �Ƚ� shuffle���ã����飩  
	@Override
	public int compareTo(CallDimentioin o) {
		
		int tmp = this.date.compareTo(o.date);//1 ��ʾthis.date>o.date   -1  0 
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
