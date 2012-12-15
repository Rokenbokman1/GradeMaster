package com.grademaster.data;

import java.io.IOException;

//Author: Jake Billings
//Date created: 12-13-2012
//Desc: Interface for loader raw data

public interface IRawLoader {
	//Loads a string from a source
	public String loadString() throws IOException;
	//Writes a string to the data source
	public void writeString(String s) throws IOException;
	//Gets the path loaded from
	public String getPath();
}
