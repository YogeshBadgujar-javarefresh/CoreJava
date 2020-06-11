/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Purpose:Write the generic method which will return me list of customer ids
 * which is associated to all areas at a time, here you have 5 areas name as A,
 * B, C, D, E. e.g. Area A list of customers, Area B list of customers same for
 * rest of areas And you will get the string as
 * "A:23455;B:344545;E:2343;A:23556;D:4567;C:563733......".
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class AreaCustomer {

	/**
	 * Send the customer area list and get the area wise customer list. Using java
	 * 1.6 code base.
	 * 
	 * @param customer
	 * @return
	 */
	Map<String, List<Integer>> getAreaCustomer(String customer) {
		Map<String, List<Integer>> customerAreaMap = new HashMap<String, List<Integer>>();
		customerAreaMap.put("A", (new ArrayList<Integer>()));
		customerAreaMap.put("B", (new ArrayList<Integer>()));
		customerAreaMap.put("C", (new ArrayList<Integer>()));
		customerAreaMap.put("D", (new ArrayList<Integer>()));
		customerAreaMap.put("E", (new ArrayList<Integer>()));
		String[] customerAreaSplit = customer.split(";");

		for (String tempCust : customerAreaSplit) {
			String[] custArea = tempCust.split(":");
			if (custArea[0].equals("A")) {
				customerAreaMap.get("A").add(Integer.parseInt(custArea[1]));
			} else if (custArea[0].equals("B")) {
				(customerAreaMap.get("B")).add(Integer.parseInt(custArea[1]));
			} else if (custArea[0].equals("C")) {
				(customerAreaMap.get("C")).add(Integer.parseInt(custArea[1]));
			} else if (custArea[0].equals("D")) {
				(customerAreaMap.get("D")).add(Integer.parseInt(custArea[1]));
			} else if (custArea[0].equals("E")) {
				(customerAreaMap.get("E")).add(Integer.parseInt(custArea[1]));
			}
		}
		return customerAreaMap;
	}

	/**
	 * Send the customer area list and get the area wise customer list. Using java
	 * Java 8 code base.
	 * 
	 * @param customer
	 * @return
	 */
	Map<String, List<Integer>> areawiseCustomerList(String customer) {
		//Here the change in below line.
		Map<String, List<Integer>> customerAreaMap = new HashMap<>();
		customerAreaMap.put("A", (new ArrayList<Integer>()));
		customerAreaMap.put("B", (new ArrayList<Integer>()));
		customerAreaMap.put("C", (new ArrayList<Integer>()));
		customerAreaMap.put("D", (new ArrayList<Integer>()));
		customerAreaMap.put("E", (new ArrayList<Integer>()));
		String[] customerAreaSplit = customer.split(";");

		for (String tempCust : customerAreaSplit) {
			String[] custArea = tempCust.split(":");
			if (custArea[0].equals("A")) {
				customerAreaMap.get("A").add(Integer.parseInt(custArea[1]));
			} else if (custArea[0].equals("B")) {
				(customerAreaMap.get("B")).add(Integer.parseInt(custArea[1]));
			} else if (custArea[0].equals("C")) {
				(customerAreaMap.get("C")).add(Integer.parseInt(custArea[1]));
			} else if (custArea[0].equals("D")) {
				(customerAreaMap.get("D")).add(Integer.parseInt(custArea[1]));
			} else if (custArea[0].equals("E")) {
				(customerAreaMap.get("E")).add(Integer.parseInt(custArea[1]));
			}
		}
		return customerAreaMap;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AreaCustomer ac = new AreaCustomer();
		//Using java 1.6 code base
		System.out.println("Using Java 1.6 -----");
		String customer = "A:23455;B:344545;E:2343;A:23556;D:4567;C:563733";
		Map<String, List<Integer>> customerAreaMap = ac.getAreaCustomer(customer);
		Set<String> areaSet = customerAreaMap.keySet();
		for (String areaName : areaSet) {
			System.out.println(areaName + " Area customer list =" + customerAreaMap.get(areaName));
		}
		
		//Using Java8
		System.out.println("Using Java 8 -----");
		Map<String, List<Integer>> cusAreaMap = ac.areawiseCustomerList(customer);
		cusAreaMap.entrySet().stream().forEach( x -> {
			System.out.println(x.getKey() + " Area customer list =" + x.getValue());
		});
	}

}
