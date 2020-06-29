/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.number;

import java.util.Scanner;

/**
 * Purpose:Which number is divide to a given number at time..
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class DivideByWhichNumber {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.print("Enter 2 Numbers : ");
		
		String name = s.nextLine();

		String a[] = name.split(" ");

		int first = Integer.parseInt(a[0]);
		int second = Integer.parseInt(a[1]);
		// Write your code here
		int small = (first < second ? first : second);
		int upto = (first < second ? second : first);
		int count = 1;
		int divideBy = 2;
		for (int i = small; i < upto; i++) {

			int temp1 = first % divideBy;
			int temp2 = second % divideBy;
			if (temp1 == 0 & temp2 == 0) {
				count++;
			}

			divideBy++;
		}
		System.out.println("Divisible Number =" + count);
	}
}
