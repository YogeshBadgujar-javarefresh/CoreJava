/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.string;

/**
 * Purpose: Check the correct password from the given string Rules - <br>
 * it has to contain only alphanumerical characters (a-z, A-Z, 0-9); <br>
 * should even number of letters; <br>
 * should odd number of digits.
 *
 *
 * e.g. "your 6 b0A get007 x1y?", there are five words and three of them are
 * valid passwords: "6", "b0A", "gets007". Thus the longest password is
 * "gets007" and its length is 7. <br>
 * Note that neither "yogesh" nor "x1y?" is a valid password, because "?" is not
 * an alphanumerical character and "your" contains an even number of digits
 * (zero). Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class CorrectPassword {

	public String getCorrectPasswordCount(String str) {
		String correctStr = "";
		String longPass = "";
		String[] array = str.trim().split(" ");
		for (String word : array) {
			int numCount = 0;
			int letterCount = 0;
			boolean noValid = false;
			for (char c : word.toCharArray()) {
				if (is_Numeric(c)) {
					numCount++;
				} else if (is_Letter(c)) {
					letterCount++;
				} else {
					noValid = true;
					break;
				}
			}
			
			if(!noValid & (numCount % 2 == 1) & (letterCount % 2 == 0)) {
				correctStr = correctStr + " "+word;
				if(word.length() > longPass.length()) {
					longPass = word;
				}
			}
		}
		System.out.println("Longest password ="+longPass);
		return correctStr;
	}

	public boolean is_Letter(char ch) {
		ch = Character.toUpperCase(ch);
		return (ch >= 'A' && ch <= 'Z');
	}

	public boolean is_Numeric(char ch) {
		return (ch >= '0' && ch <= '9');
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CorrectPassword c = new CorrectPassword();
		String correct = c.getCorrectPasswordCount("test 5 a0A pass007 ?xy1");
		System.out.println("Correct Password words are =" + correct);
	}

}
