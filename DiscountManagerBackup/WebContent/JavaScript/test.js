$(document).ready(function() {
	// View Programs
	$("#view_programs").click(function() {
		$.ajax({
			method : 'POST',
			url : 'employeeServlet',
			success : function(data) {
				$("#programs").empty();
				$("#programs").append(data);
			}
		});

	});
});