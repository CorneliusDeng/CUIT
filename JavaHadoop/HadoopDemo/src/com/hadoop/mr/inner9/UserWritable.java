package com.hadoop.mr.inner9;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;



public class UserWritable implements WritableComparable<UserWritable> {

	private String userId;
	private String userInfo;
	private String orderInfo;
	private String flag;

	public UserWritable() {
		this.userId = "";
		this.userInfo = "";
		this.orderInfo = "";
		this.flag = "";
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(this.userId);
		out.writeUTF(this.userInfo);
		out.writeUTF(this.flag);
		out.writeUTF(this.orderInfo);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.userId = in.readUTF();
		this.userInfo = in.readUTF();
		this.flag = in.readUTF();
		this.orderInfo = in.readUTF();

	}
	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	// flag 0： A 1：B
	@Override
	public int compareTo(UserWritable o) {
		int tmp = this.userId.compareTo(o.userId);
		if (tmp == 0) {//A、B用户编号相同
			if (this.flag.equals(o.flag)) {//都是order的userId
				System.out.println("========================================");
				return 1;
			} else {
				//cus 0  order 1 
				if (this.flag.equals(Constants.A)) {
					return -1;//降序  将用户放到订单上
				} else {
					return 1;
				}
			}
		} else {
			return tmp;
		}

	}

}
