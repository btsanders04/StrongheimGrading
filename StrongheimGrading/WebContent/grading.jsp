<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="stylesheet" type="text/css"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="assets/css/style.min.css" rel="stylesheet">
<link href="assets/css/retina.min.css" rel="stylesheet">
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
				<li class="active"><a href="Record">Submit Assignment</a></li>
				<li><a href="Assignments">Search Assignments</a></li>
				<li><a href="Grades">Search Grades</a></li>
				<li><a href="#"></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container">
		<form role="form" action="Record" method="POST">
			<div class="form-group">
				<label for="id">Student ID:</label> <input type="text"
					class="form-control" name="id" id="id"
					placeholder="Enter Student ID">
			</div>
			<div class="form-group">
				<label for="assignment">Assignment:</label> <input type="text"
					class="form-control" name="assignment" id="assignment"
					placeholder="Enter Assignment">
			</div>
			<form role="form">
				<div class="form-group">
					<label for="class">Select Class:</label> <select class="form-control"
						name="class" id="class">
						<option>9:30am Earth Science</option>
						<option>1:00pm Physics</option>
					</select>

				</div>
			<form role="form">
				<div class="form-group">
					<label for="type">Select Type:</label> <select class="form-control"
						name="type" id="type">
						<option>Homework</option>
						<option>Quiz</option>
						<option>Test</option>
						<option>Project</option>
					</select>

				</div>
				<div class="form-group">
					<label for="date">Date:</label> <input type="Date"
						class="form-control" name="date" id="date"
						placeholder="Enter Date">
				</div>
				<div class="form-group">
					<label for="grade">Grade:</label> <input type="number" min="0"
						max="100" class="form-control" name="grade" id="grade"
						placeholder="Enter Grade">
				</div>
				<div class="form-group">
				<label for="weight">Weight:</label> <input type="number" min="1"
						max="10" name="weight" id="weight"
						>
					<div class="slider sliderSimple"></div>
					
				</div>
				<button type="submit" name="submit" class="btn btn-default">Submit</button>
			</form>

			<script src="ui_sliders-progress.js"></script>
</body>
</html>