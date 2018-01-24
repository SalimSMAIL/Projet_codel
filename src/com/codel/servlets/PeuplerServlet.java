package com.codel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.codel.daos.ContactDAO;
import com.codel.entities.Contact;

public class PeuplerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public PeuplerServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		Contact c1 = (Contact)context.getBean("myContact");
		Contact c2 = (Contact)context.getBean("myContactBis");
		ContactDAO d = (ContactDAO)context.getBean("myContactDao");
		d.save(c1);
		d.save(c2);
		
	}

}
