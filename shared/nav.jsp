<%@ page import="com.grademaster.Globals"%>
<%@ page import="com.eakjb.EakjbData.IDataStructure"%>

<%
IDataStructure iConfig = (IDataStructure) session.getAttribute("iConfig");
IDataStructure user = (IDataStructure) session.getAttribute("user");
boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
%>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<a class="brand" href="<%= request.getContextPath() %>/index.do">
				<% if (loggedIn) { %>
				<%= iConfig.get("namePrefix") %><%= user.get("fname").getTextValue()+" "+user.get("lname").getTextValue() %>
				<% } else { %>
				<%= iConfig.get("namePrefix") %><%= iConfig.get("name") %>
				<% } %>
			</a>
			
			<div class="nav-collapse collapse">
				<% if (loggedIn&&user.get("type").getTextValue().equals("student")) { %>
				<jsp:include page="${ request.contextPath }/student/student_nav.jsp"></jsp:include>
				<%} else if (loggedIn&&user.get("type").getTextValue().equals("teacher")) { %>
				<jsp:include page="${ request.contextPath }/teacher/teacher_nav.jsp"></jsp:include>
				<%} else { %>
				<jsp:include page="misc_nav.jsp"></jsp:include>
				<% } %>

				<% if (loggedIn) { %>
				<form class="navbar-form pull-right" action="<%= request.getContextPath() %>/logout.do" method="get">
					<input type="submit" value="Log out" class="btn" />
				</form>
				<% } else { %>
				<form class="navbar-form pull-right" action="<%= request.getContextPath() %>/login.do" method="get">
					<input type="submit" value="Log in" class="btn" />
				</form>
				<% } %>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>