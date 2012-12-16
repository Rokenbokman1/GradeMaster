package com.grademaster.data.objects;

import com.grademaster.data.IDataObject;

public abstract class User implements IDataObject {
	private String username;
	private String password;
	private String fname;
	private String lname;
	private boolean showWelcomeMessage;
	private final String uid;
	public User(String uname, String pword, String fname, String lname, String uid) {
		this(uname,pword,fname,lname,uid,true);
	}
	public User(String uname, String pword, String fname, String lname, String uid, boolean showWelcomeMessage) {
		this.username=uname;
		this.password=pword;
		this.fname=fname;
		this.lname=lname;
		this.uid=uid;
		this.showWelcomeMessage=showWelcomeMessage;
	}
	public abstract String getUserType();
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getUid() {
		return uid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getName() {
		return fname+" "+lname;
	}
	public static User getInstance(String uname, String pword, String fname, String lname, String uid,String type,boolean showWelcomeMessage) {
		User u = null;
		if (type.equals("teacher")) {
			u = new Teacher(uname,pword,fname,lname,uid,showWelcomeMessage);
		} else {
			u = new Student(uname,pword,fname,lname,uid,showWelcomeMessage);
		} 
		return u;
	}
	public static User getInstance(String uname, String pword, String fname, String lname, String uid,String type) {
		return getInstance(uname,pword,fname,lname,uid,type,true);
	}
	public boolean isShowWelcomeMessage() {
		return showWelcomeMessage;
	}
	public void setShowWelcomeMessage(boolean showWelcomeMessage) {
		this.showWelcomeMessage = showWelcomeMessage;
	}
}
