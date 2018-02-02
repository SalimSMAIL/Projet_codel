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

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id  = request.getParameter("id");
		String idGroup  = request.getParameter("idg");
		

		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ContactGroupServices contactGroupServices = (ContactGroupServices) context.getBean("myContactGroupServices");
		ContactServices contactServices = (ContactServices) context.getBean("myContactServices");
		
		if(idGroup!=null){
			
			ContactGroup contactGroup = contactGroupServices.findById(Long.parseLong(idGroup));
			contactGroupServices.deleteContact(contactGroup, contactServices.findById(Long.parseLong(id)));
			response.sendRedirect("contacts?id="+idGroup);
			
		}else{
			contactServices.deleteContactbyId(Long.parseLong(id));
			response.sendRedirect("contacts");
		}
		
		

		
	}

}
