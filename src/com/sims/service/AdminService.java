
package com.sims.service;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.sims.bean.CourseBean;
import com.sims.bean.ExamResultBean;
import com.sims.bean.PaymentBean;
import com.sims.bean.UserBean;
import com.sims.dao.CourseDao;
import com.sims.dao.ExamDao;
import com.sims.dao.ExamResultDao;
import com.sims.dao.PaymentDao;
import com.sims.dao.UserDao;


public class AdminService {
		
/* 
 * 
 *  Administration Screen 
*/ 
	public boolean createCourseService(CourseBean cb) throws SQLException
	{	CourseDao cd=new CourseDao();
		boolean status = false;
		int count=cd.createCourse(cb);
		System.out.println(count);
		if(count >0)
		{
			status=true;
			System.out.println("Course Created successfully");
		}
		else
		{
			status=false;
			System.out.println("Error in creating the course");
		}
		return status;
	}
	
	// public Boolean editCourse(CourseBean cb)
	public Boolean editCourseService(CourseBean cb) throws SQLException
	{
		CourseDao cd=new CourseDao();
		int count=cd.editCourse(cb);
		boolean status=false;
		if(count>0)
		{
			status=true;System.out.println("Updated Successfully");
		}
		else
		{
			status=false;
		}
		
	return status;
	}
	
	// public Boolean deleteCourse(CourseBean cb)
	public Boolean deleteCourseService(String strcourse_id) throws SQLException
	{
		Boolean status = null;
		CourseDao cd=new CourseDao();
		strcourse_id.trim();
		System.out.println("strcourse_id  ::"+strcourse_id);
	
		int course_id=Integer.parseInt(strcourse_id);
		int count=cd.deleteCourse(course_id);
		if(count>0)
		{
			status=true;
		}
		else
		{
			status=false;
		}
		return status;
	}
	
	// public ExamBean createExam(ExamBean eb)
	
	public boolean createExamService(String exam_name) throws SQLException
	{
		boolean status=false;
		ExamDao ed=new ExamDao();
		int count=ed.createExam(exam_name);
		if(count>0)
		{
			status=true;System.out.println("Exam created");
		}
		else {
			status=false;
		}
		
		return status;
	}
	
// Manage User Screen 
	public boolean createUser(UserBean ub) throws SQLException
	{	UserDao ud=new UserDao();
		boolean status = false;
		int count=ud.createUser(ub);
		System.out.println(count);
		if(count >0)
		{
			status=true;
		}
		else
		{
			status=false;
			System.out.println("Error in creating the user ");
		}
		return status;
	}
		
 public Boolean moveUser(String editUser,int moveCourseId) throws SQLException
 {int moveUserId=Integer.parseInt(editUser);
 ViewService vs=new ViewService();
 UserBean ub=new UserBean();
	 ResultSet rs=vs.getUser(editUser);
	while(rs.next())
	{
	ub.setUser_id(moveUserId);
	ub.setUsername(rs.getString(2));
	ub.setDob(rs.getString(3));
	ub.setEmail(rs.getString(4));
	ub.setPassword(rs.getString(5));
	ub.setCourse_id(moveCourseId);
	}
	 Boolean status=false;
	 UserDao ud=new UserDao();
	 int count =ud.edituser(ub);
	 if(count>0)
	 {
		 status=true;System.out.println("User Moved");
	 }
	 else{
		 status=false;
	 }
	 return status;
 }
	
public Boolean removeUser(String userid) throws SQLException
{
	Boolean status=false;
	UserDao ud=new UserDao();
	int user_id=Integer.parseInt(userid);
	int count=ud.deleteUser(user_id);
	if(count>0)
	{
		status=true;System.out.println("USer Removed");
	}
	else{status=false;}
	return status;
}
	
/* Payment Screen 
 * 
 */	 
	// public PaymentBean payAmount(PaymentBean ub)
public boolean payAmount(PaymentBean pb) throws SQLException
{
	Boolean status=false;
	PaymentDao pd=new PaymentDao();
	int count=pd.createPayment(pb);
	if(count>0)
	{
		status=true;
		System.out.println("Payment made for the User in Service");
	}
	else{status=false;}
	
	return status;
}
	
/*
 Examination Screen
*
*/
public boolean updateResultService(ExamResultBean erb) throws SQLException
{
	boolean status=false;
	ExamResultDao erd=new ExamResultDao();
	int count=erd.editResult(erb);
	if(count>0)
	{
		status=true;
		System.out.println("Marks updated");
	}
	else{status=false;}
	return status;
}

public boolean createResultService(ExamResultBean erb) throws SQLException
{	ExamResultDao erd=new ExamResultDao();
int user_id=erb.getUser_id();
int exam_id=erb.getExam_id();
int count=0;
System.out.println("USer id"+user_id+ " exam_id "+exam_id);
ViewService vs=new ViewService();
ResultSet rs=vs.viewUserResultByExam(user_id, exam_id);
boolean status = false;
while(rs.next())
{
	count++;
	System.out.println("rows in already : "+count);
}
System.out.println("rows in already : "+count);
if(count<1)
	{
	int insertedRows=erd.createResult(erb);
	System.out.println(insertedRows);
	if(insertedRows >0)
	{
		status=true;
	}
	else
	{
		status=false;
		System.out.println("Error in adding the Mark Details");
	}
	}
else {
	System.out.println("MArks already added to this user");
	status=false;}
	return status;
	}
	
