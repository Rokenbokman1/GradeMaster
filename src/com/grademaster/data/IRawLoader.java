package com.grademaster.data;

import java.io.IOException;

/**
 * Author: Jake Billings
 * Date created: 12-13-2012
 * Desc: Interface for loading raw data as a string (simple IO)
 * @author jake
 *
 */
public interface IRawLoader {
	/**
	 * Loads a string from a source
	 * @return String the String loaded
	 * @throws IOException If IO failed
	 */
	public String loadString() throws IOException;
	/**
	 * Writes a string to the data source
	 * @param s The String to write
	 * @throws IOException If IO failed
	 */
	public void writeString(String s) throws IOException;
	/**
	 * Gets the path of IO
	 * @return String the path the loader uses for IO
	 */
	public String getPath();
}
