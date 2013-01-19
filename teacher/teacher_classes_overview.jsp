					<%@ page import="com.grademaster.data.objects.*"%>
<%@ page import="com.grademaster.*"%>
<%@ page import="java.util.ArrayList" %>
<%
	User user = null;
	if ((Boolean) session.getAttribute("loggedIn")) {
		user = (User) session.getAttribute("user");
	}
	Config iConfig = Globals.getConfig();
	
	ClassDataBase base = Globals.getClasses();
	ArrayList<MyClass> classes	= new ArrayList<MyClass>();
	for (int i=0;i<base.getObjects().size();i++) {
		MyClass iClass = (MyClass) base.getObject(i);
		if (iClass.getUid().equals(user.getUid())) {
			classes.add(iClass);
		}
	}
	%>

<jsp:include page="../shared/header.jsp" />
<body>
	<jsp:include page="teacher_nav.jsp" />
	<div class="container">
	<h2>Classes Overview</h2>
	<a href="index.do">&#60;&#60; Home</a>
	<%
	for (MyClass c : classes) {
	%>
	<h3><%= iConfig.namePrefix %><a href="teacher_class.jsp?id=<%= c.getCid() %>"><%= c.getName() %> &#62;&#62;</a></h3>
		<table style="margin-left: 30px; cell-padding: 10px;background-color:#F0F0F0;width:100%">
		<tr>
			<td style="width:50%">ID</td>
			<td><%= c.getCid() %></td>
		</tr>
		<tr>
			<td style="width:50%">Location</td>
			<td><%= c.getLoc() %></td>
		</tr>
		<tr>
			<td style="width:50%">Description</td>
			<td><%= c.getDesc() %></td>
		</tr>
	</table>
	<%	
	}
	%>
<jsp:include page="../shared/footer.jsp" />