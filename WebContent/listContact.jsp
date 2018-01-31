<%@page import="com.codel.entities.ContactGroup"%>
<%@page import="com.codel.entities.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title></title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>
<body class="landing">
	<div id="page-wrapper">


<%

	List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");

%>
<div class="containerMenu"> 
<div class="containerList">  
	<div class="menun">
	<div class="list">
	<h1>List contacts</h1>
	
	<ol start="Mes contacts">
	   
	      <ul>
	      
	      <%
	      if(contacts != null)
	      	for(Contact c: contacts){
	      	%>
	      	
		         	<ul>
		         	<div class="containerList">
		         		<% out.print(c.getFirstName()+"     "+c.getLastName()+"  "+c.getEmail());  %>
		         		
		         		<img src="images/update.png" alt="detail contact" height="20" width="20" onclick="location.href='update?id=<% out.print(c.getContactId()); %>';"> 
		         		<img src="images/trashh.png" alt="detail contact" height="20" width="20" onclick="location.href='delete?id=<% out.print(c.getContactId()); if( request.getAttribute("id") != null) out.print("&group="+request.getAttribute("id"));%>';"> 
		         		<img src="images/resume.png" alt="detail contact" height="20" width="20" onclick="location.href='details?id=<% out.print(c.getContactId()); %>';"> 
		         	</div>
		         	</ul>
	
	     <%}
	      %>

	      </ul>
	 
	</ol>
	<%if( request.getAttribute("id") != null){ %>
	<button name="emptyGroup" type="button" onclick="location.href='emptygroup?id=<% out.print(request.getAttribute("id")); %>';">Empty</button>
	<button name="emptyGroup" type="button" onclick="location.href='deleteGroup?id=<% out.print(request.getAttribute("id")); %>';">Delete</button>
	<% } %>
	<button name="return" type="button" onclick="location.href='accueil';">return</button>
	</div>
</div>
</div>
</div>
</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.dropotron.min.js"></script>
	<script src="assets/js/jquery.scrollgress.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

</body>
</html>