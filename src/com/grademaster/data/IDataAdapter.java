package com.grademaster.data;

public interface IDataAdapter {
	public IDataObject dataToObject(Object o);
	public void objectToData(Object o);
}
