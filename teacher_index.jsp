
<jsp:include page="header.jsp" />
<body>
	<jsp:include page="teacher_nav.jsp" />


	<div class="container">

		<!-- Main hero unit for a primary marketing message or call to action -->
		<div class="hero-unit">
			<h1>Welcome, @TEACHERNAME!</h1>
			<p>Welcome to GradeMaster I mean! This is the place for you to
				submit your student's grades in all your classes. I hope they're
				doing well!</p>
			<p>
				<a class="btn btn-primary btn-large">Might Be Used For Something
					but I'm afraid to remove it for it would be a pain to put back in.
					&raquo;</a>
			</p>
		</div>

		<!-- Example row of columns -->
		<div class="row">
			<div class="span4">
				<h2>Grade Overview</h2>
				<div class="column>">
					<li><a href="#1">@CLASS1NAME</a> | @CLASS1GRADE</li>
					<li><a href="#2">@CLASS2NAME</a> | @CLASS2GRADE</li>
					<li><a href="#3">@CLASS3NAME</a> | @CLASS3GRADE</li>
					<li><a href="#4">@CLASS4NAME</a> | @CLASS4GRADE</li>
					<li><a href="#5">@CLASS5NAME</a> | @CLASS5GRADE</li> <br>
				</div>
				<p>
					<a class="btn" href="#gradebook">Full Gradebook &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>Quik Assignment Creation</h2>
				<form>
					<select name="quikcreateclassselect">
						<option selected>Select A Class</option>
						<option value="quikcreateselectclass1">@CLASS1NAME</option>
						<option value="quikcreateselectclass2">@CLASS2NAME</option>
						<option value="quikcreateselectclass3">@CLASS3NAME</option>
						<option value="quikcreateselectclass4">@CLASS4NAME</option>
						<option value="quikcreateselectclass5">@CLASS5NAME</option>
					</select> <input type="text" name="quikcreatename"
						placeholder="Assignment Name"> <input type="date"
						name="quikcreateduedate" placeholder="Assignment Due-Date">
					<select name="quikcreatemultiplier">
						<option value="quikcreatemultiplier1x">1x</option>
						<option value="quikcreatemultiplier2x">2x</option>
						<option value="quikcreatemultiplier3x">3x</option>
						<option value="quikcreatemultiplier4x">4x</option>
						<option value="quikcreatemultiplier5x">5x</option>
					</select> <br>
					<button type="submit" class="btn btn-primary">Submit
						Assignment</button>
				</form>
				<p>
					<a class="btn" href="#createassingment">Full Assignment
						Creation &raquo;</a>
				</p>
			</div>
			<div class="span4">
				<h2>Quik Attendance</h2>
				<form>
					<select name="quikattendanceclass">
						<option selected>Choose a Class</option>
						<option value="quikattendance@CLASS1NAME">@CLASS1NAME</option>
						<option value="quikattendance@CLASS2NAME">@CLASS2NAME</option>
						<option value="quikattendance@CLASS3NAME">@CLASS3NAME</option>
						<option value="quikattendance@CLASS4NAME">@CLASS4NAME</option>
						<option value="quikattendance@CLASS5NAME">@CLASS5NAME</option>
					</select> <select name="quikattendancestudent">
						<option selected>Select a Student</option>
						<option value="quikattendance@STUDENT1NAME">@STUDENT1NAME</option>
						<option value="quikattendance@STUDENT2NAME">@STUDENT2NAME</option>
						<option value="quikattendance@STUDENT3NAME">@STUDENT3NAME</option>
						<option value="quikattendance@STUDENT4NAME">@STUDENT4NAME</option>
						<option value="quikattendance@STUDENT5NAME">@STUDENT5NAME</option>
					</select>
					<p>Remember, Present until proven Absent!</p>
					<select name="quikattendanceselect">
						<option selected value="quikattendanceselectpresent">Present</option>
						<option value="quikattendanceselecttardy">Tardy</option>
						<option value="quikattendanceselectabsent">Absent</option>
					</select> <br>
					<button type="submit" class="btn btn-primary">Submit
						Attendance</button>
				</form>
				<p>
					<a class="btn" href="#attendance">Full Attendance &raquo;</a>
				</p>
			</div>
		</div>

		<jsp:include page="footer.jsp" />