	// public PaymentBean 
public static void main(String[] args) throws SQLException
{
	/*AdminService as=new AdminService();
	UserBean ub=new UserBean();
	ViewService vs=new ViewService();
		ResultSet rs=vs.getUser(1004);
		while(rs.next())
		{
		ub.setUser_id(rs.getInt(1));
		ub.setUsername(rs.getString(2));
		ub.setDob(rs.getString(3));
		ub.setEmail(rs.getString(4));
		ub.setPassword(rs.getInt(5));
		ub.setCourse_id(5);
		}
	
	boolean status=as.moveUser(ub);
	System.out.println(status);
	
	}*/
	AdminService as=new AdminService();
	ExamResultBean rb=new ExamResultBean();
rb.setSubject_1(90);
rb.setSubject_2(90);
rb.setSubject_3(90);
rb.setSubject_4(90);
rb.setSubject_5(90);
rb.setTotal(450);
rb.setUser_id(1019);
rb.setExam_id(6);
boolean status=as.createResultService(rb);
System.out.println("Status of exam result :"+status);

	/*#createCourseService()
	cb.setCourse_name("Petro");
	cb.setFees(85000.0d);
	AdminService as=new AdminService();
	boolean s=as.createCourseService(cb);
	System.out.println(s);
	*/

	/*#editCourseService()
	cb.setCourse_id(14);
	cb.setCourse_name("Textile Engineering");
	cb.setFees(85000.0d);
	AdminService as=new AdminService();
	boolean s=as.editCourseService(cb);
	System.out.println(s);
	*/
/*
	#deleleCourseService()
	AdminService as=new AdminService();
	boolean status=as.deleteCourseService(15);
	System.out.println(status);*/

/*
	#createExamService()
	AdminService as=new AdminService();
	boolean status=as.createExamService(" Cycle Test 3");
	System.out.println(status);*/
	
	/*#moveUser()
	UserBean ub=new UserBean();
	ub.setUsername("User AAA");
	ub.setDob("15/06/1991");
	ub.setEmail("aaa@gmail.com");
	ub.setPassword(1);
	ub.setUser_id(1001);
	ub.setCourse_id(5);
	boolean status=as.moveUser(ub);
	System.out.println(status);
	*/
/*
	#removeUser()
	Boolean status=as.removeUser(1001);
	System.out.println(status);*/
	
/*#createExamResult
 * PaymentBean pb=new PaymentBean();
	pb.setUser_id(1010);
	pb.setPaid_amount(10000.0d);
//	pb.setPayment_date();
	boolean status=as.payAmount(pb);
	System.out.println(status);*/
}
}
