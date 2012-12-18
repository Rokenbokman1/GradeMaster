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
	<jsp:include page="student_nav.jsp" />
	<div class="container">

		<% if (user.isShowWelcomeMessage()) { %>
		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h1>Welcome, <%= iConfig.namePrefix %><%= user.getName() %>!</h1>
			<p>Welcome to <%= iConfig.name %>! This is the place for you to
				submit your student's grades into the gradebook, manage calendars, and take attendance.  You may watch a tutorial to get started or close this message.</p>
			<p>
			<a href="edit_user.do?value=false" class="btn btn-primary btn-large">Close</a>
				<a href="tutorial.jsp?t=student" class="btn btn-primary btn-large">Watch a quick start tutorial on how to use <%= iConfig.name %>.
					&raquo;</a>
			</p>
		</div>
		<% } %>

		<!-- Example row of columns -->
		<div class="row">
			<div class="span4">
				<h2>Grade Overview</h2>
				<div class="column>">
					<li><a href="#1"><%= iConfig.namePrefix %>CLASS1NAME</a> | <%= iConfig.namePrefix %>CLASS1GRADE</li>
					<li><a href="#2"><%= iConfig.namePrefix %>CLASS2NAME</a> | <%= iConfig.namePrefix %>CLASS2GRADE</li>
					<li><a href="#3"><%= iConfig.namePrefix %>CLASS3NAME</a> | <%= iConfig.namePrefix %>CLASS3GRADE</li>
					<li><a href="#4"><%= iConfig.namePrefix %>CLASS4NAME</a> | <%= iConfig.namePrefix %>CLASS4GRADE</li>
					<li><a href="#5"><%= iConfig.namePrefix %>CLASS5NAME</a> | <%= iConfig.namePrefix %>CLASS5GRADE</li>
					<li class="nav-header">Specials</li>
					<li><a href="#6"><%= iConfig.namePrefix %>CLASS6NAME</a> | <%= iConfig.namePrefix %>CLASS6GRADE</li>
					<li><a href="#7"><%= iConfig.namePrefix %>CLASS7NAME</a> | <%= iConfig.namePrefix %>CLASS7GRADE</li>
					<li><a href="#8"><%= iConfig.namePrefix %>CLASS8NAME</a> | <%= iConfig.namePrefix %>CLASS8GRADE</li>
					<li><a href="#9"><%= iConfig.namePrefix %>CLASS9NAME</a> | <%= iConfig.namePrefix %>CLASS9GRADE</li> <br>
				</div>
				<p>
					<a class="btn" href="#gradebook">Full Gradebook &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>To-Do List Overview</h2>
				<p><%= iConfig.namePrefix %>TODOLIST</p>
				<p>
					<a class="btn" href="#todolist">Full To-Do List &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>Calendar Events</h2>
				<p><%= iConfig.namePrefix %>CALENDARLIST</p>
				<p>
					<a class="btn" href="#">Full Calendar &raquo;</a>
				</p>
			</div>
		</div>
		<% if (user.isShowWelcomeMessage()) { %>
		<a href="edit_user.do?value=false">Hide welcome message</a>
		<% } else { %>
		<a href="edit_user.do?value=true">Show welcome message</a>
		<% } %>
		<jsp:include page="footer.jsp" />