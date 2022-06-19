package com.hadoop.mr.mobile6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

	public static String toDate(String mi)
	{
		Long l=Long.parseLong(mi.trim());
		Date date=new Date(l);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
		
	}
	public static String toMonth(String mi)
	{
		Long l=Long.parseLong(mi.trim());
		Date date=new Date(l);
		SimpleDateFormat sdf=new SimpleDateFormat("MM");
		return sdf.format(date);
		
	}
	public static String toSesion(String mi)
	{
		Long l=Long.parseLong(mi.trim());
		Date date=new Date(l);
		SimpleDateFormat sdf=new SimpleDateFormat("MM");
		int month=Integer.parseInt(sdf.format(date));
		String seasion="";
		if(month>=1 && month <=3)
		{
			seasion="1";
		}
		if(month>=4 && month <=6)
		{
			seasion="2";
		}
		if(month>=7 && month <=9)
		{
			seasion="3";
		}
		if(month>=10 && month <=12)
		{
			seasion="4";
		}
		return seasion;		
	}
	public static String toDateFromUS1(String d)
	{
		SimpleDateFormat in=new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss",Locale.US); 
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
			Date date=in.parse(d);
			return sdf.format(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}
}
