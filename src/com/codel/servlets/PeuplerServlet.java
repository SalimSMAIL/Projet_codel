package com.codel.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.codel.daos.ContactDAO;
import com.codel.entities.Contact;
import com.codel.entities.ContactGroup;
import com.codel.services.ContactGroupServices;

public class PeuplerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public PeuplerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		Contact c1 = (Contact)context.getBean("myContact");
		Contact c2 = (Contact)context.getBean("myContactBis");
		ContactDAO d = (ContactDAO)context.getBean("myContactDAO");
		try{
			d.save(c1);
			d.save(c2);
		}catch(Exception e){
		}

		

		ContactGroupServices contactGroupServices = (ContactGroupServices) context.getBean("myContactGroupServices");
		List<ContactGroup> cg = contactGroupServices.findAll();
		
		request.getSession(true).setAttribute("contactGroups", cg);
		getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		
	}

}
