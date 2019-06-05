<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/dataTables.bootstrap.js"></script>

<title>Home</title>
</head>
<body>

	<!-- Start navbar -->
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">GTC Movember</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/upload">Upload<span class="sr-only">(current)</span></a></li>
					<li><a href="${pageContext.request.contextPath}/email">Contact<span class="sr-only">(current)</span></a></li>
					<li><a href="${pageContext.request.contextPath}/gallery">Gallery<span class="sr-only">(current)</span></a></li>
					<li><a href="student">StudentForm</a></li>
					<li><a href="#">Profile</a></li>
					<!--<li><a href="userlogin">Logout</a></li>-->
					<li class="active"><a
						href="${pageContext.request.contextPath}/userlogin">Logout<span
							class="sr-only">(current)</span></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- End navbar -->

	<h1>Hello world!</h1>

	<p>Welcome : ${user}</p>
	<hr>

	<table id="myTable" class="table table-scripted">

		<thead>
			<tr class="success">
				<td>FirstName</td>
				<td>LastName</td>
				<td>Faculty</td>
				<td>College</td>
				<td>Actions</td>
			</tr>

		</thead>



		<tbody>

			<c:forEach var="student" items="${slist }">

				<tr class="danger">
					<td>${student.fname}</td>
					<td>${student.lname }</td>
					<td>${student.faculty }</td>
					<td>${studnet.college}</td>
					<td><input type="button" onclick="editStudent(${student.id})"
						value="Edit" class="btn btn-success"> <input type="button"
						value="Delete" onclick="deleteStudent(${student.id})"
						class="btn btn-danger"></td>
				</tr>

			</c:forEach>

		</tbody>

	</table>

	<script type="text/javascript">
	
	function editStudent(id){
		
		window.location = "${pageContext.request.contextPath}/"+id+"/edit";
		
	}
	
	function deleteStudent(id){
		
		var msg = confirm("DO you want to delete record?");
		 
		if(msg == true){
		
			window.location = "${pageContext.request.contextPath}/"+id+"/delete";
			
		}
		
	}
	
	$(document).ready( function () {
	    $('#myTable').DataTable();
	} );
	
	</script>

</body>
</html>
