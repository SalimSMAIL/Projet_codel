<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ajouter contact</title>
</head>
<body>
<%
	String firstName = (request.getAttribute("first_name")!=null)?(String)request.getAttribute("first_name"):"";
	String lastName = (request.getAttribute("last_name")!=null)?(String)request.getAttribute("last_name"):"";
	String email = (request.getAttribute("email")!=null)?(String)request.getAttribute("email"):"";
	String streetNumber = (request.getAttribute("street_number")!=null)?(String)request.getAttribute("street_number"):"";
	String streetType = (request.getAttribute("street_type")!=null)?(String)request.getAttribute("street_type"):"";
	String streetName = (request.getAttribute("street_name")!=null)?(String)request.getAttribute("street_name"):"";
	String codePostal = (request.getAttribute("code_postal")!=null)?(String)request.getAttribute("code_postal"):"";
	String city = (request.getAttribute("city")!=null)?(String)request.getAttribute("city"):"";
	String country = (request.getAttribute("country")!=null)?(String)request.getAttribute("country"):"";
%>
<section class="container">
    <div class="create">
      <h1>Veuillez remplir le formulaire : </h1>
      <form method="post" action="add">
        <p><label for="Prenom">Prenom : </label><input type="text" name="first_name" value="<% out.print(firstName); %>" placeholder="Prenom"></p>
        <p><label for="Nom">Nom : </label><input type="text" name="last_name" value="<% out.print(lastName); %>" placeholder="Nom"></p>
        <p><label for="email">Email : </label><input type="email" name="email" value="<% out.print(email); %>" placeholder="Email"></p>
        
        <p><label for="address">Adresse : </label>
        <input type="number" name="street_number" value="<% out.print(streetNumber); %>" placeholder="N&deg;" min="1" max="999">
       <select name="street_type">
           <option value="rue" selected>Rue</option>
           <option value="boulevard">Boulevard</option>
           <option value="avenue">Avenue</option>
       </select>
        <input type="text" name="street_name" value="<% out.print(streetName); %>" placeholder="Nom de rue">
        <input type="text" name="city" value="<% out.print(city); %>" placeholder="Ville">
        <input type="text" name="code_postal" value="<% out.print(codePostal); %>" placeholder="Code Postal">
        <input type="text" name="country" value="<% out.print(country); %>" placeholder="Pays">
        </p>

        <p><input type="tel" name="mobile_phone" value="" placeholder="Telephone mobile"></p>

        <p><input type="tel" name="home_phone" value="" placeholder="Telephone maison"></p>
        
        <p><input type="tel" name="work_phone" value="" placeholder="Telephone bureau"></p>

        <p><input type="submit" name="submit" value="add"><input type="reset" name="reset" value="reset"></p>
      </form>
    </div>
    
    <form action="peupler" method="post">
    	<p><input type="submit" name="submit" value="peupler"></p>
    </form>
  </section>
</body>
</html>