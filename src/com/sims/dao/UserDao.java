package com.sims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sims.bean.UserBean;

public class UserDao {
		public int createUser(String username,String dob,String email,String password,int course_id,int designation_id) throws SQLException
			{Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("insert into usermaster(username,dob,email,password,course_id,designation_id) values(?,?,?,?,?,?);");
		ps.setString(1, username);
		ps.setString(2,dob);
		ps.setString(3,email);
		ps.setString(4, password);
		ps.setInt(5,course_id);
		ps.setInt(6,designation_id);
		int CountOfInsertedRows=ps.executeUpdate();
			return CountOfInsertedRows;
		}
		public int createUser(UserBean ub) throws SQLException
		{	Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("insert into usermaster(username,dob,email,password,course_id,designation_id) values(?,?,?,?,?,?);");
		ps.setString(1,ub.getUsername());
		ps.setString(2,ub.getDob());
		ps.setString(3,ub.getEmail());
		ps.setString(4,ub.getPassword());
		ps.setInt(5,ub.getCourse_id());
		ps.setInt(6,ub.getDesignation_id());
		int CountOfInsertedRows=ps.executeUpdate();
			return CountOfInsertedRows;
		}
		
		public int edituser(UserBean ub) throws SQLException
		{	int designation_id = 1;
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("update usermaster set username=?,dob=?,email=?,password=?,course_id=?,designation_id=? where user_id=?;");
			ps.setString(1,ub.getUsername());
			ps.setString(2,ub.getDob());
			ps.setString(3,ub.getEmail());
			ps.setString(4,ub.getPassword());
			ps.setInt(5,ub.getCourse_id());
			ps.setInt(6,designation_id);
			ps.setInt(7,ub.getUser_id());
			int CountOfInsertedRows=ps.executeUpdate();
			return CountOfInsertedRows;
		}
		
		public int deleteUser(int user_id) throws SQLException
		{ 
			Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("delete from usermaster where user_id=?;");
		ps.setInt(1,user_id);
		int CountOfDeletedRows=ps.executeUpdate();
			return CountOfDeletedRows; 
		}
		
		public ResultSet getUser(int user_id) throws SQLException
		{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select * from usermaster where user_id=?;");
			ps.setInt(1,user_id);
			ResultSet rs =ps.executeQuery();
			/*while(rs.next())
			{				
			System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));
			}*/
			return rs;
		}
		public ResultSet getUserByCourse(int course_id) throws SQLException
		{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select * from usermaster where course_id=?;");
			ps.setInt(1,course_id);
			ResultSet rs =ps.executeQuery();
			/*while(rs.next())
			{				
			System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));
			}*/
			return rs;
		}
		public ResultSet getUsersByCourse(int course_id) throws SQLException
		{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement(" select c.course_name, u.user_id,u.username from usermaster u inner join course c on u.course_id=c.course_id where c.course_id=? order by user_id asc;");
			ps.setInt(1,course_id);
			ResultSet rs =ps.executeQuery();
			/*while(rs.next())
			{				
			System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));
			}*/
			return rs;
		}
		public ResultSet getUser() throws SQLException
		{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select * from usermaster;");
			ResultSet rs =ps.executeQuery();
			/*while(rs.next())
			{				
			System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));
			}*/
			return rs;
		}
		public ResultSet getUserDetails(String email) throws SQLException
			{
				Connection conn=ConnectionDao.getConnect();
				PreparedStatement ps=conn.prepareStatement("select * from usermaster where email=?;");
				ps.setString(1,email);
				ResultSet rs =ps.executeQuery();
				/*while(rs.next())
				{	hm.put("user_id",rs.getInt(1));
					hm.put("username",rs.getString(2));
					hm.put("dob",rs.getString(3));
					hm.put("email",rs.getString(4));
					hm.put("password",rs.getInt(5));
					hm.put("course_id",rs.getInt(6));						
				System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));
				}*/
				return rs;

		}
		public ResultSet getUserPayment(int user_id) throws SQLException
		{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select u.user_id,u.username,u.dob,u.email,c.fees,sum(p.paid_amount) ,(c.fees - sum(p.paid_amount)) as Balance from usermaster u inner join payment p on u.user_id=p.user_id inner join course c on u.course_id=c.course_id where u.user_id=?;");
			ps.setInt(1,user_id);
			ResultSet rs =ps.executeQuery();
			return rs;
		}		

