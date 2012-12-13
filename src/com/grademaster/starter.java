package com.grademaster;

import java.io.*;

//Author: Jake Billings 12-12-2012
/*Desc: This class is testing the Java capabilities of out current environment.
 * I will print "Hello World" and maybe do some other tests.
 */

public class starter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		for (int i=0;i<=10;i++) {
			System.out.println("Iterating: "+i);
		}
		System.out.println("Iterating done.\nTesting console...");
		Console con = System.console();
		if (con==null) {
			System.out.println("No console.");
		} else {
			System.out.print("Input: ");
			String input = con.readLine();
			if (input==null || input=="") {
				System.out.println("No input.");
			} else {
				System.out.println(input);
			}
		}
		System.out.println("Done.");
	}

}
