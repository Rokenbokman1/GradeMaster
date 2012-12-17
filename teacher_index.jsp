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
			<h1>Welcome, @<%= user.getName() %>!</h1>
			<p>Welcome to <%= iConfig.name %>! This is the place for you to
				submit your student's grades into the gradebook, manage calendars, and take attendance.  You may watch a tutorial to get started or close this message.</p>
			<p>
			<a href="edit_user.do?value=false" class="btn btn-primary btn-large">Close</a>
				<a href="tutorial.jsp?t=teacher" class="btn btn-primary btn-large">Watch a quick start tutorial on how to use <%= iConfig.name %>.
					&raquo;</a>
			</p>
		</div>
		<% } %>

		<!-- Example row of columns -->
		<div class="row">
			<div class="span4">
				<h2>Grade Overview</h2>
				<div class="column>">
				<ul>
					<%
					ClassDataBase base = Globals.getClasses();
					ArrayList<MyClass> classes	= new ArrayList<MyClass>();
					for (int i=0;i<base.getObjects().size();i++) {
						MyClass iClass = (MyClass) base.getObject(i);
						if (iClass.getUid().equals(user.getUid())) {
							classes.add(iClass);
						}
					}
					for (MyClass iClass : classes) {
					%>
					<li><a href="teacher_class.do?id=<%= iClass.getCid() %>">@<%= iClass.getName() %></a> | @CLASS1GRADE</li>
					<% } %>
				</ul>
				</div>
				<p>
					<a class="btn" href="#gradebook">Full Gradebook &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>Quik Assignment Creation</h2>
				<form>
					<select name="quikcreateclassselect">
						<option selected>Select A Class</option>
						<option value="quikcreateselectclass1">@CLASS1NAME</option>
						<option value="quikcreateselectclass2">@CLASS2NAME</option>
						<option value="quikcreateselectclass3">@CLASS3NAME</option>
						<option value="quikcreateselectclass4">@CLASS4NAME</option>
						<option value="quikcreateselectclass5">@CLASS5NAME</option>
					</select> <input type="text" name="quikcreatename"
						placeholder="Assignment Name"> <input type="date"
						name="quikcreateduedate" placeholder="Assignment Due-Date">
					<select name="quikcreatemultiplier">
						<option value="quikcreatemultiplier1x">1x</option>
						<option value="quikcreatemultiplier2x">2x</option>
						<option value="quikcreatemultiplier3x">3x</option>
						<option value="quikcreatemultiplier4x">4x</option>
						<option value="quikcreatemultiplier5x">5x</option>
					</select> <br>
					<button type="submit" class="btn btn-primary">Submit
						Assignment</button>
				</form>
				<p>
					<a class="btn" href="#createassingment">Full Assignment
						Creation &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>Quik Attendance</h2>
				<form>
					<select name="quikattendanceclass">
						<option selected>Choose a Class</option>
						<option value="quikattendance@CLASS1NAME">@CLASS1NAME</option>
						<option value="quikattendance@CLASS2NAME">@CLASS2NAME</option>
						<option value="quikattendance@CLASS3NAME">@CLASS3NAME</option>
						<option value="quikattendance@CLASS4NAME">@CLASS4NAME</option>
						<option value="quikattendance@CLASS5NAME">@CLASS5NAME</option>
					</select> <select name="quikattendancestudent">
						<option selected>Select a Student</option>
						<option value="quikattendance@STUDENT1NAME">@STUDENT1NAME</option>
						<option value="quikattendance@STUDENT2NAME">@STUDENT2NAME</option>
						<option value="quikattendance@STUDENT3NAME">@STUDENT3NAME</option>
						<option value="quikattendance@STUDENT4NAME">@STUDENT4NAME</option>
						<option value="quikattendance@STUDENT5NAME">@STUDENT5NAME</option>
					</select>
					<p>Remember, Present until proven Absent!</p>
					<select name="quikattendanceselect">
						<option selected value="quikattendanceselectpresent">Present</option>
						<option value="quikattendanceselecttardy">Tardy</option>
						<option value="quikattendanceselectabsent">Absent</option>
					</select> <br>
					<button type="submit" class="btn btn-primary">Submit
						Attendance</button>
				</form>
				<p>
					<a class="btn" href="#attendance">Full Attendance &raquo;</a>
				</p>
			</div>
		</div>
		<% if (user.isShowWelcomeMessage()) { %>
		<a href="edit_user.do?value=false">Hide welcome message</a>
		<% } else { %>
		<a href="edit_user.do?value=true">Show welcome message</a>
		<% } %>
		<jsp:include page="footer.jsp" />