	public List<Object> getUserList() throws SQLException
		{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select * from usermaster;");
			List<Object> al=new ArrayList<Object>();
			
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				al.add(rs.getInt(1));
			al.add(rs.getString(2));
			al.add(rs.getString(3));
			al.add(rs.getString(4));
			al.add(rs.getString(5));
			al.add(rs.getInt(6));
			}			
		
			return al;
		}
		public boolean isUserValid(String email,int password) throws SQLException
		{	Boolean status=false;
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select * from usermaster where email=? and password=?;");
			ps.setString(1,email);
			ps.setInt(2,password);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
			System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getString(5)+" Course_id :"+rs.getInt(6));
			 status=true;
			}
			return status;
		}
		public List<Object> getUserListofCourse(int course_id) throws SQLException
		{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select * from usermaster where course_id=?;");
			ps.setInt(1,course_id);
			ResultSet rs =ps.executeQuery();
			List<Object> al=new ArrayList<>();
			while(rs.next())
			{
				al.add(rs.getInt(1));
				al.add(rs.getString(2));
				al.add(rs.getString(3));
				al.add(rs.getString(4));
				al.add(rs.getString(5));
				al.add(rs.getInt(6));
			}
			System.out.println(al);
			return al;
		}
			
		public List<Object> getUserPaymentList(int user_id) throws SQLException
		{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select u.user_id,u.username,u.dob,u.email,c.fees,p.paid_amount,(c.fees - p.paid_amount) as Balance from usermaster u inner join payment p on u.user_id=p.user_id inner join course c on u.course_id=c.course_id where u.user_id=?;");
			ps.setInt(1,user_id);
			ResultSet rs =ps.executeQuery();
			List<Object> al=new ArrayList<>();
			while(rs.next())
			{
				al.add(rs.getInt(1));
				al.add(rs.getString(2));
				al.add(rs.getString(3));
				al.add(rs.getString(4));
				al.add(rs.getDouble(5));
				al.add(rs.getDouble(6));
				al.add(rs.getDouble(7));
 
			}
			System.out.println(al);
			return al;
		}
		
		
		
		public static void main(String[] args) throws SQLException {
			UserDao ud=new UserDao();
			int insert=ud.createUser("YYY", "11/11/11","yyy@gmail.com","1",4,5);
			System.out.println(insert);
			/*ResultSet rs=ud.getUserDetails("arul@gmail.com");
			while(rs.next())
			{
			System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));
			}*/
									
			
			/*List<Object> l=ud.getUserListofCourse(2);
			Iterator<Object> i=l.iterator();
			int count=l.size()/6;
			System.out.println(count);
			while(i.hasNext())
			{							
				System.out.println(i.next());
			}
			
			}*/

						
		}}
/*
					createUser()
					int insert=ud.createUser("ZZZ", "11/11/11","zzz@gmail.com",1,4);
					System.out.println(insert);
					
					editUser()
					int edit=ud.edituser(1001, "AaA","15/06/91","zzz@zzz.com",1,3);
					System.out.println(edit);
					
					deleteUser()
					int del=ud.deleteUser(1003);
					System.out.println(del);
					
					getUser()
					ud.getUser(1002);

					getUserListofCourse()
					ud.getUserListofCourse(2);
					
					getUserList()
					ud.getUserList();
					
					//	//System.out.println("User_id: "+rs.getInt(1)+"Username: "+rs.getString(2)+" DOB:"+rs.getString(3)+"Email: "+rs.getString(4)+" Password : "+rs.getInt(5)+" Course_id :"+rs.getInt(6));

					*/

