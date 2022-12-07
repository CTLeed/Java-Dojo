<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Dashboard</h1>
		<table class="table table-dark">
		<thead>
			<tr>
				<th>Id</th>
				<th>Email</th>
				<th>Password</th>
				<th>Age</th>
				<th>CreatedAt</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneUser" items="${allUsers }" >
			 	<tr>
			 		<td><c:out value="${oneUser.id }" /></td>
			 		<td><c:out value="${oneUser.email }" /></td>
			 		<td><c:out value="${oneUser.password }" /></td>
			 		<td><c:out value="${oneUser.age }" /></td>
			 		<td><c:out value="${oneUser.createdAt }" /></td>
			 	</tr>
			 </c:forEach>
		</tbody>
		</table>
		<form action="/users/new" method="POST">
			<p>
			<label for="name">Full Name:</label>
			<input type="text" name="name" id="" />
			</p>
			<p>
			<label for="email">Email:</label>
			<input type="text" name="email" id="" />
			</p>
			<p>
			<label for="password">Password:</label>
			<input type="password" name="password" id="" />
			</p>
			<p>
			<label for="age">Age:</label>
			<input type="number" name="age" id="" />
			</p>
			<button>Submit</button>
		</form>
		
	</div>
</body>
</html>