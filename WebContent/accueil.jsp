<%@page import="com.codel.entities.ContactGroup"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style1.css" />
<title>Accueil</title>
</head>
<body>
	
<%

	List<ContactGroup> groups = (List<ContactGroup>) request.getSession().getAttribute("contactGroups");

%>

<div class="containerMenu">  
	
	<div class="menu">
	<h1>Menu</h1>
      <button name="displayContacts" type="button" onclick="displayContacts">Display contacts</button>
      <button name="searchContact" type="button" onclick="location.href='searchContact.jsp';">Search contact</button>
      <button name="addContact" type="button" onclick="location.href='addContact.jsp';">Add contact</button>
      <div class="line-separator"></div>
      <h2>Repertorie</h2>
      <% for(int i=0; i<groups.size(); i++){ %>	
      	<button name="<% out.print(groups.get(i).getGroupName()); %>" type="button" onclick="location.href='group?id=<% out.print(groups.get(i).getGroupId()); %>';"><% out.print(groups.get(i).getGroupName()); %></button>
      <% } %>
	</div>

</div>
</body>
</html>