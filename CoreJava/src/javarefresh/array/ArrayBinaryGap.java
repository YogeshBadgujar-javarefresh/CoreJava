/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Purpose:Number 20 has binary value is 10100 and contains one binary gap of
 * length 1(between two one, count the 0 which is nothing but the gap). The
 * number 15 has binary representation 1111 and has no binary gaps.<br>
 * e.g. 20 -> 10100 --> Gap is 1 <br>
 * e.g. 15 -> 1111 --> Gap is 0 <br>
 * e.g. 9 --> 1001 --> Gap is 2 <br>
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class ArrayBinaryGap {

	public int[] getBinaryGapForArray(int number) {
		char[] binaryValue = Integer.toBinaryString(number).toCharArray();
		System.out.println("Binary value =" + Integer.toBinaryString(number));

		List<Integer> gapList = new ArrayList<>();
		boolean first = false;
		boolean second = false;
		int count = 0;
		for (char c : binaryValue) {
			if (c == '1' & count == 0) {
				first = true;
			} else if (first & c == '1') {
				second = true;
			}

			if (first) {
				if (c == '0') {
					count++;
				}
			}

			if (first & second) {
				gapList.add(count);
				count = 0;
				second = false;
			}
		}
		System.out.println(gapList.size());
		int bGap[] = new int[gapList.size()];
		for (int i = 0; i < gapList.size(); i++) {
			System.out.println("value" + gapList.get(i));
			bGap[i] = gapList.get(i);
		}

		return bGap;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayBinaryGap g = new ArrayBinaryGap();
		int occurrences[] = g.getBinaryGapForArray(32);
		System.out.println("Gaps are = " + Arrays.toString(occurrences));
	}
}
