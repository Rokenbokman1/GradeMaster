package com.grademaster.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.grademaster.Globals;

public class RawLocalLoader implements IRawLoader {
	
	String path;
	
	public RawLocalLoader(String path) {
		Globals.getLogger().log("Created new Raw Local Loader.");
		this.path=path;
	}
	
	@Override
	public String loadString() throws IOException {
		Globals.getLogger().log("Loading local data as string from " + getPath());
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
		Globals.getLogger().log("Returning path...");
		return path;
	}

	@Override
	public void writeString(String s) throws IOException {
		Globals.getLogger().log("Writing data as string...");
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		writer.write(s);
		writer.flush();
		writer.close();
	}

}
