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

<jsp:include page="header.jsp" />
<body>
	<jsp:include page="teacher_nav.jsp" />
	<div class="container">
	
<jsp:include page="footer.jsp" />