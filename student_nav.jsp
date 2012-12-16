<%@ page import="com.grademaster.*" %>
<%@ page import="com.grademaster.data.objects.*" %>
<% User user = null;
if ((Boolean) session.getAttribute("loggedIn")) {
	user =(User) session.getAttribute("user"); 
}

Config iConfig = Globals.getConfig(); %>
<div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="index.do"><% if ((Boolean)session.getAttribute("loggedIn")) { %>
                    @<%= user.getName() %>
                    <% } else { %>
                    @<%= iConfig.name %>
                    <% } %></a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li class="active"><a href="index.do">Home</a></li>
                            <% if ((Boolean) session.getAttribute("loggedIn")) { %>
                            <li><a href="todo.do">To-Do List</a></li>
                            <li><a href="calendar.do">Calendar</a></li>
                            <li><a href="gradebook.do">Gradebook</a></li>
                            <li class="dropdown">
                                <a href="classes_overview.do" class="dropdown-toggle" data-toggle="dropdown">Classes <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                	<li><a href="classes_overview.do">Overview</a>
                                	<li class="divider"></li>
                                    <li class="nav-header">Core Classes</li>
                                    <li><a href="class.do?id=1">@CLASS1NAME</a></li>
                                    <li><a href="class.do?id=2">@CLASS2NAME</a></li>
                                    <li><a href="class.do?id=3">@CLASS3NAME</a></li>
                                    <li><a href="class.do?id=4">@CLASS4NAME</a></li>
                                    <li><a href="class.do?id=5">@CLASS5NAME</a></li>
                                    <li class="divider"></li>
                                    <li class="nav-header">Specials</li>
                                    <li><a href="class.do?id=6">@CLASS6NAME</a></li>
                                    <li><a href="class.do?id=7">@CLASS7NAME</a></li>
                                    <li><a href="class.do?id=8">@CLASS8NAME</a></li>
                                    <li><a href="class.do?id=9">@CLASS9NAME</a></li>
                                </ul>
                            </li>
                            <% } %>
                        </ul>
                        <% if ((Boolean) session.getAttribute("loggedIn")==true) {%>
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