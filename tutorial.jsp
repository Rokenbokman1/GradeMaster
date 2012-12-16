<%@ page import="com.grademaster.data.objects.*" %>
<%@ page import="com.grademaster.*" %>
<% 
Config iConfig = Globals.getConfig();
User user=null;
if ((Boolean) session.getAttribute("loggedIn")) {
	user = (User) session.getAttribute("user");
	}
String tutorial = "both";
if (!(request.getParameter("t")==null || request.getParameter("t") =="")) {
	if (request.getParameter("t")=="student") {
		tutorial="student";
	} else if (request.getParameter("t")=="teacher") {
		tutorial="teacher";
	}
}
 %>
	
<jsp:include page="header.jsp" />
<body>
	<% if (user != null && user.getUserType().equals("teacher")) { %>
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