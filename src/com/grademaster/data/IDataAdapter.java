package com.grademaster.data;

import javax.xml.parsers.ParserConfigurationException;

public interface IDataAdapter {
	/**
	 *  Converts the given object to a com.grademaster.data.IDataObject making it usable to the application
	 *  
	 * @param o the raw object to convert
	 * @return the processed object to use
	 */
	public IDataObject dataToObject(Object o);
	/**
	 * Converts a com.grademaster.IDataObject to raw data for export or saving
	 * @param o The object to convert
	 * @return the raw string to export
	 * @throws ParserConfigurationException specialized DOM exception
	 * @throws Exception I was lazy, so a threw everything
	 */
	public String objectToData(Object o) throws ParserConfigurationException, Exception;
}
