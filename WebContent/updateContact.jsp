<%@page import="com.codel.entities.Contact"%>
<%@page import="com.codel.entities.PhoneNumber"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style1.css" />
<title>Modifier contact</title>
</head>
<body>
<%
Contact contact = (Contact) request.getSession().getAttribute("contact");

Iterator<PhoneNumber> listPhones = contact.getPhones().iterator();
String mobile = "";
String home = "";
String professionnal = "";
while(listPhones.hasNext()){
	PhoneNumber phone = listPhones.next();
	if(phone.getPhoneKind().equals("mobile")){
		mobile = phone.getPhoneNumber();	
	}
	if(phone.getPhoneKind().equals("home")){
		home = phone.getPhoneNumber();	
	}
	if(phone.getPhoneKind().equals("professionnal")){
		professionnal = phone.getPhoneNumber();	
	}
}
String errors = (request.getAttribute("errors") != null) ? (String) request.getAttribute("errors") : "";
%>
<div class="container">  
  <form id="contact" action="update" method="post">
    <h3>Ajouter un contact</h3>
    <h4 style="color:red;"><% out.print(errors); %></h4>
    <fieldset>
      <input name="first_name" value="<% out.print(contact.getFirstName()); %>"" placeholder="Firstname" type="text" tabindex="1" >
    </fieldset>
    <fieldset>
      <input name="last_name" value="<% out.print(contact.getLastName()); %>" placeholder="lastname" type="text" tabindex="2" >
    </fieldset>
    <fieldset>
      <input name="email" value="<% out.print(contact.getEmail()); %>" placeholder="Email" type="text" tabindex="3" >
    </fieldset>
    <fieldset>
      <input name="street_number" value="<% out.print(contact.getAddress().getStreetNumber()); %>" placeholder="Street Number" type="text" tabindex="4" >
    </fieldset>
    <fieldset>
      <input name="street_type" value="<% out.print(contact.getAddress().getStreetType()); %>" placeholder="Street Type" type="text" tabindex="5" >
    </fieldset>    <fieldset>
      <input name="street_name" value="<% out.print(contact.getAddress().getStreetName());%>" placeholder="Street Name" type="text" tabindex="6" >
    </fieldset>    
    <fieldset>
      <input name="city" value="<% out.print(contact.getAddress().getCity()); %>" placeholder="City" type="text" tabindex="7" >
    </fieldset>    
    <fieldset>
      <input name="code_postal" value="<% out.print(contact.getAddress().getCodePostal()); %>" placeholder="Code Postal" type="text" tabindex="8" >
    </fieldset>
    <fieldset>
      <input name="country" value="<% out.print(contact.getAddress().getCountry()); %>" placeholder="Country" type="text" tabindex="9" >
    </fieldset>
    
     <fieldset>
      <input name="mobile_phone" value="<% out.print(mobile); %>" placeholder="Mobile phone" type="text" tabindex="7" >
    </fieldset>    
    <fieldset>
      <input name="home_phone" value="<% out.print(home); %>" placeholder="Home phone" type="text" tabindex="8" >
    </fieldset>
    <fieldset>
      <input name="professionnal_phone" value="<% out.print(professionnal); %>" placeholder="Professionnal phone" type="text" tabindex="9" >
    </fieldset>

    <fieldset>
      <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Add</button>
    </fieldset>
    <fieldset>
      <button name="reset" type="reset" id="contact-reset" data-submit="...reset">Reset</button>
    </fieldset>
    <fieldset>
      <button name="return" type="button" onclick="location.href='accueil';">Return</button>
    </fieldset>
  </form>

</div>

</body>
</html>