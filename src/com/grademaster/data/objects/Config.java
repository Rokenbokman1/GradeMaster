package com.grademaster.data.objects;

import com.grademaster.data.IDataObject;

//Author: Jake Billings
//Date created:12.14.2010
//Desc: Data object for a config file

public class Config implements IDataObject {
	
	public String name;
	public String author;
	public String date;
	public String version;
	public String logoPath;
	
	public Config(String name,String author,String date,String version,String logoPath) {
		this.name=name;
		this.author=author;
		this.date=date;
		this.version=version;
		this.logoPath=logoPath;
	}
}
