<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo Project</title>
</head>
<body>

	<h1>Hello World!</h1>
	
	<% for(int i = 1; i < 6; i++) { %>
		<h1><%= i  %></h1>
		<% } %>
		<h3>The time is: <%= new Date() %></h3>
</body>
</html>