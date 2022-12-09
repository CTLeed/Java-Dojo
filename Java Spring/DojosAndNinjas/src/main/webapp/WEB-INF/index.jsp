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
    <title>Dojos!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Dojos</h1>
		<table class="table table-striped table-hover align-middle">
			<thead>
				<tr>
					<th>Dojo Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneDojo" items="${allDojos}" >
					<tr>
						<td class="text-center"><a href="/dojos/${oneDojo.id }" ><c:out value="${oneDojo.name }" /></a></td>
					</tr>				
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="/dojos/new" class="btn btn-success">Add Dojo</a>
			<a href="/ninjas/new" class="btn btn-info">Add Ninja</a>
		</div>
	</div>
</body>
</html>