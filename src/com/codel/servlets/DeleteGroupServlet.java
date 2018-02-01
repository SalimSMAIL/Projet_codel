package com.codel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.codel.services.ContactGroupServices;

public class DeleteGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteGroupServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id  = request.getParameter("id");
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ContactGroupServices contactGroupServices = (ContactGroupServices) context.getBean("myContactGroupServices");
		
		contactGroupServices.deleteGroup(Long.parseLong(id));

		response.sendRedirect("accueil");

	}


}
