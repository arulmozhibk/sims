/**
 * 
 */
function mark()		{
		var sub1=document.getElementById("sub1").value;
		if(sub1==null || sub1=="")
			{
			document.mark.sub1.focus();
			document.getElementById("sub1").innerHTML="Please Enter the subject1";
			}
				else{
			document.getElementById("sub1").innerHTML="";
		}
		
		}
function mark1Check()
{
	var sub1=document.getElementById("sub1").value;
	
		if(sub1==null || sub1=="")
	{
	document.mark.sub1.focus();
	document.getElementById("mark1").innerHTML="Please Enter the subject1";
	}
		else if(sub1>101)
			{
			document.getElementById("mark1").innerHTML="Mark should not be greater than 100";
			}
		else{
	document.getElementById("mark1").innerHTML="";
}
	
}

function mark2Check()
{
	var sub1=document.getElementById("sub2").value;
		if(sub1==null || sub1=="")
	{
	document.mark.sub1.focus();
	document.getElementById("mark2").innerHTML="Please Enter the subject2";
	}
		else if(sub2>101)
		{
		document.getElementById("mark2").innerHTML="Mark should not be greater than 100";
		}
		else{
	document.getElementById("mark2").innerHTML="";
}
	
}

function mark3Check()
{
	var sub1=document.getElementById("sub3").value;
		if(sub1==null || sub1=="")
	{
	document.mark.sub1.focus();
	document.getElementById("mark3").innerHTML="Please Enter the subject3";
	}
		else if(sub3>101)
		{
		document.getElementById("mark3").innerHTML="Mark should not be greater than 100";
		}
		else{
	document.getElementById("mark3").innerHTML="";
}
	
}

function mark4Check()
{
	var sub1=document.getElementById("sub4").value;
		if(sub1==null || sub1=="")
	{
	document.mark.sub1.focus();
	document.getElementById("mark4").innerHTML="Please Enter the subject5";
	}
		else if(sub4>101)
		{
		document.getElementById("mark4").innerHTML="Mark should not be greater than 100";
		}
		else{
	document.getElementById("mark4").innerHTML="";
}
	
}

function mark5Check()
{
	var sub1=document.getElementById("sub5").value;
		if(sub1==null || sub1=="")
	{
	document.mark.sub1.focus();
	document.getElementById("mark5").innerHTML="Please Enter the subject5";
	}
		else if(sub5>101)
		{
		document.getElementById("mark5").innerHTML="Mark should not be greater than 100";
		}
		else{
	document.getElementById("mark5").innerHTML="";
}
	
}

function totalCheck()
{
	var total=document.getElementById("total").value;
		if(total==null || total=="")
	{

	document.getElementById("atotal").innerHTML="Please Enter the subject5";
	}
		else if(total>501)
		{
		document.getElementById("atotal").innerHTML="Mark should not be greater than 100";
		}
		else{
	document.getElementById("atotal").innerHTML="";
}
	
}