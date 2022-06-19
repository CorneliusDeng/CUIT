package com.hadoop.hbase.etl_1.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateUtils {
	public static String stopDate(String startDate)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
		Calendar cal=Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(startDate));
			cal.add(Calendar.DAY_OF_MONTH, 1);
			return sdf.format(cal.getTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static String stopChar(String str)
	{
		
		char c=str.charAt(str.length()-1);
		char lastChar=((char)(c+1));
		String cstr=str.substring(0,str.length()-1)+lastChar;
		return cstr;
	}
	public static String dateFormat(String dateVal)
	{
		//23/Jun/2017SimpleDateFormat in=new SimpleDateFormat("dd/MMM/yyyy",Locale.US); 
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MMM/yyyy",Locale.US);
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		try {
			String date=sdf1.format(sdf.parse(dateVal));
			System.out.println(date);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
