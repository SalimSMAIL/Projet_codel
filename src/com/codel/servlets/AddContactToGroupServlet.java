package com.codel.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.codel.entities.Contact;
import com.codel.services.ContactGroupServices;
import com.codel.services.ContactServices;

public class AddContactToGroupServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public AddContactToGroupServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idGroup = request.getParameter("idg");
		String idContact = request.getParameter("id");
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ContactServices contactServices = (ContactServices) context.getBean("myContactServices");
		ContactGroupServices cgs = (ContactGroupServices) context.getBean("myContactGroupServices");
		// creer une méthode dans le contactgroupeDAO pour get les contacts de tel groupe en lui passant l'id
		List<Contact> contacts = null;// = cgs. à continuer
		request.setAttribute("contacts", contacts);
		if(idGroup!=null && idContact!=null) {
			contactServices.addContactToGroup(idContact,idGroup);
			getServletContext().getRequestDispatcher("/listContactToAddGroup.jsp").forward(request, response);
		}
		
		
	}

}
