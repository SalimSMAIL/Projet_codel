<%@page import="com.codel.entities.ContactGroup"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<!--
	Alpha by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<head>
		<title> </title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<style type="text/css">

    #conteneur {
      position: relative;
      margin: 0 auto;
      width: 760px;
      border : 1px solid #fff;
      background: #ffd url(http://sitedemikadooshop.free.fr/fond_20.jpg) no-repeat center;
      }
    </style>
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body class="landing">
	
		<div id="page-wrapper">
			<!-- Banner -->
			<div class="containerMenu">  
			<div class="menun">
				
				<center><p><span class="image featured">
							<img src="images/group.png" alt="group" />
							</span></p></center>
					
					<br>
					<ul>	
						<form action='searchContact' method='post'>
						<div class="row uniform">
									<div class="12u">
											<center><input type="text" name="name" placeholder="Tape a text ..." /></center>
			
									</div>
								</div>
						<div class="row uniform">
									<div class="12u">
										<ul class="actions align-center">
											<li><input type="submit" value="Search a contact" /></li>
										</ul>
									</div>
								</div>
								</form>
								<br>
								
						<a onclick="location.href='group';" class="button special"><center>Display all contacts</center></a>
						<br><br>
						<a onclick="location.href='addContact.jsp';" class="button special"><center> Add a contact</center></a>
						<br><br>
						<a onclick="location.href='addEntreprise.jsp';" class="button special"><center>Add an entreprise</center></a>
						<br><br>
<!-- 						<a onclick="location.href='home.html';"><center><b>return</b></center></a>
						<br><br> -->
											</lu>
											<div class="line-separator"></div>
											<h3> Mes groupes </h3>
											<%
	List<ContactGroup> groups = (List<ContactGroup>) request.getSession().getAttribute("contactGroups");
%>
											<% for(int i=0; i<groups.size(); i++){ %>
									<div class="row uniform">
									<div class="12u">
      								<a name="<% out.print(groups.get(i).getGroupName()); %>"
      								 type="button" onclick="location.href='displayContactGroup?id=<% out.print(groups.get(i).getGroupId()); %>';">
      								 <% out.print(groups.get(i).getGroupName()); %></a>
      								 </div></div><br>
      <% } %>
											
		
			</div></div>
			

			<!-- Footer -->
				<footer id="footer">
					<ul class="icons">
						<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
					</ul>
					<ul class="copyright">
						<li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
					</ul>
				</footer>

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