/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Purpose:Find the repeat char and place with-in as well.
 * 
 * e.g. Yogggeshh!!!! to Yog3esh2!4
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class CharRepeatCountWithinChar {

	private String findCharRepeatCountWithinChar(String str) {

		//Maintain the char Map with count
		Map<Character, Integer> charMap = new HashMap<>();
		int counter = 0;
		//if more than 1 char then flag is use so that will filter the 
		boolean islastRepeat = false;
		for (int i = 0; i <= str.length() - 1; i++) {
			if (i != str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
				counter++;
				islastRepeat = true;
			} else {
				if (islastRepeat) {
					charMap.put(str.charAt(i), counter + 1);
				}
				islastRepeat = false;
				counter = 0;
			}
		}

		Set<Character> keys = charMap.keySet();
		for (Character c : keys) {
			StringBuilder target = new StringBuilder();
			String replace = "";
			for (int i = 0; i < charMap.get(c); i++) {
				target.append(c);
			}
			replace = c + charMap.get(c).toString();
			String temp = str.replace(target.toString(), replace);
			str = temp;
		}

		return str;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CharRepeatCountWithinChar ch = new CharRepeatCountWithinChar();
		String value = "Yogggeshh!!!!";
		String str = ch.findCharRepeatCountWithinChar(value);
		System.out.println(value + " to given " + str);
	}

}
