<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
</head>
<body>
	<div class="container">
		<h1 class="travel-title">Save Travels</h1>
		<table class="table table-dark table-striped table-hover align-middle">
			<thead>
				<tr>
					<th class="text-center">Expense</th>
					<th class="text-center">Vendor</th>
					<th class="text-center">Amount</th>
					<th class="text-center">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="oneExpense" items="${allExpenses }">
					<tr>
						<td class="text-center"><a href="/expenses/${oneExpense.id }"><c:out
									value="${oneExpense.name }" /></a></td>
						<td class="text-center"><c:out value="${oneExpense.vendor }" /></td>
						<td class="text-center">$<c:out value="${oneExpense.amount }" /></td>
						<td class="d-flex justify-content-evenly align-middle">
							<a href="/expenses/${oneExpense.id}/edit">edit</a>
							<form action="/expenses/${oneExpense.id}" method="POST">
								<input type="hidden" name="_method" value="delete" />								
								<button class="btn btn-danger">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="m-5">
			<h2 class="travel-title">Add an expense:</h2>
			<div>
				<form:form modelAttribute="expenseObject" action="/expenses/new"
					method="POST">
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
		</div>
	</div>
</body>
</html>