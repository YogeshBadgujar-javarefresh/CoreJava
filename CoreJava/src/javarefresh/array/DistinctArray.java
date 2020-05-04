/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.array;

/**
 * Purpose: Count distinct elements in an array
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class DistinctArray {

	public int distinctNoInArray(int array[]) {
		int res = 0;

		// Pick all elements one by one
		for (int i = 0; i < array.length - 1; i++) {
			int j;
			for (j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					break;
				}
			}

			if (i == j) {
				res++;
			}
			
		}
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DistinctArray a = new DistinctArray();
		int array[] = { 12, 10, 9, 45, 2, 10, 10, 45 };
		System.out.println("Count ="+a.distinctNoInArray(array));
	}

}
