/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.string;

/**
 * Purpose:Find longest continuous whitespace characters between any two
 * words(in-case comma come between the space then sequence will break.
 * 
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class FindLongestWhitespaceInString {

	private int getLongestWhitespaceInString(String str) {

		int maxSpaceCounter = 0;
		// Maintain space counter between 2 words.
		int counter = 0;
		boolean isSpace = false;
		for (int i = 0; i <= str.length() - 1; i++) {
			if (str.charAt(i) == ' ') {
				counter++;
				isSpace = true;
			} else {
				if (isSpace && (maxSpaceCounter < counter)) {
					maxSpaceCounter = counter;
				}
				isSpace = false;
				counter = 0;
			}
		}
		return maxSpaceCounter;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindLongestWhitespaceInString fl = new FindLongestWhitespaceInString();
		String str = "I am writting       code   because          I  love coding.  ";
		int counter = fl.getLongestWhitespaceInString(str);
		System.out.println("Max space given string is " + counter);
	}

}
