<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Form</h1>
	<hr>
	
	<a href = "index.jsp">Index</a><br><br>
	
	<form action="user_login" method = "post">
	
	<p style = "color:red"> ${error}</p>
	
		UserName <input type = "text" name="username"> <br><br>
		Password &nbsp; <input type = "password" name = "password"> <br><br>
				<input type="submit" value="Login">
				<!--  &nbsp;&nbsp; --> 
				
	</form>
	<br>
	<a href = "signup.jsp"><button>SignUp</button></a>
	
	
</body>
</html>