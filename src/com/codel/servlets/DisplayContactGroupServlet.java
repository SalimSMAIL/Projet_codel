package com.codel.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codel.services.GroupServices;


public class DisplayContactGroupServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public DisplayContactGroupServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		GroupServices d = (GroupServices) context.getBean("myContactGroupServices");
		JSONObject json_element = new JSONObject();
		try {

			
			json_element = d.findAll();
			System.out.println("yess"+json_element.toString());
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().print(json_element);

		} catch (Exception e) {
			e.printStackTrace(); // local debug
			request.setAttribute("error", e); // remote debug
			response.getWriter().print(e);
		}

}
}
