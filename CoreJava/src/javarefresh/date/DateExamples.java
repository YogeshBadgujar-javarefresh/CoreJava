/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Purpose:Different sample examples of Date. 1) Convert String to Date <br>
 * 2) Convert Date to String <br>
 * 3)
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class DateExamples {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {

		// There are different format
		// dd/M/yyyy
		// yyyy/MM/dd HH:mm:ss
		// Convert String to Date by using SimpleDateFormat.
		String dateString = "30-01-1981 12:12:12";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Date date = sdf.parse(dateString);
		System.out.println(date);

		// Convert Date into String format.
		System.out.println(sdf.format(new Date()));
		// Using Calendar
		System.out.println("Direct date without format =" + Calendar.getInstance().getTime());
		System.out.println("Direct date with format =" + sdf.format(Calendar.getInstance().getTime()));
		
		//set the time in milisecond and get the date
		//Date: 1574464138000  --Sat Nov 23 04:38:58 IST 2019
		Date da = new Date(1574464138000l);
		System.out.println(da.getDay());//6-Sat
		System.out.println(da.getMonth());//10 (as it start from 0)
		System.out.println(da.getDate());//23
		System.out.println("Time ="+da.getHours() + da.getMinutes());//04
		System.out.println(da.getYear());
		
		System.out.println("Date in ISO format ="+getISOFormatDateAsString());
		
	}
	
	/**
	 * Get the date in ISO format.
	 * https://en.wikipedia.org/wiki/ISO_8601
	 * @return - Date in String format. 
	 */
	private static String getISOFormatDateAsString() {
		TimeZone timeZone = TimeZone.getTimeZone("");
		//yyyy-MM-dd'T'HH:mm:ss'Z' - 24 hr clock
		//yyyy-MM-dd'T'hh:mm:ss'Z' - 12 hr clock
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
		format.setTimeZone(timeZone);
		return format.format(new Date());
	}

}
