var elem = document.getElementById("login");
var usrn = document.getElementById("usr");
var pass = document.getElementById("pwd");

elem.addEventListener("click", function(evt) {
	$("#errors").empty();
	$("#top").prepend('<div id="errors"><p id="userError" ></p></div>');
	if (usrn.value.length == 0) {
		evt.preventDefault();
		alert("Username cannot be blank.");
	}
	if (pass.value.length < 8) {
		evt.preventDefault();
		alert("Password has to be at least 8 characters.");
	}

});