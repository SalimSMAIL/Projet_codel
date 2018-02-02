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

import com.codel.daos.ContactDAO;
import com.codel.entities.Contact;
import com.codel.services.ContactServices;

public class GetContactAddGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetContactAddGroupServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id  = request.getParameter("id");

		if(id!=null){
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			ContactServices contactServices = (ContactServices)context.getBean("myContactServices");
			
			List<Contact> contact = contactServices.findAll();
			if(contact != null) {
				request.setAttribute("id", id);
				request.setAttribute("contacts", contact);
			}
		}

		getServletContext().getRequestDispatcher("/listContactToAddGroup.jsp").forward(request, response);

	}

}
