package com.grademaster.data.objects;

import com.grademaster.data.IDataObject;
import java.util.ArrayList;

public class UserDataBase implements IDataObject {
	private ArrayList<User> users;
	public UserDataBase (ArrayList<User> users) {
		this.setUsers(users);
	}
	public UserDataBase() {
		this(new ArrayList<User>());
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public User getUser(int x) {
		return users.get(x);
	}
	public void addUser(User u) {
		users.add(u);
	}
	public void removeUser(User u) {
		users.remove(u);
	}
	public void removeUser(int x) {
		users.remove(x);
	}
	
}
