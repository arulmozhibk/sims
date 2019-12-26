/**
 * 
 */
function login() {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.open("POST", "registration.jsp", true);
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("main").innerHTML = xmlhttp.responseText;
			}
		};
	}
	function adminRegistration(designationId) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.open("POST", "registration.jsp?designationId="+designationId, true);
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("main").innerHTML = xmlhttp.responseText;
			}
		};
	}
	function registerAdmin(designationId) {
		var username=document.getElementById("username").value;
		var dob=document.getElementById("dob").value;
		var email=document.getElementById("email").value;
		var password=document.getElementById("password").value;
		var courseid=0;
		var userType=document.getElementById("usertype").value;
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
		xmlhttp.open("POST", "Registration?username=" + username+"&dob="+dob+"&email="+email+"&password="+password+"&courseid="+courseid+"&designationid="+designationId+"&usertype="+userType, true);
		xmlhttp.send();
	}
	
	function loadAdmin(designationId) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.open("POST", "admin.jsp?designationId="+designationId, true);
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("main").innerHTML = xmlhttp.responseText;
			}
		};
	}

	function loadCreateCourse(designationId) {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.open("POST", "createCourse.jsp?designationId="+designationId, true);
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("course").innerHTML = xmlhttp.responseText;
				//clearInterval(loadAdmin);
			}

		};
	}

	function createCourseAction(designationId) {
		var coursename = document.getElementById("coursename").value;
		var coursefees = document.getElementById("coursefees").value;
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("course").innerHTML = xmlhttp.responseText;
			}
		};

		xmlhttp.open("POST", "CreateCourse?coursename=" + coursename
				+ "&coursefees=" + coursefees+"&designationId="+designationId, true);
		xmlhttp.send();
	}

	function createExamAction(designationId) {
		var examname = document.getElementById("examname").value;
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("course").innerHTML = xmlhttp.responseText;
			}

		};
		xmlhttp.open("POST", "CreateExam?exam_name=" + examname+"&designationId="+designationId, true);
		xmlhttp.send();
	}

	function loadEditCourse(designationId) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("course").innerHTML = xmlhttp.responseText;
			}
		};

		xmlhttp.open("POST", "editCourse.jsp?designationid="+designationId, true);
		xmlhttp.send();
	}
	/*function editCourseAction()
	{
		var course=document.getElementsByName("courses");
		var editCourseId=null;
		for(var i=0;i<course.length;++i)
			{
			if(course[i].selectedIndex)
				{
				editCourseId=course[i].value;
			}		
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var result= xmlhttp.responseText;
				document.getElementById("course").innerHTML =result;			}
		};
		xmlhttp.open("POST","updateCourse.jsp?editCourseId="+editCourseId, true);
		xmlhttp.send();
	}*/
	function editCourseAction(editCourseId,designationId)
	{
		/*var editCourseId=document.getElementById("hiddenCourseId").value;*/
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var result= xmlhttp.responseText;
				document.getElementById("course").innerHTML =result;			}
		};
		xmlhttp.open("POST","updateCourse.jsp?editCourseId="+editCourseId + "&designationid="+designationId, true);
		xmlhttp.send();
	}
	function updateCourseAction(courseId,designationId)
	{	 document.getElementById("courseName").focus();	
		/*var courseId = document.getElementById("hiddenCourseId").value;*/
		var courseName = document.getElementById("courseName").value;
		var courseFees=document.getElementById("courseFees").value;
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("course").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("POST", "UpdateCourse?courseId=" + courseId+"&courseName="+courseName+"&courseFees="+courseFees + "&designationid="+designationId, true);
		xmlhttp.send();
	}
		
	function loadDeleteCourse(designationId) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("course").innerHTML = xmlhttp.responseText;
			}
		};

		xmlhttp.open("POST", "deleteCourse.jsp?designationId="+designationId, true);
		xmlhttp.send();
		//document.getElementById("divtag").innerHTML=xmlhttp.responseText;
	}
	function deleteCourse() {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		var course=document.getElementsByName("deleteCourse");
		var deleteCourseId=new Array();
		var len=course.length;
		for(var i=0;i<len;i++)
			{
			if(course[i].checked)
				{
				
				deleteCourseId[i]=course[i].value;
					
		xmlhttp.open("POST", "DeleteCourse?deleteCourseId=" + deleteCourseId, true);
		xmlhttp.send();
				}
			}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("course").innerHTML = xmlhttp.responseText;
			}
		};
		
	}
	function deleteCourseAction() {
		var course=document.getElementsByName("deleteCourse");
		var deleteCourseId=null;
		for(var i=0;i<course.length;i++)
			{
			if(course[i].checked)
				{
				deleteCourseId=course[i].value;
				}
			}		
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("course").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("POST", "DeleteCourse?deleteCourseId=" + deleteCourseId, true);
		xmlhttp.send();
	}
		function loadCreateExam(designationId) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("course").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("POST", "createExam.jsp?designationId="+designationId, true);
		xmlhttp.send();
		//document.getElementById("divtag").innerHTML=xmlhttp.responseText;
	}
		function loadManageUser(designationId) {
			var xmlhttp;
			if (window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest();
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}

			xmlhttp.open("POST", "manageUser.jsp?designationId="+designationId, true);
			xmlhttp.send();
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("main").innerHTML = xmlhttp.responseText;
				}
			};
		}
		function createUser(designationId) {
			var xmlhttp;
			if (window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest();
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("manageUser").innerHTML = xmlhttp.responseText;
				}
			};
			xmlhttp.open("POST", "createUser.jsp?designationId="+designationId, true);
			xmlhttp.send();

		}
		function registerUser(designationId) {
			var username=document.getElementById("username").value;
			var dob=document.getElementById("dob").value;
			var email=document.getElementById("email").value;
			var password=document.getElementById("password").value;
			var courseid=document.getElementById("courseid").value;
			var studesignationId=5;
			var xmlhttp;
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("manageUser").innerHTML = xmlhttp.responseText;
				}
		};
			xmlhttp.open("POST", "CreateUser?username=" + username+"&dob="+dob+"&email="+email+"&password="+password+"&courseid="+courseid+"&designationId="+designationId+"&stuDesignationId="+studesignationId, true);
			xmlhttp.send();
		}
		
		function moveUserCourse(designationId) {
			var xmlhttp;
			if (window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest();
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("manageUser").innerHTML = xmlhttp.responseText;
				}
			};
			xmlhttp.open("POST", "moveUser.jsp?designationId="+designationId, true);
			xmlhttp.send();

		}
		function moveUserList(courseId,designationId) {
			var xmlhttp;
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("manageUser").innerHTML = xmlhttp.responseText;
						
				}
			};
			xmlhttp.open("POST", "moveUserList.jsp?courseId=" + courseId+"&designationId="+designationId, true);
			xmlhttp.send();
		}
		
		function moveUserToCourse(designationId) {
			var course=document.getElementsByName("couseList");
			var moveCourseId=null;
			var len=course.length;
			for(var i=0;i<len;i++)
				{
				if(course[i].selectedIndex)
					{
					moveCourseId=course[i].value;
					}
				}
			var user=document.getElementsByName("usersList");
			var moveUserId=new Array();
			for(var i=0;i<user.length;i++)
				{
				if(user[i].checked)
					{
					moveUserId[i]=user[i].value;
					}
				}
			var xmlhttp;
			if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp = new XMLHttpRequest();
			} else {// code for IE6, IE5
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById("manageUser").innerHTML = xmlhttp.responseText;
				}
			};
			xmlhttp.open("POST", "MoveUser?moveCourseId=" + moveCourseId+"&moveUserId="+moveUserId+"&designationId="+ designationId, true);
			xmlhttp.send();
		}
		
		
	function loadRemoveUser(designationId) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("manageUser").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("POST", "removeUser.jsp?designationId="+designationId, true);
		xmlhttp.send();

	}
	function showCourseWiseUser(courseId,designationId) {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("manageUser").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("POST", "manageStudents.jsp?courseId=" + courseId+"&designationId="+designationId, true);
		xmlhttp.send();
	}
	function removeUser(designationId) {
		var user=document.getElementsByName("userList");
		var removeUserId=new Array();
		for(var i=0;i<user.length;i++)
			{
			if(user[i].checked)
				{
				removeUserId[i]=user[i].value;
				}
			}
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("manageUser").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("POST", "RemoveUser?removeUserId=" + removeUserId+"&designationId="+designationId, true);
		xmlhttp.send();
	}

	

	function loadFeesConfiguration(designationId) {
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
		xmlhttp.open("POST", "feesConfiguration.jsp?designationId="+designationId, true);
		xmlhttp.send();

	}
	
