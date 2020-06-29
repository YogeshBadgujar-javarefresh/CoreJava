/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.logical;

import java.util.Scanner;

/**
 * Purpose:Create the Diamand based on given number size.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class DiamandStructure {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Rows for Diamond Structure : ");

		//Build the upper structure
		int n = scan.nextInt();
		int space = n - 1;

		for (int i = 1; i <= n; i++) {
			for (int c = 1; c <= space; c++) {
				System.out.print(" ");
			}
			space--;
			for (int c = 1; c <= (2 * i - 1); c++) {
				System.out.print("*");
			}
			System.out.println();
		}

		//Build down section
		space = 1;

		for (int d = 1; d <= (n - 1); d++) {
			for (int c = 1; c <= space; c++) {
				System.out.print(" ");
			}
			space++;
			for (int c = 1; c <= (2 * (n - d) - 1); c++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
