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
		<div class="d-flex justify-content-between">
			<h1 class="travel-title">Expense Details</h1>
			<a href="/expenses">Go back</a>
		</div>
		<table>
			<tr>
				<th>Expense Name: </th>
				<td><c:out value="${expense.name }" /> </td>
			</tr>
			<tr>
				<th>Expense Description:</th>
				<td><c:out value="${expense.description }" /> </td>
			</tr>
			<tr>
				<th>Vendor:</th>
				<td><c:out value="${expense.vendor }" /> </td>
			</tr>
			<tr>
				<th>Amount:</th>
				<td>$<c:out value="${expense.amount }" /> </td>
			</tr>
		</table>
	</div>
</body>
</html>