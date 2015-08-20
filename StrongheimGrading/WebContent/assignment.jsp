<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<title>Strongheim's Grade System</title>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.html">Professor Strongheim</a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li><a href="Record">Submit Assignment</a></li>
				<li class="active"><a href="Assignments">Search Assignments</a></li>
				<li><a href="Grades">Search Grades</a></li>
				<li><a href="#"></a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div class="container">
		<form role="form"  action="Record" method="POST">
			<div class="form-group">
				<label for="id">Search by ID</label> <input type="text"
					class="form-control" id="id" name="id">
			</div>
			<div class="form-group">
				<label for="type">Search by Type</label> <select
					class="form-control" id="type" name="type">
					<option></option>
					<option>Homework</option>
					<option>Quiz</option>
					<option>Test</option>
					<option>Project</option>
				</select>
			</div>
			<button type="submit" name= "submit" class="btn btn-default">Submit</button>
		</form>
	</div>
	${assignment}
</body>
</html>