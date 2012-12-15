package com.grademaster.data;

import java.io.IOException;

import com.grademaster.Globals;


//Author: Jake Billings
//Date created: 12-13-2012
//Desc: A very basic implementation of IDataInterface that leaves most of the code to subclasses.

public abstract class DataInterface implements IDataInterface {

	//See IRawLoader.java
	public IRawLoader loader;
	
	//Data adapter for converting raw input to data
	public IDataAdapter adapter;
	
	//True=Caching on; False = caching off
	public boolean cached = true;
	
	//True when initial data has been loaded and cached
	public boolean cacheLoaded = false;
	
	//Stores cached objects if caching is enabled
	IDataObject cache;
	
	//Initiates class with given path and caching
	public DataInterface(IRawLoader l,IDataAdapter a,boolean cached) {
		Globals.getLogger().log("Created new Data Interface.");
		this.cached=true;
		this.loader=l;
		this.adapter=a;
	}
	
	// Initiates with a certain path to load and caching on
	public DataInterface(IRawLoader l,IDataAdapter a) {
		this(l,a,true);
	}

	@Override
	public abstract void flush() throws IOException;

	@Override
	public abstract IDataObject loadData() throws IOException, Exception;

	@Override
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
	public void updateCache(IDataObject data) {
		Globals.getLogger().log("Updating cache...");
		cache=data;
	}

	@Override
	public void dumpData() throws Exception {
		Globals.getLogger().log("Dumping current cache.");
		writeData(cache);
	}

	@Override
	public void dumpData(IDataObject data) throws Exception {
		Globals.getLogger().log("Dumping data...");
		if (cached){
			updateCache(data);
		}
		writeData(data);
	}

	@Override
	public abstract void writeData(IDataObject data) throws Exception;

}
