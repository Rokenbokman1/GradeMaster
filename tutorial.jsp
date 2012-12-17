<%@ page import="com.grademaster.data.objects.*" %>
<%@ page import="com.grademaster.*" %>
<% 
Config iConfig = Globals.getConfig();
User user=null;
if (session.getAttribute("loggedIn")!=null && (Boolean) session.getAttribute("loggedIn")) {
	user = (User) session.getAttribute("user");
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
	<% if (session.getAttribute("loggedIn")!=null && (Boolean) session.getAttribute("loggedIn") == true && user.getUserType().equals("teacher")) { %>
		<jsp:include page="teacher_nav.jsp" />
	<% } else { %>
		<jsp:include page="student_nav.jsp" />
	<% } %>
	<div class="container">
	<%
	char[] stringArray = tutorial.toCharArray();
	stringArray[0] = Character.toUpperCase(stringArray[0]);
	tutorial = new String(stringArray);
	%>
	<h1><%= tutorial %> tutorials coming soon.</h1>
		
<jsp:include page="footer.jsp" />