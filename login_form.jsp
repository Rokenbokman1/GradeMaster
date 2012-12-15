<jsp:include page="header.jsp"></jsp:include>

<body background="img\loginbackground.jpg">

	<jsp:include page="student_nav.jsp"></jsp:include>
	
	<div class="container">
		<p align="center"><b>Please Login!</b></p>
		
		<form align="center" action="login.do" method="post">
			<input type="text" name="username" placeholder="Username"><br>
			<input type="password" name="password" placeholder="Password"><br>
			<select name="type">
				<option value="teacher">teacher</option>
				<option value="student">student</option>
			</select>
			<br />
			<input type="submit" name="submit" class="btn"/>
		</form>
	</div>