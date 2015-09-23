$(document).ready(function() {

	// listen for enroll buttons
	$("#view_programs").click(function() {
		$.ajax({
			method : 'POST',
			url : 'employeeServlet',
			success : function(data) {
				$("#all").empty();
				$("#programs").empty();
				$("#programs").append(data);
			}
			
		});

	});
	$("#your_program").click(function() {
		$.ajax({
			method : 'POST',
			url : 'EmpProgram',
			success : function(data) {
				$("#all").empty();
				$("#error_msg").empty();
				$("#error_msg").append(data);
			}
		});

	});

});
