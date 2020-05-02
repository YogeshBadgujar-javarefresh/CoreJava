/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Purpose:CountDownLatch Task.
 *
 * Description: Create the task for CountDownLatch.
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class CountDownLatchTask implements Runnable {
	private final String taskName;
	private final int delayToStart;
	private final CountDownLatch latch;

	public CountDownLatchTask(String taskName, int delayToStart, CountDownLatch latch){
        this.taskName = taskName;
        this.delayToStart = delayToStart;
        this.latch = latch;
    }

	@Override
	public void run() {
		try {
			Thread.sleep(delayToStart);
		} catch (InterruptedException ex) {
			//LOG
		}
		System.out.println(taskName + " is Executed");
		System.out.println("CountDownLatch value Before task ="+latch.getCount());
		latch.countDown(); // reduce count of CountDownLatch by 1
		System.out.println("CountDownLatch value after task ="+latch.getCount());
	}

}
