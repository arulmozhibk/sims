package com.sims.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.service.ViewService;

/**
 * Servlet implementation class PaymentByCourse
 */
public class PaymentByCourseDashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentByCourseDashBoard() {
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
		System.out.println("Servlet Execution");
		ViewService vs=new ViewService();
		 int Courseid=2;
		 SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		 String strDate="04/01/2015";
		 String strDate1="04/30/2015";

		 Date date1=null;
		try {
			date1 = sdf.parse(strDate1);
	  	 System.out.println("Date1 is:"+date1);
	  	 		Date date=sdf.parse(strDate);
	  	 			 System.out.println("Date is:"+date);

			String fromDate=sdf.format(date);
			 String toDate=sdf.format(date1);
			try {
			ResultSet rs = vs.getPaymentOfCourse(Courseid, fromDate, toDate);
			while(rs.next())
			 {
				 System.out.println("User name: "+rs.getString(1)+"Course name: "+rs.getString(2)+"paid amount: "+rs.getDouble(3)+"Payment Date:"+rs.getDate(4));	
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

}
