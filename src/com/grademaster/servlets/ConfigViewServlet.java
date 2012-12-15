package com.grademaster.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigViewServlet extends HttpServlet {
	private static final long serialVersionUID = -9088365072065846961L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.getWriter().write("Hello, World 3!");
	}
}
