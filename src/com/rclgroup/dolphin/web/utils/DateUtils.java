/*Copyright (c) 2020 RCL| All Rights Reserved  */
package com.rclgroup.dolphin.web.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * This class mainly intended for form the date in different format.
 * 
 * @author Cognis Solution
 *
 */
public class DateUtils {
	 
	public static final SimpleDateFormat YEAR_DATE_FORMAT = new SimpleDateFormat("yyyy");
	public static final SimpleDateFormat MONTH_YEAR_DATE_FORMAT = new SimpleDateFormat("MM/yyyy");
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final SimpleDateFormat simpleDateFullFormat = new SimpleDateFormat(DATE_FORMAT);
	public static final SimpleDateFormat simpleDateFormatInput = new SimpleDateFormat("dd/MM/yyyy");
	public static final SimpleDateFormat simpleDateFormatSQL = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat simpleDateFormatInputForVpn = new SimpleDateFormat("dd-MM-yy");

	public static Date getDateFromString(String val) {
		if(StringUtils.isEmpty(val)) {
			return null;
		}
		try {
			return simpleDateFullFormat.parse(val);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getDateAndMonthString(Date val) {
		if(StringUtils.isEmpty(val)) {
			return null;
		}
		try {
			return MONTH_YEAR_DATE_FORMAT.format(val);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getPreviousMonth() {
		Date currentDate = new Date();
		
		if (currentDate.getMonth() == 0) {
			
			currentDate.setYear(currentDate.getYear() - 1);
			currentDate.setMonth(11);
		} else {
			currentDate.setMonth(currentDate.getMonth() - 1);
		}
		
		return MONTH_YEAR_DATE_FORMAT.format(currentDate);
	}
	
	public static String getYear() {
		return YEAR_DATE_FORMAT.format(new Date());
	}
	public static String getDateFromDefaultDateStringYYYYMMDD(String defaultDate) {
		String sdfYYYMMDDValue = "";
		if (defaultDate == null)
			return null;
		if (defaultDate.equals(""))
			return null;
		 

		Date date = new Date();
		try {
			date = simpleDateFormatInput.parse(defaultDate);
			System.out.println("date " + date.toString());
			sdfYYYMMDDValue = simpleDateFormatSQL.format(date);
		} catch (Exception e) {
			return null;
		}
		return sdfYYYMMDDValue;
	}
	
	 
	public static String getDateAsStringFull(Date value) {
		 if(value == null) {
			 return "";
		 }
		return simpleDateFullFormat.format(value);

	}

	
	public static String getSQLDateAsString(Date value) {
		 if(value == null) {
			 return "";
		 }
		return simpleDateFormatInput.format(value);

	}
	 
	 
}
