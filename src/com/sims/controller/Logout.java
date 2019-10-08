package com.sims.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
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
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Servlet Execution");
		PrintWriter out=response.getWriter();
		  response.setHeader("Cache-Control","no-cache");
		    response.setHeader("Cache-Control","no-store");
		    response.setDateHeader("Expires", 0);
		    response.setHeader("Pragma","no-cache");
		String alert="alert";
		    HttpSession sess=request.getSession(false);
		if(sess==null)
			{ 
			sess.setAttribute("ssnName", null);
			alert="You are already logged out";
			}
		else{
			sess.setAttribute("ssnName", null);
			alert="You are logged out";
			/*sess.removeAttribute("ssnName");
			sess.invalidate();
			*/System.out.println("Session killed");
			}
		System.out.println("Session out"+sess);
		response.sendRedirect("index.jsp?alert="+alert);
		
		System.out.println("Log out ");                            
		out.println("You are logged out..");
	
		
	
	

}
}