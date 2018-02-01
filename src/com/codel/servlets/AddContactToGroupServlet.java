package com.codel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
		ContactServices contactServices = (ContactServices)context.getBean("myContactServices");
		ContactGroupServices contactGroupServices = (ContactGroupServices)context.getBean("myContactGroupServices");
		
		if(idGroup!=null && idContact!=null) {
			contactServices.addContactToGroup(contactServices.findById(Long.parseLong(idContact)),contactGroupServices.findById(Long.parseLong(idGroup)));
			
			response.sendRedirect("contacts?id="+idGroup);
		} else response.sendRedirect("accueil");
		
		
	}

}
