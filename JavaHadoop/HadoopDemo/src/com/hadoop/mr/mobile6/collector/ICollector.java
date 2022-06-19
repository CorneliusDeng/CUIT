package com.hadoop.mr.mobile6.collector;

import java.sql.PreparedStatement;

import com.hadoop.mr.mobile6.Sequence.MDimention;
import com.hadoop.mr.mobile6.Sequence.MDimentionValue;

public interface ICollector {

	public void bindSql(MDimention key, MDimentionValue value,PreparedStatement ps);
}
