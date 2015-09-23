<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<title>Registration</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
</head>

<body>
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
					<li name="home_page"><a href="index.jsp">Home <span
							class="sr-only">(current)</span>
					</a></li>

				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="index.jsp">Login</a></li>

				</ul>
			</div>
		</div>
	</nav>

	<h1 id="test" align="center">
		Register for DiscountManager!<br />
	</h1>


	<form method="post" action="registrationServlet" class="form-group">
		<p align="center">
			Your position: <input type="radio" id="emp" name="role" value="emp"
				checked>Employee <input type="radio" id="vendor" name="role"
				value="vendor">Vendor <input type="radio" id="sales"
				name="role" value="sales">Sales <br /> <br />

		</p>
		<div class="container" id="top">
			<div class="col-md-2 col-md-offset-5">
				<div id="vendor_div"></div>
				<label>E-mail: </label><input type="email" name="email" id="email"
					class="box"> <br /> <label>First name: </label><input
					type="text" name="fname" id="fname" class="box"> <br /> <label>Last
					name: </label><input type="text" name="lname" id="lname" class="box">
				<br /> <label>Username: </label><input type="text" name="username"
					id="usr" class="box"> <br /> <label>Password: </label><input
					type="password" name="password" id="pwd" class="box"> <br />
				<label>Confirm Password: </label><input type="password"
					name="password2" id="pwd2" class="box"> <br /> <br /> <input
					type="submit" class="btn btn-primary" value="Register"
					id="register">
			</div>
		</div>
	</form>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="JavaScript/registration.js"></script>
</body>

</html>