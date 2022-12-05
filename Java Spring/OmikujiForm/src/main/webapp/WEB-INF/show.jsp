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
	 	<h1>Here's Your Omikuji!</h1>
	 	<div class="renderForm">
	 		<h3>
	 		In <c:out value="${number }" /> years, you will <br>
	 		live in <c:out value="${city }" /> with <br> <c:out value="${person }" />
	 		as your <br> roommate, <c:out value="${hobby}" /> for a living. <br>
	 		The next time you <br> see a <c:out value="${livingThing}" />, you will <br>
	 		have good luck. <br> Also, <c:out value="${niceThing }" />
	 		</h3>
	 	</div>
	 	<div>
			<a href="/omikuji">Go Back</a>
		</div>
	</div>
</body>
</html>