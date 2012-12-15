package com.grademaster.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grademaster.*;
import com.grademaster.data.objects.Config;
import com.grademaster.logging.ErrorLevel;
import com.grademaster.logging.Logger;

public class ConfigViewServlet extends HttpServlet {
	private static final long serialVersionUID = -9088365072065846961L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Logger log = Globals.log;
		Config con = Globals.getConfig();
		log.log("Config View Servlet Started.",ErrorLevel.INFO);
		PrintWriter out;
		out = res.getWriter();
		out.write("<html><body><table><tr><td>Author: </td><td>" + con.metadata.author  + "</td></tr><tr><td>Version: </td></tr><tr><td>"+con.metadata.version+"</td></tr></table></body></html>");
	}
}
