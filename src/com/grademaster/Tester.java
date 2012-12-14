package com.grademaster;

import com.grademaster.logging.*;
import com.grademaster.data.*;
import com.grademaster.data.objects.Config;
//Author: Jake Billings
//Date created: 12-13-2012
//Desc: Tests functions of the program
import com.grademaster.data.xml.XMLConfigAdapter;

public class Tester {
	public static void main(String[] args) {
		Logger log=new Logger();
		
		RawLocalLoader loader = new RawLocalLoader("WebContent/xml/Config.xml");
		XMLConfigAdapter a = new XMLConfigAdapter();
		
		log.log("Config Path: " + loader.getPath(), ErrorLevel.INFO);
		
		XMLInterface xml = new XMLInterface(loader,a);
		
		Config con = null;
		try {
			con = (Config) xml.getData();
		} catch (Exception e) {
			log.log(e);
		}
		
		log.log(con.metadata.author+" wrote this configuration file.");
		log.log("Now trying to edit configuration settings...");
		
		log.log("Done.",ErrorLevel.INFO);
	}
}
