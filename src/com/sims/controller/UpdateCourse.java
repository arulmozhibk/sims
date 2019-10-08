package com.sims.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.bean.CourseBean;
import com.sims.service.AdminService;

/**
 * Servlet implementation class UpdateCourse
 */
public class UpdateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourse() {
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
		request.setCharacterEncoding("UTF-8");
		String strCourseId=request.getParameter("courseId");
		String strdesignationId=request.getParameter("designationid");
		int designationId=Integer.parseInt(strdesignationId);
		
		System.out.println("strCourseId"+strCourseId);
		int courseId=Integer.parseInt(strCourseId);
		
		String CourseName=request.getParameter("courseName");
		
		String strCourseFees=request.getParameter("courseFees");
		
		AdminService as=new AdminService();
		CourseBean cb=new CourseBean();
		
		String alert="";String falert="";
		try {
			double courseFees=Double.parseDouble(strCourseFees);
			cb.setCourse_id(courseId);
			cb.setCourse_name(CourseName);
			cb.setFees(courseFees);
			boolean status=as.editCourseService(cb);
			System.out.println("status"+status);
			if(status==true)
			{  alert="Course Updated";
				RequestDispatcher rd=request.getRequestDispatcher("courseList.jsp?alert="+alert);
				rd.forward(request, response);
				System.out.println(" Course updated in servlet");
				
			}
			falert="Failed to Update";
			RequestDispatcher rd1=request.getRequestDispatcher("editCourse.jsp?designationid="+designationId+"&falert="+falert);
			rd1.include(request, response);
			System.out.println(" Course is not updated in servlet");

			
		} catch (SQLException e) {
			falert="Failed to Update. Please enter the valid details";
			RequestDispatcher rd1=request.getRequestDispatcher("editCourse.jsp?designationid="+designationId+"&falert="+falert);
			rd1.include(request, response);
			e.printStackTrace();
		}
		 catch (Exception ex) {
				falert="Failed to Update. Please enter the valid details";
				RequestDispatcher rd1=request.getRequestDispatcher("editCourse.jsp?designationid="+designationId+"&falert="+falert);
				rd1.include(request, response);
				ex.printStackTrace();
			}
	}

}
