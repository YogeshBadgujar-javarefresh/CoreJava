/**
 * Copyright (c) 2004, 2020, Yogesh Badgujar and/or its affiliates. 
 * All rights reserved and PROPRIETARY/CONFIDENTIAL. 
 * Use is subject to Yogesh Badgujar terms.
 */
package javarefresh.fileHandle;

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
 * Purpose:Read the file using Scanner and fill into a desire object, finally
 * write the data into file as well.
 *
 * Description:Read the file line by line using Scanner.
 *
 * @author Yogesh Badgujar email me in case any problem -
 *         badgujar.yogesh@gmail.com
 *
 */
public class ReadFileUsingScanner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			/*
			 * Reading all the lines of file 'scannerReadFile.txt'.
			 */
			Scanner in = new Scanner(new BufferedReader(
					new FileReader("/home/user/git/CoreJava/CoreJava/src/javarefresh/fileHandle/scannerReadFile.txt")));
			List<String> inputData = new ArrayList<>();
			int numLines = 0;
			while (in.hasNextLine()) {
				String line = in.nextLine();
				if (!line.isEmpty()) {
					numLines++;
					inputData.add(line);
				}
			}
			System.out.println("Number of lines in file =" + numLines);
			inputData.stream().forEach(x -> {
				System.out.println(x);
			});
			/*
			 * Writing to the file 'scannerWriteFile.txt'.
			 */
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(
					"/home/user/git/CoreJava/CoreJava/src/javarefresh/fileHandle/scannerWriteFile.txt")));
			output.println("" + numLines);
			output.println("" + inputData.toString());
			output.close();
		} catch (IOException e) {
			System.out.println("IO error in input.txt or output.txt");
		}

	}
}
