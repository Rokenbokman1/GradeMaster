package com.grademaster.data;
import java.io.Flushable;
import java.io.IOException;

//Author: Jake Billings
//Date created: 12-13-2012
//Desc: provides an interface for base methods for data io.

public interface IDataInterface extends Flushable {
	// Loads data from file.  DOES NOT UPDATE CACHE; DOES NOT USE CACHE
	public IDataObject loadData() throws IOException, Exception;
	// Loads data using and/or updating cache.
	public IDataObject getData() throws IOException, Exception;
	// Updates cache with given data
	public void updateCache(IDataObject data);
	// Writes the contents of the current cache to the data source.
	public void dumpData() throws Exception;
	// Updates cache with given data, then writes the data
	public void dumpData(IDataObject data) throws Exception;
	// Writes provided data to data source; DOES NOT UPDATE CACHE
	public void writeData(IDataObject data) throws Exception;
	// NOTE: Flush must be called to finalize any data writing.
}
