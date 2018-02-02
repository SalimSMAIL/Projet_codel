<%@page import="com.codel.entities.Contact"%>
<%@page import="com.codel.entities.Address"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style1.css" />
<title>Insert title here</title>
</head>
<body>
	<% 
		Contact c = (Contact)request.getAttribute("details");
		Address a = c.getAddress();
	%>

	<div class="containerDetails">
		
		<div class="details">
		<h1>Details contact</h1>
			<fieldset>
				<p><b>Firstname : </b><% out.print(c.getFirstName()); %></p>
				<p><b>Lastname : </b><% out.print(c.getLastName()); %></p>
				<p><b>Email : </b><% out.print(c.getEmail()); %></p>
			</fieldset>
			<fieldset>
				<p><b>Address : </b><% out.print(a.getStreetName()+" "+a.getStreetType()+" "+a.getStreetName()+
						", "+a.getCodePostal()+" "+a.getCity()+", "+a.getCountry()+" "); %></p>
			</fieldset>
			<fieldset>
				<%if(c.getPhone("mobile")!=null){ %>
					<p><b>Mobile phone : </b><% out.print(c.getPhone("mobile").getPhoneNumber()); %>
						<img src="images/trashh.png" alt="detail contact" height="15" width="15" onclick="location.href='deletePhone?idp=<% out.print(c.getPhone("mobile").getPhoneId()); %>&id=<%out.print(c.getContactId());%>';"> 
					</p><%} %>
			</fieldset>
			<fieldset>
				<%if(c.getPhone("home")!=null){ %>
					<p><b>Home phone : </b><% out.print(c.getPhone("home").getPhoneNumber()); %>
						<img src="images/trashh.png" alt="detail contact" height="15" width="15" onclick="location.href='deletePhone?idp=<% out.print(c.getPhone("home").getPhoneId()); %>&id=<%out.print(c.getContactId());%>';"> 
					</p><%} %>
			</fieldset>
			<fieldset>
				<%if(c.getPhone("professionnal")!=null){ %>
					<p><b>Professionnal phone : </b><% out.print(c.getPhone("professionnal").getPhoneNumber()); %>
						<img src="images/trashh.png" alt="detail contact" height="15" width="15" onclick="location.href='deletePhone?idp=<% out.print(c.getPhone("professionnal").getPhoneId()); %>&id=<%out.print(c.getContactId());%>';"> 
					</p><%} %>
			</fieldset>

			<button name="return" type="button" onclick="window.history.go(-1);">Return</button>
		</div>
	</div>
</body>
</html>