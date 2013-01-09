package com.grademaster;

import java.io.IOException;
import java.util.HashMap;

import com.eakjb.EakjbData.IDataInterface;
import com.eakjb.EakjbData.IDataStructure;
//import com.grademaster.auth.Hasher;
import com.eakjb.EakjbData.Logging.Logger;

//Author: Jake Billings
//Date created: 12-13-2012
//Desc: Tests functions of the program

/**
 * A tester class for testing apis with loading Apache
 * Rarely used.
 * @author Jake Billings
 */
public class Tester {
	public static void main(String[] args) {
		Logger l = Globals.getLogger();
		
		HashMap<String,Object> p = Globals.getProps();

		IDataInterface i = (IDataInterface) p.get("Config.interface");
		try {
			IDataStructure config = (IDataStructure) i.getData();
			l.log(config.getObjects().toString());
			l.log(((IDataStructure) config.get("metadata")).get("author").getTextValue());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
