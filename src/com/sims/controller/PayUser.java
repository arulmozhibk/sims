package com.sims.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.bean.PaymentBean;
import com.sims.service.AdminService;

/**
 * Servlet implementation class PayUser
 */
public class PayUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayUser() {
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
		int designationID=Integer.parseInt(strDesignationId);
		
		String strpaidAmount=request.getParameter("paidAmount");
		double paidAmount=Double.parseDouble(strpaidAmount);

		String strUserId=request.getParameter("userId");
		int userId=Integer.parseInt(strUserId);
		
		String alert=" ";String falert=" ";
		
		AdminService as=new AdminService();
		PaymentBean pb=new PaymentBean();
		pb.setUser_id(userId);
		pb.setPaid_amount(paidAmount);
		pb.setPayment_date(new java.sql.Timestamp(System.currentTimeMillis()));

		try {
			boolean status=as.payAmount(pb);
			if(status==true)
				{alert="Payment succeed";
				System.out.println("Status in servlet:"+status);
				response.sendRedirect("payUserReport.jsp?UserId="+userId+"&designationId="+designationID+"&alert="+alert);

				}
			else{
				falert="Payment Failed";
				System.out.println("Status in servlet:"+status);
				RequestDispatcher rd=request.getRequestDispatcher("payUser.jsp?UserId="+userId+"&designationId="+designationID+"&falert="+falert);
				rd.include(request, response);

				
			}
		} catch (SQLException e) {
			falert="Payment Failed. Please enter the valid amount";
			RequestDispatcher rd=request.getRequestDispatcher("payUser.jsp?UserId="+userId+"&designationId="+designationID+"&falert="+falert);
			rd.include(request, response);
			e.printStackTrace();
		}
	}

}
