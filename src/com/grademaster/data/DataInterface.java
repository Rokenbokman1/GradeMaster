package com.grademaster.data;

import java.io.IOException;
import java.util.HashMap;

//Author: Jake Billings
//Date created: 12-13-2012
//Desc: A very basic implementation of IDataInterface that leaves most of the code to subclasses.

public abstract class DataInterface implements IDataInterface {

	//See IRawLoader.java
	public IRawLoader loader;
	
	//True=Caching on; False = caching off
	public boolean cached = true;
	
	//True when initial data has been loaded and cached
	public boolean cacheLoaded = false;
	
	//Stores cached objects if caching is enabled
	HashMap<Object,Object> cache = new HashMap<Object,Object>();
	
	//Initiates class with given path and caching
	public DataInterface(IRawLoader l,boolean cached) {
		this.cached=true;
		this.loader=l;
	}
	
	// Initiates with a certain path to load and caching on
	public DataInterface(IRawLoader l) {
		this(l,true);
	}

	@Override
	public abstract void flush() throws IOException;

	@Override
	public abstract HashMap<Object, Object> loadData() throws IOException, Exception;

	@Override
	public HashMap<Object, Object> getData() throws Exception {
		if (cached && cacheLoaded) {
			return cache;
		} else {
			HashMap<Object,Object> data = loadData();
			cacheLoaded=true;
			return data;
		}
	}

	@Override
	public void updateCache(HashMap<Object, Object> data) {
		cache=data;
	}

	@Override
	public void dumpData() throws IOException {
		writeData(cache);
	}

	@Override
	public void dumpData(HashMap<Object,Object> data) throws IOException {
		if (cached){
			updateCache(data);
		}
		writeData(data);
	}

	@Override
	public abstract void writeData(HashMap<Object, Object> data) throws IOException;

}
