<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
</head>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">DiscountManager</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li name="home_page"><a href="index.jsp">Home
						<span class="sr-only">(current)</span>
				</a></li>

			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="registration.jsp">Register</a></li>
			</ul>
		</div>
	</div>
</nav>
<body>
	<h1 align="center">
		Login to Discount Manager!<br />
	</h1>
	<form method="post" action="login" class="form-group">
		<div class="container" id="top">
			<div class="col-md-2 col-md-offset-5">
				<label for="usr" class="control-label">Username: </label> <input
					type="text" class="form-control" name="username" id="usr"
					placeholder="Username"> <label for="pwd">Password:
				</label><input type="password" class="form-control" name="password" id="pwd"
					placeholder="Password"> <br /> <input type="submit"
					class="btn btn-primary" value="Login" id="login">
			</div>
		</div>
		<script src="JavaScript/login.js"></script>
	</form>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
<style>
#top {
	margin: 0 auto;
	width: 80%;
}
</style>
</html>