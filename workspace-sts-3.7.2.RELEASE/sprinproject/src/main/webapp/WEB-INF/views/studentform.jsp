<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<spring:form action="student" method="post" modelAttribute="stud">

		<table>

			<tr>

				<td><spring:label path="fname">FirstName</spring:label></td>
				<td><spring:input path="fname" /></td>


			</tr>

			<tr>

				<td><spring:label path="lname">LastName</spring:label></td>
				<td><spring:input path="lname" /></td>


			</tr>

			<tr>

				<td><spring:label path="gender">Gender</spring:label></td>
				<td><spring:radiobutton path="gender" value="male" />Male</td>
				<td><spring:radiobutton path="gender" value="female" />Female</td>


			</tr>

			<tr>

				<td><spring:label path="dob">DOB</spring:label></td>
				<td><spring:input path="dob" type="date" /></td>


			</tr>

			<tr>

				<td><spring:label path="phone">PhoneNumber</spring:label></td>
				<td><spring:input path="phone" /></td>


			</tr>

			<tr>

				<td><spring:label path="college">College</spring:label></td>
				<td><spring:input path="college" /></td>


			</tr>

			<tr>

				<td><spring:label path="semester">Semester</spring:label></td>
				<td><spring:input path="semester" /></td>


			</tr>

			<tr>

				<td><spring:label path="faculty">Faculty</spring:label></td>
				<td><spring:input path="faculty" /></td>


			</tr>

			<tr>

				<td><spring:label path="rollno">RollNo</spring:label></td>
				<td><spring:input path="rollno" /></td>


			</tr>

		</table>

		<table>

			<tr>
				<td><input type="submit" value="save"></td>
				<td><input type="reset"></td>
			</tr>


		</table>

	</spring:form>

</body>
</html>