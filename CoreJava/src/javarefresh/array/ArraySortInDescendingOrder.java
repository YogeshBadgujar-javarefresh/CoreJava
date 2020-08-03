/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.array;

import java.util.Arrays;

/**
 * Purpose:Different ways to sort the arrays.
 *
 * Description: Array sort in Descending order. <br>
 * e.g. [24, 34, 25, 6, 22, 5] to [34, 25, 24, 22, 6, 5]
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class ArraySortInDescendingOrder {

	/**
	 * Sorry array using old ways.
	 * 
	 * In descending order.
	 * 
	 * @param array - Pass unsorted array.
	 * @return - Sorted array.
	 */
	public static int[] sort(int[] array) {
		int[] sortedArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			sortedArray[i] = array[i];
		}

		boolean flag = true;
		int temp;
		while (flag) {
			flag = false;
			for (int i = 0; i < sortedArray.length - 1; i++) {
				if (sortedArray[i] < sortedArray[i + 1]) {
					temp = sortedArray[i];
					sortedArray[i] = sortedArray[i + 1];
					sortedArray[i + 1] = temp;
					flag = true;
				}

			}
		}
		return sortedArray;
	}

	/**
	 * Sorry the array using Arrays.copyOf().
	 * 
	 * In descending order.
	 * 
	 * @param array
	 * @return
	 */
	public static int[] sortArrayCopy(int[] array) {

		// This is correct to to copy array.
		int[] sortedArray = Arrays.copyOf(array, array.length);

		boolean flag = true;
		int temp;
		while (flag) {
			flag = false;
			for (int i = 0; i < sortedArray.length - 1; i++) {
				if (sortedArray[i] < sortedArray[i + 1]) {
					temp = sortedArray[i];
					sortedArray[i] = sortedArray[i + 1];
					sortedArray[i + 1] = temp;
					flag = true;
				}
			}
		}
		return sortedArray;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 24, 34, 25, 6, 22, 5 };
		System.out.println("Before Sort array=" + Arrays.toString(arr));
		System.out.println("After Sort array=" + Arrays.toString(sort(arr)));

		System.out.println("Before Sort array=" + Arrays.toString(arr));
		System.out.println("After Sort array=" + Arrays.toString(sortArrayCopy(arr)));

	}

}