function loadPayUser(designationId) {
		var userId = document.getElementById("PayUserID").value;
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("fees").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("POST", "payUser.jsp?userId=" + userId+"&designationId="+designationId, true);
		xmlhttp.send();
	}
	 function payAmountforUser(designationId)
	{
		var paidAmount=document.getElementById("paidAmount").value;
		var userId=document.getElementById("hiddenUserId").value;
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("fees").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("POST", "PayUser?userId="+userId+"&paidAmount="+paidAmount+"&designationId="+designationId, true);
		xmlhttp.send();
	} 
	/*function payAmount() {
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("fees").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("POST", "payUserReport.jsp", true);
		xmlhttp.send();
	}*/
	function loadExamination(designationId) {
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

		xmlhttp.open("POST", "examination.jsp?designationId="+designationId, true);
		xmlhttp.send();

	}
	function CycleTests(designationId) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("exam").innerHTML = xmlhttp.responseText;
			}
		};

		xmlhttp.open("POST", "cycleTests.jsp?designationId="+designationId, true);
		xmlhttp.send();
		//document.getElementById("divtag").innerHTML=xmlhttp.responseText;
	}
	function SemExams(designationId) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("exam").innerHTML = xmlhttp.responseText;
			}
		};

		xmlhttp.open("POST", "semExams.jsp?designationId="+designationId, true);
		xmlhttp.send();
		//document.getElementById("divtag").innerHTML=xmlhttp.responseText;
	}
	function searchUser(examId,designationId) {
		var xmlhttp;
		/* 		var hiddenexamid=document.getElementById("hiddenexamid").value;
		 */if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("exam").innerHTML = xmlhttp.responseText;
			}
		};
		/* xmlhttp.open("POST","searchUser.jsp",true); */

		xmlhttp.open("POST", "searchUser.jsp?examid=" + examId+"&designationId="+designationId, true);
		xmlhttp.send();
		//document.getElementById("divtag").innerHTML=xmlhttp.responseText;
	}
