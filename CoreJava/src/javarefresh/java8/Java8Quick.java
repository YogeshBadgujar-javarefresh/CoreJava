/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.StreamSupport;

/**
 * Purpose:Quick code at a glance.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class Java8Quick {

	/**
	 * Output will be 13.0
	 */
	private void filterAverageArray() {
		Arrays.stream(new int[] { 1, 2, 3, 4 }).map(n -> 3 * n + 1).filter(i -> i > 10).average()
				.ifPresent(System.out::println);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Java8Quick j8 = new Java8Quick();
		
		// Initialize the thread
		new Thread(() -> System.out.println("Testing")).start();

		// Iterate the list
		List<String> listString = Arrays.asList("Java", "JavaScript", "Spring", "Hibernate");
		listString.stream().forEach(x -> System.out.println("Simple print one by one =" + x));
		// Sort the list based on word lengths
		listString.sort((one, two) -> Integer.compare(one.length(), two.length()));
		System.out.println("After sort on length of the list word=" + listString);

		// Count of the string
		System.out.println("Count =" + listString.stream().count());

		// Simple filter
		Predicate<String> pre = (p) -> p.startsWith("Ja");
		listString.stream().filter(pre).forEach(x -> System.out.println("Start Ja =" + x));

		// Integer
		List<Integer> listInteger = Arrays.asList(1, 4, 78, 3, 56);
		listInteger.stream().forEach(x -> System.out.println(x));

		// Avoid Nullpointer exception
		String str = null;
		Optional<String> str2 = Optional.empty();
		System.out.println("Use Optional to avoid Nullpointer exception" + str2);

		// Iterable to stream convert
		Iterable<String> itr = listString;
		StreamSupport.stream(itr.spliterator(), false).forEach(x -> System.out.println("From Iterable=" + x));
		
		j8.filterAverageArray();
	}
}
