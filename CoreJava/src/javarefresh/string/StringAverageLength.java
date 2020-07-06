/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Purpose:
 *
 * e.g. 'Pattern pattern $ Pattern_compile(\"[a-zA-Z_]+\");' is 5
 *
 * 5 + 5 + 15 + 1 + 2 + 1 = 33/6 = 5.5 ~ 5
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class StringAverageLength {

	private int findAverageLength(String str) {
		Pattern pattern = Pattern.compile("[a-zA-Z_]+");
		Matcher matcher = pattern.matcher(str);
		int totalWords = 0;
		int totalChar = 0;
		while (matcher.find()) {
			totalChar = totalChar + matcher.group().length();
			totalWords++;
		}
		return (int) (totalChar / totalWords);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringAverageLength sa = new StringAverageLength();
		String str = "Pattern pattern $ Pattern_compile(\"[a-zA-Z_]+\");";
		int count = sa.findAverageLength(str);
		System.out.println(count);
	}

}
