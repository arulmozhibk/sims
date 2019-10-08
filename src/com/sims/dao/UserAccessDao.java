package com.sims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sims.bean.UserAccessBean;

public class UserAccessDao {

	public int createUserAccess(UserAccessBean uab) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("insert into useraccess(designation_id,canread,canedit,cancreate,candelete) values(?,?,?,?,?);");
		ps.setInt(1,uab.getDesignation_id());
		ps.setBoolean(2,uab.isCanread());
		ps.setBoolean(3,uab.isCanedit());
		ps.setBoolean(4,uab.isCancreate());
		ps.setBoolean(5,uab.isCandelete());
		int count=ps.executeUpdate();
		
		return count;
		
	}
	
	public int editUserAccess(UserAccessBean uab) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("update useraccess set designation_id=?,canread=?,canedit=?,cancreate=?,candelete=? where useraccess_id=?;");
		ps.setInt(1,uab.getDesignation_id());
		ps.setBoolean(2,uab.isCanread());
		ps.setBoolean(3,uab.isCanedit());
		ps.setBoolean(4,uab.isCancreate());
		ps.setBoolean(5,uab.isCandelete());
		ps.setInt(6, uab.getUseraccess_id());
		int count=ps.executeUpdate();
		
		return count;
		
	}
	
	public int deleteUserAccess(int useraccess_id) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("delete from useraccess where useraccess_id=?;");
		ps.setInt(1,useraccess_id);
		int count=ps.executeUpdate();
		
		return count;
		
	}
	
	public ResultSet getUserAccessByDesignation(int designation_id) throws SQLException
	{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select d.designation_id,d.designation_name,ua.canread,ua.canedit,ua.cancreate,ua.candelete from designation d inner join useraccess ua on d.designation_id=ua.designation_id where d.designation_id=?;");
			ps.setInt(1,designation_id);
			ResultSet rs =ps.executeQuery();
			return rs;
	}
	public List<Object> getUserAccessList(int useraccess_id) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from useraccess where useraccess_id=?;");
		ps.setInt(1,useraccess_id);
		ResultSet rs =ps.executeQuery();
		List<Object> al=new ArrayList<>();
		while(rs.next())
		{			
			al.add(rs.getInt(1));
			al.add(rs.getInt(2));
			al.add(rs.getBoolean(3));
			al.add(rs.getBoolean(4));
			al.add(rs.getBoolean(5));
			al.add(rs.getBoolean(6));
		}
	return al;
	}
	
}
