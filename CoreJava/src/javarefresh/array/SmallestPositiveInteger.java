/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * Purpose: Get the small int from the array.
 *
 * Description: e.g. { 4, 3, 5, 6, 2 } ==> 2
 * 
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class SmallestPositiveInteger {

	/**
	 * Sort the array using in-build and custom solution.
	 * 
	 * @param array
	 * @return
	 */
	public int solution(int[] array) {
		// Method 1 - Quick way sort the array and get the 1 value
		Arrays.sort(array);
		System.out.println("Smalled value after sort =" + array[0]);

		// Method 2 - Java 8 - using parallelSort()
		Arrays.parallelSort(array);
		System.out.println("Java 8 parallelSort() method =" + Arrays.toString(array));

		// Method 2 - Without using any in-build function.
		int value = 0;
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				value = array[i];
			} else if (value > array[i]) {
				value = array[i];
			}
		}
		return value;
	}

	/**
	 * Revert the int[] only when array is in odd number/length
	 * 
	 * @param input
	 */
	public void reverseWithOddLength(int[] input) {
		int last = input.length - 1;
		int middle = input.length / 2;
		for (int i = 0; i <= middle; i++) {
			int temp = input[i];
			input[i] = input[last - i];
			input[last - i] = temp;
		}
	}

	/**
	 * Any no of length we can try this but not efficient.
	 * @param input
	 */
	public int[] reverseWithEvenOrAnyLength(int[] array) {
		int reverseArray[] = new int[array.length];
		int inc = 0;
		for (int i = array.length-1; i >= 0; i--) {
			reverseArray[inc] = array[i];
			inc++;
		}
		return reverseArray;
	}

	public static void main(String[] args) {
		SmallestPositiveInteger s = new SmallestPositiveInteger();
		int[] array = { 4, 3, 5, 6, 2, 1 };
		System.out.println("Small int from array = " + s.solution(array));

		Arrays.sort(array);
		System.out.println("Ascending array = " + Arrays.toString(array));

		if (array.length % 2 == 1) {
			s.reverseWithOddLength(array);
			System.out.println("If length ODD then Descending array = " + Arrays.toString(array));
		} else {
			int[] arrayRev = s.reverseWithEvenOrAnyLength(array);
			System.out.println("If length Even Descending array = " + Arrays.toString(arrayRev));
		}
	}

}
