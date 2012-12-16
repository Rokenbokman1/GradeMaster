package com.grademaster.data.objects;

public class Teacher extends User {

	public Teacher(String uname, String pword, String fname, String lname,
			String uid) {
		this(uname, pword, fname, lname, uid,true);
	}
	public Teacher(String uname, String pword, String fname, String lname,
			String uid, boolean showWelcomeMessage) {
		super(uname, pword, fname, lname, uid, showWelcomeMessage);
	}

	@Override
	public String getUserType() {
		return "teacher";
	}

}
