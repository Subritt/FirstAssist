package com.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webdemo.models.User;
import com.wedemo.service.UserDaolmpl;

/**
 * Servlet implementation class SIgnupServlet
 */
@WebServlet("/usersignup")
public class SIgnupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SIgnupServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("signup.jsp").forward(request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User u = new User() ;
		
		u.setFnmae(request.getParameter("fname"));
		u.setLname(request.getParameter("lname"));
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		
		new UserDaolmpl().signup(u) ;
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
