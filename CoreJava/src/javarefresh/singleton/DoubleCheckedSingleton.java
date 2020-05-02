/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.singleton;

/**
 * Double synchronized locks
 * 
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 */
public class DoubleCheckedSingleton {

	private static volatile DoubleCheckedSingleton instance;

	private DoubleCheckedSingleton() {
		StaticFactorySingleton.getSingleton();
	}

	public static DoubleCheckedSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckedSingleton.class) {
				// Double checking
				if (instance == null) {
					instance = new DoubleCheckedSingleton();
					System.out.println("First time to create the instance");
				}
			}
		} else {
			System.out.println("Already instance then....");
		}
		return instance;
	}
	
	public static void main(String[] args) throws InterruptedException {
		DoubleCheckedSingleton firstCall = DoubleCheckedSingleton.getInstance();
		System.out.println("Get the instance of the class");
		Thread.sleep(1000);
		System.out.println("Get another the instance of the class after delay ");
		DoubleCheckedSingleton secondCall = DoubleCheckedSingleton.getInstance();
		if(firstCall == secondCall) {
			System.out.println("Same instance");
		} else {
			System.out.println("Another instance created");
		}
		
	}
}

class StaticFactorySingleton {
	// initailzed during class loading
	private static final StaticFactorySingleton instance = new StaticFactorySingleton();

	private StaticFactorySingleton() {
	}

	public static StaticFactorySingleton getSingleton() {
		return instance;
	}
}
