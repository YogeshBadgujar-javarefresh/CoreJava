/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose:Given Array will be Chunk or break using given size.
 *
 * Description: e.g.<br>
 * chunks([1,2,3,4,5] , 2) -> [[1,2],[3,4],[5]] <br>
 * chunks([1,2,3,4,5] , 1) -> [[1],[2],[3],[4],[5] <br>
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class ArrayChunksOrBreaks {

	/**
	 * Break the Array into given size and give the 2 dimension array.
	 * 
	 * @param array - Given array
	 * @param size  - Size to break the array into
	 * @return - Return 2 dimension array
	 */
	public List<List<Integer>> chunksWithCollection(int[] array, int size) {
		List<List<Integer>> mainList = new ArrayList<>();
		List<Integer> subList = new ArrayList<>();
		int incrementCounter = 1;
		for (int i = 0; i < array.length; i++) {
			if (incrementCounter == size) {
				subList.add(array[i]);
				mainList.add(subList);
				// Re-set the counter and sublist
				incrementCounter = 1;
				subList = new ArrayList<>();
			} else {
				subList.add(array[i]);
				incrementCounter++;
			}
		}
		// Insert the list which is less than break size(means last remaining element)
		if (subList.size() < size & !subList.isEmpty()) {
			mainList.add(subList);
		}
		return mainList;
	}

	/**
	 * Break the Array into given size and give the 2 dimension array.
	 * 
	 * @param array - Given array
	 * @param size  - Size to break the array into
	 * @return - Return 2 dimension array
	 */
	public int[][] chunksWithArray(int[] array, int size) {
		// Initialize the two dimension array
		int finalArraySize = (array.length % size == 0 ? array.length / size : ((array.length/size) + 1));
		int[][] finalArray = new int[finalArraySize][];
		int[] innerArrary = new int[size];
		int innerCounter = 0;
		int outerCounter = 0;
		for (int i = 0; i < array.length; i++) {
			// Check the size of innerArray equal to break size
			
			if ((innerCounter + 1) == size) {
				innerArrary[innerCounter] = array[i];
				finalArray[outerCounter] = innerArrary;
				// Set the innerCounter and initialize the array
				// Also check the last array will not make fill with zero value i.e. [5,0,0]
				if (outerCounter+1 == finalArraySize-1) {
					int defineSize = (array.length % size == 0 ? size : array.length % size);
					innerArrary = new int[defineSize];
				} else {
					innerArrary = new int[size];
				}
				innerCounter = 0;
				outerCounter++;
			} else {
				innerArrary[innerCounter] = array[i];
				innerCounter++;
			}
		}
		//Only when execute when reminder not zero to put last value
		if(innerArrary.length > 0 && array.length % size != 0) {
			finalArray[outerCounter] = innerArrary;
		}
		return finalArray;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayChunksOrBreaks breaks = new ArrayChunksOrBreaks();
		// chunksWithCollection
		int[] array = { 1, 2, 3, 4, 5, 6 };
		int chunkSize = 2;
		List<List<Integer>> breakList = breaks.chunksWithCollection(array, chunkSize);
		breakList.stream().forEach(x -> {
			System.out.println("Using Collection Inner List =" + x.toString());
			/*x.stream().forEach(y -> {
				System.out.println("Value of Inner List=" + y.intValue());
			});*/
		});

		// chunksWithArray
		int[] arrayA = { 1, 2, 3, 4, 5, 6,7 };
		int chunkSizeA = 2;
		int[][] finalArray = breaks.chunksWithArray(arrayA, chunkSizeA);
		System.out.print("Array split using 2 array dimension => ");
		for (int[] arr : finalArray) {
			System.out.print("[");
			for (int x : arr) {
				System.out.print(x + " ");
			}
			System.out.print("], ");
		}
	}
}
