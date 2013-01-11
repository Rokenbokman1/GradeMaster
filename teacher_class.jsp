<%@ page import="com.eakjb.EakjbData.*"%>
<%@ page import="com.grademaster.Globals"%>
<%@ page import="java.util.ArrayList"%>
<%
	IDataStructure user = null;
	if ((Boolean) session.getAttribute("loggedIn")) {
		user = (IDataStructure) session.getAttribute("User");
	}
	IDataStructure iConfig = Globals.getStructure("Config");

	IDataStructure iClass = Globals.runAttrQuery("Classes", "class",
			"cid", request.getParameter("id"));
%>

<jsp:include page="header.jsp" />
<body>
	<jsp:include page="teacher_nav.jsp" />
	<div class="container">
		<h2>
			Class Overview:
			<%=iConfig.get("namePrefix")%><%=iClass.get("name")%></h2>
		<a href="teacher_classes_overview.jsp">&#60;&#60; Classes Overview</a>
		<h3>Information</h3>
		<table
			style="margin: 5px; cell-padding: 5px; background-color: #F0F0F0; width: 30%">
			<tr>
				<td style="padding-right: 5px">Class ID</td>
				<td><%=iClass.get("cid")%></td>
			</tr>
			<tr>
				<td style="padding-right: 5px">Class Location</td>
				<td><%=iClass.get("loc")%></td>
			</tr>
			<tr>
				<td style="padding-right: 5px">Class Description</td>
				<td><%=iClass.get("desc")%></td>
			</tr>
		</table>
		<h3>Sections</h3>
		<div style="background-color: #F0F0F0; margin: 30px; width: 100%">
			<%
				for (IDataObject s1 : ((IDataStructure) iClass.get("sections")).getObjects()) {
					IDataStructure s = (IDataStructure) s1;
					IDataStructure assignments = Globals.runAttrQuery("Assignments", "assignment", "sid", s.get("sid").getTextValue());
			%>
			<h4><%=iConfig.get("namePrefix")%><%=s.get("name")%></h4>
			<table
				style="margin: 10px; cell-padding: 5px; background-color: #F0F0F0; width: 30%">
				<tr>
					<td style="padding-right: 50px">ID</td>
					<td><%=s.get("sid")%></td>
				</tr>
				<tr>
					<td style="padding-right: 50px">Value</td>
					<td><%=s.get("value")%></td>
				</tr>
				<tr>
					<td style="padding-right: 50px">Description</td>
					<td><%=s.get("desc")%></td>
				</tr>
			</table>
			<h5 style="margin-left: 30px">Assignments</h5>
			<%
				for (IDataObject a1 : assignments) {
						IDataStructure a = (IDataStructure) a1;
			%>
			<div style="margin-left: 60px">
				<h6><%=iConfig.get("namePrefix")%><%=a.get("name")%><a
						href="gradebook.jsp" class="btn">Grade Assignment</a><a
						href="delete_assignment.do?aid=<%=a.get("aid")%>&redirect=teacher_class.jsp?id=<%=s.get("cid")%>"
						class="btn btn-primary">Delete Assignment >></a>
				</h6>
				<table
					style="margin-left: 30px; cell-padding: 10px; background-color: #F0F0F0; width: 80%">
					<tr>
						<td style="padding-right: 10px">ID</td>
						<td><%=a.get("aid")%></td>
					</tr>
					<tr>
						<td style="padding-right: 10px">Name</td>
						<td><%=a.get("name")%></td>
					</tr>
					<tr>
						<td style="padding-right: 10px">Points Possible</td>
						<td><%=a.get("pts")%></td>
					</tr>
					<tr>
						<td style="padding-right: 10px">Date Assigned</td>
						<td><%=a.get("assigned")%></td>
					</tr>
					<tr>
						<td style="padding-right: 10px">Date Due</td>
						<td><%=a.get("due")%></td>
					</tr>
					<tr>
						<td style="padding-right: 50px">Multiplier</td>
						<td><%=a.get("multi")%></td>
					</tr>
					<tr>
						<td style="padding-right: 10px">Description</td>
						<td><%=a.get("desc")%></td>
					</tr>
				</table>
			</div>
			<%
				}
				}
			%>
		</div>
		<jsp:include page="footer.jsp" />