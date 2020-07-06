/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Purpose:Find the topper student in subject.
 *
 * Description:Given list
 * 
 * 21|Hindi|52 <br>
 * 22|Social Science|45 <br>
 * 23|English|52 <br>
 * 22|Hindi|51 <br>
 * 26|Social Science|72 <br>
 * 23|Social Science|61 <br>
 * 27|English|81 <br>
 * 
 * Result -
 * 
 * English:27 <br>
 * Hindi:21 <br>
 * Social Science:26
 * 
 * 
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class FindTopperStudent {

	public Map<String, Integer> findTopperStudent(List<String> array) {
		// Subject & student
		Map<String, Integer> retVal = new HashMap<>();
		// Subject & highest Marks
		Map<String, Integer> subjectTopEntry = new HashMap<>();
		array.stream().forEach(x -> {
			String[] arr = x.replace("|", ";").split(";"); // ID, Subject, Mark
			if (subjectTopEntry.containsKey(arr[1])) {
				if (subjectTopEntry.get(arr[1]) < Integer.parseInt(arr[2])) {
					subjectTopEntry.put(arr[1], Integer.parseInt(arr[2]));
					retVal.put(arr[1], Integer.parseInt(arr[0]));
				}
			} else {
				subjectTopEntry.put(arr[1], Integer.parseInt(arr[2]));
				retVal.put(arr[1], Integer.parseInt(arr[0]));
			}
		});

		Map<String, Integer> sortByKeyMapRetVal = retVal.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(
				Collectors.toMap(e1 -> e1.getKey(), e -> e.getValue(), (oldKey, newKey) -> oldKey, LinkedHashMap::new));

		return sortByKeyMapRetVal;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FindTopperStudent ts = new FindTopperStudent();
		List<String> list = new ArrayList<>();
		list.add("21|Hindi|52");
		list.add("22|Social Science|45");
		list.add("23|English|52");
		list.add("22|Hindi|51");
		list.add("26|Social Science|72");
		list.add("23|Social Science|61");
		list.add("27|English|81");
		Map<String, Integer> topperMap = ts.findTopperStudent(list);
		topperMap.entrySet().forEach(x -> {
			System.out.println(x.getKey() + ": " + x.getValue());
		});

	}

}
