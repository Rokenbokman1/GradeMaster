<%@ page import="com.eakjb.EakjbData.IDataStructure"%>
<%@ page import="com.grademaster.*"%>

<jsp:include page="${request.contextPath}/shared/header.jsp" />

<%
	IDataStructure iConfig = (IDataStructure) session
			.getAttribute("iConfig");
	IDataStructure user = (IDataStructure) session.getAttribute("user");
	boolean loggedIn = (Boolean) session.getAttribute("loggedIn");

	String tutorial = "both";
	if (request.getParameter("id") != null
			&& (tutorial.equals("student") || tutorial
					.equals("teacher"))) {
		tutorial = request.getParameter("t");
	}
%>

<body>

	<jsp:include page="${request.contextPath }/shared/nav.jsp" />
	<div class="container">
	<%
		char[] stringArray = tutorial.toCharArray();
		stringArray[0] = Character.toUpperCase(stringArray[0]);
		tutorial = new String(stringArray);
	%>
	<h1><%=tutorial%>
		tutorials coming soon.
	</h1>
	</div>
	<jsp:include page="footer.jsp" />