<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.eintern.discountmanager.models.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Dashboard</title>
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
					<li name="home_page"><a
						href="employeeDashboard.jsp">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li><a id="view_programs" href="#">View Programs</a></li>
					<li><a href="#" id="your_program">Your Program</a></li>

				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout.jsp" id="logout_button" name="logout">Logout</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">My Account<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="change_information.jsp">Change Account Info</a></li>
							<li><a href="myaccount.jsp">My Account</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<div id="all" class="row">
		<div class="container" id="top">
			<div align="center">
				<p>Change your account information</p>
			</div>
			<div class="col-md-2 col-md-offset-5">

				<div id="error_msg"></div>
				<%
					User user = (User) request.getSession()
							.getAttribute("current_user");
				%>
				<form method="post" action="UpdateUser">
					<label for="email">E-mail: </label><input type="email"
						class="form-control" name="email" id="email" class="box"
						value="<%=user.getEmail()%>"> <label for="fname">First
						name: </label><input type="text" class="form-control" name="fname"
						id="fname" class="box" value="<%=user.getFirstname()%>"> <label
						for="lname">Last name: </label><input type="text"
						class="form-control" name="lname" id="lname" class="box"
						value="<%=user.getLastname()%>"> <label for="usr">Username:
					</label><input type="text" class="form-control" name="username" id="usr"
						class="box" value="<%=user.getUsername()%>"> <label
						for="pwd">Password: </label><input type="password"
						class="form-control" name="password" id="pwd" class="box">
					<label for="pwd2">Confirm Password: </label><input type="password"
						class="form-control" name="password2" id="pwd2" class="box">
					<input type="submit" class="btn btn-primary" name="update"
						value="Update" id="update">
				</form>
				<div id="programs" class="col-lg-12"></div>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="JavaScript/employee.js"></script>
</body>

<style>
form {
	display: inline;
}

#programs {
	font-size: 15px;
}

#top {
	margin: 0 auto;
	width: 80%;
}
</style>
</html>