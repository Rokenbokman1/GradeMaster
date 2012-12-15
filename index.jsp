<%@ page import="com.grademaster.*" %>
<jsp:include page="header.jsp" />
<p>Matt, this is where you come in and make things look pretty.<br/>
Replace anywhere where it says GradeMaster with <%= Globals.getConfig().name %>, <br/>
so it can be configured in config.  It might not look right for you, but on Tomcat,<br/>
the JSP renders, and it is normal.  Keep in mind there is now a header.jsp and footer.jsp.</p>
<h3>Pages</h3>
<ul>
<li><a href="/GradeMaster/ViewConfig.do">View Config</a></li>
</ul>
<jsp:include page="footer.jsp" />