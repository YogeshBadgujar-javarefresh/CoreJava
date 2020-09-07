/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.string;

/**
 * Purpose: Detect Capital letter is at correct space or not for a given word.
 * 1) All letters in word should be capital letters - True <br>
 * 2) All letters in word should be small letters - True <br>
 * 3) First letter should be capital letter only- True <br>
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class DetectCapitalLetterAtCorrectPlace {

	public static boolean DetectCaptialLetter(String word) {
		boolean correct = Boolean.TRUE;
		int count = 0;
		boolean isFirst = Boolean.FALSE;
		for (int i = 0; i < word.length(); i++) {
			Character cha = word.charAt(i);
			if (!cha.isLowerCase(cha)) {
				count++;
				if (i == 0) {
					isFirst = Boolean.TRUE;
				}
			}

		}

		if (count > 1 && count < word.length()) {
			correct = Boolean.FALSE;
		}
		if (!isFirst && count == 1) {
			correct = Boolean.FALSE;
		}
		return correct;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String word = "JAVAREFRESH";
		boolean isCorrect = DetectCaptialLetter(word);
		System.out.println("Given '" + word + "' detect "
				+ (isCorrect == Boolean.TRUE ? "correct Capital Letter format" : "not correct Capital Letter format"));

	}

}
