package com.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * Convert java.util.Date to java.sql.Date
	 * @author shenxianrui
	 * @param uDate
	 * @return java.sql.Date
	 */
	public static java.sql.Date convertUtilToSql(Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}

	/**
	 * Convert java.sql.Date to java.util.Date
	 * @author shenxianrui
	 * @param uDate
	 * @return java.util.Date
	 */
	public static java.util.Date convertSQLToUtil(java.sql.Date uDate) {
		java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		return sDate;
	}

	/**
	 * Convert String to java.util.Date
	 * @author shenxianrui
	 * @param sDate
	 * @return java.util.Date
	 */
	public static Date convertStringToUtil(String sDate) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;

	}

	/**
	 * Convert java.util.Date to String
	 * @author shenxianrui
	 * @param uDate
	 * @return String
	 */
	public static String convertUtilToString(Date uDate,String pattern) {
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		String strDate = dateFormat.format(uDate);
		return strDate;
	}
	
	public static Integer diffDate(Date date1,Date date2) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		date1=sdf.parse(sdf.format(date1));  
		date2=sdf.parse(sdf.format(date2));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(date1);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(date2);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  

       return Integer.parseInt(String.valueOf(between_days));     
		
	}
}
