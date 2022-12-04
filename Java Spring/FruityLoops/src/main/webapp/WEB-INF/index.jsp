<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Fruity Loops</title>
</head>
<body>
	<div class="container">
		<h1>Fruit Store</h1>
		<table class="table table-dark table-striped table-hover table-bordered border-primary table-sm">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
				</tr>
			</thead>
			<tbody class="table-group-divider">
				<c:forEach var="fruit" items="${allFruits}">
					<tr>
						<td><c:out value="${fruit.name }" /></td>
						<td><c:out value="${fruit.price }" /></td>
					</tr>
				</c:forEach>
				<tr>
			</tbody>
		</table>
	</div>
</body>
</html>