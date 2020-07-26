/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.java8;

import java.io.Serializable;

/**
 * Purpose:CricketEmployee class
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = -5500575493305990033L;

	private int age;
	private String firstName;
	private String lastName;
	private String dept;

	public Employee() {

	}

	public Employee(int age, String firstName, String lastName, String dept) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}
