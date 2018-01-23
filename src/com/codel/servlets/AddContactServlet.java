package com.codel.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codel.enumeration.Response;
import com.codel.services.ContactServices;

public class AddContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public AddContactServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String streetNumber = request.getParameter("street_number");
		String streetType = request.getParameter("street_type");
		String streetName = request.getParameter("street_name");
		String codePostal = request.getParameter("code_postal");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		Response result = ContactServices.addContact(firstName, lastName, email, streetNumber, streetType, streetName, codePostal, city, country);
		request.setAttribute("response", result);
		if(result != Response.OK){
			request.setAttribute("first_name", firstName);
			request.setAttribute("last_name", lastName);
			request.setAttribute("email", email);
			request.setAttribute("street_number", streetNumber);
			request.setAttribute("street_type", streetType);
			request.setAttribute("street_name", streetName);
			request.setAttribute("code_postal", codePostal);
			request.setAttribute("city", city);
			request.setAttribute("country", country);
			request.setAttribute("reponse", result);
			getServletContext().getRequestDispatcher("/addContact.jsp").forward(request, response);
		}
		else  getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
	}

}
