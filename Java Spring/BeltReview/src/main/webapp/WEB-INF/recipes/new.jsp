<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Recipes</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>New Recipe</h1>
		<form:form method="POST" action="/recipes/new" modelAttribute="recipeObject">
			<form:input type="hidden" path="creator" value="${user_id}" />
			<div>
				<form:label path="name">Name:</form:label>
				<form:input type="text" path="name" />
				<form:errors path="name" />
			</div>
			<div>
				<form:label path="description">Description:</form:label>
				<form:textarea path="description" />
				<form:errors path="description" />
			</div>
			<div>
				<form:label path="under30Min">Under 30 mins?</form:label>
				<form:checkbox path="under30Min" />
				<form:errors path="under30Min" />
			</div>
		 	<button>Create</button>
		</form:form>
	</div>
</body>
</html>