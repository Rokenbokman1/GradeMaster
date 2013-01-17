<%@ page import="com.grademaster.*" %>
<%@ page import="com.eakjb.EakjbData.IDataStructure" %>
<% IDataStructure user = null;
if (session.getAttribute("loggedIn")!=null&&(Boolean) session.getAttribute("loggedIn")==true) {
	user =(IDataStructure) session.getAttribute("user"); 
}

IDataStructure iConfig = Globals.getStructure("Config");
%>
<div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="index.do"><% if (session.getAttribute("loggedIn")!=null&&(Boolean)session.getAttribute("loggedIn")==true) { %>
                    <%= iConfig.get("namePrefix") %><%= user.get("fname").getTextValue()+" "+user.get("lname").getTextValue() %>
                    <% } else { %>
                    <%= iConfig.get("namePrefix") %><%= iConfig.get("name") %>
                    <% } %></a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li class="active"><a href="index.do">Home</a></li>
                            <li><a href="../shared/about.jsp">About</a></li>
                            <% if (session.getAttribute("loggedIn")!=null&&(Boolean) session.getAttribute("loggedIn")==true) { %>
                            <li><a href="todo.do">To-Do List</a></li>
                            <li><a href="calendar.do">Calendar</a></li>
                            <li><a href="gradebook.do">Gradebook</a></li>
                            <li class="dropdown">
                                <a href="classes_overview.do" class="dropdown-toggle" data-toggle="dropdown">Classes <b class="caret"></b></a>
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
                                </ul>
                            </li>
                            <% } else { %>
                            	<li><a href="../shared/tutorial.jsp">Tutorials</a></li>
                            <% } %>
                        </ul>
                        <% if (session.getAttribute("loggedIn")!=null&&(Boolean) session.getAttribute("loggedIn")==true) {%>
                        <form class="navbar-form pull-right" action="logout.do" method="get">
                        	<input type="submit" value="Log out" class="btn"/>
                        </form>
                        <% } else { %>
                        <form class="navbar-form pull-right" action="login.do" method="get">
                        	<input type="submit" value="Log in" class="btn"/>
                        </form>
                       <% } %>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>