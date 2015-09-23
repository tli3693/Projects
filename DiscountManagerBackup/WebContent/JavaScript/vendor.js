$(document).ready(function() {
	// View Programs
	$("#manage_discounts").click(function() {
		$.ajax({
			method : 'POST',
			url : 'ViewDiscounts',
			success : function(data) {
				$("#all").empty();
				$("#top").empty();
				$("#discounts").empty();
				$("#discounts").append(data);
			}
		});

	});

	$("#update_discount").click(function() {
		$("#all").empty();
		$("#top").empty();
		$("#discounts").empty();
		$("#top").append("Create Discount<br/><form class='form-group' method='post' action='CreateDiscount'>Name of discount: <input type='text' name='discount_name' id='discount_name'></input><br/>" +
				"Percentage off: <input type='number' name='percent' id='percent'></input><br/>" +
				"<button id='submit_discount' class='btn btn-primary btn-sm' class='submit_discount' name='submit_discount'"
					+ ">Submit</button></form>");

	});

});