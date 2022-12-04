<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>One User</h1>
		<h1> Hello, <c:out value="${fulltName}"/> 
		</h1>
		<h3>Age: <c:out value="${age}"/></h3>
		<c:if test = "${check}">
			<p>CHECK IS TRUE<p>
		</c:if>
	</div>
</body>
</html>