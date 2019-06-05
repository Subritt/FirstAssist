package com.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webdemo.models.User;
import com.wedemo.service.UserDaolmpl;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/userlist")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getSession().getAttribute("activeuser") == null){
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			
		
		UserDaolmpl ud = new UserDaolmpl() ;
		List<User> ulist = ud.getAllUser() ;
		
		request.setAttribute("ulist", ulist) ;
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
