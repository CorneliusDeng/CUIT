package com.hadoop.mr.inner9;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class UserGroupByUserid extends WritableComparator {
	public UserGroupByUserid() {
		super(UserWritable.class, true);
	}
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		UserWritable userWritable1 = (UserWritable) a;
		UserWritable userWritable2 = (UserWritable) b;
		return userWritable1.getUserId().compareTo(userWritable2.getUserId());//用户编号相同为同一分组
	}

}
