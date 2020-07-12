/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.array;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Purpose:Find the Duplicate Array from given array.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class DuplicateArray {

	public static int[] findDuptlicate(int[] arr) {

		int[] newArray = new int[arr.length];

		Set<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < arr.length - 1; i++) {
			if (!set.contains(arr[i])) {
				set.add(arr[i]);
				newArray[i] = arr[i];
			}
		}
		return newArray;
	}

	public static void main(String args[]) {
		int[] c = { 2, 3, 4, 4, 3, 2 };
		int[] newArray = findDuptlicate(c);

		for (int y : newArray) {
			System.out.print("Value " + y);
		}
	}

}
