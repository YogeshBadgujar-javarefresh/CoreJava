/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Purpose: CountDownLatch sample example
 *
 * Description: There are four task A, B, C, D after completing. Remaining
 * action will work further.
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class CountDownLatchDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// You can loop the task based on N of task.
		// If you give count less also it won't give any error
		final CountDownLatch latch = new CountDownLatch(4);
		Thread taskA = new Thread(new CountDownLatchTask("Task A", 500, latch));
		Thread taskB = new Thread(new CountDownLatchTask("Task B", 500, latch));
		Thread taskC = new Thread(new CountDownLatchTask("Task C", 500, latch));
		Thread taskD = new Thread(new CountDownLatchTask("Task D", 500, latch));

		// Start the task now
		taskA.start();
		taskB.start();
		taskC.start();
		taskD.start();

		try {
			// main thread is waiting on CountDownLatch to finish
			latch.await();
			System.out.println("All task finish THEN do further work...");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

}
