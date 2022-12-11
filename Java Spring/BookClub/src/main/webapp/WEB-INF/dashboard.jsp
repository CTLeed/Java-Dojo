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
    <title>Read Share</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<div class="header d-flex justify-content-between">
		<div class="header-left" >
			<h1>Welcome, <c:out value="${userObject.name}" /></h1>
			<p><b>Books on the shelves:</b></p>
		</div>
		<div class="header-right d-flex align-items-end justify-content-center flex-column mb-3">
			<a href="/logout">logout</a>
			<a href="/books/new">+ Add a book to the shelf!</a>		
		</div>
	</div>
		<table class="table table-striped table-bordered table-hover align-middle">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">Title</th>
					<th class="text-center">Author Name</th>
					<th class="text-center">Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneBook" items="${allBooks}">
					<tr>
						<td class="text-center"><c:out value="${oneBook.id}" /></td>
						<td class="text-center"><a href="/books/${oneBook.id}" ><c:out value="${oneBook.title}" /></a></td>
						<td class="text-center"><c:out value="${oneBook.author}" /></td>
						<td class="text-center"><c:out value="${oneBook.posted_by.name}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
		
	</div>
</body>
</html>