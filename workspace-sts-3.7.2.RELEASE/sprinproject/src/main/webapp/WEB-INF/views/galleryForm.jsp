<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:forEach var="imgname" items="${imglist }">
		<a href="resources/imgs/${imgname}"  target="_blank">
		<img alt="${imgname }" src = "resources/imgs/${imgname}" width = "200px;" height = "200psx;">
		</a>
	</c:forEach>

</body>
</html>