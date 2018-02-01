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

String numSiret = (request.getAttribute("num_siret") != null)? (String) request.getAttribute("num_siret") : "";
String firstName = (request.getAttribute("first_name") != null)? (String) request.getAttribute("first_name") : "";
String lastName = (request.getAttribute("last_name") != null) ? (String) request.getAttribute("last_name"): "";
String email = (request.getAttribute("email") != null) ? (String) request.getAttribute("email") : "";
String streetNumber = (request.getAttribute("street_number") != null)? (String) request.getAttribute("street_number") : "";
String streetType = (request.getAttribute("street_type") != null)? (String) request.getAttribute("street_type") : "";
String streetName = (request.getAttribute("street_name") != null)? (String) request.getAttribute("street_name") : "";
String codePostal = (request.getAttribute("code_postal") != null)? (String) request.getAttribute("code_postal") : "";
String city = (request.getAttribute("city") != null) ? (String) request.getAttribute("city") : "";
String country = (request.getAttribute("country") != null) ? (String) request.getAttribute("country") : "";

String mobilePhone = (request.getAttribute("mobile_phone") != null)? (String) request.getAttribute("mobile_phone") : "";
String homePhone = (request.getAttribute("home_phone") != null) ? (String) request.getAttribute("home_phone") : "";
String professionnalPhone = (request.getAttribute("professionnal_phone") != null) ? (String) request.getAttribute("professionnal_phone") : "";

String errors = (request.getAttribute("errors") != null) ? (String) request.getAttribute("errors") : "";
%>
	<div class="container">
		<form id="contact" action="addE" method="post">
			<h3>Ajouter un contact</h3>
			<h4 style="color: red;">
				<%
							out.print(errors);
						%>
			</h4>
			<fieldset>
				<input name="num_siret" value="<%out.print(numSiret);%>"
					placeholder="Num siret" type="text" tabindex="1">
			</fieldset>
			<fieldset>
				<input name="first_name" value="<%out.print(firstName);%>"
					placeholder="Firstname" type="text" tabindex="1">
			</fieldset>
			<fieldset>
				<input name="last_name" value="<%out.print(lastName);%>"
					placeholder="lastname" type="text" tabindex="2">
			</fieldset>
			<fieldset>
				<input name="email" value="<%out.print(email);%>"
					placeholder="Email" type="text" tabindex="3">
			</fieldset>
			<fieldset>
				<input name="street_number" value="<%out.print(streetNumber);%>"
					placeholder="Street Number" type="text" tabindex="4">
			</fieldset>
			<fieldset>
				<input name="street_type" value="<%out.print(streetType);%>"
					placeholder="Street Type" type="text" tabindex="5">
			</fieldset>
			<fieldset>
				<input name="street_name" value="<%out.print(streetName);%>"
					placeholder="Street Name" type="text" tabindex="6">
			</fieldset>
			<fieldset>
				<input name="city" value="<%out.print(city);%>" placeholder="City"
					type="text" tabindex="7">
			</fieldset>
			<fieldset>
				<input name="code_postal" value="<%out.print(codePostal);%>"
					placeholder="Code Postal" type="text" tabindex="8">
			</fieldset>
			<fieldset>
				<input name="country" value="<%out.print(country);%>"
					placeholder="Country" type="text" tabindex="9">
			</fieldset>
			<fieldset>
				<input name="mobile_phone" value="<%out.print(mobilePhone);%>"
					placeholder="Mobile phone" type="text" tabindex="9">
			</fieldset>
			<fieldset>
				<input name="home_phone" value="<%out.print(homePhone);%>"
					placeholder="Home phone" type="text" tabindex="9">
			</fieldset>
			<fieldset>
				<input name="professionnal_phone"
					value="<%out.print(professionnalPhone);%>"
					placeholder="Professionnal phone" type="text" tabindex="9">
			</fieldset>
			<fieldset>
				<button class="button special" name="submit" type="submit"
					id="contact-submit" data-submit="...Sending">Add</button>
			</fieldset>
			<fieldset>
				<button class="button special" name="reset" type="reset"
					id="contact-reset" data-submit="...reset">Reset</button>
			</fieldset>
			<fieldset>
				<button class="button special" name="return" type="button"
					onclick="location.href='accueil';">Return</button>
			</fieldset>
		</form>

	</div>

</body>
</html>