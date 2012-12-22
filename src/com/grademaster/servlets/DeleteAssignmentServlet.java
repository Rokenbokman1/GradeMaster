package com.grademaster.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grademaster.Globals;
import com.grademaster.logging.ErrorLevel;
import com.grademaster.logging.Logger;

import com.grademaster.data.objects.Assignment;
import com.grademaster.data.objects.AssignmentDataBase;

public class DeleteAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = -9088365072065846961L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		Logger log = Globals.getLogger();
		
	    log.log("Create Assignment servlet started.",ErrorLevel.INFO);
	    
		AssignmentDataBase b = Globals.getAssignments();
		
		Assignment a = null;
		
		for (Object a1 : b.getObjects()) {
			Assignment a2 = (Assignment) a1;
			if (a2.getAid().equals(req.getParameter("aid"))) {
				a=a2;
				break;
			}
		}
		
		if (a!=null) {
			b.getObjects().remove(a);
		}
		
		
		Globals.saveAssignments();
		
		if (req.getParameter("redirect")==null || req.getParameter("redirect")=="") {
			res.sendRedirect("index.do");
		} else {
			res.sendRedirect(req.getParameter("redirect"));
		}
	}
}
