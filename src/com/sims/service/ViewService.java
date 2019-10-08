package com.sims.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sims.dao.CourseDao;
import com.sims.dao.ExamDao;
import com.sims.dao.ExamResultDao;
import com.sims.dao.PaymentDao;
import com.sims.dao.UserDao;



public class ViewService {
	/*public HashMap<String, Object> getUserDetails(String email) throws SQLException
	{	
		UserDao ud=new UserDao();
		HashMap<String, Object> hm=ud.getUserDetails(email);
		return hm;
	}*/
	public ResultSet getUserDetails(String email) throws SQLException
	{	
		UserDao ud=new UserDao();
		ResultSet rs=ud.getUserDetails(email);
		return rs;
	}
	/* 
	* 
	*  Administration Screen 
	*/ 
	
	public ResultSet getCourseService(int course_id) throws SQLException // to get the specified course details
	{
		CourseDao cd=new CourseDao();
		ResultSet rs=cd.getCourse(course_id);
	return rs;
	}
	
	public ResultSet getCourseList() throws SQLException
	 {
	 		CourseDao cd=new CourseDao();
	 		
	 		ResultSet rs =cd.getCourseList();
	 		/*while(rs.next())
	 		{
	 			System.out.println("Course_id: "+rs.getInt("course_id")+"Course_name : "+rs.getString("course_name")+"Fees : "+rs.getDouble("Fees"));
	 		}*/
	 	return rs;
	 }
	public List<Object> getCoursesList() throws SQLException
		{
			CourseDao cd=new CourseDao();
			List<Object> al=cd.getCoursesList();
			
		return al;
	}
		
	 public List<Object> getAllExamList() throws SQLException	// to get All exam list
	 {
	ExamDao ed=new ExamDao(); 
	List<Object> al=new ArrayList<>();
		 al=ed.getAllExamList();
		 return al;
	 }
	 
	 public ResultSet getExamList() throws SQLException
	 {
		 	ExamDao ed=new ExamDao();	 		
	 		ResultSet rs =ed.getExamList();
	 		/*while(rs.next())
	 		{
			System.out.println(rs.getInt(1)+rs.getString(2));
	 		}*/
	 	return rs;
	 }
	
	 /* 
		* 
		*  Manage Screen 
		*/ 
	public List<Object> getTotalUserList(int course_id) throws SQLException// to get specified course details with No Of students
	{
		CourseDao cd=new CourseDao();
		List<Object> al=new ArrayList<>();
		al=cd.getTotalUserList(course_id);
		System.out.println(al);
	return al;
	}
 public List<Object> getUserListofCourse(int course_id) throws SQLException// to get the user list of specified course
 {
	 UserDao ud=new UserDao();
	 List<Object> al=new ArrayList<>();
	 al=ud.getUserListofCourse(course_id);
	 return al;
	 
 }

 /* 
	* 
	*  Payment Screen 
	*/ 
	 public List<Object> getUserPaymentList(int user_id) throws SQLException	//Remaining Amount
 {
	 UserDao ud=new UserDao();
	 List<Object> al=new ArrayList<>();
	 al=ud.getUserPaymentList(user_id);
	 return al;
	 
 }
	 /* 
		* 
		*  Examination Screen 
		*/ 
		
