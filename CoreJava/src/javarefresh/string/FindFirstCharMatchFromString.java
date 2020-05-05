/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.string;

/**
 * Assignment - 
 * Find the first char match from the given string/word
 * 
 * e.g. Input - javarefresh and output - a
 * e.g. Input - yogeshbadgujar and output - g
 * e.g. Input - finding and out - f
 * e.g. Input - abcba and out - a
 * 
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 *
 */
public class FindFirstCharMatchFromString {
	
	public String matchChar(String word) {
		String firstChar = "";
		boolean out = false;
		for(int i=0; i < word.length()-1; i++) {
			char c = word.charAt(i);
			for(int j=i+1; j < word.length(); j++) {
				char c2 = word.charAt(j);
				if(c == c2) {
					firstChar = word.charAt(i) + "";
					out = true;
					break;
				}
			}
			if(out) {
				break;
			}
		}
		return firstChar;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindFirstCharMatchFromString f = new FindFirstCharMatchFromString();
		System.out.println("Input - javarefresh and Output "+f.matchChar("javarefresh"));
		System.out.println("Input - yogeshbadgujar and Output "+f.matchChar("yogeshbadgujar"));
		System.out.println("Input - maskanine and Output "+f.matchChar("maskanine"));
		System.out.println("Input - finding and Output "+f.matchChar("finding"));
		System.out.println("Input - abcba and Output "+f.matchChar("abcba"));
	}
}
