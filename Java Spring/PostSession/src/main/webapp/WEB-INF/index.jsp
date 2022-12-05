<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post Session</title>
</head>
<body>
	<div class="container">
		<h1>Hello World</h1>
		<form action="/login" method="POST">
			<input type="email" name="email" id="" />
			<input type="password" name="password" id="" />
			<button>Login</button>
		</form>
		<h1>
		<c:out value="${sessionEmail }" />
		</h1>	
		<h1>
		<c:out value="${sessionPassword }" />
		</h1>	
	</div>
</body>
</html>