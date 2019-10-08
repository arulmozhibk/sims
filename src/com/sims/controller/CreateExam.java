package com.sims.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.service.AdminService;

/**
 * Servlet implementation class CreateExam
 */
public class CreateExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateExam() {
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
		String strDesignationId=request.getParameter("designationId");
		int designationId=Integer.parseInt(strDesignationId);
		String exam_name=request.getParameter("exam_name");
		AdminService as=new AdminService();
		String alert="";	String falert="";
		try {
			boolean status=as.createExamService(exam_name);
			if(status==true)
			{alert="Exam Created.!";
				response.sendRedirect("createExam.jsp?designationId="+designationId+"&alert="+alert);

			}
			else
			{
				falert="Exam is not Created";
				response.sendRedirect("createExam.jsp?designationId="+designationId+"&falert="+falert);
			}
				
		} catch (SQLException e) {
			falert="Exam is not Created. Please enter the correct exam name";
			response.sendRedirect("createExam.jsp?designationId="+designationId+"&falert="+falert);
			e.printStackTrace();
		}
		
		
	}

}
