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
<title>Recipes</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Dashboard for Recipes</h1>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Under 30</th>
					<th>Posted By</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="recipe" items="${allRecipes }">
					<tr>
						<td><c:out value="${recipe.name}" /></td>
						<td><c:out value="${recipe.under30Min}" /></td>
						<td><c:out value="${recipe.creator.userName}" /></td>
						<td><a href="/recipes/${recipe.id}">View</a> 
							<c:if test="${user_id == recipe.creator.id }">
								<a href="/recipes/${recipe.id}/edit">Edit</a>
								<a href="">Delete</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>