package com.sims.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sims.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String email=request.getParameter("uid");
		String pwd=request.getParameter("password");
		String alert="";
		
		
		
		
		UserDao ud=new UserDao();
		try {
			int password=Integer.parseInt(pwd);
			boolean status=ud.isUserValid(email, password);
			System.out.println(status);
			if(status==true)
			{
				HttpSession session=request.getSession();
				session.setAttribute("ssnName",email);
				session.setMaxInactiveInterval(1000);
				
				RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}
			else
			{ alert="The email and password you entered don't match";
				RequestDispatcher rd1=request.getRequestDispatcher("index.jsp?alert="+alert);
				rd1.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception ne) {
			 alert="The email and password you entered don't match";
			RequestDispatcher rdt=request.getRequestDispatcher("index.jsp?alert="+alert);
			rdt.forward(request, response);
			
		}

	}

}
