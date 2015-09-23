<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sales</title>
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
				<li name="home_page"><a href="salesDashboard.jsp">Home <span
						class="sr-only">(current)</span>
				</a></li>
				<li><a id="prog_button" href="#">Manage Programs</a></li>
				<li><a href="#" id="update_button">Create/Add Program</a></li>
				<li><a href="#" id="manage_employees">Manage Employees</a></li>

			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="logout.jsp" id="logout_button" name="logout">Logout</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">My Account<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="change_information.jsp">Change Account Info</a></li>
						<li><a href="myaccount.jsp">My account</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>
<body>
	<h1>Failed to create program.</h1>

	<div id="error_msg"></div>
	<div id="programs"></div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="JavaScript/sales.js"></script>

</body>
<style>
form {
	display: inline;
}

#programs {
	font-size: 20px;
}
</style>
</html>