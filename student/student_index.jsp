<%@ page import="com.eakjb.EakjbData.IDataStructure"%>
<%@ page import="com.grademaster.Globals"%>

<jsp:include page="/${ request.contextPath }/shared/header.jsp" />

<%
	IDataStructure iConfig = (IDataStructure) session
			.getAttribute("iConfig");
	IDataStructure user = (IDataStructure) session.getAttribute("user");
	boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
%>

<body>
	<jsp:include page="/${ request.contextPath }/shared/nav.jsp" />
	<div class="container">

		<%
			if (Boolean.parseBoolean(user.get("showWelcome").getTextValue())) {
		%>
		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h1>
				Welcome,
				<%=iConfig.get("namePrefix")%><%=user.get("fname").getTextValue() + " "
						+ user.get("lname").getTextValue()%>!
			</h1>
			<p>
				Welcome to
				<%=iConfig.get("name")%>! This is the place for you to submit your
				student's grades into the gradebook, manage calendars, and take
				attendance. You may watch a tutorial to get started or close this
				message.
			</p>
			<p>
				<a href="<%= request.getContextPath() %>/edit_user.do?value=false" class="btn btn-primary btn-large">Close</a>
				<a href="<%= request.getContextPath() %>/shared/tutorial.jsp?t=student" class="btn btn-primary btn-large">Watch
					a quick start tutorial on how to use <%=iConfig.get("name")%>.
					&raquo;
				</a>
			</p>
		</div>
		<%
			}
		%>

		<!-- Example row of columns -->
		<div class="row">
			<div class="span4">
				<h2>Grade Overview</h2>
				<div class="column>">
					<ul>
						<li><a href="#1"><%=iConfig.get("namePrefix")%>CLASS1NAME</a>
							| <%=iConfig.get("namePrefix")%>CLASS1GRADE</li>
						<li><a href="#2"><%=iConfig.get("namePrefix")%>CLASS2NAME</a>
							| <%=iConfig.get("namePrefix")%>CLASS2GRADE</li>
						<li><a href="#3"><%=iConfig.get("namePrefix")%>CLASS3NAME</a>
							| <%=iConfig.get("namePrefix")%>CLASS3GRADE</li>
						<li><a href="#4"><%=iConfig.get("namePrefix")%>CLASS4NAME</a>
							| <%=iConfig.get("namePrefix")%>CLASS4GRADE</li>
						<li><a href="#5"><%=iConfig.get("namePrefix")%>CLASS5NAME</a>
							| <%=iConfig.get("namePrefix")%>CLASS5GRADE</li>
						<li class="nav-header">Specials</li>
						<li><a href="#6"><%=iConfig.get("namePrefix")%>CLASS6NAME</a>
							| <%=iConfig.get("namePrefix")%>CLASS6GRADE</li>
						<li><a href="#7"><%=iConfig.get("namePrefix")%>CLASS7NAME</a>
							| <%=iConfig.get("namePrefix")%>CLASS7GRADE</li>
						<li><a href="#8"><%=iConfig.get("namePrefix")%>CLASS8NAME</a>
							| <%=iConfig.get("namePrefix")%>CLASS8GRADE</li>
						<li><a href="#9"><%=iConfig.get("namePrefix")%>CLASS9NAME</a>
							| <%=iConfig.get("namePrefix")%>CLASS9GRADE</li>
						<br>
					</ul>
				</div>
				<p>
					<a class="btn" href="#gradebook">Full Gradebook &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>To-Do List Overview</h2>
				<p><%=iConfig.get("namePrefix")%>TODOLIST
				</p>
				<p>
					<a class="btn" href="#todolist">Full To-Do List &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>Calendar Events</h2>
				<p><%=iConfig.get("namePrefix")%>CALENDARLIST
				</p>
				<p>
					<a class="btn" href="#">Full Calendar &raquo;</a>
				</p>
			</div>
		</div>
		<%
			if (Boolean.parseBoolean(user.get("showWelcome").getTextValue())) {
		%>
		<a href="<%= request.getContextPath() %>/edit_user.do?value=false">Hide welcome message</a>
		<% } else { %>
		<a href="<%= request.getContextPath() %>/edit_user.do?value=true">Show welcome message</a>
		<% } %>
	</div>
	<jsp:include page="${ request.contextPath }/shared/footer.jsp" />