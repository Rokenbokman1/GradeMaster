<%@ page import="com.eakjb.EakjbData.IDataStructure" %>
<%@ page import="com.eakjb.EakjbData.IDataObject" %>
<%@ page import="com.grademaster.*" %>
<%@ page import="java.util.ArrayList" %>
<% 
IDataStructure iConfig = Globals.getStructure("Config");
IDataStructure user=null;
if ((Boolean) session.getAttribute("loggedIn")) {
	user = (IDataStructure) session.getAttribute("user");
	}%>
<jsp:include page="header.jsp" />
<body>
	<jsp:include page="teacher_nav.jsp" />


	<div class="container">
		<% if ((Boolean.parseBoolean(user.get("showWelcome").getTextValue()))) { %>
		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h1>Welcome, <%= iConfig.get("namePrefix") %><%= user.get("fname")+" "+user.get("lname") %>!</h1>
			<p>Welcome to <%= iConfig.get("name") %>! This is the place for you to
				submit your student's grades into the gradebook, manage calendars, and take attendance.  You may watch a tutorial to get started or close this message.</p>
			<p>
			<a href="edit_user.do?value=false" class="btn btn-primary btn-large">Close</a>
				<a href="tutorial.jsp?t=teacher" class="btn btn-primary btn-large">Watch a quick start tutorial on how to use <%= iConfig.get("name") %>.
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
					IDataStructure classes=Globals.runAttrQuery("Classes", "class", "uid", user.get("uid").getTextValue());
					for (IDataObject iClass1 : classes) {
						IDataStructure iClass=(IDataStructure) iClass1;
					%>
					<li><a href="teacher_class.jsp?id=<%= iClass.get("cid") %>"><%= iConfig.get("namePrefix") %><%= iClass.get("name") %></a> | <%= iConfig.get("namePrefix") %>CLASS1GRADE</li>
					<% } %>
				</ul>
				</div>
				<p>
					<a class="btn" href="teacher_classes_overview.jsp">Classes overview &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>Create Assignment</h2>
				<form action="quick_assignment_create.do" method="post">
					<select name="sid">
						<option selected>Select a Section</option>
						<%
						for (IDataObject c1 : classes) {
							IDataStructure c=(IDataStructure) c1;
							for (IDataObject s1 : (IDataStructure) c.get("sections")) {
								IDataStructure s = (IDataStructure) s1;
						%>
							<option value="<%= s.get("sid") %>"><%= iConfig.get("namePrefix") %><%= s.get("name") %></option>
						<%
							}
						}
						%>
					</select>
					<input type="text" name="name" placeholder="Assignment Name">
					<input type="date" name="due" placeholder="Assignment Due-Date">
					<input type="text" name="pts" placeholder="Points possible">
					<select name="multi">
						<% for (int i = 1; i<=5; i++) { %>
						<option value="<%= i %>"><%= i %>x</option>
						<% } %>
					</select>
					<input type="text" name="desc" placeholder="Description">
					<br>
					<input type="submit" class="btn btn-primary" value="Submit Assignment >>"/>
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
						<option value="quikattendance<%= iConfig.get("namePrefix") %>CLASS1NAME"><%= iConfig.get("namePrefix") %>CLASS1NAME</option>
						<option value="quikattendance<%= iConfig.get("namePrefix") %>CLASS2NAME"><%= iConfig.get("namePrefix") %>CLASS2NAME</option>
						<option value="quikattendance<%= iConfig.get("namePrefix") %>CLASS3NAME"><%= iConfig.get("namePrefix") %>CLASS3NAME</option>
						<option value="quikattendance<%= iConfig.get("namePrefix") %>CLASS4NAME"><%= iConfig.get("namePrefix") %>CLASS4NAME</option>
						<option value="quikattendance<%= iConfig.get("namePrefix") %>CLASS5NAME"><%= iConfig.get("namePrefix") %>CLASS5NAME</option>
					</select> <select name="quikattendancestudent">
						<option selected>Select a Student</option>
						<option value="quikattendance<%= iConfig.get("namePrefix") %>STUDENT1NAME"><%= iConfig.get("namePrefix") %>STUDENT1NAME</option>
						<option value="quikattendance<%= iConfig.get("namePrefix") %>STUDENT2NAME"><%= iConfig.get("namePrefix") %>STUDENT2NAME</option>
						<option value="quikattendance<%= iConfig.get("namePrefix") %>STUDENT3NAME"><%= iConfig.get("namePrefix") %>STUDENT3NAME</option>
						<option value="quikattendance<%= iConfig.get("namePrefix") %>STUDENT4NAME"><%= iConfig.get("namePrefix") %>STUDENT4NAME</option>
						<option value="quikattendance<%= iConfig.get("namePrefix") %>STUDENT5NAME"><%= iConfig.get("namePrefix") %>STUDENT5NAME</option>
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
		
		<% if (Boolean.parseBoolean(user.get("showWelcome").getTextValue())) { %>
		<a href="edit_user.do?value=false">Hide welcome message</a>
		<% } else { %>
		<a href="edit_user.do?value=true">Show welcome message</a>
		<% } %>
		<jsp:include page="footer.jsp" />