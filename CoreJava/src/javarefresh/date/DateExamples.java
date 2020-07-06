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
	}

}
