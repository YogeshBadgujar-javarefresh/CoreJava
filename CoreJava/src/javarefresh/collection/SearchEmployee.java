/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.collection;

import java.util.ArrayList;
import java.util.List;
import javarefresh.collection.Employee;

/**
 * Purpose: Suppose we have 10,000 records and you want to search based on given
 * input. Also you need to use only collection to search the value. <br>
 * Search record from collection using stream filter without Predicate and with
 * Predicate.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class SearchEmployee {

	private List<Employee> employeeList;

	public SearchEmployee() {
		employeeList = new ArrayList<>();
		// Adding employee
		employeeList.add(new Employee(1, "Yogesh", "Badgujar", "Lending"));
		employeeList.add(new Employee(2, "Sachin", "Patil", "Lending"));
		employeeList.add(new Employee(3, "Ram", "Kumar", "Cards"));
		employeeList.add(new Employee(4, "Seeta", "Zah", "Banking"));
		employeeList.add(new Employee(5, "Geeta", "patil", "Cards"));
		employeeList.add(new Employee(6, "Monu", "Kulkrni", "Banking"));
		employeeList.add(new Employee(7, "Raju", "Kolate", "Banking"));
	}

	/**
	 * Search the Employee based on given values.
	 * 
	 * @param id
	 * @param name
	 * @param lastName
	 * @param depName
	 * @return
	 */
	public List<Employee> searchEmployeeByIdOrName(int id, String name) {
		List<Employee> filterList = new ArrayList<>();
		// Filter the list
		employeeList.stream().filter(p -> (id == p.getId() || p.getName().toLowerCase().startsWith(name.toLowerCase())))
				.forEach(x -> {
					Employee emp = new Employee();
					emp.setId(x.getId());
					emp.setName(x.getName());
					emp.setLastName(x.getLastName());
					emp.setDepName(x.getDepName());
					filterList.add(emp);
				});
		return filterList;
	}
	
	public List<Employee> searchEmployeeByDeptOrLastName(String lastName, String depName) {
		List<Employee> filterList = new ArrayList<>();
		employeeList.stream().filter(p -> (p.getLastName().toLowerCase().startsWith(lastName.toLowerCase()) || p.getDepName().toLowerCase().startsWith(depName.toLowerCase())))
				.forEach(x -> {
					Employee emp = new Employee();
					emp.setId(x.getId());
					emp.setName(x.getName());
					emp.setLastName(x.getLastName());
					emp.setDepName(x.getDepName());
					filterList.add(emp);
				});
		return filterList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchEmployee search = new SearchEmployee();
		List<Employee> searchList = search.searchEmployeeByIdOrName(3, "Yogesh");
		searchList.stream().forEach(x -> {
			System.out.println("Based on id and name result - " + x.toString());
		});
		List<Employee> searchList1 = search.searchEmployeeByDeptOrLastName("Patil", "Cards");
		searchList1.stream().forEach(x -> {
			System.out.println("Based on Last Name and dept result - " + x.toString());
		});
	}
}