/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Purpose: Execute the Thread in sequence such as Red, Green, Blue.
 *
 * Description: Multiple way you can handle this situation <br>
 * Solution A - By using newSingleThreadExecutor() <br>
 * 
 * Solution B - By using newFixedThreadPool() <br>
 * 
 * Solution C - Using Java 8 <br>
 * 
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class ThreadSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Solution A - By using newSingleThreadExecutor()
		List<String> colourList = new ArrayList<>();
		// Red Green Blue
		colourList.add("Red");
		colourList.add("Green");
		colourList.add("Blue");
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for (String colour : colourList) {
			ColourTask loopTask = new ColourTask(colour);
			executor.submit(loopTask);
		}
		executor.shutdown();

		// Solution B - By using newFixedThreadPool()
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
		queue.add("Red");
		queue.add("Green");
		queue.add("Blue");

		ExecutorService executor2 = Executors.newFixedThreadPool(3);
		for (String colour : queue) {
			ColourTask loopTask = new ColourTask(colour);
			executor2.submit(loopTask);
		}
		executor2.shutdown();

		// Solution C - Using Java 8
		ExecutorService executor3 = Executors.newFixedThreadPool(3);
		queue.stream().forEach(x -> {
			ColourTask loopTask = new ColourTask(x);
			executor3.submit(loopTask);
		});
		executor3.shutdown();

		// Solution D - Using Java 8
		ExecutorService executor4 = Executors.newFixedThreadPool(3);
		queue.stream().forEach(x -> {
			Runnable cTask = () -> {
				System.out.println("Java 8 sequence task is " + x);
			};
			executor4.submit(cTask);
		});
		executor4.shutdown();
	}

}

class ColourTask implements Runnable {

	private String colourName;

	public ColourTask(String colourName) {
		super();
		this.colourName = colourName;
	}

	@Override
	public void run() {
		System.out.println("Colour =" + colourName);
	}
}
