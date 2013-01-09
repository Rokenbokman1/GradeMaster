package com.grademaster;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import com.eakjb.EakjbData.DataInterface;
import com.eakjb.EakjbData.IDataInterface;
import com.eakjb.EakjbData.IDataStructure;
import com.eakjb.EakjbData.RawLocalLoader;
import com.eakjb.EakjbData.DataAdapters.XMLAdapter;
import com.eakjb.EakjbData.Logging.*;

public class Globals {
	private static HashMap<String,Object> props = genDefaults();
	
	private static HashMap<String,Object> genDefaults() {
		HashMap<String,Object> p = new HashMap<String,Object>();
		
		try {
			p.put("logger", new Logger(System.getProperties().get("user.dir")+"/Grademaster.log"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<String> paths = new ArrayList<String>();
		
		paths.add("Config");
		paths.add("Users");
		paths.add("Classes");
		paths.add("Assignments");
		
		p.put("interfaces", paths);
		
		for (String path : paths) {
			setInterface(path,System.getProperties().get("user.dir")+"/xml/"+path+".xml",p);
		}
           
		return p;
	}
	public static HashMap<String,Object> setInterface(String i, String path, HashMap<String,Object> p) {
		p.put(i+".path", path);
		p.put(i+".interface", new DataInterface(new RawLocalLoader((String) p.get(i+".path"), (Logger) p.get("logger")), new XMLAdapter((Logger) p.get("logger")), true, (Logger) p.get("logger")));
		return p;
	}
	public static IDataInterface getInterface(String i) {
		return (IDataInterface) props.get(i+".interface");
	}
	public static IDataStructure getStructure(String i) {
		try {
			return (IDataStructure) ((IDataStructure) getInterface(i).getData()).get(i);
		} catch (Exception e) {
			Globals.getLogger().log(e);
		}
		return null;
	}
	public static void setInterface(String i, String path) {
		props=setInterface(i,path,props);
	}
	public static HashMap<String,Object> getProps() {
		return props;
	}
	public static void setProps(HashMap<String,Object> props) {
		Globals.props = props;
	}
	public static Logger getLogger() {
		return (Logger) props.get("logger");
	}
}


