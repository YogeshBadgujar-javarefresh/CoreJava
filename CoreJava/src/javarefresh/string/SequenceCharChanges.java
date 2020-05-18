/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.string;

/**
 * Purpose: String myString = "yogesh badgujar!"
 * 
 * Given two strings of lowercase English letters F and S perform the following
 * operations:
 * 
 * Description: 1 - Sum the lengths of F and S.<br>
 * 2 - Determine if F is lexicographically larger than S (i.e. S does come
 * before F in the dictionary?).<br>
 * 3 - Capitalize the first letter in F and S and print them on a single line,
 * separated by a space.
 *
 *
 * 
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */

public class SequenceCharChanges {

	public void stringOperation(String first, String second) {
		// First Task
		System.out.println(first.length() + " " + second.length());

		// Task 2
		if(first.charAt(0) < second.charAt(0)) {
			System.out.println(first + " " + second);
		} else {
			System.out.println(second + " " + first);
		}
		
		// Task 3
		System.out.println((Character.toUpperCase(first.charAt(0)) + first.substring(1, first.length())) + " "
				+ (Character.toUpperCase(second.charAt(0)) + second.substring(1, second.length())));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SequenceCharChanges s = new SequenceCharChanges();
		s.stringOperation("yogesh", "badgujar");
	}

	protected void finalize() {
		System.out.println("finalize called");
	}

}
