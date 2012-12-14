package com.grademaster.data;
import java.io.Flushable;
import java.io.IOException;
import java.util.HashMap;

//Author: Jake Billings
//Date created: 12-13-2012
//Desc: provides an interface for base methods for data io.

public interface IDataInterface extends Flushable {
	// Loads data from file.  DOES NOT UPDATE CACHE; DOES NOT USE CACHE
	public HashMap<Object,Object> loadData();
	// Loads data using and/or updating cache.
	public HashMap<Object,Object> getData();
	// Updates cache with given data
	public void updateCache(HashMap<Object,Object> data);
	// Writes the contents of the current cache to the data source.
	public void dumpData() throws IOException;
	// Writes updates cache with given data, then writes the data
	public void dumpData(HashMap<Object,Object> data) throws IOException;
	// Writes provided data to data source; DOES NOT UPDATE CACHE
	public void writeData(HashMap<Object,Object> data) throws IOException;
	// NOTE: Flush must be called to finalize any data writing.
}
