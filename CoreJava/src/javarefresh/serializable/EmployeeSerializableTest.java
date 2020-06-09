/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Purpose:Serial and De-serial the serial Employee object.
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class EmployeeSerializableTest {

	/**
	 * Serial the Employee Object.
	 * 
	 * @param fileName - Pass the file name.
	 * @param employee - Pass the object which you want to serialize
	 */
	private void serialEmployee(String fileName, Employee employee) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(employee);
			// Close the resources
			oos.close();
			fos.close();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	/**
	 * De-serial the serial object.
	 * 
	 * @param fileName - Send the file name which has already serial object.
	 * @return - Return the Emplyee object
	 * @throws IOException            - Can throw IOException
	 * @throws ClassNotFoundException - Can throw ClassNotFoundException.
	 */
	private Employee deserialEmployee(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Employee deserialEmployee = (Employee) ois.readObject();
		// Close the resources
		ois.close();
		fis.close();
		return deserialEmployee;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Serial the Employee object
		String fileName = "employee.ser";
		Employee em = new Employee(1, "Yogesh", "HSBC");
		EmployeeSerializableTest test = new EmployeeSerializableTest();
		test.serialEmployee(fileName, em);

		// De-Serial the Employee object
		Employee deSerialEmployee = test.deserialEmployee(fileName);
		System.out.println("Id =" + deSerialEmployee.getId());
		System.out.println("Name =" + deSerialEmployee.getName());
		System.out.println("Dept =" + deSerialEmployee.getDept());
	}
}
