<%@ page import="com.grademaster.*" %>
<%@ page import="com.grademaster.data.objects.*" %>
<% User user = null;
if (session.getAttribute("loggedIn")!=null&&(Boolean) session.getAttribute("loggedIn")==true) {
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
                    <a class="brand" href="index.do"><% if (session.getAttribute("loggedIn")!=null&&(Boolean)session.getAttribute("loggedIn")==true) { %>
                    <%= iConfig.namePrefix %><%= user.getName() %>
                    <% } else { %>
                    <%= iConfig.namePrefix %><%= iConfig.name %>
                    <% } %></a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            	<li><a href="tutorial.jsp">Tutorials</a></li>
                            	<li><a href="about.jsp">About GradeMaster</a>
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