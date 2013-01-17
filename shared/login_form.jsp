<jsp:include page="header.jsp"></jsp:include>

<body background="../img/loginbackground.jpg">

<script type="text/javascript">
var selectFunction = function() {
	loadXMLDoc();
}
function loadXMLDoc() 
{
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("typebox").value=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","user_type.do?uname="+document.getElementById("unamebox").value,true);
xmlhttp.send();
}
</script>

	<jsp:include page="../student/student_nav.jsp"></jsp:include>
	
	<div class="container">
		<h2 align="center">Please Login</h2>
		<% if (request.getParameter("error")!=null && request.getParameter("error")!="") { %>
		<p align="center">Error: <%= request.getParameter("error") %></p>
		<% } %>
		<form align="center" action="login.do" method="post">
			<fieldset>
			<input type="text" name="username" placeholder="Username" id="unamebox" onkeyup="selectFunction()"><br>
			<input type="password" name="password" placeholder="Password"><br>
			<select name="type" id="typebox">
				<option value="teacher">Teacher</option>
				<option value="student">Student</option>
			</select>
			<br />
			<input type="submit" name="submit" class="btn"/>
			</fieldset>
		</form>
	</div>