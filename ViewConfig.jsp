<jsp:include page="header.jsp" />
<%@ page import="com.grademaster.data.objects.*" %>
<% 
if (request.getAttribute("config")==null) {
	response.sendRedirect("/GradeMaster/ViewConfig.do");
} else {
Config con = (Config) request.getAttribute("config"); %>
<h2>Configuration Settings</h2>
<table>
	<tr>
		<td>Name: </td>
		<td><%= con.name %></td>
	</tr>
	<tr>
		<td>Author: </td>
		<td><%= con.metadata.author %></td>
	</tr>
	<tr>
		<td>Date: </td>
		<td><%= con.metadata.date %></td>
	</tr>
	<tr>
		<td>Version: </td>
		<td><%= con.metadata.version %></td>
	</tr>
	<tr>
		<td>logoPath: </td>
		<td><%= con.logoPath %></td>
	</tr>
</table>
<% } %>
<jsp:include page="footer.jsp" />