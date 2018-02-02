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
import com.codel.services.ContactServices;

public class DisplayDetailsContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayDetailsContactServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id  = request.getParameter("id");
		if(id!=null){
			ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
			ContactServices contactServices = (ContactServices) context.getBean("myContactServices");
			Contact contact = contactServices.findById(Long.parseLong(id));
			if(contact!=null) {
				request.setAttribute("details", contact);
			}
			getServletContext().getRequestDispatcher("/details.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("accueil");
		}

		

	}

}
