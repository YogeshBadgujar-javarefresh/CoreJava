/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.singleton;

/**
 * Purpose: Test the DoubleCheckedSingleton class from outside of the class.
 *
 * Description:Test the DoubleCheckedSingleton.
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class DoubleCheckedSingletonTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		DoubleCheckedSingleton firstCall = DoubleCheckedSingleton.getInstance();
		System.out.println("Get the instance of the class");
		Thread.sleep(1000);
		System.out.println("Get another the instance of the class after delay ");
		DoubleCheckedSingleton secondCall = DoubleCheckedSingleton.getInstance();
		if (firstCall == secondCall) {
			System.out.println("Same instance");
		} else {
			System.out.println("Another instance created");
		}

	}

}
