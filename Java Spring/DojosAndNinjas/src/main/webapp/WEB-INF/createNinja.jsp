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
<title>Ninja!</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>New Ninja</h1>
		<form:form modelAttribute="ninjaObject" action="/ninjas/new/process"
			method="POST">
			<div>
				<form:label path="dojo">Dojo: </form:label>
				<form:select path="dojo">
					<c:forEach var="oneDojo" items="${allDojos}">
						<form:option value="${oneDojo.id}">
							<c:out value="${oneDojo.name }" />
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				<form:label path="firstName">First Name:</form:label>
				<form:input type="text" path="firstName" />
				<form:errors path="firstName" />
			</div>
			<div>
				<form:label path="lastName">Last Name:</form:label>
				<form:input type="text" path="lastName" />
				<form:errors path="lastName" />
			</div>
			<div>
				<form:label path="age">Age:</form:label>
				<form:input type="number" path="age" />
				<form:errors path="age" />
			</div>
			<div>
				<button class="btn btn-primary">Create</button>
			</div>
		</form:form>

	</div>
</body>
</html>