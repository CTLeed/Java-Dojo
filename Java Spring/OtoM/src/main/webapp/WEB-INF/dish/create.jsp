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
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Create a Dish</h1>
		<form:form method="POST" action="/dish/new" modelAttribute="dishObject">
			<div>
				<form:label path="name">Name of Dish</form:label>
				<form:input type="text" path="name" />
				<form:errors path="name" />
			</div>
			<div>
				<form:label path="calories">Number of Calories</form:label>
				<form:input type="number" path="calories" />
				<form:errors path="calories" />
			</div>
			<div>
				<form:label path="creator">Chef</form:label>
				<form:select path="creator" >
					<c:forEach var="chef" items="${allChefs }">
						<form:option value="${chef.id}" >
							<c:out value="${chef.fullName }" />
						</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="name" />
			</div>
			<button>Create</button>		
		</form:form>
		
	</div>
</body>
</html>