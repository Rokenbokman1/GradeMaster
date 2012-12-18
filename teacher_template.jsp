<%@ page import="com.grademaster.data.objects.*" %>
<%@ page import="com.grademaster.*" %>
<%@ page import="java.util.ArrayList" %>
<% 
Config iConfig = Globals.getConfig();
User user=null;
if ((Boolean) session.getAttribute("loggedIn")) {
	user = (User) session.getAttribute("user");
	}%>
<jsp:include page="header.jsp" />
<body>
	<jsp:include page="teacher_nav.jsp" />


	<div class="container">
		<% if (user.isShowWelcomeMessage()) { %>
		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			</p>
		</div>
		<% } %>
		</div>
		<jsp:include page="footer.jsp" />