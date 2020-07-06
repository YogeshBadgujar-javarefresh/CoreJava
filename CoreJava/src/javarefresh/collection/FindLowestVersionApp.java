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

/**
 * Purpose:Find the lowest version app. Data is AppName, APIName, version.
 * 
 * Condition - If API is used by only one app then that APP is not consider for
 * lowest API use.
 * 
 * Chat App, Data Storage API, v11 <br>
 * Whatup App, Search API, v6 <br>
 * Chat App, Authentication API, v8 <br>
 * Chat App, Presence API, v2 <br>
 * Video Call App, Data Storage API, v11 <br>
 * Video Call App, Video Compression API, v3 <br>
 * Whatup App, Authentication API, v6 <br>
 * Video Call App, Authentication API, v7 <br>
 * Whatup App, Data Storage API, v10 <br>
 * 
 * Output - Whatup App
 *
 * Description:
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class FindLowestVersionApp {

	private Map<String, List<String>> getAppAPILowestVersion(List<String> list) {
		// Build the API Name & Version
		Map<String, String> apiVersionEntry = new HashMap<>();
		// Also API with App entry
		Map<String, List<String>> apiAppEntry = new HashMap<>();

		list.stream().forEach(x -> {
			String[] arr = x.split(",");
			if (apiVersionEntry.containsKey(arr[1].trim())) {
				String app = arr[0].trim();
				String api = arr[1].trim();
				String ver = arr[2].trim();
				int mapVersion = Integer.parseInt(apiVersionEntry.get(api).replace("v", ""));
				int version = Integer.parseInt(ver.replace("v", ""));
				// Check the lowest version and also set the App at first position
				boolean isAdd = true;
				if (mapVersion > version) {
					apiVersionEntry.put(api, ver);
					List<String> tempList = apiAppEntry.get(api);
					tempList.add(0, app);
					apiAppEntry.put(api, tempList);
					isAdd = false;
				}
				// Normally add App into list
				if (isAdd) {
					List<String> tempList = apiAppEntry.get(api);
					tempList.add(app);
					apiAppEntry.put(api, tempList);
				}

			} else {
				// First time
				apiVersionEntry.put(arr[1].trim(), arr[2].trim());
				List<String> tempList = new ArrayList<>();
				tempList.add(arr[0].trim());
				apiAppEntry.put(arr[1].trim(), tempList);
			}
		});

		// Build the App Name with their different API's
		Map<String, List<String>> appAPIEntry = new HashMap<>();
		apiAppEntry.entrySet().stream().forEach(x -> {
			List<String> appList = x.getValue();
			// Build only when App used more than 1 API
			if (appList.size() > 1) {
				if (appAPIEntry.containsKey(appList.get(0))) {
					List<String> tempList = appAPIEntry.get(appList.get(0));
					tempList.add(x.getKey());
					appAPIEntry.put(appList.get(0), tempList);
				} else {
					List<String> tempList = new ArrayList<>();
					tempList.add(x.getKey());
					appAPIEntry.put(appList.get(0), tempList);
				}
			}
		});
		return appAPIEntry;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Chat App, Data Storage API, v11");
		list.add("Whatup App, Search API, v6");
		list.add("Chat App, Authentication API, v8");
		list.add("Chat App, Presence API, v2");
		list.add("Video Call App, Data Storage API, v11");
		list.add("Video Call App, Video Compression API, v3");
		list.add("Whatup App, Authentication API, v6");
		list.add("Video Call App, Authentication API, v7");
		list.add("Whatup App, Data Storage API, v10");

		FindLowestVersionApp app = new FindLowestVersionApp();
		Map<String, List<String>> appAPIEntry = app.getAppAPILowestVersion(list);
		for (Map.Entry<String, List<String>> e : appAPIEntry.entrySet()) {
			System.out.println(e.getKey());
		}
	}
}
