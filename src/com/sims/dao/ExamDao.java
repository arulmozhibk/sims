package com.sims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sims.dao.ConnectionDao;

public class ExamDao
{
	public int createExam(String exam_name) throws SQLException
	{	Connection conn=ConnectionDao.getConnect();
	PreparedStatement ps=conn.prepareStatement("insert into exammaster(exam_name) values(?);");
	ps.setString(1,exam_name);
	int CountOfInsertedRows=ps.executeUpdate();
		return CountOfInsertedRows;
	}
	
	
	public int editExam(int exam_id, String exam_name) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("update exammaster set exam_name=? where exam_id=?;");
		ps.setString(1,exam_name);
		ps.setInt(2,exam_id);
		int CountOfInsertedRows=ps.executeUpdate();
			return CountOfInsertedRows;
	}
	
	public int deleteExam(int exam_id) throws SQLException
	{ 
		Connection conn=ConnectionDao.getConnect();
	PreparedStatement ps=conn.prepareStatement("delete from exammaster where exam_id=?;");
	ps.setInt(1,exam_id);
	int CountOfDeletedRows=ps.executeUpdate();
			return CountOfDeletedRows; 
	}
	
	public ResultSet getExam(int exam_id) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from exammaster where exam_id=?;");
		ps.setInt(1,exam_id);
		ResultSet rs =ps.executeQuery();
		/*while(rs.next())
		{
			System.out.println(rs.getInt(1));
		}*/
		return rs;
	}
	public ResultSet getExamList() throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from exammaster;");
		ResultSet rs =ps.executeQuery();
		/*while(rs.next())
		{
			System.out.println(rs.getInt(1));
		}*/
		return rs;
	}
	public List<Object> getAllExamList() throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from exammaster;");
		ResultSet rs =ps.executeQuery();
		List<Object> al=new ArrayList<>();
		while(rs.next())
		{
		al.add(rs.getInt(1));
		al.add(rs.getString(2));
		}
		return al;	
	}
	public ResultSet getCycleExam() throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from exammaster where exam_name like 'cyc%';");
		ResultSet rs =ps.executeQuery();
		
		return rs;	
	}
	public List<Object> getCycleExamList() throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from exammaster where exam_name like 'cyc%';");
		ResultSet rs =ps.executeQuery();
		List<Object> al=new ArrayList<>();
		while(rs.next())
		{
		al.add(rs.getInt(1));
		al.add(rs.getString(2));
		}
		return al;	
	}
	
	
	public ResultSet getSemExam() throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from exammaster where exam_name like 'sem%';");
		ResultSet rs =ps.executeQuery();
		
		return rs;	
	}
	public List<Object> getSemExamList() throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from exammaster where exam_name like 'sem%';");
		ResultSet rs =ps.executeQuery();
		List<Object> al=new ArrayList<>();
		while(rs.next())
		{
		al.add(rs.getInt(1));
		al.add(rs.getString(2));
		}
		return al;	
	}
public List<Object> getExamUserDetailsList(int user_id) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select u.user_id,u.username,c.course_name,p.paid_amount from usermaster u inner join course c on u.course_id=c.course_id inner join payment p on u.user_id=p.user_id where u.user_id=?;");
		ps.setInt(1,user_id);
		ResultSet rs =ps.executeQuery();
		List<Object> al=new ArrayList<>();
		while(rs.next())
		{
		al.add(rs.getInt(1));
		al.add(rs.getString(2));
		al.add(rs.getString(3));
		al.add(rs.getDouble(4));
 		}
		return al;	
}
public ResultSet getExamUserDetails(int user_id) throws SQLException
{
	Connection conn=ConnectionDao.getConnect();
	PreparedStatement ps=conn.prepareStatement("select u.user_id,u.username,c.course_name,sum(p.paid_amount) from usermaster u inner join course c on u.course_id=c.course_id inner join payment p on u.user_id=p.user_id where u.user_id=?;");
	ps.setInt(1,user_id);
	ResultSet rs =ps.executeQuery();
	return rs;	
}

public static void main(String[] args) throws SQLException {
	ExamDao ed=new ExamDao();
	ResultSet rs=ed.getCycleExam();
	int i=0;
	while(rs.next())
	{i++;
	
		System.out.println("S.No"+i+"examname: "+rs.getString(2)+"exam_id: "+rs.getInt(1));

	//System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+"course name" +rs.getString(3)+"Paid Amount "+rs.getDouble(4));
	}
	
	
	
	
	
	
	
	/*List<Object> l=ed.getExamUserDetailsList(1002);
	Iterator<Object> i=l.iterator();
	int count=l.size();
	System.out.println(count);
	while(i.hasNext())
	{							
		System.out.println(i.next());
	}*/
	
}
}
/*}		List<Object> l=ed.getAllExamList();
 *	 	List<Object> l=ed.getSemExamList();
 *		List<Object> l=ed.getCycleExamList();

	
*/
			/*#createExam()
			int count=ex.createExam("Cycle Test");.
			System.out.println(count);
			
			editExam()
			int edit=ex.editExam(4,"CycleTest 1");
			System.out.println(edit);
	
			deleteExam()
			int del=ex.deleteExam(5);
			System.out.println(del);
	
			getExam()
			ex.getExam(1);
			
			getExamList()
			ex.getExamList();
	*/		