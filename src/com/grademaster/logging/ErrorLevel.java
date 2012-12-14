package com.grademaster.logging;

//Author: Jake Billings
//Date Created: 12-13-2012
//Desc: An enum used to determine the severity of a log message

public enum ErrorLevel {
	DEBUG (1),
	INFO (2),
	WARNING (3),
	ERROR (4),
	SEVERE (5),
	CRITICAL (6);
	
	public final int error_level;
	
	ErrorLevel(int e) {
		error_level=e;
	}
}
