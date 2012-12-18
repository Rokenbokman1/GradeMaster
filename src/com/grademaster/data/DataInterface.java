package com.grademaster.data;

import java.io.IOException;

import com.grademaster.Globals;

/**
 * DataInterface provides the cache handling and misc. functions of a data interface that would be the same across all IDataInterfaces
 * 
 * Author: Jake Billings
 * Date created: 12-13-2012
 * Desc: A very basic implementation of IDataInterface that leaves most of the code to subclasses.
 * @author jake
 *
 */


public abstract class DataInterface implements IDataInterface {

	//See IRawLoader.java
	/**
	 * The IRawLoader that loads raw data for the DataInterface as a String.
	 * See IRawLoader and RawLocalLoader
	 */
	public IRawLoader loader;
	
	//Data adapter for converting raw input to data
	/**
	 * The IDataAdapter that converts data from its raw data format to a com.grademaster.data.object
	 */
	public IDataAdapter adapter;
	
	//True=Caching on; False = caching off
	/**
	 * True=cached DataInterface; False=non-cached DataInterface
	 * Caching uses slightly more memory, but improves performance.  It may lead to confusing IO errors.
	 * No cachcing increases ease of coding and decreases memory usage, but leads to more IO total.
	 */
	public boolean cached = true;
	
	//True when initial data has been loaded and cached
	/**
	 * For internal use, tells whether or not a cache has been loaded at all
	 */
	protected boolean cacheLoaded = false;
	
	//Stores cached objects if caching is enabled
	/**
	 * Stores the cached objects if caching is enabled
	 */
	IDataObject cache;
	
	//Initiates class with given path and caching
	/**
	 * Contructs a new DataInterface with a given IRawLoader (see loader), IDataAdapter (see adapter), and determines caching
	 * @param l The IRawLoader used
	 * @param a The IDataAdaper used
	 * @param cached If DataInterface uses caching
	 */
	public DataInterface(IRawLoader l,IDataAdapter a,boolean cached) {
		Globals.getLogger().log("Created new Data Interface.");
		this.cached=true;
		this.loader=l;
		this.adapter=a;
	}
	
	// Initiates with a certain path to load and caching on
	/**
	 * Contructs a new DataInterface with a given IRawLoader (see loader), IDataAdapter (see adapter), and determines caching
	 * Uses the default value of true for caching
	 * @param l The IRawLoader used
	 * @param a The IDataAdaper used
	 */
	public DataInterface(IRawLoader l,IDataAdapter a) {
		this(l,a,true);
	}
	
	
	@Override
	/**
	 * Not currently used for anything and I'm not sure it ever will be.
	 */
	public abstract void flush() throws IOException;
	
	@Override
	/**
	 * Loads and returns data bypassing the cache.  Specific to subclasses.
	 */
	public abstract IDataObject loadData() throws IOException, Exception;
	
	@Override
	/**
	 * Uses cache (if enabled) to return data.  If data not loaded, then it calls loadData()
	 * @returns IDataObject The data object cached or loaded
	 */
	public IDataObject getData() throws Exception {
		if (cached && cacheLoaded) {
			Globals.getLogger().log("Returned cached data.");
			return cache;
		} else {
			Globals.getLogger().log("Loaded new data.");
			IDataObject data = loadData();
			cacheLoaded=true;
			return data;
		}
	}

	@Override
	/**
	 * Updates the cache with data from loadData()
	 */
	public void updateCache(IDataObject data) {
		Globals.getLogger().log("Updating cache...");
		cache=data;
	}
	
	@Override
	/**
	 * Writes the current cached data using the IRawLoader
	 */
	public void dumpData() throws Exception {
		Globals.getLogger().log("Dumping current cache.");
		writeData(cache);
	}
	
	
	@Override
	/**
	 * Updates the cache (if enabled) with given data, then writes the data
	 * @param IDataObject IDataObject to dump
	 */
	public void dumpData(IDataObject data) throws Exception {
		Globals.getLogger().log("Dumping data...");
		if (cached){
			updateCache(data);
		}
		writeData(data);
	}

	@Override
	/**
	 * Writes data; specific to subclasses
	 */
	public abstract void writeData(IDataObject data) throws Exception;

}
