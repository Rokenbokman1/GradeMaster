<%@ page import="com.grademaster.data.objects.*" %>
<% User user = (User) session.getAttribute("user"); %>
<jsp:include page="header.jsp" />
<body>
	<jsp:include page="student_nav.jsp" />
	<div class="container">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h1>Welcome, @<%= user.getName() %></h1>
			<p>Welcome to GradeMaster I mean! This is the place for you to
				check your grades in all your classes. I hope you're doing well!</p>
			<p>
				<a class="btn btn-primary btn-large">Might Be Used For Something
					but I'm afraid to remove it for it would be a pain to put back in.
					&raquo;</a>
			</p>
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<div class="span4">
				<h2>Grade Overview</h2>
				<div class="column>">
					<li><a href="#1">@CLASS1NAME</a> | @CLASS1GRADE</li>
					<li><a href="#2">@CLASS2NAME</a> | @CLASS2GRADE</li>
					<li><a href="#3">@CLASS3NAME</a> | @CLASS3GRADE</li>
					<li><a href="#4">@CLASS4NAME</a> | @CLASS4GRADE</li>
					<li><a href="#5">@CLASS5NAME</a> | @CLASS5GRADE</li>
					<li class="nav-header">Specials</li>
					<li><a href="#6">@CLASS6NAME</a> | @CLASS6GRADE</li>
					<li><a href="#7">@CLASS7NAME</a> | @CLASS7GRADE</li>
					<li><a href="#8">@CLASS8NAME</a> | @CLASS8GRADE</li>
					<li><a href="#9">@CLASS9NAME</a> | @CLASS9GRADE</li> <br>
				</div>
				<p>
					<a class="btn" href="#gradebook">Full Gradebook &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>To-Do List Overview</h2>
				<p>@TODOLIST</p>
				<p>
					<a class="btn" href="#todolist">Full To-Do List &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>Calendar Events</h2>
				<p>@CALENDARLIST</p>
				<p>
					<a class="btn" href="#">Full Calendar &raquo;</a>
				</p>
			</div>
		</div>
		<jsp:include page="footer.jsp" />