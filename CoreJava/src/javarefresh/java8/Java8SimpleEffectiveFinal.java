/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.java8;

/**
 * Purpose:Simple effectively final feature and @FunctionalInterface interface of Java 8.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class Java8SimpleEffectiveFinal {

	public void projectTechnology(String techDetails) {
		String defaultTechValue = "Java, J2EE, ";
		// implements IRefresh interface
		IRefresh iRefresh = () -> System.out
				.println("My last project technologies are " + defaultTechValue + " " + techDetails);
		// call getTechnology method other wise it won't print it.
		iRefresh.getTechnology();
	}

	public static void main(String[] args) {
		Java8SimpleEffectiveFinal efe = new Java8SimpleEffectiveFinal();
		efe.projectTechnology("Microservices, Spring Boot, Cloud");
	}

}

@FunctionalInterface
interface IRefresh {
	void getTechnology();
}
