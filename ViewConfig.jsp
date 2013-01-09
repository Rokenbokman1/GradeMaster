<%@ page import="com.eakjb.EakjbData.IDataStructure" %>
<% 
if (request.getAttribute("config")==null) {
	response.sendRedirect("/GradeMaster/ViewConfig.do");
} else {
IDataStructure con = (IDataStructure) request.getAttribute("config");
IDataStructure metadata = (IDataStructure) con.get("metadata");
%>
<h2>Configuration Settings</h2>
<table>
	<tr>
		<td>Name: </td>
		<td><%= con.get("name") %></td>
	</tr>
	<tr>
		<td>Author: </td>
		<td><%= metadata.get("author") %></td>
	</tr>
	<tr>
		<td>Date: </td>
		<td><%= metadata.get("date") %></td>
	</tr>
	<tr>
		<td>Version: </td>
		<td><%= metadata.get("version") %></td>
	</tr>
	<tr>
		<td>logoPath: </td>
		<td><%= con.get("logoPath") %></td>
	</tr>
</table>
<% } %>
<jsp:include page="footer.jsp" />