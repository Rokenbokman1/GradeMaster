package com.grademaster.data.objects;

public class Teacher extends User {

	public Teacher(String uname, String pword, String fname, String lname,
			String uid) {
		super(uname, pword, fname, lname, uid);
	}

	@Override
	public String getUserType() {
		return "teacher";
	}

}
