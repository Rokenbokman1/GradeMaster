package com.grademaster.data;

import java.io.IOException;
import java.util.HashMap;

//Author: Jake Billings
//Date created: 12-13-2012
//Desc: A very basic implementation of IDataInterface that leaves most of the code to subclasses.

public abstract class DataInterface implements IDataInterface {

	//Path should always be different, so it is path error here.
	public String path = "PathError";
	
	//True=Caching on; False = caching off
	public boolean cached = true;
	
	//True when initial data has been loaded and cached
	public boolean cacheLoaded = false;
	
	//Stores cached objects if caching is enabled
	HashMap<Object,Object> cache = new HashMap<Object,Object>();
	
	//Initiates class with given path and caching
	public DataInterface(String path,boolean cached) {
		this.cached=true;
		this.path=path;
	}
	
	// Initiates with a certain path to load and caching on
	public DataInterface(String path) {
		this(path,true);
	}

	@Override
	public abstract void flush() throws IOException;

	@Override
	public abstract HashMap<Object, Object> loadData();

	@Override
	public HashMap<Object, Object> getData() {
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
