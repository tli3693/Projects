<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.eintern.discountmanager.models.Vendor"%>

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

<body>

	<div class="row">
		<div class="container">
			<p>Create/Add a program.</p>
			<div id="error_msg"></div>
			<div id="programs" class="col-lg-12"></div>
			<form method="post" action="CreateProgram">
				<label>Name of Program: </label><br />
				<input type='text' name='program_name' id='program_name'></input>
				<button id="submit_discount"
					class="btn btn-primary btn-sm submit_discount"
					name="submit_discount" value="submit_discount">Submit</button>

				<br /> Select the vendors you want to add to the program: <br />
				<%
					List<Vendor> list = (List<Vendor>) request.getSession().getAttribute("list_vendors");
								for(Vendor v : list) {
									out.println("<input type='checkbox' name='add_vendors' value='"+v.getName()+"'>"+ v.getName() +"<br/>" );
								}
				%>

			</form>
		</div>
	</div>

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