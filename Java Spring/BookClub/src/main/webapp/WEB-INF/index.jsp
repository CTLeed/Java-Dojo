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
		<h1 class="text-primary">Book Club</h1>
			<p>A place for friends to share thoughts on books.</p>
			<div class="left">
				<form:form modelAttribute="newUser" action="/register" method="POST">
					<div>
						<form:label path="name">Name:</form:label>
						<form:input type="text" path="name" />
						<form:errors path="name"/>					
					</div>				
					<div>
						<form:label path="email">Email:</form:label>
						<form:input type="email" path="email" />
						<form:errors path="email"/>					
					</div>				
					<div>
						<form:label path="password">Password:</form:label>
						<form:input type="password" path="password" />
						<form:errors path="password"/>					
					</div>				
					<div>
						<form:label path="confirm">Confirm Password:</form:label>
						<form:input type="password" path="confirm" />
						<form:errors path="confirm"/>					
					</div>				
					<div>
						<button>Submit</button>
					</div>				
				</form:form>
			</div>
			<div class="right">
			<form:form modelAttribute="newLogin" action="/login" method="POST">
				<div>
					<form:label path="email">Email:</form:label>
					<form:input type="email" path="email" />
					<form:errors path="email" />
				</div>
				<div>
					<form:label path="password">Password:</form:label>
					<form:input type="password" path="password" />
					<form:errors path="password" />
				</div>
				<div>
					<button>Submit</button>
				</div>
			</form:form>			
			</div>
	</div>
</body>
</html>