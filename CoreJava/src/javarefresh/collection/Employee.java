/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.collection;

/**
 * Purpose:
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class Employee {

	private int id;
	private String name;
	private String lastName;
	private String depName;

	public Employee() {

	}

	public Employee(int id, String name, String lastName, String depName) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.depName = depName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String toString() {
		StringBuilder sf = new StringBuilder();
		sf.append("id=" + this.id).append(" Name =" + this.name)
		.append(" LastName=" + this.lastName).append(" Dep Name="+this.depName);
		return sf.toString();
	}

}
