package com.grademaster;

import com.grademaster.auth.Hasher;

//Author: Jake Billings
//Date created: 12-13-2012
//Desc: Tests functions of the program

/**
 * A tester class for testing apis with loading Apache
 * Rarely used.
 * @author Jake Billings
 */
public class Tester {
	public static void main(String[] args) {
		Hasher h = new Hasher("test");
		Globals.getLogger().log(h.getHashed());
	}
}
