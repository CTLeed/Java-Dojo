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
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="header">
			<div class="header-left">
				<h1>Add a Book to the Shelf!</h1>
			</div>
			<div class="header-right">
				<a href="/books">back to the shelves</a>
			</div>		
		</div>
		<form:form modelAttribute="bookObject" action="/books/create" method="POST">
			<div>
				<form:label path="title">Title</form:label>
				<form:input type="text" path="title" />
				<form:errors path="title" />
			</div>
			<div>
				<form:label path="author">Author</form:label>
				<form:input type="text" path="author" />
				<form:errors path="author" />
			</div>
			<div>
				<form:label path="thoughts">My Thoughts</form:label>
				<form:textarea path="thoughts" rows="4" />
				<form:errors path="thoughts" />
			</div>
				<form:input type="hidden" path="posted_by" value="${user_id}" />
			<div>
				<button class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>