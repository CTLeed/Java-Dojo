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
				<th>Full Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Age</th>
				<th>CreatedAt</th>
				<th>UpdatedAt</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="oneUser" items="${allUsers }" >
			 	<tr>
			 		<td><c:out value="${oneUser.id }" /></td>			 		
			 		<td>
			 			<a href="/users/${oneUser.id }">
			 				<c:out value="${oneUser.fullName }" />
			 			</a>
			 		</td>
			 		<td><c:out value="${oneUser.email }" /></td>
			 		<td><c:out value="${oneUser.password }" /></td>
			 		<td><c:out value="${oneUser.age }" /></td>
			 		<td><c:out value="${oneUser.createdAt }" /></td>
			 		<td><c:out value="${oneUser.updatedAt }" /></td>
			 		<td>
			 			<a href="/users/${oneUser.id }/edit" class="btn btn-warning" >Edit</a>
			 			<form action="/users/${oneUser.id}" method="POST">
			 				<input type="hidden" name="_method" value="delete" >
			 				<button class="btn btn-danger">Delete</button>
			 			</form>
			 		</td>
			 	</tr>
			 </c:forEach>
		</tbody>
		</table>
		<form:form modelAttribute="userObject" action="/users/new" method="POST">
			<p>
				<form:label path="fullName">Name: </form:label>
				<form:input type="text" path="fullName" />	
				<form:errors path="fullName" />		
			</p>
			<p>
				<form:label path="email">Email: </form:label>
				<form:input type="email" path="email" />	
				<form:errors path="email" />				
			</p>
			<p>
				<form:label path="password">Password: </form:label>
				<form:input type="password" path="password" />
				<form:errors path="password" />					
			</p>
			<p>
				<form:label path="age">Age: </form:label>
				<form:input type="number" path="age" />
				<form:errors path="age" />					
			</p>
			<button>Submit</button>
			
		
		</form:form>
		
	</div>
</body>
</html>