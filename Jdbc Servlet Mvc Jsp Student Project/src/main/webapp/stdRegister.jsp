<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="adminHeader.jsp"%>
<body>
	<center>
		<%
		String msg = (String) request.getAttribute("msg");

		if (msg != null)
			out.println("<h2 style=color:green>" + msg + "</h2>");
		String user = (String) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("stdLogin.jsp");
		}
		%>
	</center>
	<div class="container">
		<h2 style="color: gray; text-align: center;">~~~Student
			Registration Form~~~</h2>
		<form action="RegStudent" method="post">
			<div class="form-group">
				<label for="exampleInputId">Student Id</label> <input type="text"
					name="id" class="form-control" id="exampleInputId"
					placeholder="Enter Your Id" aria-describedby="idHelp">
			</div>
			<div class="form-group">
				<label for="exampleInputName">Student Name</label> <input
					type="text" name="name" class="form-control" id="exampleInputName"
					placeholder="Enter Your Name">
			</div>
			<div class="form-group">
				<label for="exampleInputCourse">Student Course</label> <input
					type="text" name="course" class="form-control"
					id="exampleInputCourse" placeholder="Enter Your Course">
			</div>
			<div class="form-group">
				<label for="exampleInputCity">Student City</label> <input
					type="text" name="city" class="form-control" id="exampleInputCity"
					placeholder="Enter Your City">
			</div>
			<div class="form-group">
				<label for="exampleInputMobile">Student Mobile</label> <input
					type="text" name="mobile" class="form-control"
					id="exampleInputMobile" placeholder="Enter Your Mobile">
			</div>
			<button type="submit" class="btn btn-primary">Register</button>
		</form>
	</div>
</body>
</html>