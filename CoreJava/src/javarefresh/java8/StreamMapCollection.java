/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Collection Map using stream. <br>
 * 1) Print the Map in different way<br>
 * 2) Sort the Map
 * 
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 */

public class StreamMapCollection {

	public static void main(String[] args) {

		// Example 1 - Map and sort the values
		Map<String, Integer> refreshMap = new HashMap<>();
		refreshMap.put("Jsp", 34);
		refreshMap.put("Test", 22);
		refreshMap.put("Java", 15);
		refreshMap.put("SSL", 100);
		refreshMap.put("JavaScript", 50);
		System.out.println("Print Map in simple way ---------------------- ");
		refreshMap.entrySet().stream().forEach(System.out::println);

		System.out.println("Print Map in Different way ---------------------- ");
		refreshMap.entrySet().stream().forEach(x -> {
			System.out.println("Map Key =" + x.getKey() + " and Value=" + x.getValue());
		});

		// Example 2 - Sort the Map based on key and print
		// below implementation if you use then it won't sort properly
		// Map<String, Integer> sortByKeyMap =
		// refreshMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
		// .collect(Collectors.toMap(e1 -> e1.getKey(), e -> e.getValue()));

		Map<String, Integer> sortByKeyMap = refreshMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(
				Collectors.toMap(e1 -> e1.getKey(), e -> e.getValue(), (oldKey, newKey) -> oldKey, LinkedHashMap::new));

		System.out.println("Map sort by key ---------------------- ");
		sortByKeyMap.entrySet().stream().forEach(x -> {
			System.out.println("Key =" + x.getKey() + " and value=" + x.getValue());
		});

		// Example 3 - Sort the Map based on Value and print
		Map<String, Integer> sortByValueMap = refreshMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

		System.out.println("Map sort by value ---------------------- ");
		sortByValueMap.entrySet().stream().forEach(x -> {
			System.out.println("Key =" + x.getKey() + " and value=" + x.getValue());
		});

	}
}