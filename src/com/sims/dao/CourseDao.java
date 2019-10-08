package com.sims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import com.sims.bean.CourseBean;
import com.sims.dao.ConnectionDao;

public class CourseDao 
{
public int createCourse(CourseBean cb) throws SQLException
{	
	Connection conn=ConnectionDao.getConnect();
	PreparedStatement ps=conn.prepareStatement("insert into course(course_name,fees) values(?,?);");
	ps.setString(1,cb.getCourse_name());
	ps.setDouble(2,cb.getFees());
	
	int CountOfInsertedRows=ps.executeUpdate();
	
	return CountOfInsertedRows;
}
		
public int editCourse(CourseBean cb) throws SQLException
{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("update course set course_name=?,fees=? where course_id=? and course_id>0;");
		
		ps.setString(1,cb.getCourse_name());
		ps.setDouble(2,cb.getFees());
		ps.setInt(3,cb.getCourse_id());
		int CountOfInsertedRows=ps.executeUpdate();
	return CountOfInsertedRows;
}
	
public int deleteCourse(int course_id) throws SQLException
{
	Connection conn=ConnectionDao.getConnect();
	PreparedStatement ps=conn.prepareStatement("delete from course where course_id=? and course_id>0;");
	ps.setInt(1,course_id);
	int CountOfDeletedRows=ps.executeUpdate();
		return CountOfDeletedRows; 
}     
	
public ResultSet getCourse(int course_id) throws SQLException
{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from course where course_id=? and course_id>0;");
		ps.setInt(1,course_id);
		ResultSet rs =ps.executeQuery();
		/*while(rs.next())
		{
			System.out.println("Course_id: "+rs.getInt("course_id")+"Course_name : "+rs.getString("course_name")+"Fees : "+rs.getDouble("Fees"));
		}*/
	return rs;
}
	
public ResultSet getCourseList() throws SQLException
{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from course where course_id>0;");
		ResultSet rs =ps.executeQuery();
		/*while(rs.next())
		{
			System.out.println("Course_id: "+rs.getInt("course_id")+"Course_name : "+rs.getString("course_name")+"Fees : "+rs.getDouble("Fees"));
		}*/
	return rs;
}
	
 public List<Object> getCoursesList() throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from course  where course_id>0;");
		ResultSet rs =ps.executeQuery();
		List<Object> al=new ArrayList<>();
		while(rs.next())
		{			
			al.add(rs.getInt(1));
			al.add(rs.getString(2));
			al.add(rs.getDouble(3));
		}
	return al;
} 
 public List<Object> getTotalUserList(int course_id) throws SQLException
{
	Connection conn=ConnectionDao.getConnect();
	PreparedStatement ps=conn.prepareStatement("select c.course_id,c.course_name,count(u.user_id) as NoOfStudents from course c inner join usermaster u on c.course_id=u.course_id where c.course_id=? and c.course_id>0;");
	ps.setInt(1,course_id);
	ResultSet rs =ps.executeQuery();
	List<Object> al=new ArrayList<>();
	while(rs.next())
	{			
		al.add(rs.getInt(1));
		al.add(rs.getString(2));
		al.add(rs.getInt(3));
				
	}
return al;
}
 
 public ResultSet getCourseUsers(int course_id) throws SQLException
{
	Connection conn=ConnectionDao.getConnect();
	PreparedStatement ps=conn.prepareStatement(" select c.course_id,c.course_name,c.fees,count(u.user_id) as NoOfStudents from course c inner join usermaster u on c.course_id=u.course_id where c.course_id=? and c.course_id>0;");
	ps.setInt(1,course_id);
	ResultSet rs =ps.executeQuery();
	
return rs;
}

 // main method
public static void main(String[] args) throws SQLException {
		/*CourseDao cd=new CourseDao();
		ResultSet rs=cd.getCourseUsers(1);
		while(rs.next())
		{
			System.out.println("course id:"+rs.getInt(1)+"course name :"+rs.getString(2)+"Course fess :"+rs.getDouble(3)+"No Of Students"+rs.getInt(4));
		}
		*/
	/*DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Calendar cal=Calendar.getInstance();
	String currentdate=dateFormat.format(dateFormat.format(cal.getTime()));
	System.out.println("Surrent Date : "+currentdate);//2014/08/06 15:59:48
*/		
		/*List<Object> l=cd.getCoursesList();		
		Iterator<Object> i=l.iterator();
		int count=l.size();
		
		System.out.println(count);
		while(i.hasNext())
		{
			for(int j=0;j<count;j++)
			{				
			System.out.println(i.next());
			
			System.out.println("Courese Id: +");
			}*/
		
		}
		/* int twoDm[][]= new int[7][5];
		    int i,j,k=1;

		        for(i=0;i<7;i++){
		            for(j=0;j<5;j++) {
		             twoDm[i][j]=k;
		                k++;}
		        }

		        for(i=0;i<7;i++){
		            for(j=0;j<5;j++) {
		                System.out.print(twoDm[i][j]+" ");
		                System.out.print("");}
		        }
		*/
		/*cb.setCourse_id(14);
		cb.setCourse_name("Chemical Engineering");
		cb.setFees(75000.0d);
		int count=cd.editCourse(cb);
		System.out.println(count);
		*/
	
		
		/*# createCourse()
		CourseBean cb=new CourseBean();
		cb.setCourse_name("Petro");
		cb.setFees(85000.0d);
		int count=cd.createCourse(cb);
		System.out.println(count);*/
		
		
		/* #editCourse
		cb.setCourse_id(12);
		cb.setCourse_name("Petro");
		cb.setFees(85000.0d);
		int count=cd.editCourse(cb);
		System.out.println(count);*/
		
		
		
		
		/*AdminService as=new AdminService();
		CourseBean cb=new CourseBean();
		as.createCourse(cb);
		List<Object> al=new ArrayList<Object>();
		al.add(cb.getCourse_id());
		al.add(cb.getCourse_name());
		al.add(cb.getFees());
		
		System.out.println(al);
		*/
		/*List<Object> l=cd.getCourseofStudent		//getCourses();
		Iterator i=l.iterator();
		int count=l.size();
		System.out.println(count);
		while(i.hasNext())
		{
			for(int j=0;j<count;j++)
			{				
			System.out.println(i.next());
			}
		
		}*/
	}
			
	
	
	/*
	createCourse()
	int count=cd.createCourse("CivilEngineering",86000.0d);
	System.out.println(count);
	
	editCourse()
	int edit=cd.editCourse(1, "Information Technologoy",85000.0d);
		System.out.println(edit);
		
		deleteCourse()
		int del=cd.deleteCourse(6);
		System.out.println(del);
		
		getCourse()
			cd.getCourse(1);
			
			getCourselist()
				cd.getCourseList();
	*/

/*while(rs.next())
{ 
	int course_id=rs.getInt("course_id");
	String course_name=rs.getString("course_name");
	double fees=rs.getDouble("fees");
	
//	CourseBean cb=new CourseBean();
	cb.setCourse_id(course_id);
	cb.setCourse_name(course_name);
	cb.setFees(fees);

	
	al.add(cb.getCourse_id());
	al.add(cb.getCourse_name());
	al.add(cb.getFees());
	
	System.out.println("Method :"+al);
	
}
System.out.println("Size of the list is:"+al.size());
*/
//	System.out.println("Out Method  :"+al);