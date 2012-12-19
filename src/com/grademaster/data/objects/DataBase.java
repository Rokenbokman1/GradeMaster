package com.grademaster.data.objects;

import com.grademaster.data.IDataObject;
import java.util.ArrayList;

public abstract class DataBase implements IDataObject {
	protected ArrayList<Object> Objects;
	public DataBase (ArrayList<Object> Objects) {
		this.setObjects(Objects);
	}
	public DataBase() {
		this(new ArrayList<Object>());
	}
	public ArrayList<Object> getObjects() {
		return Objects;
	}
	public void setObjects(ArrayList<Object> Objects) {
		this.Objects = Objects;
	}
	public Object getObject(int x) {
		return Objects.get(x);
	}
	public void addObject(Object u) {
		Objects.add(u);
	}
	public void removeObject(Object u) {
		Objects.remove(u);
	}
	public void removeObject(int x) {
		Objects.remove(x);
	}
	
}
