package com.grademaster.data;

import javax.xml.parsers.ParserConfigurationException;

public interface IDataAdapter {
	public IDataObject dataToObject(Object o);
	public String objectToData(Object o) throws ParserConfigurationException, Exception;
}
