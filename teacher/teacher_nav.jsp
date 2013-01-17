<%@ page import="com.grademaster.Globals"%>
<%@ page import="com.eakjb.EakjbData.IDataStructure"%>
<%@ page import="com.eakjb.EakjbData.IDataObject"%>

<%
	IDataStructure iConfig = (IDataStructure) session
			.getAttribute("iConfig");
	IDataStructure user = (IDataStructure) session.getAttribute("user");
	boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
%>

<ul>
	<li class="active"><a href="index.do">Home</a></li>
	<li><a href="../shared/about.jsp">About</a></li>
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