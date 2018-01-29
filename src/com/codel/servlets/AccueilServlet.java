package com.codel.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.codel.entities.ContactGroup;
import com.codel.services.ContactGroupServices;

public class AccueilServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public AccueilServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ContactGroupServices contactGroupServices = (ContactGroupServices) context.getBean("myContactGroupServices");
		
		List<ContactGroup> cg = contactGroupServices.findAll();
		request.getSession(true).setAttribute("contactGroups", cg);
		getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		
	}
	
}
