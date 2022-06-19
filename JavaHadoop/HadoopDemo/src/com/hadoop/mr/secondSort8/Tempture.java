package com.hadoop.mr.secondSort8;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class Tempture implements WritableComparable<Tempture> {//序列化是只有年和温度

	private String year;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getTemp() {
		return temp;
	}

	public void setTemp(Integer temp) {
		this.temp = temp;
	}

	private Integer temp;

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(year);
		out.writeInt(temp);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.year = in.readUTF();
		this.temp = in.readInt();
	}
	@Override
	public int compareTo(Tempture o) {//先按年排序，再按温度排序，温度倒序
		int tmp = year.compareTo(o.year);
		if (tmp == 0) {
			tmp = this.temp.compareTo(o.temp);
			if (tmp != 0) {
				return -tmp;//降序
			} else {
				return tmp;
			}
		} else {
			return tmp;
		}

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.year + "\t" + this.temp;
	}

}
