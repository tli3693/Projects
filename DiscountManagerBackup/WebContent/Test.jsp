<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="http://localhost:7001/LoginForm/">DiscountManager</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li name="home_page"><a
					href="http://localhost:7001/LoginForm/">Home <span
						class="sr-only">(current)</span></a></li>
				<li name="view_programs"><a href="">View Programs</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="http://localhost:7001/LoginForm/">Logout</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">My Account<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Change password</a></li>
						<li><a href="#">Change information</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
</head>

<body>
	<div class="col-xs-1">.col-xs-9.col-xs-9.col-xs-9.col-xs-9.col-xs-9.col-xs-9</div>
	<div class="col-xs-2">
		.col-xs-4<br>Since 9 + 4 = 13 &gt; 12, this 4-column-wide div
		gets wrapped onto a new line as one contiguous unit.
	</div>
	<div class="col-xs-2">
		.col-xs-6<br>Subsequent columns continue along the new line.
	</div>

	<div id="error_msg"></div>
	<div id="programs"></div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>

</html>