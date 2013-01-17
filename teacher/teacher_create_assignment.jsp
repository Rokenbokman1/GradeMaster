<%@ page import="com.grademaster.data.objects.*" %>
<%@ page import="com.grademaster.*" %>
<%@ page import="java.util.ArrayList" %>
<% 
Config iConfig = Globals.getConfig();
User user=null;
if ((Boolean) session.getAttribute("loggedIn")) {
	user = (User) session.getAttribute("user");
	}%>
<jsp:include page="../shared/header.jsp" />
<body>
	<jsp:include page="teacher_nav.jsp" />


	<div class="container">
		<% if (user.isShowWelcomeMessage()) { %>

		<div class="hero-unit">
			<h1>Welcome to Assignment Creation!</h1>
			<form action="assignment_create.do" method="post">
					<select name="sid">
						<option selected>Select a Section</option>
						<%
						for (MyClass c : classes) {
							for (ClassSection s : c.getSections()) {
						%>
							<option value="<%= s.getSid() %>"><%= iConfig.namePrefix %><%= s.getName() %></option>
						<%
							}
						}
						%>
					</select>
					<input type="text" name="name" placeholder="Assignment Name">
					<input type="date" name="due" placeholder="Assignment Due-Date">
					<input type="text" name="pts" placeholder="Points possible">
					<input type="text" name="standard" placeholder="State Standard">
					<select name="multi">
						<% for (int i = 1; i<=5; i++) { %>
						<option value="<%= i %>"><%= i %>x</option>
						<% } %>
					</select>
					<input type="text" name="desc" placeholder="Description">
					<br>
					<input type="submit" class="btn btn-primary" value="Submit Assignment >>"/>
				</form>
		</div>
		<% if (user.isShowWelcomeMessage()) { %>
		<a href="edit_user.do?value=false">Hide welcome message</a>
		<% } else { %>
		<a href="edit_user.do?value=true">Show welcome message</a>
		<% } %>
		<jsp:include page="../shared/footer.jsp" />