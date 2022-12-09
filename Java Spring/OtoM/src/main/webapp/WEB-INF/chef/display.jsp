<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tacos</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>
			Chef:
			<c:out value="${chef.fullName}" />
		</h1>
		<h2>
			Number of Created Dishes:
			<c:out value="${chef.dishes.size() }" />
		</h2>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Name</th>
					<th>Calories</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dish" items="${chef.dishes }">
					<tr>
						<td><c:out value="${dish.name }" /></td>
						<td><c:out value="${dish.calories }" /></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>
</body>
</html>