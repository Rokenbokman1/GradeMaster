package com.grademaster;

import com.grademaster.logging.*;

//Author: Jake Billings
//Date created: 12-13-2012
//Desc: Tests functions of the program


public class Tester {
	public static void main(String[] args) {
		Logger log =Globals.getLogger();
		log.log("Loading config...");
		log.log(Globals.getConfig().metadata.version);
	}
}
