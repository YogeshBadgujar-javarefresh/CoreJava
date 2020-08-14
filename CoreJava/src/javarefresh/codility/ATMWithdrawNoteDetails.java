/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.codility;

import java.util.Scanner;

/**
 * Purpose:ATM withdraw note message based on enter amount.<br>
 * Note calculation should go in particular sequence only. <br>
 * Amount ==> 50 Rs note --> 20 Rs note --> 10 Rs note<br>
 * Exception - <br>
 * 1) -ve value throw exception<br>
 * 2) Amount not in multiple of 10 then throw exception.
 *
 * Description:example <br>
 * Amount 530 Rs then it should display - 50*10 20*1 10*1
 * 
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class ATMWithdrawNoteDetails {

	public static void main(String[] args) throws RuntimeException {

		System.out.print("Please enter the amount - ");
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		if (amount < 0) {
			throw new RuntimeException("Error: ....");
		} else if (amount % 10 != 0) {
			throw new RuntimeException("Error: ....");
		}
		int slab[] = { 50, 20, 10 };
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < slab.length; i++) {
			int reminder = amount % slab[i];
			sb.append(slab[i] + "*" + (amount / slab[i]) + " ");
			amount = reminder;
			if (amount == 0) {
				break;
			}
		}
		System.out.println("Note details - " + sb.toString());
	}
}
