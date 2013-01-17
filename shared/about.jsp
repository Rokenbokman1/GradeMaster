<%@ page import="com.eakjb.EakjbData.IDataStructure"%>
<%@ page import="com.grademaster.*"%>

<jsp:include page="${request.contextPath}/shared/header.jsp" />

<%
	IDataStructure iConfig = (IDataStructure) session
			.getAttribute("iConfig");
	IDataStructure user = (IDataStructure) session.getAttribute("user");
	boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
%>

<body>

<jsp:include page="${request.contextPath }/shared/nav.jsp" />

	<div class="container">
		<div class="hero-unit">
			<h1>About GradeMaster</h1>
			<p>GradeMaster is a versatile alternative UI for Infinite Campus.
				It is made by 3 students, Matt, Jake, and Ryan.</p>
		</div>
		<div class="row">
			<div class="span4">
				<h2>GradeMaster</h2>
				<p>GradeMaster is a versatile alternative UI for Infinite
					Campus. It was sparked as a 1 district Infinite Campus replacement.
					It became a alternitive UI when the creators realized, with the
					time they had, they could not reach the full capability as Infinite
					Campus. Our goal is to add requested features to and address
					problems students, parents, and teachers have with the current IC
					User Interface.</p>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />