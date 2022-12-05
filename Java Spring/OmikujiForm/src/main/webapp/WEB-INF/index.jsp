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
<title>Omikuji Form</title>
</head>
<body>
	<div class="container">
		<h1>Send an Omikuji!</h1>
		<form action="/omikuji/process" method="POST">
			<div class="mb-3">
				<label class="form-label" for="number">Pick any number from 5 to 25</label>				
				<input class="form-control" type="range" min="5" max="25" step="1" name="number" id="number"/>
			</div>
			<div class="mb-3">
				<label class="form-label" for="city">Enter the name of any city.</label>				
				<input class="form-control" type="text" name="city" id="city" />
			</div>
			<div class="mb-3">
				<label class="form-label" for="person">Enter the name of any real person.</label>				
				<input class="form-control" type="text" name="person" id="person" />
			</div>
			<div class="mb-3">
				<label class="form-label" for="hobby">Enter professional endeavor or hobby.</label>				
				<input class="form-control" type="text" name="hobby" id="hobby" />
			</div>
			<div class="mb-3">
				<label class="form-label" for="livingThing">Enter any type of living thing.</label>				
				<input class="form-control" type="text" name="livingThing" id="livingThing" />
			</div>
			<div class="mb-3">
				<label class="form-label" for="niceThing">Say something nice to someone.</label>				
				<textarea class="form-control" name="niceThing" id="niceThing" rows="5" ></textarea>
			</div>
			<p>Send and show a friend</p>
			<div>
				<button type="submit" class="btn btn-primary">Send</button>
			</div>
		</form>
	</div>
</body>
</html>