package com.sims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sims.bean.ExamResultBean;

public class ExamResultDao {
	public int createResult(ExamResultBean erb) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("insert into examresults(subject_1,subject_2,subject_3,subject_4,subject_5,total,exam_id,user_id) values(?,?,?,?,?,?,?,?);");
		ps.setInt(1,erb.getSubject_1());
		ps.setInt(2,erb.getSubject_2());
		ps.setInt(3,erb.getSubject_3());
		ps.setInt(4,erb.getSubject_4());
		ps.setInt(5,erb.getSubject_5());
		ps.setInt(6,erb.getTotal());
		ps.setInt(7,erb.getExam_id());
		ps.setInt(8,erb.getUser_id());
		int CountOfInsertedRows=ps.executeUpdate();
		return CountOfInsertedRows;
	}
	
	public int editResult(ExamResultBean erb) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("update examresults set subject_1=?,subject_2=?,subject_3=?,subject_4=?,subject_5=?,total=?, exam_id=? where user_id=?;");
		ps.setInt(1,erb.getSubject_1());
		ps.setInt(2,erb.getSubject_2());
		ps.setInt(3,erb.getSubject_3());
		ps.setInt(4,erb.getSubject_4());
		ps.setInt(5,erb.getSubject_5());
		ps.setInt(6,erb.getTotal());
		ps.setInt(7,erb.getExam_id());
		ps.setInt(8,erb.getUser_id());
		int CountOfInsertedRows=ps.executeUpdate();
		return CountOfInsertedRows;
		
	}
	
 public int deleteExamResults(int result_id) throws SQLException
 {
	 Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("delete from examresults where result_id=?;");
		ps.setInt(1,result_id);
		int CountOfDeletedRows=ps.executeUpdate();
			return CountOfDeletedRows; 
 }
 
 public ResultSet getResult(int result_id) throws SQLException{
	 Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from examresults where result_id=?;");
		ps.setInt(1,result_id);
		ResultSet rs =ps.executeQuery();
		/*while(rs.next())
		{
		System.out.println("sub1: "+rs.getInt(1)+"sub 2: "+rs.getInt(2)+"sub 3 : "+rs.getInt(3)+"sub4: "+rs.getInt(4)+"sub 5: "+rs.getInt(5)+"total  : "+rs.getInt(6)+"Examid: "+rs.getInt(7)+"Userid: "+rs.getInt(8)+"result : "+rs.getInt(9));
		}*/return rs ;
	 
 }
 public List<Object> getResultsOfExam(int exam_id) throws SQLException{
	 Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from examresults where exam_id=?;");
		ps.setInt(1,exam_id);
		ResultSet rs =ps.executeQuery();
		List<Object> al=new ArrayList<>();
		while(rs.next())
		{
		al.add(rs.getInt(1));
		al.add(rs.getInt(2));
		al.add(rs.getInt(3));
		al.add(rs.getInt(4));
		al.add(rs.getInt(5));
		al.add(rs.getInt(6));
		al.add(rs.getInt(7));
		al.add(rs.getInt(8));
		al.add(rs.getInt(9));
		}
		return al;
 }
 
 public List<Object> getResultsOfUser(int user_id) throws SQLException{
	 Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from examresults where user_id=?;");
		ps.setInt(1,user_id);
		ResultSet rs =ps.executeQuery();
		List<Object> al=new ArrayList<>();
		while(rs.next())
		{
		al.add(rs.getInt(1));
		al.add(rs.getInt(2));
		al.add(rs.getInt(3));
		al.add(rs.getInt(4));
		al.add(rs.getInt(5));
		al.add(rs.getInt(6));
		al.add(rs.getInt(7));
		al.add(rs.getInt(8));
		al.add(rs.getInt(9));
		}
		return al;

	 
 }
 public List<Object> getAllExamResults() throws SQLException{
	 Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from examresults;");
		ResultSet rs =ps.executeQuery();
		List<Object> al=new ArrayList<>();

		while(rs.next())
		{
		al.add(rs.getInt(1));
		al.add(rs.getInt(2));
		al.add(rs.getInt(3));
		al.add(rs.getInt(4));
		al.add(rs.getInt(5));
		al.add(rs.getInt(6));
		al.add(rs.getInt(7));
		al.add(rs.getInt(8));
		al.add(rs.getInt(9));
		}
		return al;

	 
 }
 public List<Object> viewUserResultList(int user_id) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select u.user_id,u.username,em.exam_name,er.subject_1,er.subject_2,er.subject_3,er.subject_4,er.subject_5,er.total, (er.total/5) as Percentage from usermaster u inner join examresults er on u.user_id=er.user_id inner join exammaster em on er.exam_id=em.exam_id where u.user_id=?;");
		ps.setInt(1,user_id);
		ResultSet rs =ps.executeQuery();
		List<Object> al=new ArrayList<>();
		while(rs.next())
		{
		al.add(rs.getInt(1));
		al.add(rs.getString(2));
		al.add(rs.getString(3));
		al.add(rs.getInt(4));
		al.add(rs.getInt(5));
		al.add(rs.getInt(6));
		al.add(rs.getInt(7));
		al.add(rs.getInt(8));
		al.add(rs.getInt(9));
		al.add(rs.getDouble(10));
		}
		return al;	
	}
 public ResultSet viewUserResult(int user_id) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select u.user_id,u.username,em.exam_name,er.subject_1,er.subject_2,er.subject_3,er.subject_4,er.subject_5,er.total, (er.total/5) as Percentage from usermaster u inner join examresults er on u.user_id=er.user_id inner join exammaster em on er.exam_id=em.exam_id where u.user_id=?;");
		ps.setInt(1,user_id);
		ResultSet rs =ps.executeQuery();
	/*	while(rs.next())
		{
		System.out.println("User id: "+rs.getInt(1)+" User name :"+rs.getString(2)+" Exam name : "+rs.getString(3)+"Subject 1"+rs.getInt(4)+"Subject 2"+rs.getInt(5)+"Subject 3 :"+rs.getInt(6)+"Subject 4"+rs.getInt(7)+"Subject 5"+rs.getInt(8)+"Total "+rs.getInt(9)+" Percentage"+rs.getDouble(10));
		}*/
		return rs;	
	}
 public ResultSet viewUserResultByExam(int user_id,int exam_id) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select u.user_id,em.exam_id,u.username,em.exam_name,er.subject_1,er.subject_2,er.subject_3,er.subject_4,er.subject_5,er.total, (er.total/5) as Percentage from usermaster u inner join examresults er on u.user_id=er.user_id inner join exammaster em on er.exam_id=em.exam_id where u.user_id=? and em.exam_id=?;");
		ps.setInt(1,user_id);
		ps.setInt(2,exam_id);
		ResultSet rs =ps.executeQuery();
	/*	while(rs.next())
		{
		System.out.println("User id: "+rs.getInt(1)+" User name :"+rs.getString(2)+" Exam name : "+rs.getString(3)+"Subject 1"+rs.getInt(4)+"Subject 2"+rs.getInt(5)+"Subject 3 :"+rs.getInt(6)+"Subject 4"+rs.getInt(7)+"Subject 5"+rs.getInt(8)+"Total "+rs.getInt(9)+" Percentage"+rs.getDouble(10));
		}*/
		return rs;	
	}
 public List<Object> viewCourseResultList(int course_id,int exam_id) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select u.user_id,u.username,c.course_name,em.exam_name,er.subject_1,er.subject_2,er.subject_3,er.subject_4,er.subject_5,er.total, (er.total/5) as Percentage from usermaster u inner join examresults er on u.user_id=er.user_id inner join exammaster em on er.exam_id=em.exam_id inner join course c on u.course_id=c.course_id where c.course_id=? and er.exam_id=?;");
		ps.setInt(1,course_id);
		ps.setInt(2,exam_id);
		ResultSet rs =ps.executeQuery();
		List<Object> al=new ArrayList<>();
		while(rs.next())
		{
		al.add(rs.getInt(1));
		al.add(rs.getString(2));
		al.add(rs.getString(3));
		al.add(rs.getString(4));
		al.add(rs.getInt(5));
		al.add(rs.getInt(6));
		al.add(rs.getInt(7));
		al.add(rs.getInt(8));
		al.add(rs.getInt(9));
		al.add(rs.getInt(10));
		al.add(rs.getDouble(11));
		}
		return al;	
	}
 public ResultSet viewCourseResult(int course_id,int exam_id) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select u.user_id,u.username,em.exam_name,er.subject_1,er.subject_2,er.subject_3,er.subject_4,er.subject_5,er.total, (er.total/5) as Percentage from usermaster u inner join examresults er on u.user_id=er.user_id inner join exammaster em on er.exam_id=em.exam_id inner join course c on u.course_id=c.course_id where c.course_id=? and er.exam_id=?;");
		ps.setInt(1,course_id);
		ps.setInt(2,exam_id);
		ResultSet rs =ps.executeQuery();
		return rs;	
	}
 public static void main(String[] args) throws SQLException {
	 
	ExamResultDao er=new ExamResultDao();
	List<Object> l=	er.viewCourseResultList(5, 2);
			Iterator<Object> i=l.iterator();
	int count=l.size();
	System.out.println(count);
	while(i.hasNext())
	{							
		System.out.println(i.next());
	}
	
}
}	
/*	List<Object> l=	er.getResultsOfUser(1004);

 * 	List<Object> l=	er.viewCourseResult(2,1);
 * List<Object> l=	er.viewUserResult(1001);
 * 	List<Object> l=	er.getAllExamResults();
 * 	List<Object> l=	er.getResultsOfExam(1);


 * 
 * */

	
/*
	createResult()
	int count=er.createResult(98,87,89,78,78,421,3,1001);
	System.out.println(count);
	
	edit()
	int edit=er.editResult(98,87,89,78,78,421,3,1001,3);
	System.out.println(edit);
	
	delete()
	int del=er.deleteExamResults(10);
	System.out.println(del);

	er.getResult(1);
	
	er.getResultsOfExam(1);
	
	er.getAllExamResults();

*/