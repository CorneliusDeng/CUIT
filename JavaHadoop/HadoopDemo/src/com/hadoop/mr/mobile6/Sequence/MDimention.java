package com.hadoop.mr.mobile6.Sequence;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class MDimention extends BaseDimention {//key的序列化，需进行比较，加入flag标记，方便知道当前是按哪种方式求流量。

	private int flag;
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getSeasion() {
		return seasion;
	}

	public void setSeasion(String seasion) {
		this.seasion = seasion;
	}

	private String date;
	private String month;
	private String seasion;
	private String phoneNumber;

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub

		out.writeUTF(seasion);
		out.writeUTF(date);
		out.writeUTF(month);
		out.writeUTF(phoneNumber);
		out.writeInt(flag);//用于标记采用哪种方式统计

	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.seasion = in.readUTF();
		this.date = in.readUTF();
		this.month = in.readUTF();
		this.phoneNumber = in.readUTF();
		this.flag=in.readInt();

	}

	@Override
	public int compareTo(BaseDimention o) {
		MDimention mDimention = (MDimention) o;
		int tmp = this.seasion.compareTo(mDimention.seasion);
		if (tmp != 0) {
			return tmp;
		}
		tmp = this.date.compareTo(mDimention.date);
		if (tmp != 0) {
			return tmp;
		}
		tmp = this.month.compareTo(mDimention.month);
		if (tmp != 0) {
			return tmp;
		}
		tmp = this.phoneNumber.compareTo(mDimention.phoneNumber);
		if (tmp != 0) {
			return tmp;
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {//手动比较，用不上
		if (this == obj) {
			return true;
		}
		MDimention mdimention = (MDimention) obj;
		if (this.date == null) {
			if (mdimention.date != null) {
				return false;
			}
		} else if (mdimention.date == null) {
			if (this.date != null) {
				return false;
			}
		} else if (!this.date.equals(mdimention.date)) {
			return false;
		}
		
		if (this.month == null) {
			if (mdimention.month != null) {
				return false;
			}
		} else if (mdimention.month == null) {
			if (this.month != null) {
				return false;
			}
		} else if (!this.month.equals(mdimention.month)) {
			return false;
		}
		
		if (this.seasion == null) {
			if (mdimention.seasion != null) {
				return false;
			}
		} else if (mdimention.seasion == null) {
			if (this.seasion != null) {
				return false;
			}
		} else if (!this.seasion.equals(mdimention.seasion)) {
			return false;
		}
		
		if (this.phoneNumber == null) {
			if (mdimention.phoneNumber != null) {
				return false;
			}
		} else if (mdimention.phoneNumber == null) {
			if (this.phoneNumber != null) {
				return false;
			}
		} else if (!this.phoneNumber.equals(mdimention.phoneNumber)) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return date + "\t" + month + "\t" + seasion + "\t" + phoneNumber;
	}
}
