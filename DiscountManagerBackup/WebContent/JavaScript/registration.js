var usrn = document.getElementById("usr");
var pass = document.getElementById("pwd");
var pass2 = document.getElementById("pwd2");
var email = document.getElementById("email");
var reg = document.getElementById("register");

$( document ).ready(function() {
	$("#register").click(function(evt) {

	$("#errors").empty();
	$("#top").prepend('<div id="errors"><p id="userError" ></p></div>');

	if (usrn.value.length == 0) {
		$('#userError').append("Username cannot be blank");
	}

	if (pass.value !== pass2.value) {
		$('#userError').append("</br> Passwords don't match");
		evt.preventDefault();
	}
	if (pass.value.length < 8) {
		$('#userError').append("</br> Password has to be at least 8 characters");
		evt.preventDefault();
	}
	});
	$("#vendor").click(function(evt) {
		$("#vendor_div").empty();
		$("#vendor_div").append("<label>Vendor name:</label><br/><input type='text' name='vendor_name' id='vendor_name' class='box'></input><br/>");
	});
	$("#sales").click(function(evt) {
		$("#vendor_div").empty();
		
	});
	$("#emp").click(function(evt) {
		$("#vendor_div").empty();
	});
	
});