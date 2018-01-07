package com.codel.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codel.services.ContactServices;

public class SearchContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public SearchContactServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		
		ContactServices.add(id, firstName, lastName, email);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/accueil.jsp");
		dispatcher.forward(request,response);
	}

}
