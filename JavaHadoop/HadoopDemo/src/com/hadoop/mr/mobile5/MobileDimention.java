package com.hadoop.mr.mobile5;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class MobileDimention implements WritableComparable<MobileDimention> {

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

	@Override
	public void write(DataOutput out) throws IOException {
		
		out.writeUTF(phoneNumber);
		out.writeUTF(date);

	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.phoneNumber = in.readUTF();
		this.date = in.readUTF();

	}

	@Override
	public int compareTo(MobileDimention o) {
		int tmp = this.date.compareTo(o.date);
		if (tmp != 0) {
			return tmp;
		}
		tmp = this.phoneNumber.compareTo(o.phoneNumber);
		if (tmp != 0) {
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
