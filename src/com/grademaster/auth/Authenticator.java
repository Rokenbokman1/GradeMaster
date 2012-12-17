package com.grademaster.auth;

import java.util.ArrayList;

import com.grademaster.data.objects.User;
import com.grademaster.data.objects.UserDataBase;
import com.grademaster.Globals;

public class Authenticator {
	private UserDataBase users;
	public Authenticator(UserDataBase users) {
		this.users=users;
	}
	public Authenticator() {
		this(Globals.getUsers());
	}
	public User authUser(String uname, String pword, String type) {
		ArrayList<Object> aUsers = users.getObjects();
		User user = null;
		Hasher h = new Hasher(pword);
		String hpword=h.getHashed();
		for (Object u1 : aUsers) {
			User u = (User) u1;
			if (u.getUsername().equals(uname) && u.getPassword().equals(hpword) && u.getUserType().equals(type)) {
				user=u;
			}
		}
		return user;
	}
	public String typeUser(String uname) {
		ArrayList<Object> aUsers = Globals.getUsers().getObjects();
		for (Object u1 : aUsers) {
			User u = (User) u1;
			if (u.getUsername().equals(uname)) {
				return u.getUserType();
			}
		}
		return null;
	}
}
