/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.codility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Purpose:Find the word combination of a words in particular format from the
 * list of given words. All the given words are the part of the wordlist file
 * provided to you. Word can be split into 2 part first part and second part,
 * such as yardstick => yard + stick
 * 
 * e.g.<br>
 * "The following are examples of combinations we would like you to find /
 * count<br>
 * [adaptability, adapt, ability] <br>
 * [adjustable, adjust, able] <br>
 * [yardstick, yard, stick] <br>
 * [abodes, abo, des) <br>
 * [adages, ad, ages] <br>
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class Dictionary_workmen_work_men_OldWay {

	public static void main(String[] args) {
		try {
			long time = System.currentTimeMillis();
			// Reading all the lines of file 'wordlist.txt' and store into list.
			Scanner in = new Scanner(new BufferedReader(
					new FileReader("/home/user/git/CoreJava/CoreJava/src/javarefresh/codility/wordlist.txt")));
			List<String> wordList = new ArrayList<>();
			int total = 0;
			while (in.hasNextLine()) {
				String word = in.nextLine().trim();
				if (!word.isEmpty()) {
					wordList.add(word);
					total++;
				}
			}
			//Using Java 1.6 - output takes 52 sec for 45000 records.
			List<List<String>> combinationsList = new ArrayList<>();
			// Logic - workmen, work, men
			// Take the value from First loop then search over the collection
			// (second loop) after find match then find second word from the collection.
			for (int i = 0; i < wordList.size(); i++) {
				String tempFirst = wordList.get(i);
				for (int j = 0; j < wordList.size(); j++) {
					String tempSecond = wordList.get(j);
					if (!tempFirst.equals(tempSecond) && tempFirst.startsWith(tempSecond)) {
						String tempThird = tempFirst.substring(tempSecond.length());
						if (wordList.contains(tempThird)) {
							List<String> tempList = new ArrayList<>();
							tempList.add(tempFirst);
							tempList.add(tempSecond);
							tempList.add(tempThird);
							combinationsList.add(tempList);
						}
					}
				}
			}

			System.out.println("Total word are =" + total);
			System.out.println("Combinations List size =" + combinationsList.size());

			// Writing to the file 'combinations.txt'.
			PrintWriter output = new PrintWriter(new BufferedWriter(
					new FileWriter("/home/user/git/CoreJava/CoreJava/src/javarefresh/codility/combinations.txt")));

			for (List<String> templs : combinationsList) {
				output.println(templs);
			}
			output.close();
			time = System.currentTimeMillis() - time;
			System.out.println("Total Executation time for class LocalDictionaryOld.java is " + time);
		} catch (IOException e) {
			System.out.println("IO error in wordlist.txt");
		}

	}

}
