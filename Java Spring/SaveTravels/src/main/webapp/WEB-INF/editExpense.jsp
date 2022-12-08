<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
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
		<h1>Edit Expense</h1>
		<a href="/expenses" >Go back</a>
		<form:form modelAttribute="expenseObject"
			action="/expenses/${expenseObject.id}/edit" method="POST">
			<input type="hidden" name="_method" value="put">
			<div>
				<form:label path="name">Expense Name: </form:label>
				<form:input type="text" path="name" />
				<form:errors path="name" />
			</div>
			<div>
				<form:label path="vendor">Vendor: </form:label>
				<form:input type="text" path="vendor" />
				<form:errors path="vendor" />
			</div>
			<div>
				<form:label path="amount">Amount: </form:label>
				<form:input type="number" step="0.01" path="amount" />
				<form:errors path="amount" />
			</div>
			<div>
				<form:label path="description">Description: </form:label>
				<form:textarea path="description" />
				<form:errors path="description" />
			</div>
			<div>
				<button class="btn btn-success">Submit</button>
			</div>
		</form:form>

	</div>
</body>
</html>