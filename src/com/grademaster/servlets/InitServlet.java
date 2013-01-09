package com.grademaster.servlets;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

import com.grademaster.*;
import com.eakjb.EakjbData.Logging.*;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 5420347520988085861L;
	public void init() {
		try {
			Globals.getProps().put("logger", new Logger(getServletContext().getRealPath("GradeMaster.log")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Logger log = Globals.getLogger();
		log.log("Initializing...",ErrorLevel.INFO);
		ArrayList<String> a = (ArrayList<String>) Globals.getProps().get("interfaces");
		for (String s : a) {
			log.log("Configuring '"+s+"' path to: " + getServletContext().getRealPath("/xml/"+s+".xml"),ErrorLevel.INFO);
			Globals.setInterface(s, getServletContext().getRealPath("/xml/"+s+".xml"));
		}
	}
}
