package com.hadoop.hbase.etl_1.constants;

import java.text.DecimalFormat;

public class Test {

	public static String formatPartion(int part)
	{
		DecimalFormat dft=new DecimalFormat("00");
		return dft.format(part);
	}
	public static void main(String[] args) {
//		System.out.println(formatPartion(2));
		System.out.println(EventLogConstants.EventEnum.PAGEVIEW.alias);
	}

}
