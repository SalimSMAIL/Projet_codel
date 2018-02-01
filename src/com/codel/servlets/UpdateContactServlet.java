package com.codel.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.codel.entities.Contact;
import com.codel.services.ContactServices;

public class UpdateContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public UpdateContactServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id  = request.getParameter("id");
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ContactServices contactServices = (ContactServices) context.getBean("myContactServices");
		
		Contact contact = contactServices.findById(Long.parseLong(id));
		
		if(contact != null) {
			request.getSession(true).setAttribute("contact", contact);
			getServletContext().getRequestDispatcher("/updateContact.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id  = request.getParameter("id");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String streetNumber = request.getParameter("street_number");
		String streetName = request.getParameter("street_name");
		String streetType = request.getParameter("street_type");
		String codePostal = request.getParameter("code_postal");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		String mobilePhone = request.getParameter("mobile_phone");
		String homePhone = request.getParameter("home_phone");
		String professionnalPhone = request.getParameter("professionnal_phone");
		
		Map<String, String> listPhones = new HashMap<>();
		listPhones.put("mobilePhone", mobilePhone);
		listPhones.put("homePhone", homePhone);
		listPhones.put("professionnalPhone", professionnalPhone);
		

		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ContactServices contactServices = (ContactServices) context.getBean("myContactServices");
		Contact contact = (Contact) request.getSession().getAttribute("contact");
		try {
			JSONObject result = contactServices.updateContact(contact, firstName, lastName, email, streetNumber, streetType, streetName, 
					codePostal, city, country, listPhones);
			if(result.has("errors")) {
				request.setAttribute("errors", "veuillez remplir correctement ces champs : "+result.getString("errors"));
				getServletContext().getRequestDispatcher("/updateContact.jsp").forward(request, response);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
