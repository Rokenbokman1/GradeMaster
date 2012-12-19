package com.grademaster.data.objects;

import com.grademaster.Globals;
import com.grademaster.data.IDataObject;

//Author: Jake Billings
//Date created:12.14.2010
//Desc: Data object for a config file

public class Config implements IDataObject {
	
	public String name;
	public String logoPath;
	public Metadata metadata;
	public String namePrefix;
	public String favicon;
	
	public Config(String name,String author,String date,String version,String logoPath,String namePrefix, String favicon) {
		Globals.getLogger().log("Created new Config object.");
		this.name=name;
		this.metadata=new Metadata();
		this.metadata.author=author;
		this.metadata.date=date;
		this.metadata.version=version;
		this.logoPath=logoPath;
		this.namePrefix=namePrefix;
		this.favicon=favicon;
	}
	//Stores data for the metadata
	public class Metadata implements IDataObject {
		public String author;
		public String date;
		public String version;
	}
}
