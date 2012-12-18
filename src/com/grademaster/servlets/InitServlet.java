package com.grademaster.servlets;

import javax.servlet.http.HttpServlet;

import com.grademaster.*;
import com.grademaster.logging.*;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 5420347520988085861L;
	public void init() {
		Globals.setLoggerPath(getServletContext().getRealPath("GradeMaster.log"));
		Logger log = Globals.getLogger();
	    log.log("Initializing...",ErrorLevel.INFO);
		log.log("Configuring configuration path...",ErrorLevel.INFO);
		Globals.setConfigURL(getServletContext().getRealPath("/xml/Config.xml"));
		log.log("Configuring user path...",ErrorLevel.INFO);
		Globals.setUserURL(getServletContext().getRealPath("/xml/Users.xml"));
		log.log("Configuring classes path...",ErrorLevel.INFO);
		Globals.setClassURL(getServletContext().getRealPath("/xml/Classes.xml"));
		log.log("Configuring assignments path...",ErrorLevel.INFO);
		Globals.setAssignmentURL(getServletContext().getRealPath("/xml/Assignments.xml"));
	}
}
