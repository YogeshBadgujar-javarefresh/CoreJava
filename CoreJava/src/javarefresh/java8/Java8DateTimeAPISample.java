/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.TimeZone;

/**
 * Purpose:Using Java 8, create the sample for Time API
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class Java8DateTimeAPISample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Instant, ZonedDateTime - 1.8, immutable and thread-safe.
		// From date object get the calendar instance
		Date dateFromInstant = Date.from(Instant.now());
		GregorianCalendar calendarFromZonedDateTime = GregorianCalendar.from(ZonedDateTime.now());
		Instant instantFromDate = new Date().toInstant();
		ZoneId zoneIdFromTimeZone = TimeZone.getTimeZone("PST").toZoneId();
		//Different
		Instant instantFromCalendar = GregorianCalendar.getInstance().toInstant();
		ZonedDateTime zonedDateTimeFromCalendar = new GregorianCalendar().toZonedDateTime();

		// Get current time
		ZonedDateTime currTime = ZonedDateTime.now();
		System.out.println("Current Time=" + currTime);
		// Set the particular date.
		LocalDate birthDate = LocalDate.of(1981, Month.JUNE, 15);
		System.out.println("You set this date =" + birthDate);
		// Get current month
		Month month = LocalDateTime.now().getMonth();
		System.out.println("Current Month is " + month);

		// Add the time in current time
		LocalDateTime oneHoursAfter = LocalDateTime.now().plusHours(1);
		System.out.println(
				"Current time is =" + LocalDateTime.now() + " and get future time by one hr =" + oneHoursAfter);

		// Substract the given time from current time.
		LocalDateTime threeDaysBefore = LocalDateTime.now().minusDays(3);
		System.out.println("Current time is =" + LocalDateTime.now() + " and get past 3 days time=" + threeDaysBefore);

		LocalDateTime inJune = LocalDateTime.now().withMonth(Month.JUNE.getValue());
		System.out.println("Month time=" + inJune);

		// Set the hr/min/sec/milli to zero value
		LocalTime truncated = LocalTime.now().truncatedTo(ChronoUnit.HOURS);
		System.out.println("Current time = " + LocalTime.now());
		System.out.println("Set the zero value for hr in current time = " + truncated);

		// Get any timezone
		ZonedDateTime europe = LocalDateTime.now().atZone(ZoneId.of("GMT"));
		System.out.println("Get the GMT zone time=" + europe);

		// Get time Duration of 2 different time
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime hourLater = LocalDateTime.now().plusHours(1);
		Duration span = Duration.between(now, hourLater);
		System.out.println("Different hrs is =" + span);

		// Time format
		LocalDate current = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = current.format(formatter);
		LocalDate parsedDate = LocalDate.parse(formattedDate, formatter);
		System.out.println("Parse date =" + parsedDate);

		// Get Number of days in a month of any year. Very simple but can use for Feb
		// months
		int daysInMonth = YearMonth.of(1981, 2).lengthOfMonth();
		System.out.println("In 1981 days Feb month is" + daysInMonth);

		// We can set the custom Message on Nullpointer exception
		String str = null;
		System.out.println("Object =" + Objects.requireNonNull(str, "Me set string as Null"));
	}

}
