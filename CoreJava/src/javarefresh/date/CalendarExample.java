/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Purpose:All Calendar related sample with example.<br>
 * such as set the value, get the value, date to calendar etc.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class CalendarExample {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// Set the particular date and get the details
		// can use - yyyy MMM dd HH:mm:ss
		// can use - dd-MM-yyyy hh:mm:ss"
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		Calendar calendar = new GregorianCalendar(2020, 3, 22, 11, 20, 16);
		// 12 hour clock
		int hour = calendar.get(Calendar.HOUR);
		// 24 hour clock
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int weekOfMonth = calendar.get(Calendar.WEEK_OF_MONTH);
		int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

		// Print hr/min/mill/year/days/months etc
		System.out.println("Set Hour =" + hour);
		System.out.println("Set HourOfDay =" + hourOfDay);
		System.out.println("Set Min =" + minute);
		System.out.println("Set Sec =" + second);
		System.out.println("Set Milli =" + millisecond);

		System.out.println("Set Year =" + year);
		System.out.println("Set Month =" + month);
		System.out.println("Day of month =" + dayOfMonth);
		System.out.println("Day of week =" + dayOfWeek);
		System.out.println("Week of month =" + weekOfMonth);
		System.out.println("Week of year =" + weekOfYear);

		// Calendar cal = new GregorianCalendar();
		System.out.println("Date from calendar= =" + sdf.format(calendar.getTime()));
		// Set new date to calendar
		Date date = sdf.parse("25-5-2001 11:45:45");
		calendar.setTime(date);
		System.out.println("Get newly set Date to calendar=" + sdf.format(calendar.getTime()));

		// update a year/month/hr etc
		calendar.set(Calendar.YEAR, 2025);
		calendar.set(Calendar.MONTH, 5);
		calendar.set(Calendar.MINUTE, 33);
		// add the month
		calendar.add(Calendar.MONTH, 2);
		// sub the in days
		calendar.add(Calendar.DAY_OF_MONTH, -15);

		System.out.println("Another way to set the year/month etc= " + sdf.format(calendar.getTime()));

	}

}
