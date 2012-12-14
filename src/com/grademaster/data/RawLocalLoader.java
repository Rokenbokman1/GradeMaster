package com.grademaster.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RawLocalLoader implements IRawLoader {
	
	String path;
	
	public RawLocalLoader(String path) {
		this.path=path;
	}
	
	@Override
	public String loadString() throws IOException {
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader( new FileReader (path));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    return stringBuilder.toString();
	}

	@Override
	public String getPath() {
		return path;
	}

}