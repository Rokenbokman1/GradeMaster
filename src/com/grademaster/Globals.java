package com.grademaster;

import java.io.FileNotFoundException;

import com.grademaster.data.RawLocalLoader;
import com.grademaster.data.XMLInterface;
import com.grademaster.data.objects.ClassDataBase;
import com.grademaster.data.objects.Config;
import com.grademaster.data.xml.XMLClassDataBaseAdapter;
import com.grademaster.data.xml.XMLConfigAdapter;
import com.grademaster.logging.ErrorLevel;
import com.grademaster.logging.Logger;
import com.grademaster.data.objects.UserDataBase;
import com.grademaster.data.xml.XMLUserDataBaseAdapter;

public class Globals {
	private static Config CON;
	private static UserDataBase USERS;
	private static XMLInterface USERINTERFACE;
	private static Logger log;
	private static ClassDataBase CLASSES;
	private static String configURL = System.getProperty("user.dir")+"/xml/Config.xml";
	private static String userURL = System.getProperty("user.dir")+"/xml/Users.xml";
	private static String loggerPath = System.getProperty("user.dir")+"/xml/Classes.xml";
	private static XMLInterface CLASSINTERFACE;
	private static String classURL;
	
	public static void setClassURL(String classURL) {
		Globals.classURL=classURL;
		CLASSINTERFACE=null;
		CLASSES=null;
	}
	
	public static String getClassURL() {
		return classURL;
	}
	
	// Forces a reload of the main user file
	public static void updateClasses() {
		log.log("Updating classes...");
		CLASSES = loadClasses();
	}
	//Loads config with cache
	public static ClassDataBase getClasses() {
		log.log("Getting classes...");
		if (CLASSES == null) {
			CLASSES = loadClasses();
		}
		return CLASSES;
	}

	//Load users without cache
	public static ClassDataBase loadClasses() {
		log.log("Loading classes...", ErrorLevel.INFO);
		if (CLASSINTERFACE==null) {
			CLASSINTERFACE = new XMLInterface(new RawLocalLoader(classURL), new XMLClassDataBaseAdapter());
		}
		ClassDataBase classes = null;
		try {
			classes = (ClassDataBase) CLASSINTERFACE.getData();
		} catch (Exception e) {
			log.log(e);
		}
		return classes;
	}

	//Saves cached users
	public static void saveUsers() {
		log.log("Saving user data...", ErrorLevel.INFO);
		try {
			USERINTERFACE.dumpData(USERS);
		} catch (Exception e) {
			log.log(e);
		}
	}

	// Forces a reload of the main user file
	public static void updateUsers() {
		log.log("Updating users...");
		USERS = loadUsers();
	}
	//Loads config with cache
	public static UserDataBase getUsers() {
		log.log("Getting users...");
		if (USERS == null) {
			USERS = loadUsers();
		}
		return USERS;
	}

	//Load users without cache
	public static UserDataBase loadUsers() {
		log.log("Loading users...", ErrorLevel.INFO);
		if (USERINTERFACE==null) {
			USERINTERFACE = new XMLInterface(new RawLocalLoader(userURL), new XMLUserDataBaseAdapter());
		}
		UserDataBase users = null;
		try {
			users = (UserDataBase) USERINTERFACE.getData();
		} catch (Exception e) {
			log.log(e);
		}
		return users;
	}

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
				log = new Logger(loggerPath);
				log.log("New logger initialized.");
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
			log.log(e);
		}
		return con;
	}
	public static void setUserURL(String path) {
		userURL=path;
	}
	public static String getUserURL() {
		return userURL;
	}

	public static String getLoggerPath() {
		return loggerPath;
	}

	public static void setLoggerPath(String loggerPath) {
		Globals.loggerPath = loggerPath;
		Globals.log=null;
	}
}
