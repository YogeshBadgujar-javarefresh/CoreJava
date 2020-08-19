/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * Purpose:Sort single array in two section based on given size. First part will
 * in ascending order and second part will in descending order.<br>
 * e.g. [5, 3, 6, 45, 12, 99, 23, 9] to [6, 5, 3, 9, 12, 23, 45, 99]
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class ArrayHalfwayDescendingAscending {

	private static Integer[] halfwayDescendingAscendingSort(int[] array, int position) {
		Integer[] tempArray = new Integer[array.length];
		Integer[] firstHalfArray = new Integer[position];
		Integer[] secondHalfArray = new Integer[array.length - position];

		for (int i = 0; i < array.length; i++) {
			if (i < position) {
				firstHalfArray[i] = array[i];
			} else {
				secondHalfArray[i - position] = array[i];
			}
		}
		// descending order 6, 5, 3
		Arrays.sort(firstHalfArray, Collections.reverseOrder());
		// Default Ascending order
		Arrays.sort(secondHalfArray);

		System.arraycopy(firstHalfArray, 0, tempArray, 0, firstHalfArray.length);
		System.arraycopy(secondHalfArray, 0, tempArray, firstHalfArray.length, secondHalfArray.length);

		return tempArray;
	}

	public static void main(String[] args) {
		int[] array = { 5, 3, 6, 45, 12, 99, 23, 9 };
		Integer[] arraySort = halfwayDescendingAscendingSort(array, 3);
		System.out.println("Before Sort array=" + Arrays.toString(array));
		System.out.println("After Sort array=" + Arrays.toString(arraySort));

	}

}
