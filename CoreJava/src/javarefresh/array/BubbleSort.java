
/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.array;

import java.util.Arrays;

/**
 * Purpose:Sort the array using Bubblesort and using in build method.
 *
 * Description:e.g. [24, 34, 25, 6, 22, 5] to [5, 6, 22, 24, 25, 34]
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */

public class BubbleSort {

	// Simple sorting algorithm Bubble Sort
	public void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap temp and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String args[]) {
		BubbleSort bs = new BubbleSort();
		int arr[] = { 24, 34, 25, 6, 22, 5 };
		System.out.println("Before Bubble Sort array=" + Arrays.toString(arr));
		bs.bubbleSort(arr);
		System.out.println("After Bubble Sort array=" + Arrays.toString(arr));
		// Can sort the array using below as well just for reference
		int arrAnoth[] = { 40, 17, 23, 6, 5 };
		System.out.println("Array=" + Arrays.toString(arrAnoth));
		Arrays.sort(arrAnoth);
		System.out.println("Using Arrays.sort() Sorted =" + Arrays.toString(arrAnoth));
	}

}
