/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.array;

import java.util.Arrays;

/**
 * Purpose:Shifting Elements in an Array will be left or right depending on no
 * of shift size.
 *
 * Description: Shift the int array by given no of shift to Right/Left side.
 * e.g. Right shift {1,2,3,4,5} by 2 ==> [4, 5, 1, 2, 3]
 * 
 * e.g. Left shift {1,2,3,4,5} by 2 ==> [3, 4, 5, 1, 2]
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class ShiftingElementsArray {

	public Integer[] getRightShift(Integer arrayOrg[], int n) {
		//No point to loop, result will be same.
		if(arrayOrg.length == 1) {
			return arrayOrg;
		}
		
		// Note - Many developer make a mistake and use the original array and change
		// the values after that another shift method call the it shift on updated array
		// value. So iterate the original array and store temp then do the further job.
		Integer array[] = new Integer[arrayOrg.length];
		for (int x = 0; x < arrayOrg.length; x++) {
			array[x] = arrayOrg[x];
		}

		for (int i = 0; i < n; i++) {
			int temp = array[array.length - 1];
			for (int j = array.length - 1; j > 0; j--) {
				array[j] = array[j - 1];
			}
			array[0] = temp;
		}

		return array;
	}

	public Integer[] getLeftShift(Integer array[], int n) {
		for (int i = 0; i < n; i++) {
			int temp = array[0];
			for (int j = 0; j < array.length - 1; j++) {
				array[j] = array[j + 1];
			}
			array[array.length - 1] = temp;
		}

		return array;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShiftingElementsArray shift = new ShiftingElementsArray();
		Integer array[] = { 3, 8, 9, 7, 6 };
		System.out.println("Given array=" + Arrays.toString(array));
		Integer rightShift[] = shift.getRightShift(array, 3);
		System.out.println("Right shift=" + Arrays.toString(rightShift));

		System.out.println("Original array = " + Arrays.toString(array));
		Integer leftShift[] = shift.getLeftShift(array, 3);
		System.out.println("Left shift=" + Arrays.toString(leftShift));

	}

}
