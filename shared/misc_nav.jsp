<%@ page import="com.grademaster.Globals" %>
<%@ page import="com.eakjb.EakjbData.IDataStructure" %>

<%
IDataStructure iConfig = (IDataStructure) session.getAttribute("iConfig");
boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
%>

<ul class="nav">
	<li class="active"><a href="index.do">Home</a></li>
	<li><a href="shared/about.jsp">About</a></li>
	<li><a href="shared/tutorial.jsp">Tutorials</a></li>
</ul>
