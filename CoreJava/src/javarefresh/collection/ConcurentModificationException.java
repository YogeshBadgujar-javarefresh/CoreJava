/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Purpose: Write a program to iterate over array list , it should show the
 * scenarios where it will throw concurentModificationException and will not.
 * Both in single threaded model.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class ConcurentModificationException {

	private static final String SURNAME = "Bad";
	private static final String NAME = "Yog";

	public static void main(String[] args) {
		List<String> empList = new ArrayList<>();
		empList.add("Yogesh");
		empList.add("Badgujar");
		empList.add("Yog");
		empList.add("Badguj");
		empList.add("Badwani");
		empList.add("Yogesss");
		// Before remove Employee list
		empList.stream().forEach(System.out::println);

		ConcurentModificationException example = new ConcurentModificationException();
		// Non concurentModificationException
		example.nonConcurentModificationException(empList);
		// concurentModificationException
		//example.concurentModificationException(empList);

		example.concurentModificationExceptionJava8(empList);
		// After remove Employee list
		empList.stream().forEach(System.out::println);
	}

	private void nonConcurentModificationException(List<String> empList) {
		for (Iterator<String> itr = empList.iterator(); itr.hasNext();) {
			String str = itr.next();
			if (str.startsWith(ConcurentModificationException.SURNAME)) {
				itr.remove();
				System.out.println("No exception after Removed the " + str);
			}
		}
	}

	/**
	 * This will throw  java.util.ConcurrentModificationException
	 * @param empList
	 */
	private void concurentModificationException(List<String> empList) {
		for (String str : empList) {
			if (str.startsWith(ConcurentModificationException.NAME)) {
				empList.remove(str);
				System.out.println("Will get exception after Removed the " + str);
			}
		}
	}
	
	/**
	 * concurentModificationException() code only but difference is with Java 8 
	 * Using Java 8 - It will throw java.lang.NullPointerException
	 * @param empList
	 */
	private void concurentModificationExceptionJava8(List<String> empList) {
		empList.stream().filter(x -> x.startsWith(ConcurentModificationException.NAME))
		.forEach( p -> {
			empList.remove(p);
			System.out.println("Will throw exception after Removed the " + p);
		});
	}
}
