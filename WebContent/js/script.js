// Include form validation functions here
function fvalidate() {
	var name = document.getElementById("moviename");
	var gross = document.getElementById("moviegross");
	var date = document.getElementById("date");
	var choose = document.getElementById("selectCategory");
	var yes = document.getElementById("Active-yes");
	var no = document.getElementById("Active-no");
	if (isTitle(name, "Name should be valid")) {
		if (isNum(gross, "Box Office has to be a number")) {
			if (radioChecked(yes, no)) {
				if (isValid(date)) {
					if (isSelected(choose)) {

						return true;
					}
				}
			}
		}
	}
	return false;
}
function clickAndDisable(link) {
    // disable subsequent clicks
    link.onclick = function(event) {
       event.preventDefault();
    }
  }   
function isTitle(elem, mesg) {
	var alpha = /^[a-z A-Z 0-9]+$/;
	var min = 2;
	var max = 65;
	if (elem.value.length==0) {
		alert("Title is required");
		elem.focus();
		return false;
	} else if ((elem.value.length < min) || (elem.value.length > max)) {
		alert("Title should have 2 to 65 characters");
		elem.focus();
		return false;
	} else if (elem.value.match(alpha)) {
		return true;
	} else {
		alert(mesg);
		elem.focus();
		return false;
	}
}

function isNum(elem, mesg) {
	var num = /^[0-9]+$/;
	if (elem.value == "") {
		alert("Box Office is required");
		elem.focus();
		return false;
	} else if (elem.value.match(num)) {
		return true;
	} else {
		alert(mesg);
		elem.focus();
		return false;
	}
}

function isValid(elem) {
	var dateformat = /^(0?[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\- \/.](19|20)[0-9]{2})$/

	if (elem.value.match(dateformat) && (elem.value.length != null)) {
		return true;
	} else {
		alert("Date of Launch is required");
		elem.focus();
		return false;
	}
}

function isSelected(elem) {
	if (elem.value == "Please Choose") {
		alert("Select one genre");
		elem.focus();
		return false;
	} else {
		return true;
	}
}

function radioChecked(elem1, elem2) {
	if (elem1.checked || elem2.checked) {
		return true;
	} else {

		alert("Please choose between Yes or No");
		return false;
	}
}