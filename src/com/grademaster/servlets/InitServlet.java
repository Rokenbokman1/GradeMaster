package com.grademaster.servlets;

import javax.servlet.http.HttpServlet;

import com.grademaster.*;
import com.grademaster.logging.*;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 5420347520988085861L;
	public void init() {
	    Globals.getLogger().log("Initializing...",ErrorLevel.INFO);
		Logger log = Globals.getLogger();
		log.log("Configuring configuration path...",ErrorLevel.INFO);
		Globals.setConfigURL(getServletContext().getRealPath("/xml/Config.xml"));
	}
}
