<%@page import="com.app.dto.Student"%>
<%@page import="com.app.model.StdModel"%>
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
		String user = (String) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("stdLogin.jsp");
		}
		%>
		<%
		Student s = (Student) request.getAttribute("STD");
		%>
	</center>
	<div class="container">
		<h2 style="color: gray; text-align: center;">~~~Student Update
			Form~~~</h2>
		<form action="UpdateStd" method="post">
			<div class="form-group">
				<label for="exampleInputId">Student Id</label> <input type="text"
					name="id" value="<%=s.getId()%>" class="form-control"
					id="exampleInputId" placeholder="Enter Your Id"
					aria-describedby="idHelp" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="exampleInputName">Student Name</label> <input
					type="text" name="name" value="<%=s.getName()%>"
					class="form-control" id="exampleInputName"
					placeholder="Enter Your Name">
			</div>
			<div class="form-group">
				<label for="exampleInputCourse">Student Course</label> <input
					type="text" name="course" value="<%=s.getCourse()%>"
					class="form-control" id="exampleInputCourse"
					placeholder="Enter Your Course">
			</div>
			<div class="form-group">
				<label for="exampleInputCity">Student City</label> <input
					type="text" name="city" value="<%=s.getCity()%>"
					class="form-control" id="exampleInputCity"
					placeholder="Enter Your City">
			</div>
			<div class="form-group">
				<label for="exampleInputMobile">Student Mobile</label> <input
					type="text" name="mobile" value="<%=s.getMobile()%>"
					class="form-control" id="exampleInputMobile"
					placeholder="Enter Your Mobile">
			</div>
			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>
</body>
</html>