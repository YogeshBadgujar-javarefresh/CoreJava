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
public class Dictionary_workmen_work_men {

	public static void main(String[] args) {
		try {
			long time = System.currentTimeMillis();
			// Reading all the lines of file 'wordlist.txt'.
			Scanner in = new Scanner(new BufferedReader(new FileReader("javarefresh/codility/wordlist.txt")));
			List<String> wordList = new ArrayList<>();
			int total = 0;
			while (in.hasNextLine()) {
				String word = in.nextLine().trim();
				if (!word.isEmpty()) {
					wordList.add(word);
					total++;
				}
			}
			List<List<String>> combinationsList = new ArrayList<>();
			// Logic - workmen, work, men
			// Take the value from First loop then search over the collection with startwith
			// (second loop) after find match then find remaining part of word from the
			// collection.
			wordList.stream().forEach(tempFirst -> {
				wordList.parallelStream().forEach(tempSecond -> {
					if (!tempFirst.equals(tempSecond) && tempFirst.startsWith(tempSecond)
							&& wordList.contains(tempFirst.substring(tempSecond.length()))) {
						List<String> tempList = new ArrayList<>();
						tempList.add(tempFirst);
						tempList.add(tempSecond);
						tempList.add(tempFirst.substring(tempSecond.length()));
						combinationsList.add(tempList);
					}
				});
			});
			System.out.println("Total word are =" + total);
			System.out.println("Combinations List size =" + combinationsList.size());

			// Writing to the file 'combinationsFaster.txt'.
			PrintWriter output = new PrintWriter(
					new BufferedWriter(new FileWriter("javarefresh/codility/combinationsFaster.txt")));

			combinationsList.stream().forEach(x -> {
				output.println(x);
			});
			output.close();
			time = System.currentTimeMillis() - time;
			System.out.println("Total Executation time for class LocalDictionaryFaster.java is " + time);
		} catch (

		IOException e) {
			System.out.println("IO error in wordlist.txt");
		}
	}
}
