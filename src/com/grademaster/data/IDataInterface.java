package com.grademaster.data;
import java.io.Flushable;
import java.io.IOException;

/** @author: Jake Billings
 * Date created: 12-13-2012
 * Desc: provides an interface for base methods for data io.
 * IDataInterface provides basic methods for handling data
*/

public interface IDataInterface extends Flushable {
	/**
	 * Loads data from file.  DOES NOT UPDATE CACHE; DOES NOT USE CACHE
	 * @return IDataObject containing loaded data
	 * @throws IOException if IO failed
	 * @throws Exception I got lazy, so I threw everything else
	 */
	public IDataObject loadData() throws IOException, Exception;
	/**
	 * Loads data using and/or updating cache.
	 * @return IDataObject containing loaded or cached data
	 * @throws IOException if IO failed
	 * @throws Exception I got lazy, so I threw everything
	 */
	public IDataObject getData() throws IOException, Exception;
	/**
	 * Updates cache with given data
	 * @param data Data to be cached
	 */
	public void updateCache(IDataObject data);
	/**
	 * Writes the contents of the current cache to the data source.
	 * @throws Exception I got lazy, so I threw everything
	 */
	public void dumpData() throws Exception;
	/**
	 * Updates cache with given data, then writes the data
	 * @param data data to update cache with, then dump
	 * @throws Exception I got lazy, so I threw everything
	 */
	public void dumpData(IDataObject data) throws Exception;
	/**
	 * Writes provided data to data source; DOES NOT UPDATE CACHE
	 * @param data Data to be written
	 * @throws Exception I got lazy, so I threw everything.
	 */
	public void writeData(IDataObject data) throws Exception;
	// NOTE: Flush must be called to finalize any data writing.
	// UPDATE NOTE: The note above this is a lie.  flush() does nothing
}
