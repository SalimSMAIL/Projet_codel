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
			<form action='searchContact' method='post'>
				<fieldset>
					<input type="text" name="name" placeholder="Text to search ..." />
					<button class="button special" name="submit" type="submit"
						id="contact-submit" data-submit="...Sending">Search a
						contact</button>
				</fieldset>
			</form>
			<div class="line-separator"></div>
			<button name="displayContacts" type="button"
				onclick="location.href='contacts';">List contacts</button>
			<button name="addContact" type="button"
				onclick="location.href='addContact.jsp';">Add contact</button>
			<button name="addGroup" type="button"
				onclick="location.href='addGroup.jsp';">Add group</button>
			<button name="addEntreprise" type="button"
				onclick="location.href='addEntreprise.jsp';">Add entreprise</button>
			<div class="line-separator"></div>
			<h2>Repertorie</h2>
			<% for(int i=0; i<groups.size(); i++){ %>
			<button name="<% out.print(groups.get(i).getGroupName()); %>"
				type="button"
				onclick="location.href='contacts?id=<% out.print(groups.get(i).getGroupId()); %>';">
				<% out.print(groups.get(i).getGroupName()); %>
			</button>
			<% } %>
		</div>

	</div>
</body>
</html>