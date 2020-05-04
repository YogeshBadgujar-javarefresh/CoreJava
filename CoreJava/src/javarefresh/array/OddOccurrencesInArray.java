/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.array;

import java.util.HashMap;
import java.util.Set;

/**
 * Purpose: More that 1 element repeat then create the pair for same
 * e.g. { 9, 3, 9, 3, 9, 7, 9 } --> only 7 is not have pair/duplicate element.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class OddOccurrencesInArray {

	public int getOddOccurrences(int[] array) {
		// "XOR" (^) when there is a pair A and B
		// A^B will be zero
		// A^B^C (where C is not paired),
		// then A^B^C = C

		if (array.length == 0) {
			return 0;
		}

		int unpaired = array[0];

		for (int i = 1; i < array.length; i++) {
			unpaired = unpaired ^ array[i]; // xor
		}

		return unpaired;
	}

	public int getOddOccurrencesGeneral(int[] array) {
		int occur = 0;
		HashMap<Integer, Integer> occurrencesMap = new HashMap<>();

		for (int i = 0; i < array.length - 1; i++) {
			if (occurrencesMap.containsKey(array[i])) {
				occurrencesMap.put(array[i], occurrencesMap.get(array[i]) + 1);
			} else {
				occurrencesMap.put(array[i], 1);
			}
		}

		Set<Integer> keySet = occurrencesMap.keySet();

		for (int currentKey : keySet) {
			int occurrences = occurrencesMap.get(currentKey);

			// if occurs odd number of times, we found the unpaired value - no need to
			// continue checking
			if (occurrences % 2 != 0) {
				occur = currentKey;
				break;
			}
		}
		return occur;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OddOccurrencesInArray o = new OddOccurrencesInArray();
		int array[] = { 9, 3, 9, 3, 9, 7, 9 };
		int occurrences = o.getOddOccurrences(array);
		System.out.println("Method 1 = " + occurrences);

		System.out.println("Method 2 = " + o.getOddOccurrencesGeneral(array));
	}

}
