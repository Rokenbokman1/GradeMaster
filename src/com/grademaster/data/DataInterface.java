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
	public void flush() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public HashMap<Object, Object> loadData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Object, Object> getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCache(HashMap<Object, Object> data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dumpData() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void dumpData(HashMap<Object, Object> data) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeData(HashMap<Object, Object> data) throws IOException {
		// TODO Auto-generated method stub

	}

}
