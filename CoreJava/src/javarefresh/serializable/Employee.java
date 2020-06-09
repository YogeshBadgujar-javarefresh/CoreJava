/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Purpose:
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class Employee implements Serializable {

	/**
	 * Note - If you add/update any field then you need to regenerate the
	 * serialVersionUID again.
	 */
	private static final long serialVersionUID = 477288098703618429L;

	private int id;

	private String name;

	private String dept;

	private transient String address;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * As per coding std you need to overwrite the this method.
	 * @param inputStream
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
		id = inputStream.readInt();
		name = inputStream.readUTF();
		dept = inputStream.readUTF();
	}

	/**
	 * As per coding std you need to overwrite the this method.
	 * 
	 * @param outputStream
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream outputStream) throws IOException {
		outputStream.writeInt(id);
		outputStream.writeUTF(name);
		outputStream.writeUTF(dept);
	}
}
