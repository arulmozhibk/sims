package com.sims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sims.bean.DesignationBean;

public class DesignationDao {
	
	public int createDesignation(DesignationBean db) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("insert into designation(designation_name,menu_rights_id) values(?,?);");
		ps.setString(1,db.getDesignation_name());
		ps.setInt(2, db.getMenu_rights_id());
		int count=ps.executeUpdate();
		
		return count;
		
	}
	
	public int editDesignation(DesignationBean db) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("update designation set designation_name=?,menu_rights_id=? where designation_id=?;");
		ps.setString(1,db.getDesignation_name());
		ps.setInt(2, db.getMenu_rights_id());
		ps.setInt(3,db.getDesignation_id());
		int count=ps.executeUpdate();
		
		return count;
		
	}
	
	public int deleteDesignation(int designation_id) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("delete from designation where designation_id=?;");
		ps.setInt(1,designation_id);
		int count=ps.executeUpdate();
		
		return count;
		
	}
	
	public ResultSet getDesignationById(int designation_id) throws SQLException
	{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select * from designation where designation_id=?;");
			ps.setInt(1,designation_id);
			ResultSet rs =ps.executeQuery();
			return rs;
	}
	public ResultSet getDesignation() throws SQLException
	{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select * from designation where designation_id<5;");
			ResultSet rs =ps.executeQuery();
			return rs;
	}
	public ResultSet getDesignationByUser(int user_id) throws SQLException
	{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select u.user_id,u.username,d.designation_name, d.designation_id from usermaster u inner join designation d on u.designation_id=d.designation_id where u.user_id=?;");
			ps.setInt(1,user_id);
			ResultSet rs =ps.executeQuery();
			return rs;
	}
	public List<Integer> getDesignationList(String designation_name) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select menu_rights_id from designation where designation_name=?;");
		ps.setString(1,designation_name);
		ResultSet rs =ps.executeQuery();
		List<Integer> al=new ArrayList<>();
		while(rs.next())
		{			
			al.add(rs.getInt(1));
			
		}
	return al;
	}
	public ResultSet getMenusOfDesignation(int designation_id) throws SQLException
	{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select umr.menu_rights_id,mr.menu_rights_name from usermenu_rights umr inner join menu_rights_master mr on mr.menu_rights_id=umr.menu_rights_id inner join designation d on d.designation_id=umr.designation_id where d.designation_id=?;");
			ps.setInt(1,designation_id);
			ResultSet rs =ps.executeQuery();
			return rs;
	}
	

	public static void main(String[] args) throws SQLException {
		DesignationDao dd=new DesignationDao();
		List<Integer> al=new ArrayList<>();
		al=dd.getDesignationList("Admin");
		System.out.println("Admin :"+al);
		 int[] menu = new int[al.size()];
		    for (int i = 0; i < al.size(); i++) {
		        menu[i] = al.get(i);
		        System.out.println("value : "+menu[i]);
		    }
		
		
		
	}
}
