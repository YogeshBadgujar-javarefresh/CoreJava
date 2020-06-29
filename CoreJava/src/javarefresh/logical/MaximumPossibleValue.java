/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.logical;

/**
 * Purpose: On particular number, find out max(+ve /-ve) value by putting certain given number.
 *
 * Description:e.g. Suppose 56 number by placing 5 -> max value will be 565 <br>
 * 
 * -556 number by placing 5 -> max value will be -5565
 * 
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class MaximumPossibleValue {

	/**
	 * Only for +ve number
	 * 
	 * @param num     - Given number
	 * @param byValue - Place number
	 * @return - Max number after placing
	 */
	public int maximumPossiblePositiveNumber(int num, int byValue) {

		if (num == 0) {
			return (Integer.parseInt(byValue + "0"));
		}

		int maxNumber = 0;
		int place = 1;
		int count = Integer.valueOf(num).toString().length();

		for (int i = 0; i <= count; i++) {
			//main formula
			int newVal = ((num / place) * (place * 10)) + (byValue * place) + (num % place);

			if (newVal > maxNumber) {
				maxNumber = newVal;
			}
			//increment by 10 for unit, digit, hundred etc
			place = place * 10;
		}

		return maxNumber;
	}

	/**
	 * Only for -ve number
	 * 
	 * @param num     - Given number
	 * @param byValue - Place number
	 * @return - Max number after placing
	 */
	public int maximumPossibleNegative(int num, int byValue, int negative) {

		// get the absolute value of given number
		num = Math.abs(num);
		
		
		int maxNumber = 0;
		int place = 1;
		int count = Integer.valueOf(num).toString().length();

		// loop to place digit at every possible position in the number,
		// and check the obtained value.
		for (int i = 0; i <= count; i++) {
			int newVal = ((num / place) * (place * 10)) + (byValue * place) + (num % place);

			// if new value is greater the maxVal
			if (newVal > maxNumber) {
				maxNumber = newVal;
			}
			place = place * 10;
		}		
		return maxNumber * negative;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximumPossibleValue m = new MaximumPossibleValue();
		//+ve integer
		int number = 56;
		int max = m.maximumPossiblePositiveNumber(number, 5);
		System.out.println("Max value by placing 5 to this number " + number + " is " + max);
		//-ve integer
		int num = -556;
		int maxNeg = m.maximumPossibleNegative(num, 5, -1);
		System.out.println("Max value by placing 5 to this number " + num + " is " + maxNeg);
	}

}
