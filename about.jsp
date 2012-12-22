<%@ page import="com.grademaster.data.objects.*" %>
<%@ page import="com.grademaster.*" %>
<% 
Config iConfig = Globals.getConfig();
User user=null;
if ((Boolean) session.getAttribute("loggedIn")) {
	user = (User) session.getAttribute("user");
	}%>
<jsp:include page="header.jsp" />
<body>
	<jsp:include page="about_nav.jsp" />
	<div class="container">
		<div class="hero-unit">
			<h1>About GradeMaster</h1>
			<p>GradeMaster is a versatile alternative UI for Infinite Campus. It is made by 3 students, Matt, Jake, and Ryan.</p>
		</div>
		<div class="row">
			<div class="span4">
				<h2>GradeMaster</h2>
				<p>GradeMaster is a versatile alternative UI for Infinite Campus. It was sparked as a 1 district Infinite Campus replacement. It became a alternitive UI when the creators realized, with the time they had, they could not reach the full capability as Infinite Campus. This system is currently used in CREATECONFIGVARIBLEHERE districts across the nation.</p>
			</div>
		</div>
		<jsp:include page="footer.jsp" />