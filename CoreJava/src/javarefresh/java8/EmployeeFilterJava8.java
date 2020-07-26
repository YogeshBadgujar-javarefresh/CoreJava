/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * Purpose:Filter list of employee where age is greater than 26 and sort on
 * first name.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class FilterSortEmployee {

	private List<CricketEmployee> employeeList;

	public FilterSortEmployee() {
		employeeList = new ArrayList<>();
		employeeList.add(new CricketEmployee(30, "Virat", "Kohli"));
		employeeList.add(new CricketEmployee(25, "Hardik", "Pandya"));
		employeeList.add(new CricketEmployee(34, "Kedar", "Jadhav"));
		employeeList.add(new CricketEmployee(25, "Jasprit", "Bumrah"));
	}

	public List<CricketEmployee> getEmployeeFilterByAgeSortByFirstName(int age) {
		List<CricketEmployee> filterList = new ArrayList<>();
		employeeList.stream().filter(x -> (age < x.getAge()))
				.sorted((CricketEmployee e1, CricketEmployee e2) -> e1.getFirstName().compareTo(e2.getFirstName())).forEach(y -> {
					CricketEmployee emp = new CricketEmployee();
					emp.setAge(y.getAge());
					emp.setFirstName(y.getFirstName());
					emp.setLastName(y.getLastName());
					filterList.add(emp);
				});
		return filterList;
	}

	public static void main(String[] args) {
		FilterSortEmployee emp = new FilterSortEmployee();
		List<CricketEmployee> filterList = emp.getEmployeeFilterByAgeSortByFirstName(26);
		filterList.stream().forEach(x -> {
			System.out.println(x.getFirstName() + " " + x.getLastName() + " age is "+x.getAge());
		});
	}
}

class CricketEmployee {
	int age;
	String firstName;
	String lastName;

	public CricketEmployee() {

	}

	public CricketEmployee(int age, String firstName, String lastName) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
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
}

