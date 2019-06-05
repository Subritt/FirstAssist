package com.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wedemo.service.UserDaolmpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user_login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String un = request.getParameter("username");
			String pw = request.getParameter("password") ;
			
			UserDaolmpl ud = new UserDaolmpl();
			
			 String rsult = ud.userLogin(un, pw);
			
			if(!rsult.isEmpty()){
				
				HttpSession session = request.getSession();
				session.setAttribute("activeuser", un);
				session.setMaxInactiveInterval(10);
				
				request.setAttribute("username", rsult);
				request.getRequestDispatcher("home.jsp").forward(request, response) ;
			}else{
				request.setAttribute("error", "Username does not exist!");
				request.getRequestDispatcher("login.jsp").forward(request, response) ;
			}
//			if((boolean) ud.userLogin(un, pw)){
//				HttpSession session = request.getSession() ;
//				session.setAttribute("activeuser", un);
//				
//				request.setAttribute("username", un);
//				request.getRequestDispatcher("home.jsp").forward(request, response);
//				
//			}else {
//				request.setAttribute("error", "user doesn't exit!");
//				request.getRequestDispatcher("login.jsp").forward(request, response);
//			}
	}

}
