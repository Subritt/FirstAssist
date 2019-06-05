<%@page import="com.webdemo.models.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Database Contents</h1>
	<hr>

	<table align="center" cellpadding="1px;" width="100%">

		<tr bgcolor="yellow">
			<td align="center">First Name</td>
			<td align="center">Last Name</td>
			<td align="center">UserName</td>
			<td align="center">Password</td>
		</tr>

		<%

	List<User> ulist = (List<User>)request.getAttribute("ulist") ;
for(User u : ulist){

%>

		<tr bgcolor="skyblue">
			<td align="center"><%= u.getFnmae() %></td>
			<td align="center"><%= u.getLname() %></td>
			<td align="center"><%= u.getUsername() %></td>
			<td align="center"><%= u.getPassword() %></td>
		</tr>
		<%
}
%>
	</table>

</body>
</html>