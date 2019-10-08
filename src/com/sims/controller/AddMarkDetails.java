package com.sims.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.bean.ExamResultBean;
import com.sims.service.AdminService;
import com.sims.service.ViewService;

/**
 * Servlet implementation class AddMarkDetails
 */
public class AddMarkDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMarkDetails() {
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
		System.out.println("Servlet execution");
		String strExamid=request.getParameter("examid");
		int examid=Integer.parseInt(strExamid);
		
		String strUserid=request.getParameter("userid");
		int userid=Integer.parseInt(strUserid);
		

		String strSub1=request.getParameter("sub1");
		int sub1=Integer.parseInt(strSub1);
		
		String strSub2=request.getParameter("sub2");
		int sub2=Integer.parseInt(strSub2);
		
		String strSub3=request.getParameter("sub3");
		int sub3=Integer.parseInt(strSub3);
		
		String strSub4=request.getParameter("sub4");
		int sub4=Integer.parseInt(strSub4);
		
		String strSub5=request.getParameter("sub5");
		int sub5=Integer.parseInt(strSub5);
		
		String strTotal=request.getParameter("total");
		int total=Integer.parseInt(strTotal);
		
		String strDesignationId=request.getParameter("designationId");
		int designationID=Integer.parseInt(strDesignationId);
		
		AdminService as=new AdminService();
		String alert=" ";String falert=" ";
		try {
			
		ExamResultBean rb=new ExamResultBean();
		rb.setSubject_1(sub1);
		rb.setSubject_2(sub2);
		rb.setSubject_3(sub3);
		rb.setSubject_4(sub4);
		rb.setSubject_5(sub5);
		rb.setTotal(total);
		rb.setExam_id(examid);
		rb.setUser_id(userid);
	
		int user_id=rb.getUser_id();
		int exam_id=rb.getExam_id();
		int count=0;
		System.out.println("USer id"+user_id+ " exam_id "+exam_id);
		ViewService vs=new ViewService();
		ResultSet rs=vs.viewUserResultByExam(user_id, exam_id);
		boolean status = false;
		while(rs.next())
		{	count++;
		}System.out.println("rows in already : "+count);
		
		if(count<1)
			{
			
			status=as.createResultService(rb);
			System.out.println(" status of report: "+status);
			}
		else if(count>0)
		{
			status=as.updateResultService(rb);
			System.out.println("MArks Updated ");
		}
		if(status==true)
			{if(count>0){ alert="Marks Updated";}
			  else{alert="Marks Added";}
			
					System.out.println("Marks added in DB");
					RequestDispatcher rds=request.getRequestDispatcher("examination.jsp?designationId="+designationID+"&alertmsg=" + alert);
					rds.include(request, response);
			}
			else
			{  falert="Marks can not be Added";
				System.out.println("Marks not added");
				RequestDispatcher rd=request.getRequestDispatcher("examination.jsp?designationId="+designationID+"&falertmsg=" + falert);
				rd.include(request, response);			}
		
			
		} catch (SQLException e) {
			falert="Please enter the valid marks";
			System.out.println("Marks not added");
			RequestDispatcher rd1=request.getRequestDispatcher("examination.jsp?designationId="+designationID+"&falertmsg=" + falert);
			rd1.include(request, response);	
		e.printStackTrace();

		}
		 catch (Exception ne) {
				falert="Please enter the valid marks";
				System.out.println("Marks not added");
				RequestDispatcher rdp=request.getRequestDispatcher("examination.jsp?designationId="+designationID+"&falertmsg=" + falert);
				rdp.include(request, response);	
			ne.printStackTrace();

			}
		
		
	
		
	}

}
