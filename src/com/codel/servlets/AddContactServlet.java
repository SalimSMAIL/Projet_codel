package com.codel.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.codel.services.ContactServices;

public class AddContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public AddContactServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String streetNumber = request.getParameter("street_number");
		String streetType = request.getParameter("street_type");
		String streetName = request.getParameter("street_name");
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
		
		JSONObject resultService = null;
		try {
			resultService = contactServices.addContact(firstName, lastName, email, streetNumber,
					streetType, streetName, codePostal, city, country, listPhones);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if(resultService.has("errors")){
			request.setAttribute("first_name", firstName);
			request.setAttribute("last_name", lastName);
			request.setAttribute("email", email);
			request.setAttribute("street_number", streetNumber);
			request.setAttribute("street_type", streetType);
			request.setAttribute("street_name", streetName);
			request.setAttribute("code_postal", codePostal);
			request.setAttribute("city", city);
			request.setAttribute("country", country);
			
			request.setAttribute("mobile_phone", mobilePhone);
			request.setAttribute("home_phone", homePhone);
			request.setAttribute("professionnal_phone", professionnalPhone);
			
			StringBuilder result = new StringBuilder();
			
			try {
				JSONArray array = new JSONArray();
				array = resultService.getJSONArray("errors");
				for(int i=0; i<array.length(); i++){
					result.append(array.get(i)+", ");
				}
			} catch (JSONException e1) {
				try {
					result.append(resultService.getString("errors"));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
			request.setAttribute("errors", "veuillez remplir correctement ces champs : "+result);
			getServletContext().getRequestDispatcher("/addContact.jsp").forward(request, response);
		}
		else response.sendRedirect("accueil");
	}

}
