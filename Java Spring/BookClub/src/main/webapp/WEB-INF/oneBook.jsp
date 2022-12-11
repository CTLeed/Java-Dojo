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
		<div class="header d-flex justify-content-between mb-5">
			<div class="header-left">
				<h1>
					<c:out value="${book.title}" />
				</h1>
			</div>
			<div class="header-right">
				<a href="/books">back to the shelves</a>
			</div>
		</div>
		<div class="body">
			<c:choose>
				<c:when test="${user_id == book.posted_by.id }">
					<h3 class="mb-3">
						<span class="text-danger">You</span> Read <span
							class="text-primary"><c:out value="${book.title}" /></span> by <span
							class="text-success"><c:out value="${book.author}" /></span>
					</h3>
					<h3 class="mb-4">Here are your thoughts:</h3>
				</c:when>
				<c:otherwise>
					<h3 class="mb-3">
						<span class="text-danger"><c:out
								value="${book.posted_by.name }" /></span> Read <span
							class="text-primary"><c:out value="${book.title}" /></span> by <span
							class="text-success"><c:out value="${book.author}" /></span>
					</h3>
					<h3 class="mb-4">
						Here are
						<c:out value="${book.posted_by.name}" />
						's thoughts:
					</h3>
				</c:otherwise>
			</c:choose>
			<div class="card">
				<div class="card-body">
					<c:out value="${book.thoughts}" />
				</div>
			</div>
			<c:choose>
				<c:when test="${user_id == book.posted_by.id }">
				<div class="buttons d-flex justify-content-center m-3">
					<form action="/books/${book.id}/edit">
					<button class="btn btn-warning m-3">Edit</button>
					</form>
					<form action="/books/${book.id}" method="POST">
					<input type="hidden" name="_method" value="delete" />					
					<button class="btn btn-danger m-3">Delete</button>
					</form>
				</div>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>