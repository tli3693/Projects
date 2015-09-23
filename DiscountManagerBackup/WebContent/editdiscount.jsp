<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.eintern.discountmanager.models.*"%>
<%@ page import="com.eintern.discountmanager.DAO.DiscountManagerDAO"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Discount</title>
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
					<li name="home_page"><a href="vendorDashboard.jsp">Home <span
							class="sr-only">(current)</span>
					</a></li>
					<li><a id="manage_discounts" href="#">Manage Discounts</a></li>
					<li><a href="#" id="update_discount">Create Discount</a></li>

				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a id="logout_button" name="logout_button"
						href="logout.jsp">Logout</a></li>
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
	<div class="container" id="all">
		<div id="discounts"></div>
		<div id="top" class="col-md-2 col-md-offset-5">
			<p>Edit Discount</p>
			<%
				DiscountManagerDAO dao = new DiscountManagerDAO();
				Discount d = dao.getDiscountWithName((String) request
						.getParameter("edit_discount"));
			%>
			<form class='form-group' method='post' action='CreateDiscount'>
				Name of discount: <input type='text' name='discount_name'
					id='discount_name' value=<%=d.getName()%>></input><br />
				Percentage off: <input type='number' name='percent' id='percent'
					value=<%=d.getPercent()%>></input><br />
				<button id='submit_discount' class='btn btn-primary btn-sm'
					class='submit_discount' name='submit_discount'>Submit</button>
			</form>
			<div id="discounts" class="col-lg-12"></div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="JavaScript/vendor.js"></script>
</body>
</html>