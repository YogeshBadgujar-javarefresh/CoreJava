/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.collection;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

/**
 * Purpose:Write a program using employee object as map key where employee
 * having 3 property ( to check knowledge of immutability) <br>
 * a. Name : String <br>
 * b. DOB : LocalDate <br>
 * c. Age : int
 *
 * Description: Created the immutable  Using builder pattern set the object. 
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class HashMapEmployeeImmutable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Employee1, String> employeeMap = new HashMap<>();
		Employee1 employee1 = Employee1.EmployeeBuilder.anEmployee().buildName("Yogesh")
				.buildDOB(LocalDate.of(1981, Month.JUNE, 30)).buildAge(35).build();
		employeeMap.put(employee1, "Intellective");
		Employee1 employee2 = Employee1.EmployeeBuilder.anEmployee().buildName("Kirti")
				.buildDOB(LocalDate.of(1989, Month.MARCH, 5)).buildAge(35).build();
		employeeMap.put(employee2, "HSBC");

		employeeMap.entrySet().stream().forEach(x -> {
			System.out.println("Key =" + x.getKey() + " and value = " + x.getValue());
			Employee1 emp = x.getKey();
			System.out.println("Name =" + emp.getName() + ", DOB=" + emp.getDOB() + " and age=" + emp.getAge());
		});
	}
}

final class Employee1 {
	private final String name;
	private final LocalDate dob;
	private final int age;

	public Employee1(EmployeeBuilder employeeBuilder) {
		this.name = employeeBuilder.name;
		this.dob = employeeBuilder.dob;
		this.age = employeeBuilder.age;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Employee1 employee = (Employee1) o;
		if (age != employee.age)
			return false;
		if (name != null ? !name.equals(employee.name) : employee.name != null)
			return false;
		return dob != null ? dob.equals(employee.dob) : employee.dob == null;
	}

	@Override
	public int hashCode() {
		int result = age ^ (age >>> 32);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (dob != null ? dob.hashCode() : 0);
		return result;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDOB() {
		return dob;
	}

	public int getAge() {
		return age;
	}

	static final class EmployeeBuilder {
		private String name;
		private LocalDate dob;
		private int age;

		public Employee1 build() {
			return new Employee1(this);
		}

		public static EmployeeBuilder anEmployee() {
			return new EmployeeBuilder();
		}

		public EmployeeBuilder buildName(String name) {
			this.name = name;
			return this;
		}

		public EmployeeBuilder buildDOB(LocalDate dob) {
			this.dob = dob;
			return this;
		}

		public EmployeeBuilder buildAge(int age) {
			this.age = age;
			return this;
		}
	}
}
