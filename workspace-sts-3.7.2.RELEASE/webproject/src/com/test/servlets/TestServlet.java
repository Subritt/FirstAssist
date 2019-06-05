package com.test.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.doGet(req, resp);
		
		//resp.getWriter().println("Test Servlet");
		//resp.sendRedirect("http://www.google.com");
		PrintWriter out = resp.getWriter();
		 out.println("<h1> Login Form </h1>");
		out.println("User Name <input type = 'text'><br><br>");
		out.println("Password &nbsp;&nbsp <input type = 'text'><br><br>");
		out.println("<input type='submit' value='Login'>");
	}
}
