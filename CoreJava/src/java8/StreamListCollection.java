/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package java8;

/**
 * Collection List String/Refresh Object using stream.
 * 1) Print the List using Java 8
 * 2) Apply filter on list
 * 3) Print reversed list based on id
 * 4) Find the empty element from the list
 *
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListCollection {

	public static void main(String[] args) {

		// Example 1 - Simple Print the values of List
		List<Refresh> refreshList = new ArrayList<>();
		refreshList.add(new Refresh(1, "Java", 10));
		refreshList.add(new Refresh(2, "Spring", 5));
		refreshList.add(new Refresh(3, "AWS", 6));

		System.out.println("Simple Print the values of List output ---------------- ");
		refreshList.stream().forEach(x -> {
			System.out.print(" Id =" + x.id);
			System.out.print(" Name =" + x.name);
			System.out.print(" Value =" + x.value);
			System.out.println(" ");
		});

		// Example 2 - Filter on id and display the result
		refreshList.stream().filter(p -> p.id == 2).forEach(x -> System.out.println("You "
				+ "search by id 2 and value is " + x.name));
		
		// Example 3 - reversed display the list
		System.out.println("Print reverse the List --------------------- ");
		refreshList.stream().sorted(Comparator.comparingInt(Refresh::getId).reversed()).collect(Collectors.toList())
				.forEach(x -> {
					System.out.print(" Id =" + x.id);
					System.out.print(" Name =" + x.name);
					System.out.print(" Value =" + x.value);
					System.out.println(" ");
				});

		// Example 4 - Count the empty values from the list
		List<String> strList = Arrays.asList("abc", " ", "bcd", "", "defg", "jk");
		long count = strList.stream().filter(x -> x.trim().isEmpty()).count();
		System.out.println("Empty values in list Count is = " + count);
	}
}

class Refresh {
	int id;
	String name;
	int value;

	public Refresh(int id, String name, int value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