function searchUserById(examId,designationId)
	{ 
	var userID=document.getElementById("userid").value;
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("exam").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("POST", "SearchUser?examid=" + examId+"&designationId="+designationId+"&userid="+userID, true);
		xmlhttp.send();

	
	}

	function addMarkDetails(examid,designationId) {
		var xmlhttp;
		var userid = document.getElementById("userid").value;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("exam").innerHTML = xmlhttp.responseText;
			}
		};
		xmlhttp.open("POST", "addMarkDetails.jsp?examid=" + examid + "&userid="
				+ userid+"&designationId="+designationId, true);

		xmlhttp.send();
		//document.getElementById("divtag").innerHTML=xmlhttp.responseText;
	}
	function addMarks(examid, userid,designationId) {
		var xmlhttp;
		var sub1 = document.getElementById("sub1").value;
		var sub2 = document.getElementById("sub2").value;
		var sub3 = document.getElementById("sub3").value;
		var sub4 = document.getElementById("sub4").value;
		var sub5 = document.getElementById("sub5").value;
		var total = document.getElementById("total").value;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var result=xmlhttp.responseText;
				document.getElementById("main").innerHTML = result;
			}
		};
		
		xmlhttp.open("POST","AddMarkDetails?examid=" + examid + "&userid="+ userid + "&sub1=" + sub1 + "&sub2=" + sub2 + "&sub3=" + sub3
				+ "&sub4=" + sub4 + "&sub5=" + sub5 + "&total=" + total+"&designationId="+designationId, true);
		xmlhttp.send();
		}
	
	
	function loadAcademics(designationId) {
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

		xmlhttp.open("POST", "academics.jsp?designationId="+designationId, true);
		xmlhttp.send();

	}
	function cycleCourse(designationId) {
		var xmlhttp;	

		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("academics").innerHTML = xmlhttp.responseText;
			}
		};

		xmlhttp.open("POST", "cycleAcademic.jsp?designationId="+designationId, true);
		xmlhttp.send();
		//document.getElementById("divtag").innerHTML=xmlhttp.responseText;
	}
	function semCourse(designationId) {
		var xmlhttp;	

		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("academics").innerHTML = xmlhttp.responseText;
			}
		};

		xmlhttp.open("POST", "semAcademic.jsp?designationId="+designationId, true);
		xmlhttp.send();
		//document.getElementById("divtag").innerHTML=xmlhttp.responseText;
	}
	function coursesList(examId,designationId)
	{
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				var result=xmlhttp.responseText;
				document.getElementById("academics").innerHTML =result; 
			}
		};

		xmlhttp.open("POST","coursesList.jsp?examId="+examId+"&designationId="+designationId,true);
		xmlhttp.send();
		//document.getElementById("divtag").innerHTML=xmlhttp.responseText;
	}
	function academicReport(designationId,courseId) {
		var xmlhttp;
		var examId=document.getElementById("hiddenExamId").value;
				if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("POST", "academicReport.jsp?examId="+examId+"&courseId="+courseId+"&designationId="+designationId, true);
		xmlhttp.send();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) 
			{ 
				var result=xmlhttp.responseText;
			document.getElementById("academics").innerHTML =result; 
			}
		};
		
	}
	

function showTotal()
{
var subject1=document.getElementById("sub1").value;
var subject2=document.getElementById("sub2").value;
var subject3=document.getElementById("sub3").value;
var subject4=document.getElementById("sub4").value;
var subject5=document.getElementById("sub5").value;

var total=parseInt(subject1)+parseInt(subject2)+parseInt(subject3)+parseInt(subject4)+parseInt(subject5);
if(!isNaN(total))
	{
	document.getElementById("total").value=total;
	}
}
	