 public List<Object> getCycleExamList() throws SQLException	//cycleTest only
 {
ExamDao ed=new ExamDao(); 
List<Object> al=new ArrayList<>();
	 al=ed.getCycleExamList();
	 return al;
	 
 }
 public ResultSet getCycleExam() throws SQLException
 {
	 	ExamDao ed=new ExamDao();	 		
 		ResultSet rs =ed.getCycleExam();
 		/*while(rs.next())
 		{
		System.out.println(rs.getInt(1)+rs.getString(2));
 		}*/
 	return rs;
 }
 public List<Object> getSemExamList() throws SQLException	//Semester exam list only
 {
ExamDao ed=new ExamDao(); 
List<Object> al=new ArrayList<>();
	 al=ed.getSemExamList();
	 return al;
	 
 }
 public ResultSet getSemExam() throws SQLException
 {
	 	ExamDao ed=new ExamDao();	 		
 		ResultSet rs =ed.getSemExam();
 		/*while(rs.next())
 		{
		System.out.println(rs.getInt(1)+rs.getString(2));
 		}*/
 	return rs;
 }
 public List<Object> getExamUserDetailsList(int user_id) throws SQLException	
 {
ExamDao ed=new ExamDao(); 
List<Object> al=new ArrayList<>();
	 al=ed.getExamUserDetailsList(user_id);
	 return al;
	 
 }
 public ResultSet getExamUserDetails(int user_id) throws SQLException
 {
	 	ExamDao ed=new ExamDao();	 		
 		ResultSet rs =ed.getExamUserDetails(user_id);
 		/*while(rs.next())
 		{
		System.out.println(rs.getInt(1)+rs.getString(2));
 		}*/
 	return rs;
 }
 /* 
	* 
	* Academic Report Screen 
	*/ 
 
	
 public List<Object> viewUserResultList(int user_id) throws SQLException	
 {
	 ExamResultDao erd=new ExamResultDao();
	List<Object> al=new ArrayList<>();
	 al=erd.viewUserResultList(user_id);
	 return al;
	 
 }
 public ResultSet viewUserResult(int user_id) throws SQLException
	{
		ExamResultDao erd=new ExamResultDao();
		ResultSet rs =erd.viewUserResult(user_id);
		/*while(rs.next())
		{		
		System.out.println("User id: "+rs.getInt(1)+" User name :"+rs.getString(2)+"Course Name"+rs.getString(3)+" Exam name : "+rs.getString(4)+"Subject 1"+rs.getInt(5)+"Subject 2"+rs.getInt(6)+"Subject 3 :"+rs.getInt(7)+"Subject 4"+rs.getInt(8)+"Subject 5"+rs.getInt(9)+"Total "+rs.getInt(10)+" Percentage"+rs.getDouble(11));		
		}*/
		return rs;
	}
 public List<Object> viewCourseResultList(int course_id,int exam_id) throws SQLException	
 {
	 ExamResultDao erd=new ExamResultDao();
	List<Object> al=new ArrayList<>();
	 al=erd.viewCourseResultList(course_id,exam_id);
	 return al;
	 
 }
 public ResultSet viewCourseResult(int course_id, int exam_id) throws SQLException
	{
		ExamResultDao erd=new ExamResultDao();
		ResultSet rs =erd.viewCourseResult(course_id, exam_id);
		
		return rs;
	}
 public List<Object> getUserList() throws SQLException // to get all users
 {
	 UserDao ud=new UserDao();
	 List<Object> al=new ArrayList<>();
	 al=ud.getUserList();
	 return al;
 }

 public ResultSet getCourseNameList() throws SQLException
 {
 		CourseDao cd=new CourseDao();
 		
 		ResultSet rs =cd.getCourseList();
 		/*while(rs.next())
 		{
 			System.out.println("Course_id: "+rs.getInt("course_id")+"Course_name : "+rs.getString("course_name")+"Fees : "+rs.getDouble("Fees"));
 		}*/
 	return rs;
 }
 public ResultSet getCourseUsers(int course_id) throws SQLException
 {
 		CourseDao cd=new CourseDao();
 		
 		ResultSet rs =cd.getCourseUsers(course_id);
 		/*while(rs.next())
 		{
 					System.out.println("course id:"+rs.getInt(1)+"course name :"+rs.getString(2)+"Course fess :"+rs.getDouble(3)+"No Of Students"+rs.getInt(4));

 		}*/
 	return rs;
 }
 
 public ResultSet getUser() throws SQLException
	{
		UserDao ud=new UserDao();
		ResultSet rs =ud.getUser();
		/*while(rs.next())
		{				
		System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));
		}*/
		return rs;
	}
 
 public ResultSet getUserByCourse(int course_id) throws SQLException
	{
		UserDao ud=new UserDao();
		ResultSet rs =ud.getUserByCourse(course_id);
		/*while(rs.next())
		{				
		System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));
		}*/
		return rs;
	}
 public ResultSet getUsersByCourse(int course_id) throws SQLException
	{
		UserDao ud=new UserDao();
		ResultSet rs =ud.getUsersByCourse(course_id);
		/*while(rs.next())
		{				
		System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2));
		}*/
		return rs;
	}

