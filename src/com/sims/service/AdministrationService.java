package com.sims.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sims.dao.ConnectionDao;
import com.sims.dao.DesignationDao;
import com.sims.dao.UserAccessDao;

public class AdministrationService {
	
	public int[] getDesignationList(String designation_name) throws SQLException
	{
		DesignationDao dd=new DesignationDao();
		List<Integer> al=new ArrayList<>();
		al=dd.getDesignationList(designation_name);
		int[] menu = new int[al.size()];
	    for (int i = 0; i < al.size(); i++)
	    {
	        menu[i] = al.get(i);
		
	}
		return menu;
	    
		
	}
	public ResultSet getMenusOfDesignation(int designation_id) throws SQLException
	{
		DesignationDao dsd=new DesignationDao();
		ResultSet rs=dsd.getMenusOfDesignation(designation_id);	
			return rs;
	}
	
	public ResultSet getUserAccessByDesignation(int designation_id) throws SQLException
	{
			UserAccessDao uad=new UserAccessDao();
			ResultSet rs =uad.getUserAccessByDesignation(designation_id);
			return rs;
	}
	
	public ResultSet getDesignation() throws SQLException{
		DesignationDao dd=new DesignationDao();
		ResultSet rs=dd.getDesignation();	
		return rs;}
	
	public ResultSet getDesignationByUser(int user_id) throws SQLException{
		DesignationDao dd=new DesignationDao();
		ResultSet rs=dd.getDesignationByUser(user_id)	;
		return rs;}
	
	
	
	public static void main(String[] args) throws SQLException {
		AdministrationService ads=new AdministrationService();
		boolean access=true;
		boolean access1=true;
		UserAccessDao uad=new UserAccessDao();
		ResultSet rs=ads.getUserAccessByDesignation(1);
		while(rs.next())
		{
			boolean read=rs.getBoolean("canread");
			boolean edit=rs.getBoolean("canedit");
			boolean create=rs.getBoolean("cancreate");
			boolean delete=rs.getBoolean("candelete");
			if(read)
			{
				System.out.println("read : :");
			}
			if(edit)
			{
				System.out.println(" edit :: ");
			}
			
			/*if(rs.getBoolean(1)==access)
			{
			System.out.println(" canread ");
			}
			else if(rs.getBoolean(2)==access1)
			{
			System.out.println(" canedit ");
			}
			else if(rs.getBoolean(3)==access)
			{
			System.out.println(" cancreate ");
			}
			else if(rs.getBoolean(3)==access)
			{
				System.out.println(" cancreate ");
			}*/
			
		}
		/*AdministrationService ads=new AdministrationService();
			ResultSet rs=ads.getMenusOfDesignation(2);
		while(rs.next())
		{
			int menu=(int) rs.getInt("menu_rights_id");
			System.out.println("Menu "+menu);
			switch (menu) {
			case 1:
				System.out.println("  "+rs.getString("menu_rights_name"));
				break;
			case 2:
				System.out.println(" "+rs.getString("menu_rights_name"));
				break;
			case 3:
				System.out.println(" "+rs.getString("menu_rights_name"));
				break;
			case 4:
				System.out.println(" "+rs.getString("menu_rights_name"));
				break;
			case 5:
				System.out.println(" "+rs.getString("menu_rights_name"));
				break;
			case 6:
				System.out.println(" "+rs.getString("menu_rights_name"));
				break;

			default:
				
				System.out.println(" ");
				break;
			}
		}
*/		
			
			/*for(int i=0;i<size;++i)
			{
			if(n[i]==rs.getInt("menu_rights_id"))
					{
					System.out.println("List  "+n[i]+" "+rs.getString("menu_rights_name"));
					}*/
			/*
			else if(n[i]==rs.getInt("menu_rights_id"))
				{
				System.out.println("Administration");
				}
			else if(n[i]==rs.getInt("menu_rights_id"))
				{		System.out.println("Manage user");}
			else if(n[i]==rs.getInt("menu_rights_id"))
				{				System.out.println("Fees Config");}
			else if(n[i]==rs.getInt("menu_rights_id"))
				{	System.out.println("Examination"); }
			else if(n[i]==rs.getInt("menu_rights_id"))
			{	System.out.println("Academic"); }
			else if(n[i]==rs.getInt("menu_rights_id"))
			{	System.out.println("Nothing"); }
		
			*/
		}
		
	
}
