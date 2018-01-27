<%@page import="com.codel.entities.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>modifier contact</title>
</head>
<body>
<%
Contact contact = (Contact) request.getSession().getAttribute("contact");
String errors = (request.getAttribute("errors")!=null)?(String)request.getAttribute("errors"):"";
%>
<section class="container">
    <div class="create">
      <h1>Modifier les valeurs que vous voulez: </h1>
      <h2><% out.print(errors); %></h2>
      <form method="post" action="update">
        <p><label for="Prenom">Prenom : </label><input type="text" name="first_name" value="<% out.print(contact.getFirstName()); %>" placeholder="Prenom"></p>
        <p><label for="Nom">Nom : </label><input type="text" name="last_name" value="<% out.print(contact.getLastName()); %>" placeholder="Nom"></p>
        <p><label for="email">Email : </label><input type="email" name="email" value="<% out.print(contact.getEmail()); %>" placeholder="Email"></p>
        
        <p><label for="address">Adresse : </label>
        <input type="number" name="street_number" value="<% out.print(contact.getAddress().getStreetNumber()); %>" placeholder="N&deg;" min="1" max="999">
       <input type="text" name="street_type" value="<% out.print(contact.getAddress().getStreetType()); %>" placeholder="Type de rue">
        <input type="text" name="street_name" value="<% out.print(contact.getAddress().getStreetName());%>" placeholder="Nom de rue">
        <input type="text" name="city" value="<% out.print(contact.getAddress().getCity()); %>" placeholder="Ville">
        <input type="text" name="code_postal" value="<% out.print(contact.getAddress().getCodePostal()); %>" placeholder="Code Postal">
        <input type="text" name="country" value="<% out.print(contact.getAddress().getCountry()); %>" placeholder="Pays">
        </p>

        <p><input type="tel" name="mobile_phone" value="" placeholder="Telephone mobile"></p>

        <p><input type="tel" name="home_phone" value="" placeholder="Telephone maison"></p>
        
        <p><input type="tel" name="work_phone" value="" placeholder="Telephone bureau"></p>

        <p><input type="submit" name="submit" value="add"><input type="reset" name="reset" value="reset"></p>
      </form>
    </div>
  </section>
</body>
</html>