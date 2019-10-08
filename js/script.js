/**
 * Arul
 * 
 */
var xhr;
var result;
function createXHR()
{
	if(window.XMLHttpRequest)
		{
		xhr=new XMLHttpRequest();
		}
	else{
		xhr=new ActiveXObject("MicroSoft.XMLHTTP");
	}
return xhr;
}

//
function loadXML(url,callfunction)
{
	xhr=createXHR();
	alert("Object Created");
xhr.onreadystatechange =callfunction;
alert("Callback function called..");
xhr.open(GET,url,true);
xhr.send("Arulmozhi");
}

//
function sis_home()
{
loadXML("home.jsp", function calleefunction()
{ alert(" sis_home called");
	if(xhr.readystate==4 && xhr.status==200)
	{
	alert(" Executing...");
	result=xhr.responseText;
	document.getElementByID("home").innerHTML=result;
	}
});
}