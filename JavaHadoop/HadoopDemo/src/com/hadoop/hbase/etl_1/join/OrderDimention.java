package com.hadoop.hbase.etl_1.join;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

import org.apache.hadoop.io.WritableComparable;

public class OrderDimention implements WritableComparable<OrderDimention> {

	private String userId;
	private String orderInfo="";

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public String getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(String customerInfo) {
		this.customerInfo = customerInfo;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	private String customerInfo="";
	// 1客户 2订单
	private Integer flag;

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(userId);
		out.writeUTF(orderInfo);
		out.writeUTF(customerInfo);
		out.writeInt(flag);

	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.userId = in.readUTF();
		this.orderInfo = in.readUTF();
		this.customerInfo = in.readUTF();
		this.flag = in.readInt();

	}

	@Override
	public int compareTo(OrderDimention o) {
		int tmp = this.userId.compareTo(o.userId);
		if (tmp == 0) {
			// userid相等情况：1.客户与订单 2.都是订单
			if (this.flag == 1) {
				return -1;
			} else {
				return tmp;
			}
		} else {
			return tmp;
		}

	}

}
