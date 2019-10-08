package com.sims.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.service.AdminService;

/**
 * Servlet implementation class DeleteCourse
 */
public class DeleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminService as=new AdminService();
		boolean status = false;
		String alert="";String falert="";
		String[] strdeleteCourseId=request.getParameterValues("deleteCourseId");
		System.out.println("strdeleteCourseId :"+strdeleteCourseId.length);
		String deleteId="";
		for(int i=0;i<strdeleteCourseId.length;i++)
		{
			 deleteId=deleteId+strdeleteCourseId[i];
			 System.out.println("size :::::: "+deleteId.length());
		}
		String deleteStr = new String(deleteId);
		/*for(int i=0;i<deleteId.length();i++)
		{
			
			deleteStr.trim();
			String deleteCourse=deleteStr.split(",");
			
			System.out.println("deleteCourse : :"+deleteCourse[i]);
		}*/
		/*String cid="";
		String delcourseId="";
	      for (String courseId: deleteStr.split(","))
	      {
	    	  courseId.trim();
	    	  delcourseId=delcourseId.trim()+" "+courseId.trim();
	    	  char delid[]=courseId.toCharArray();
	    	  for(int i=0;i<delid.length;i++)
	    	  {
	    		 cid=cid+delid[i];
	    	  }
	    	  
	     }*/
	      
		String Str =new String(deleteStr);
		List<String> al=new ArrayList<>();
	for(String l:Str.split(","))
	{	l.trim();
					if(l.equals(""))
					{
					}
					else{al.add(l);}
						System.out.println("list : "+al);
					}
	
	Iterator<String> iter=al.iterator();
	int count=0;
	int delcount=al.size();
	for(int i=0;i<al.size();i++)
	{
		String cid=iter.next();
		System.out.println("cid : "+cid);
	
		 try {	
			 	status=as.deleteCourseService(cid);
			 	if(status==true)
				{ count++;
			 		System.out.println("count "+count+" delcount "+delcount);
				}
			 if(count==delcount)
			 {
				 alert="Course Deleted";
					System.out.println("Deletion succeed  ");
					RequestDispatcher rsd=request.getRequestDispatcher("courseList.jsp?alert="+alert);
					rsd.include(request, response); 
			 }
					
			} 
		 catch (SQLException e) {
			 falert="Course can not be Deleted. This course contains many number of students."+""+" To delete this course first remove the students from this course and then delete ";
			 RequestDispatcher rsd=request.getRequestDispatcher("courseList.jsp?falert="+falert);
				rsd.include(request, response);	
				System.out.println("Deletion failed of "+cid);
				e.printStackTrace();
				}
	    	
	}System.out.println("count "+count+" delcount "+delcount);
	/*if(count==delcount)
	 {
		 alert="Course Deleted";
			System.out.println("Deletion succeed  ");
			RequestDispatcher rsd=request.getRequestDispatcher("courseList.jsp?alert="+alert);
			rsd.include(request, response); 
	 }*/
	
	    	/*catch(ArrayIndexOutOfBoundsException ab)
	    	{
	    		
	    	}*/
	     
			/*int deleteCourseId=Integer.parseInt(strdeleteCourseId[i]);
		System.out.println("servlet deleteCourseId of"+i+"is : " +deleteCourseId);
		try {
			 status=as.deleteCourseService(deleteCourseId);
			if(status==true)
			{
				System.out.println("course Deleted");
				response.sendRedirect("courseList.jsp");
				out.print("<div class='header'>Course Deleted.!</div>");
				
			}
		
			else{
				
				System.out.println("Failed to delete");
				response.sendRedirect("deleteBatch.jsp");
				out.print("<div class='header'>Course can not be deleted.!</div>");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("deleteBatch.jsp");
			out.print("<div class='header'>Course have some users cannot delete.!</div>");
			e.printStackTrace();

		}*/
		}
		
	}
/*	PrintWriter out=response.getWriter();
	String strdeleteCourseId=request.getParameter("deleteCourseId");
	int deleteCourseId=Integer.parseInt(strdeleteCourseId);
	System.out.println("deleteCourseId"+deleteCourseId);
	AdminService as=new AdminService();
	try {
		boolean status=as.deleteCourseService(deleteCourseId);
		if(status==true)
		{
			System.out.println("course Deleted");
			response.sendRedirect("batchList.jsp");
			out.print("<div class='header'>Course Deleted.!</div>");
			
		}
		else{
			
			System.out.println("Failed to delete");
			response.sendRedirect("deleteBatch.jsp");
			out.print("<div class='header'>Course can not be deleted.!</div>");
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		response.sendRedirect("deleteBatch.jsp");
		out.print("<div class='header'>Course have some users cannot delete.!</div>");
		e.printStackTrace();

	}
	{
		
	}
*/

