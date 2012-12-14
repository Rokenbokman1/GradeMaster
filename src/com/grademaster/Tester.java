package com.grademaster;
import com.grademaster.logging.*;

//Author: Jake Billings
//Date created: 12-13-2012
//Desc: Tests functions of the program

public class Tester {
	public static void main(String[] args) {
		Logger log=new Logger();
		log.log("Testing log with test method...", ErrorLevel.DEBUG);
		Logger.test_log();
		log.log("This is not a real error.", ErrorLevel.ERROR);
		log.log("This is not real either.", ErrorLevel.CRITICAL);
		log.log("Done", ErrorLevel.DEBUG);
	}
}
