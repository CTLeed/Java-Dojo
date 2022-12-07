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
		<h1>One User</h1>
		<h2>Name: <c:out value="${user.fullName }" /></h2>
		<h2>Email: <c:out value="${user.email}" /></h2>
		<h2>Age: <c:out value="${user.age}" /></h2>
		<c:if test="${ user.age < 18 }" >
			<p>You are a minor</p>
		</c:if>
		<c:choose>
			<<c:when test="${user.age > 21 }">
				<p>You are over 21</p>
			</c:when>
			<c:when test="${user.age > 18 }">
				<p>You are over 18</p>
			</c:when>
			<<c:otherwise>
				<p>You are a minor</p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>