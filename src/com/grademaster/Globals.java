package com.grademaster;

import java.io.FileNotFoundException;

import com.eakjb.EakjbData.Logging.*;

public class Globals {
	private static Logger log;
	
	private static String configURL = System.getProperty("user.dir")+"/xml/Config.xml";
	private static String userURL = System.getProperty("user.dir")+"/xml/Users.xml";
	private static String classURL = System.getProperty("user.dir")+"/xml/Classes.xml";
	private static String assignmentURL = System.getProperty("user.dir")+"/xml/Assignments.xml";
	
	private static String loggerPath = System.getProperty("user.dir")+"/GradeMaster.log";
	
	
	
	
	public static void setAssignmentURL(String a) {
		Globals.assignmentURL=a;
	}
	
	public static String getAssignmentURL() {
		return assignmentURL;
	}
	public static void setClassURL(String classURL) {
		Globals.classURL=classURL;
	}
	
	public static String getClassURL() {
		return classURL;
	}

	public static String getConfigURL() {
		return configURL;
	}

	public static void setConfigURL(String u) {
		if (u==configURL) {
			return;
		} else {
			configURL = u;
		}		
	}
	public static void setUserURL(String path) {
		userURL=path;
	}
	public static String getUserURL() {
		return userURL;
	}

	public static String getLoggerPath() {
		return loggerPath;
	}

	public static void setLoggerPath(String loggerPath) throws FileNotFoundException {
		Globals.loggerPath = loggerPath;
		Globals.setLogger(new Logger(loggerPath));
	}

	public static Logger getLogger() {
		return log;
	}

	public static void setLogger(Logger log) {
		Globals.log = log;
		Globals.loggerPath=log.path;
	}
}
