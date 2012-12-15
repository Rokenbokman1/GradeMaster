package com.grademaster.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RawLocalLoader implements IRawLoader {
	
	String path;
	
	public RawLocalLoader(String path) {
		this.path=System.getProperty("user.dir")+System.getProperty("file.separator")+path;
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

	@Override
	public void writeString(String s) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		writer.write(s);
		writer.flush();
		writer.close();
	}

}
