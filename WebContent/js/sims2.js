/**
 * 
 */
function sample()
{alert("Test");
}

function isUserValid(examid,designationId)
{ 
	
var userID=document.getElementById("PayUserID").value;
alert("userID "+userID);
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("fees").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("POST", "PayUserSearch?examid=" + examid+"&designationId="+designationId+"&UserID="+userID, true);
	xmlhttp.send();
}

function resetRegistration()
{
document.getElementById("registration").reset();

}

function resetCreateUSer()
{
	document.getElementById("CreateUSer").reset();
}

function userNameValidate()
{
	var name=document.getElementById("username").value;
	/*var dob=document.getElementById("dob").value;
	var email=document.getElementById("email").value;
	var password=document.getElementById("password").value;
	var usertype=document.getElementById("usertype").value;*/
	
	if(name==null || name=="")
		{
		document.registration.username.focus();
		document.getElementById("aname").innerHTML="Please Enter the User Name";
		}
	else if(!isNaN(name)){
		document.registration.username.focus();
		document.getElementById("aname").innerHTML="Please Enter the Alphaba Numeric";
		
	}
	else{
		document.getElementById("aname").innerHTML="";
	}
	/*if(dob==null || dob=="")
	{
	document.getElementById("aname").innerHTML="Please Enter the User Name";
	}*/
}

	function isValidDate() {
		var dateStr=document.getElementById("dob").value;
				var datePat = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{2}|\d{4})$/;

		// To require a 4 digit year entry, use this line instead:
		// var datePat = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{4})$/;

		var matchArray = dateStr.match(datePat); // is the format ok?
		if (matchArray == null) {
			document.registration.dob.focus();
			document.getElementById("adob").innerHTML="Date is not in a valid format.";
		return false;
		}
		day = matchArray[1]; // parse date into variables
		month = matchArray[3];
		year = matchArray[4];
		if (month < 1 || month > 12) { // check month range
			document.registration.dob.focus();
			document.getElementById("adob").innerHTML="Month must be between 1 and 12.";
		return false;
		}
		if (day < 1 || day > 31) {
			document.registration.dob.focus();
			document.getElementById("adob").innerHTML="Day must be between 1 and 31.";
		return false;
		}
		if ((month==4 || month==6 || month==9 || month==11) && day==31) {
			document.registration.dob.focus();
			document.getElementById("adob").innerHTML="Month "+month+" doesn't have 31 days!";
		return false;
		}
		if (month == 2) { // check for february 29th
		var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		if (day>29 || (day==29 && !isleap)) {
			document.registration.dob.focus();
			document.getElementById("adob").innerHTML="February " + year + " doesn't have " + day + " days!";
		return false;
		   }
		}
		document.getElementById("adob").innerHTML="";  // date is valid
		}
	
	function emailValidate()
	{
		var email=document.getElementById("email").value;
		
		if(email==null || email=="")
			{
			document.registration.email.focus();
			document.getElementById("aemail").innerHTML="Please Enter the Email";
			}
		else if(!isNaN(email)){
			document.registration.email.focus();
			document.getElementById("aemail").innerHTML="Please Enter the valid email";
			
		}
		else{
			document.getElementById("aemail").innerHTML="";
		}
		
	}
	function passwordValidate()
	{
		var password=document.getElementById("password").value;		
		if(password==null || password=="")
			{
			document.registration.password.focus();
			document.getElementById("apassword").innerHTML="Please Enter the password";
			}
		else if(password.length>16)
			{
			document.getElementById("apassword").innerHTML="Password should not exceed 15 characters";
			}
		else{
			document.getElementById("apassword").innerHTML="";
		}
		
	}
	
	function designationValidate()
	{
			
		
		if(document.getElementById("usertype").selectedIndex == 0)
			{
			document.registration.usertype.focus();
			document.getElementById("adesignation").innerHTML="Please Select the Designation";
			}
		else{
			document.getElementById("adesignation").innerHTML="";
		}
		
	}
	
	function userNameValidate1()
	{
		var name=document.getElementById("username").value;
		/*var dob=document.getElementById("dob").value;
		var email=document.getElementById("email").value;
		var password=document.getElementById("password").value;
		var usertype=document.getElementById("usertype").value;*/
		
		if(name==null || name=="")
			{
			document.CreateUser.username.focus();
			document.getElementById("aname").innerHTML="Please Enter the User Name";
			}
		else if(!isNaN(name)){
			document.CreateUser.username.focus();
			document.getElementById("aname").innerHTML="Please Enter the Alphaba Numeric";
			
		}
		else{
			document.getElementById("aname").innerHTML="";
		}
		/*if(dob==null || dob=="")
		{
		document.getElementById("aname").innerHTML="Please Enter the User Name";
		}*/
	}

		function isValidDate1() {
			var dateStr=document.getElementById("dob").value;
					var datePat = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{2}|\d{4})$/;

			// To require a 4 digit year entry, use this line instead:
			// var datePat = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{4})$/;

			var matchArray = dateStr.match(datePat); // is the format ok?
			if (matchArray == null) {
				document.CreateUser.dob.focus();
				document.getElementById("adob").innerHTML="Date is not in a valid format.";
			return false;
			}
			day = matchArray[1]; // parse date into variables
			month = matchArray[3];
			year = matchArray[4];
			if (month < 1 || month > 12) { // check month range
				document.CreateUser.dob.focus();
				document.getElementById("adob").innerHTML="Month must be between 1 and 12.";
			return false;
			}
			if (day < 1 || day > 31) {
				document.CreateUser.dob.focus();
				document.getElementById("adob").innerHTML="Day must be between 1 and 31.";
			return false;
			}
			if ((month==4 || month==6 || month==9 || month==11) && day==31) {
				document.CreateUser.dob.focus();
				document.getElementById("adob").innerHTML="Month "+month+" doesn't have 31 days!";
			return false;
			}
			if (month == 2) { // check for february 29th
			var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
			if (day>29 || (day==29 && !isleap)) {
				document.CreateUser.dob.focus();
				document.getElementById("adob").innerHTML="February " + year + " doesn't have " + day + " days!";
			return false;
			   }
			}
			document.getElementById("adob").innerHTML="";  // date is valid
			}
		
		function emailValidate1()
		{
			var email=document.getElementById("email").value;
			
			if(email==null || email=="")
				{
				document.CreateUser.email.focus();
				document.getElementById("aemail").innerHTML="Please Enter the Email";
				}
			else if(!isNaN(email)){
				document.CreateUser.email.focus();
				document.getElementById("aemail").innerHTML="Please Enter the valid email";
				
			}
			else{
				document.getElementById("aemail").innerHTML="";
			}
			
		}
		function passwordValidate1()
		{
			var password=document.getElementById("password").value;
			if(password==null || password=="")
				{
				document.CreateUser.password.focus();
				document.getElementById("apassword").innerHTML="Please Enter the password";
				}
			else if(password.length>=16)
			{
			document.getElementById("apassword").innerHTML="Password should not exceed 15 characters";
			}
			else{
				document.getElementById("apassword").innerHTML="";
			}
			
		}
		
		
		function courseValidate()
		{
				
			
			if(document.getElementById("courseid").selectedIndex == 0)
				{
				document.CreateUser.courseid.focus();
				document.getElementById("ac").innerHTML="Please Select the Designation";
				}
			else{
				document.getElementById("ac").innerHTML="";
			}
			
		}
		
		