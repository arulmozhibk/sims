package com.sims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sims.bean.UserMenuBean;

public class UserMenuDao {
	public int createUserMenu(UserMenuBean mrb) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("insert into usermenu_rights( designation_id,menu_rights_id) values(?,?);");
		ps.setInt(1,mrb.getDesignation_id());
		ps.setInt(2,mrb.getMenu_rights_id() );
		int count=ps.executeUpdate();
		
		return count;
		
	}
	
	public int editUserMenu(UserMenuBean mrb) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("update usermenu_rights set designation_id=?,menu_rights_id=? where usermenu_rights=?;");
		ps.setInt(1,mrb.getDesignation_id());
		ps.setInt(2,mrb.getMenu_rights_id() );
		ps.setInt(3,mrb.getUsermenu_rights_id());
		int count=ps.executeUpdate();
		
		return count;
		
	}
	
	public int deleteUserMenu(int usermenu_rights) throws SQLException
	{
		Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("delete from usermenu_rights where usermenu_rights=?;");
		ps.setInt(1,usermenu_rights);
		int count=ps.executeUpdate();
		
		return count;
		
	}

}
