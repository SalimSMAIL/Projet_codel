package com.codel.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//
//		if(ContactServices.login(email, password)){
//			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/accueil.jsp");
//			dispatcher.forward(request,response);
//		}
//		else {
//			response.sendRedirect("index.html");
//		}
	}

}
