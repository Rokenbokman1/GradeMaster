package com.grademaster;

import java.io.FileNotFoundException;

import com.grademaster.data.RawLocalLoader;
import com.grademaster.data.XMLInterface;
import com.grademaster.data.objects.Config;
import com.grademaster.data.xml.XMLConfigAdapter;
import com.grademaster.logging.ErrorLevel;
import com.grademaster.logging.Logger;

public class Globals {
	private static Config CON;
	private static Logger log;
	private static String configURL = System.getProperty("user.dir")+System.getProperty("file.separator")+"xml/config.xml";
	
	public static String getConfigURL() {
		log.log("Globals returned config url.");
		return configURL;
	}
	
	public static void setConfigURL(String u) {
		log.log("Globals sets config url.");
		if (u==configURL) {
			return;
		} else {
			configURL = u;
			updateConfig();
		}		
	}
	//Returns a logger and creates a new one if it doesn't exist
	public static Logger getLogger() {
		if (log==null) {
			try {
				log = new Logger();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return log;
	}
	// Forces a reload of the main config file
	public static void updateConfig() {
		log.log("Updating config...");
		CON = loadConfig();
	}
	//Loads config with cache
	public static Config getConfig() {
		log.log("Getting config...");
		if (CON == null) {
			CON = loadConfig();
		}
		return CON;
	}
	// Loads config bypassing cache
	public static Config loadConfig() {
		log.log("Re-Loading config...",ErrorLevel.INFO);
		XMLInterface i = new XMLInterface(new RawLocalLoader(configURL), new XMLConfigAdapter());
		Config con = null;
		try {
			con = (Config) i.getData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.log(e);
		}
		return con;
	}
}
