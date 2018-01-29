<%@page import="com.codel.entities.ContactGroup"%>
<%@page import="com.codel.entities.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style1.css" />
<title>Contacts</title>
</head>
<body>

<%

	List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");

%>

<div class="containerList">  
	
	<div class="list">
	<h1>List contacts</h1>
	
	<ol start="Mes contacts">
	   <li>
	      <ul>
	      
	      <%
	      if(contacts != null)
	      	for(Contact c: contacts){
	      	%>
	      	
		         <li>
		         	<ul>
		         		<li><% out.print(c.getFirstName()); %></li>
		         		<li><% out.print(c.getLastName()); %></li>
		         		<li><% out.print(c.getEmail()); %></li>
		         		
		         		<img src="img/update.png" alt="detail contact" height="20" width="20" onclick="location.href='update?id=<% out.print(c.getContactId()); %>';"> 
		         		<img src="img/delete.ico" alt="detail contact" height="20" width="20" onclick="location.href='delete?id=<% out.print(c.getContactId()); if( request.getAttribute("id") != null) out.print("&group="+request.getAttribute("id"));%>';"> 
		         		<img src="img/detail.ico" alt="detail contact" height="20" width="20" onclick="location.href='delail?id=<% out.print(c.getContactId()); %>';"> 
		         	</ul>
		         </li>
	     <%}
	      %>

	      </ul>
	   </li>  
	</ol>
	<%if( request.getAttribute("id") != null){ %>
	<button name="emptyGroup" type="button" onclick="location.href='emptygroup?id=<% out.print(request.getAttribute("id")); %>';">Empty</button>
	<button name="emptyGroup" type="button" onclick="location.href='deleteGroup?id=<% out.print(request.getAttribute("id")); %>';">Delete</button>
	<% } %>
	<button name="return" type="button" onclick="location.href='accueil';">return</button>
	</div>

</div>

</body>
</html>