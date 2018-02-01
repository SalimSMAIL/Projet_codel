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

/**
 * Servlet implementation class DisplayContacts
 */
public class DisplayContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayContactServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id  = request.getParameter("id");
		

		if(id!=null){
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			ContactGroupServices contactGroupServices = (ContactGroupServices) context.getBean("myContactGroupServices");
			ContactGroup contactGroup = contactGroupServices.findById(Long.parseLong(id));
			
			if(contactGroup != null) {
				request.setAttribute("id", id);
				request.setAttribute("contacts", new ArrayList(contactGroup.getContacts()));
			}
		}else{
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			ContactServices contactServices = (ContactServices)context.getBean("myContactServices");
			List<Contact> contacts = contactServices.findAll();
			
			if(!contacts.isEmpty()) {
				request.setAttribute("contacts", contacts);
			}
		}
		

		getServletContext().getRequestDispatcher("/listContact.jsp").forward(request, response);

	}

}
