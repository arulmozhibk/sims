/**
 * 
 */
function dashboardPayment() {
	var xmlhttp;

	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("main").innerHTML = xmlhttp.responseText;
		}
	};
	xmlhttp.open("GET", "courseWisePayment.jsp", true);
	xmlhttp.send();
}
function paymentByCourse() {
	var courseId = document.getElementById("courseId").value;
	var fromDate = document.getElementById("fromDate").value;
	var toDate = document.getElementById("toDate").value;
	var xmlhttp;
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("main").innerHTML = xmlhttp.responseText;
		}

	};
	xmlhttp.open("POST", "paymentByCourseReport.jsp?courseId=" + courseId
			+ "&fromDate=" + fromDate + "&toDate=" + toDate, true);
	alert("Arguements passed");
	xmlhttp.send();
}

function ExcelReport()
{

//Source:: http://stackoverflow.com/questions/22317951/export-html-table-data-to-excel-using-javascript-jquery-is-not-working-properl
    var tab_text="<table border='2px'><tr bgcolor='#87AFC6'>";
    var textRange; 
    var j=0;
    tab = document.getElementById('payment'); // id of table

    for(j = 0 ; j < tab.rows.length ; j++) 
    {     
        tab_text=tab_text+tab.rows[j].innerHTML+"</tr>";
        //tab_text=tab_text+"</tr>";
    }

    tab_text=tab_text+"</table>";
    tab_text= tab_text.replace(/<A[^>]*>|<\/A>/g, "");//remove if u want links in your table
//    tab_text= tab_text.replace(/<img[^>]*>/gi,""); // remove if u want images in your table
//    tab_text= tab_text.replace(/<input[^>]*>|<\/input>/gi, ""); // reomves input params

    var ua = window.navigator.userAgent;
    var msie = ua.indexOf("MSIE "); 

    if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./))      // If Internet Explorer
    {
        txtArea1.document.open("txt/html","replace");
        txtArea1.document.write(tab_text);
        txtArea1.document.close();
        txtArea1.focus(); 
        sa=txtArea1.document.execCommand("SaveAs",true,"Say Thanks to Sumit.xls");
    }  
    else                 //other browser not tested on IE 11
        sa = window.open('data:application/vnd.ms-excel,' + encodeURIComponent(tab_text));  

    return (sa);
}


function logOut() {
	var xmlhttp;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	} else {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	xmlhttp.open("POST", "Logout", true);
	xmlhttp.send();
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			document.getElementById("index").innerHTML = xmlhttp.responseText;
		}
	};
}

