package com.sims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sims.bean.MenuRightsBean;

public class MenuRightsDao {
	public int createMenuRights(MenuRightsBean mrd) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("insert into menu_rights_master(menu_rights_name) values(?);");
		ps.setString(1,mrd.getMenu_rights_name());
		int count=ps.executeUpdate();
		
		return count;
		
	}
	
	public int editMenuRights(MenuRightsBean mrd) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("update menu_rights_master set menu_rights_name=?where menu_rights_id=?;");
		ps.setString(1,mrd.getMenu_rights_name());
		ps.setInt(1,mrd.getMenu_rights_id());
		int count=ps.executeUpdate();
		
		return count;
		
	}
	
	public int deleteMenuRights(int menu_rights_id) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("delete from menu_rights_master where menu_rights_id=?;");
		ps.setInt(1,menu_rights_id);
		int count=ps.executeUpdate();
		
		return count;
		
	}
	
	
	public ResultSet getMenuRights(int designation_id) throws SQLException
	{
			Connection conn=ConnectionDao.getConnect();
			PreparedStatement ps=conn.prepareStatement("select * from menu_rights_master where designation_id=?;");
			ps.setInt(1,designation_id);
			ResultSet rs =ps.executeQuery();
			return rs;
	}

}
