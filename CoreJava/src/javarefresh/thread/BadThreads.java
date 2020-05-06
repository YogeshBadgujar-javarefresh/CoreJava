/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.thread;

/**
 * If not done proper use of sleep or variable then you will get wrong value
 * 
 * 
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 */
public class BadThreads {
	
	static volatile String message;

	private static class CorrectorThread extends Thread {
		public void run() {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("InterruptedException is "+e.getMessage());
			}
			// Key statement 1:
			message = "Correct message.";
		}
	}

	public static void main(String args[]) throws InterruptedException {
		(new CorrectorThread()).start();
		message = "Not correct message.";
		Thread.sleep(2000);
		// Key statement 2:
		System.out.println(message);
	}
}