 public ResultSet getUser(String user_id) throws SQLException
	{
		UserDao ud=new UserDao();
		int userid=Integer.parseInt(user_id);
		ResultSet rs =ud.getUser(userid);
		/*while(rs.next())
		{				
		System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));
		}*/
		return rs;
	}
 
 public ResultSet getUserPayment(int user_id) throws SQLException
	{
		UserDao ud=new UserDao();
		ResultSet rs =ud.getUserPayment(user_id);
		/*while(rs.next())
		{				
		System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));
		}*/
		return rs;
	}
 public ResultSet viewUserResultByExam(int user_id,int exam_id) throws SQLException
 {
		ExamResultDao erd=new ExamResultDao();
		ResultSet rs=erd.viewUserResultByExam(user_id, exam_id);
		return rs;
 }
 /*DashBoard
  * 
  * 
  * 
  * */
 public ResultSet getPaymentOfCourse(int course_id,String fromDate,String toDate) throws SQLException
 {
	 
		 PaymentDao pd=new PaymentDao();
		 ResultSet rs=pd.getPaymentOfCourse(course_id, fromDate, toDate);
		 return rs;
 }
		 
	 
 public static void main(String[] args) throws SQLException  {
	ViewService vs=new ViewService();
	ResultSet rs=vs.viewCourseResult(5,6); 
	while(rs.next())
	{		
	System.out.println("User id: "+rs.getInt(1)+" User name :"+rs.getString(2)+" Exam name : "+rs.getString(3)+"Subject 1"+rs.getInt(4)+"Subject 2"+rs.getInt(5)+"Subject 3 :"+rs.getInt(6)+"Subject 4"+rs.getInt(7)+"Subject 5"+rs.getInt(8)+"Total "+rs.getInt(9)+" Percentage"+rs.getDouble(10));		
	}
	/*ResultSet rs=vs.viewCourseResult(5,2);
	while(rs.next())
	{		
	System.out.println("User id: "+rs.getInt(1)+" User name :"+rs.getString(2)+" Exam name : "+rs.getString(3)+"Subject 1"+rs.getInt(4)+"Subject 2"+rs.getInt(5)+"Subject 3 :"+rs.getInt(6)+"Subject 4"+rs.getInt(7)+"Subject 5"+rs.getInt(8)+"Total "+rs.getInt(9)+" Percentage"+rs.getDouble(10));		
	}*/
	/*ResultSet rs=vs.getCourseNameList();
	while(rs.next())
		{
		System.out.println("Course_name : "+rs.getString("course_name"));
			System.out.println("Course_id: "+rs.getInt("course_id")+"Course_name : "+rs.getString("course_name")+"Fees : "+rs.getDouble("Fees"));
		}*/
	/* int Courseid=2;
	 SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
	 String strDate="04/01/2015";
	 String strDate1="04/30/2015";

	 Date date1=null;
	try {
		date1 = sdf.parse(strDate1);
  	 System.out.println("Date1 is:"+date1);
  	 		Date date=sdf.parse(strDate);
  	 			 System.out.println("Date is:"+date);

		String fromDate=sdf.format(date);
		 String toDate=sdf.format(date1);
		try {
		ResultSet rs = vs.getPaymentOfCourse(Courseid, fromDate, toDate);
		while(rs.next())
		 {
			 System.out.println("User name: "+rs.getString(1)+"Course name: "+rs.getString(2)+"paid amount: "+rs.getDouble(3)+"Payment Date:"+rs.getDate(4));	
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	 
	 
	
	
	/*ResultSet rs =vs.viewCourseResult(5,2);
	while(rs.next())
	{
		System.out.println("User id: "+rs.getInt(1)+" User name :"+rs.getString(2)+"Course Name"+rs.getString(3)+" Exam name : "+rs.getString(4)+"Subject 1"+rs.getInt(5)+"Subject 2"+rs.getInt(6)+"Subject 3 :"+rs.getInt(7)+"Subject 4"+rs.getInt(8)+"Subject 5"+rs.getInt(9)+"Total "+rs.getInt(10)+" Percentage"+rs.getDouble(11)+"......... ");		
	}*/
	
/*	ResultSet rs =vs.viewUserResult(1001);
	while(rs.next())
	{
	System.out.println("User id: "+rs.getInt(1)+" User name :"+rs.getString(2)+" Exam name : "+rs.getString(3)+"Subject 1"+rs.getInt(4)+"Subject 2"+rs.getInt(5)+"Subject 3 :"+rs.getInt(6)+"Subject 4"+rs.getInt(7)+"Subject 5"+rs.getInt(8)+"Total "+rs.getInt(9)+" Percentage"+rs.getDouble(10));		
	}*/
	
	
/*ResultSet rs=vs.getExamUserDetails(1002);
		while(rs.next())
		{
		System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+"course name" +rs.getString(3)+"Paid Amount "+rs.getDouble(4));
		}
*/	
	/*ResultSet rs=vs.getUserPayment(1001);
	
	
	while(rs.next())
		{
		System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+"DOB" +rs.getString(3)+"Email "+rs.getString(4)+"Toatal Payment "+rs.getDouble(5)+"Paid Amount "+rs.getDouble(6)+"Remaining "+rs.getDouble(7));
		}*/
	
	/*ResultSet rs=vs.getUserByCourse(1);
	while(rs.next())
		{
		System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));
		}*/
		
	/*ResultSet rs=vs.getUser();
	while(rs.next())
		{
		System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));
		}*/
		//System.out.println("Exam_name : "+rs.getString("exam_name"));
		
	
	
	/*ResultSet rs=vs.getCourseList();
	while(rs.next())
		{
		
		System.out.println("Course_name : "+rs.getString("course_name"));
			System.out.println("Course_id: "+rs.getInt("course_id")+"Course_name : "+rs.getString("course_name")+"Fees : "+rs.getDouble("Fees"));
		}
	*/
	
	/*List<Object> l=vs.getCoursesList();
	Iterator<Object> i=l.iterator();
	int count=l.size();
	int c=0;
	System.out.println(count);
	int rec=count/3;
	System.out.println("Records :"+rec);*/
	/*while(i.hasNext())
	{							
		System.out.print(i.next()+" "+i.next()+" " +i.next());
		++c;		
		if(c % 3==0)
		{
			System.out.println(" New");
		}
	}*/
	
 }
}
	/*Object result[][]= new Object[count][rec];
    int q,j;
	int k=1;


        for(q=0;q<count;q++){
            for(j=0;j<count;j++) {
            	k++;
             result[q][j]= i.next();
             System.out.print(i.next()+" ");
             if(k%3==0)
             {
            	 System.out.println("New");
             }
             
               }
        }*/

       
	
	/*ResultSet rs=vs.getCourseNameList();
	while(rs.next())
		{
		System.out.println("Course_name : "+rs.getString("course_name"));
			System.out.println("Course_id: "+rs.getInt("course_id")+"Course_name : "+rs.getString("course_name")+"Fees : "+rs.getDouble("Fees"));
		}*/
	
	
	/*ResultSet rs=vs.getUserDetails("arul@gmail.com");
	while(rs.next())
	{
		String user=rs.getString(2);
		System.out.println("User");
		System.out.println("Username="+user);*/
	/*System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));*/
	
	/*
	Iterator<Object> i=l.iterator();
	int count=l.size();
	System.out.println(count);
	while(i.hasNext())
	{							
		System.out.print(i.next()+" ");
	}*/
	/*HashMap<String, Object> hm=vs.getUserDetails("aaa@gmail.com");
	String s=(String) hm.get("username");
	System.out.println("Name :"+s);
	
	List<Object> l=vs.viewCourseResult(1, 2);
	//List<Object> l=vs.getAllExamList();
	//List<Object> l=vs.viewUserResult(1001);
	//List<Object> l=vs.getTotalUser(1);
	//List<Object> l=vs.getSemExamList();
//	List<Object> l=vs.getCourseListService();
	//List<Object> l=vs.getExamUserDetails(1003);
//	List<Object> l=vs.getCycleExamList();
	//	List<Object> l=vs.getUserPayment(1001);
	//List<Object> l=vs.getUserListofCourse(2);
/*	
*/	
	/*#List<Object> l=vs.getCourseListService();*/
	
	




