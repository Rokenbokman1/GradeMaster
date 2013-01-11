<%@ page import="com.eakjb.EakjbData.IDataStructure"%>
<%@ page import="com.eakjb.EakjbData.IDataObject"%>
<%@ page import="com.grademaster.Globals"%>
<%@ page import="java.util.ArrayList"%>
<%
	IDataStructure user = null;
	if ((Boolean) session.getAttribute("loggedIn")) {
		user = (IDataStructure) session.getAttribute("user");
	}
	IDataStructure iConfig = Globals.getStructure("Config");
%>
<!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a class="brand" href="index.do"><%=iConfig.get("namePrefix")%><%=user.get("fname") + " " + user.get("lname")%></a>
			<div class="nav-collapse collapse">
				<ul class="nav">
					<li class="active"><a href="index.do">Home</a></li>
					<li><a href="about.jsp">About</a></li>
					<li><a href="create_assignment.do">Create Assignment</a></li>
					<li><a href="teacher_calendar.do">Calendar</a></li>
					<li><a href="teacher_gradebook.do">Gradebook</a></li>
					<li><a href="attendance.do">Attendance</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Classes <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="teacher_classes_overview.jsp">Overview</a>
							<li class="divider"></li>
							<li class="nav-header">Classes</li>
							<%
								IDataStructure classes = Globals.runAttrQuery("Classes", "class",
										"uid", user.get("uid").getTextValue());
								for (IDataObject iClass1 : classes.getObjects()) {
									IDataStructure iClass = (IDataStructure) iClass1;
							%>
							<li><a href="teacher_class.jsp?id=<%=iClass.get("cid")%>"><%=iConfig.get("namePrefix")%><%=iClass.get("name")%></a></li>
							<%
								}
							%>
						</ul></li>
				</ul>
				<%
					if ((Boolean) session.getAttribute("loggedIn") == true) {
				%>
				<form class="navbar-form pull-right" action="logout.do" method="get">
					<input type="submit" value="Log out" class="btn" />
				</form>
				<%
					} else {
				%>
				<form class="navbar-form pull-right" action="login.do" method="get">
					<input type="submit" value="Log in" class="btn" />
				</form>
				<%
					}
				%>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>