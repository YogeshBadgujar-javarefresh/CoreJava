/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.java9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Purpose:
 *
 * Description:
 *
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 *
 */
public class ImmutableListExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//List.of()
		//List.of(e1)
		//List.of(e1, e2)         // fixed-argument form overloads up to 10 elements
		//List.of(elements...)   // varargs form supports an arbitrary number of elements or an array

		//java 8

		List<String> stringList = Arrays.asList("a", "b", "c");
		stringList = Collections.unmodifiableList(stringList);
		
		//java 9
		//List stringList9 = List.of("a", "b", "c");

	}

}
