package com.grademaster.data.objects;

import java.util.ArrayList;

public class ClassDataBase extends DataBase {
	public ClassDataBase (ArrayList<Object> users) {
		super(users);
	}
	public ClassDataBase () {
		this(new ArrayList<Object>());
	}
	
}
