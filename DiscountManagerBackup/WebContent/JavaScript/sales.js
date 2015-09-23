$(document).ready(function() {
	// View Programs
	$("#prog_button").click(function() {
		$.ajax({
			method : 'POST',
			url : 'salesPrograms',
			success : function(data) {
				$("#programs").empty();
				$("#programs").append(data);
			}
		});

	});
	$("#manage_employees").click(function() {
		$.ajax({
			method : 'POST',
			url : 'ListEmployees',
			success : function(data) {
				$("#programs").empty();
				$("#programs").append(data);
			}
		});

	});

	$("#update_button").click(function() {
		$.ajax({
			method : 'POST',
			url : 'ListVendors',
			success : function(data) {
				$("#programs").empty();
				$("#programs").append(data);
			}
		});

		// $("#programs").empty();
		// $("#programs").append("<form method='post'
		// action='CreateProgram'>Name of Program: <input type='text'
		// name='program_name' id='program_name'></input><br/>"
		// +"<button id='submit_discount' class='btn btn-primary btn-sm'
		// class='submit_discount' name='submit_discount'"
		// + ">Submit</button></form>");
	});
	$(document.body).on('click', '.update_prog', (function() {

		$.ajax({
			method : 'POST',
			url : 'updProgServlet',
			success : function(data) {
				$("#all").empty();
				$("#error_msg").empty();
				$("#error_msg").append(data);
			}
		});
	}));

});