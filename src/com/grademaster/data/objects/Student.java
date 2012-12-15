package com.grademaster.data.objects;

public class Student extends User {

	public Student(String uname, String pword, String fname, String lname,
			String uid) {
		super(uname, pword, fname, lname, uid);
	}

	@Override
	public String getUserType() {
		return "student";
	}

}
