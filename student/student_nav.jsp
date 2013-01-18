<%@ page import="com.grademaster.Globals" %>
<%@ page import="com.eakjb.EakjbData.IDataStructure" %>
<%
IDataStructure iConfig = (IDataStructure) session.getAttribute("iConfig");
boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
%>
<ul class="nav">
	<li><a href="<%= request.getContextPath() %>/index.do">Home</a></li>
	<li><a href="<%= request.getContextPath() %>/shared/about.jsp">About</a></li>
	<li><a href="<%= request.getContextPath() %>/shared/tutorial.jsp?t=student">Tutorials</a></li>
	<li><a href="<%= request.getContextPath() %>/todo.do">To-Do List</a></li>
	<li><a href="<%= request.getContextPath() %>/calendar.do">Calendar</a></li>
	<li><a href="<%= request.getContextPath() %>/gradebook.do">Gradebook</a></li>
	<li class="dropdown"><a href=""
		class="dropdown-toggle" data-toggle="dropdown">Classes <b
			class="caret"></b></a>
		<ul class="dropdown-menu">
			<li><a href="classes_overview.do">Overview</a>
			<li class="divider"></li>
			<li class="nav-header">Core Classes</li>
			<li><a href="class.do?id=1"><%= iConfig.get("namePrefix") %>CLASS1NAME</a></li>
			<li><a href="class.do?id=2"><%= iConfig.get("namePrefix") %>CLASS2NAME</a></li>
			<li><a href="class.do?id=3"><%= iConfig.get("namePrefix") %>CLASS3NAME</a></li>
			<li><a href="class.do?id=4"><%= iConfig.get("namePrefix") %>CLASS4NAME</a></li>
			<li><a href="class.do?id=5"><%= iConfig.get("namePrefix") %>CLASS5NAME</a></li>
			<li class="divider"></li>
			<li class="nav-header">Specials</li>
			<li><a href="class.do?id=6"><%= iConfig.get("namePrefix") %>CLASS6NAME</a></li>
			<li><a href="class.do?id=7"><%= iConfig.get("namePrefix") %>CLASS7NAME</a></li>
			<li><a href="class.do?id=8"><%= iConfig.get("namePrefix") %>CLASS8NAME</a></li>
			<li><a href="class.do?id=9"><%= iConfig.get("namePrefix") %>CLASS9NAME</a></li>
		</ul></li>
</ul>
