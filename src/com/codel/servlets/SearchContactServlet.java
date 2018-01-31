package com.codel.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.codel.entities.Contact;
import com.codel.entities.ContactGroup;
import com.codel.services.ContactGroupServices;
import com.codel.services.ContactServices;

public class SearchContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchContactServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query  = request.getParameter("name");
		System.out.println(query);
		if(query!=null){
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			ContactServices contactServices = (ContactServices) context.getBean("myContactServices");
			List<Contact> contacts = contactServices.searchContact(query);
			
			if(!contacts.isEmpty()) {
				request.setAttribute("contacts", contacts);
				System.out.println(contacts.iterator().next().getFirstName());
			}
		}
		

		getServletContext().getRequestDispatcher("/listContact.jsp").forward(request, response);

	}

}
