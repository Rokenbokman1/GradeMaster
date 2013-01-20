<%@ page import="com.eakjb.EakjbData.IDataStructure"%>
<%@ page import="com.eakjb.EakjbData.IDataObject"%>
<%@ page import="com.grademaster.Globals"%>
<%@ page import="java.util.ArrayList"%>

<jsp:include page="${ request.contextPath }/shared/header.jsp" />

<%
	IDataStructure iConfig = (IDataStructure) session
			.getAttribute("iConfig");
	IDataStructure user = (IDataStructure) session.getAttribute("user");
	boolean loggedIn = (Boolean) session.getAttribute("loggedIn");

	IDataStructure classes = Globals.runAttrQuery("Classes", "class",
			"uid", user.get("uid").getTextValue());
%>
<body>
	<div class="container">
		<jsp:include page="${ request.contextPath }/shared/nav.jsp" />
		<h2>Classes Overview</h2>
		<a href="<%= request.getContextPath() %>/index.do">&#60;&#60; Home</a>
		<%
			for (IDataObject c1 : classes) {
				IDataStructure c = (IDataStructure) c1;
				String cid = c.get("cid").getTextValue();
		%>
		<h3><%=iConfig.get("namePrefix")%><a
				href="teacher_class.jsp?id=<%=c.get("cid")%>"><%=c.get("name")%>
				&#62;&#62;</a>
		</h3>
		<table
			style="margin-left: 30px; cell-padding: 10px; background-color: #F0F0F0; width: 100%">
			<tr>
				<td style="width: 50%">ID</td>
				<td><%=c.get("cid")%></td>
			</tr>
			<tr>
				<td style="width: 50%">Location</td>
				<td><%=c.get("loc")%></td>
			</tr>
			<tr>
				<td style="width: 50%">Description</td>
				<td><%=c.get("desc")%></td>
			</tr>
		</table>
		<%
			}
		%>
	</div>
	<jsp:include page="${ request.contextPath }/shared/footer.jsp" />