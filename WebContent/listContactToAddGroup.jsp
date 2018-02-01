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
	
	<ol start="My contacts">
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
		         		
		         		<img src="img/update.png" alt="detail contact" height="20" width="20" onclick="location.href='addToGroup?id=<% out.print(c.getContactId()); %>&idg=<%=request.getAttribute("id")%>';"> 
		         	</ul>
		         </li>
	     <%}
	      %>

	      </ul>
	   </li>  
	</ol>
	<button name="return" type="button" onclick="location.href='accueil';">return</button>
	</div>

</div>

</body>
</html>