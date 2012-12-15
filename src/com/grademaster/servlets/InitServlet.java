package com.grademaster.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grademaster.*;
import com.grademaster.logging.*;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 5420347520988085861L;
	public void init() {
		Logger log = Globals.log;
		log.log("Configuring configuration path...",ErrorLevel.INFO);
		Globals.setConfigURL(getServletContext().getRealPath("/xml/Config.xml"));
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//Do nothing
	}
}
