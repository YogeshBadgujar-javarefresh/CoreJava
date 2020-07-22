/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.java8;

/**
 * flatMap using Java 8
 * flatMap - combination of n number of list
 * 
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlapExample {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(2, 4, 6);
		List<Integer> list2 = Arrays.asList(3, 5, 7);
		List<Integer> list3 = Arrays.asList(2, 3, 5, 7, 11);
		List<Integer> combineList = (List<Integer>) Stream.of(list1, list2, list3).flatMap(list -> list.stream())
				.collect(Collectors.toList());
		//Old method
		System.out.println("Combine flattend list: " + combineList);
		
		//Java 8 method
		combineList.stream().forEach(System.out::print);
	}

}
