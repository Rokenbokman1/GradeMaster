<%@ page import="com.eakjb.EakjbData.IDataStructure" %>
<%@ page import="com.grademaster.Globals" %>
<% 
IDataStructure iConfig = Globals.getStructure("Config");
IDataStructure user=null;
if (session.getAttribute("loggedIn")!=null && (Boolean) session.getAttribute("loggedIn")) {
	user = (IDataStructure) session.getAttribute("user");
	}
String tutorial = "both";
if (!(request.getParameter("t")==null || request.getParameter("t") =="")) {
	if (request.getParameter("t").equals("student")) {
		tutorial="student";
	} else if (request.getParameter("t").equals("teacher")) {
		tutorial="teacher";
	}
}
 %>
	
<jsp:include page="header.jsp" />
<body>
	<% if (session.getAttribute("loggedIn")!=null && (Boolean) session.getAttribute("loggedIn") == true && user.get("type").getTextValue().equals("teacher")) { %>
		<jsp:include page="../teacher/teacher_nav.jsp" />
	<% } else { %>
		<jsp:include page="../student/student_nav.jsp" />
	<% } %>
	<div class="container">
	<%
	char[] stringArray = tutorial.toCharArray();
	stringArray[0] = Character.toUpperCase(stringArray[0]);
	tutorial = new String(stringArray);
	%>
	<h1><%= tutorial %> tutorials coming soon.</h1>
		
<jsp:include page="footer.jsp" />