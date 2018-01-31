package com.codel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.codel.entities.Contact;
import com.codel.entities.Entreprise;
import com.codel.services.ContactServices;
import com.codel.services.EntrepriseServices;

public class UpdateEntrepriseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    public UpdateEntrepriseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id  = request.getParameter("id");
		
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		EntrepriseServices entrepriseServices = (EntrepriseServices) context.getBean("myEntrepriseServices");
		
		Entreprise entreprise = entrepriseServices.findById(Long.parseLong(id));
		
		if(entreprise != null) {
			request.getSession(true).setAttribute("entreprise", entreprise);
			getServletContext().getRequestDispatcher("/updateEntreprise.jsp").forward(request, response);
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
		String numSiret = request.getParameter("num_siret");

		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		EntrepriseServices entrepriseServices = (EntrepriseServices) context.getBean("myEntrepriseServices");
		Entreprise entreprise = (Entreprise) request.getSession().getAttribute("entreprise");
		try {
			JSONObject result = entrepriseServices.updateEntreprise(entreprise, firstName, lastName, email, streetNumber, streetType, streetName, codePostal, city, country,Long.parseLong(numSiret));
			if(result.has("errors")) {
				request.setAttribute("errors", "veuillez remplir correctement ces champs : "+result.getString("errors"));
				getServletContext().getRequestDispatcher("/updateEntreprise.jsp").forward(request, response);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
