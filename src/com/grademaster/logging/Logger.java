package com.grademaster.logging;

import java.io.PrintStream;
import java.util.Date;

//Author: Jake Billings
//Date created: 12-13-2012
//Desc: Logs messages.  It currently does little more than println(), but may play a larger role as logging can be adapted to new forms.

public class Logger {
	private PrintStream out;
	private PrintStream err;
	//Creates a logger with default console output
	public Logger() {
		this(System.out,System.err);
	}
	//Creates a logger with adaptable output streams
	public Logger(PrintStream out, PrintStream err) {
		this.out=out;
		this.err=err;
	}
	public void log(Throwable t) {
		log("Throwable detected.  Printing stack trace...", ErrorLevel.ERROR);
		t.printStackTrace(err);
	}
	public void log(String message) {
		log(message,ErrorLevel.DEBUG);
	}
	//Log a message to console or other source later in deveolopment
	public void log(String message, ErrorLevel level) {
		Date date = new Date();
		String output="["+date+"] ["+level+"] "+message;
		if (level.error_level > 3) {
			err.println(output);
		} else {
			out.println(output);
		}
	}
	//A test method that should be removed before release.
	public static void test_log() {
		Logger log = new Logger();
		log.log("Test", ErrorLevel.DEBUG);
		log.log("Test 2", ErrorLevel.SEVERE);
	}
}
