package com.grademaster.auth;

import java.util.ArrayList;

import com.grademaster.data.objects.User;
import com.grademaster.data.objects.UserDataBase;
import com.grademaster.Globals;
/**
 * Authenticator objects are used to compare passwords and lookup
 * user data
 * @author jake
 *
 */
public class Authenticator {
	/**
	 * The UserDataBase in which the Authenticator looks up user data
	 */
	private UserDataBase users;
	/**
	 * Constructs an Authenticator object with a given UserDataBase
	 * @param users a UserDataBase object in which user data will be searched for
	 */
	public Authenticator(UserDataBase users) {
		this.users=users;
	}
	/**
	 * Constructs an Authenticator object with a default UserDataBase taken from com.grademaster.globals.getUsers()
	 */
	public Authenticator() {
		this(Globals.getUsers());
	}
	/**
	 * Looks up a user object based on given data returns null if no user found
	 * @param uname The username of the user being looked up
	 * @param pword The password (raw String) of the user being looked up.  Remember, this will be hashed with SHA-256 before comparison
	 * @param type The type of account currently (as of 12-17-2012) "student" or "teacher"
	 * @return either a User object with given properties or null if none was found
	 */
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
	/**
	 * Gets the type of user (as of 12-17-2012 "student" or "teacher") or returns null if not found
	 * @param uname The username of the user being looked up
	 * @return the user type of the user with a given username (as of 12-17-2012 "student or "teacher") or null if no user was found
	 */
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
