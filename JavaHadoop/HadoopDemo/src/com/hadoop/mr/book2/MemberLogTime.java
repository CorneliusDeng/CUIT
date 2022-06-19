package com.hadoop.mr.book2;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class MemberLogTime implements WritableComparable<MemberLogTime>{
	private String member_name;
	private String logTime;
	public MemberLogTime() {
		
	}
	public MemberLogTime(String member_name,String logTime){
		this.member_name=member_name;
		this.logTime=logTime;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getLogTime() {
		return logTime;
	}
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		this.member_name=in.readUTF();
		this.logTime=in.readUTF();	
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(member_name);
		out.writeUTF(logTime);	
	}
	@Override
	public int compareTo(MemberLogTime o) {
		return this.getMember_name().compareTo(o.getMember_name());
	}
	@Override
	public String toString() {
		return this.member_name+","+this.logTime;
	}
}
