<%@ page import="com.grademaster.data.objects.*"%>
<%@ page import="com.grademaster.*"%>
<%
	User user = null;
	if ((Boolean) session.getAttribute("loggedIn")) {
		user = (User) session.getAttribute("user");
	}
	Config iConfig = Globals.getConfig();
	
	ClassDataBase base = Globals.getClasses();
	MyClass iClass = new MyClass("Error","Error","Error","Error",null);
	for (int i = 0; i < base.getObjects().size(); i++) {
		MyClass c = (MyClass) base.getObject(i);
		if (c.getCid().toString().equals(request.getParameter("id").toString())&&c.getUid().toString().equals(user.getUid())) {
			iClass=c;
			break;
		}
	}
%>

<jsp:include page="header.jsp" />
<body>
	<jsp:include page="teacher_nav.jsp" />
	<div class="container">
	<h2>Class Overview: <%= iConfig.namePrefix %><%= iClass.getName() %></h2>
	<a href="teacher_classes_overview.jsp">&#60;&#60; Classes Overview</a>
	<h3>Information</h3>
	<table style="margin: 30px; cell-padding: 10px;background-color:#F0F0F0;width:100%">
		<tr>
			<td style="padding-right: 50px">ID</td>
			<td><%= iClass.getCid() %></td>
		</tr>
		<tr>
			<td style="padding-right: 50px">Location</td>
			<td><%= iClass.getLoc() %></td>
		</tr>
		<tr>
			<td style="padding-right: 50px">Description</td>
			<td><%= iClass.getDesc() %></td>
		</tr>
	</table>
	<h3>Sections</h3>
	<div style="background-color:#F0F0F0;margin:30px;width:100%">
	<%
	for (ClassSection s : iClass.getSections()) {
	%>
	<h4><%= iConfig.namePrefix %><%= s.getName() %></h4>
	<table style="margin: 30px; cell-padding: 10px;background-color:#F0F0F0;width:80%">
		<tr>
			<td style="padding-right: 50px">ID</td>
			<td><%= s.getSid() %></td>
		</tr>
		<tr>
			<td style="padding-right: 50px">Value</td>
			<td><%= s.getValue() %></td>
		</tr>
		<tr>
			<td style="padding-right: 50px">Description</td>
			<td><%= s.getDesc() %></td>
		</tr>
	</table>
	<%
	}
	%>
	</div>
<jsp:include page="footer.jsp" />