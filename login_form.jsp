<jsp:include page="header.jsp"></jsp:include>

<body background="img\loginbackground.jpg">

	<jsp:include page="student_nav.jsp"></jsp:include>
	
	<div class="container">
		<h2 align="center">Please Login</h2>
		<form align="center" action="login.do" method="post">
			<fieldset>
			<input type="text" name="username" placeholder="Username"><br>
			<input type="password" name="password" placeholder="Password"><br>
			<select name="type">
				<option value="teacher">Teacher</option>
				<option value="student">Student</option>
			</select>
			<br />
			<input type="submit" name="submit" class="btn"/>
			</fieldset>
		</form>
	</div>