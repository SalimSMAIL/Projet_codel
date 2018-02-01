<!DOCTYPE HTML>
<!--
	Alpha by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title></title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>

<%
String groupName = (request.getAttribute("group_name") != null)? (String) request.getAttribute("group_name") : "";
	String errors = (request.getAttribute("errors") != null) ? (String) request.getAttribute("errors") : "";
%>
<body class="landing">
	<div id="page-wrapper">
		
<% out.print(errors); %>
		<div class="containerMenu">  
			<div class="menun">
				<form action='addGroup' method='post'>
						<div class="row uniform">
									<div class="12u">
											<center><input type="text" name="group_name" value="<% out.print(groupName); %>" placeholder="Tape a text ..." /></center>
			
									</div>
								</div>
						<div class="row uniform">
									<div class="12u">
										<ul class="actions align-center">
											<li><input type="submit" value="Add a group" /></li>
										</ul>
									</div>
								</div>
								</form>
				<br>
				<fieldset>
					<button class="button special" name="reset" type="reset" id="contact-reset"
						data-submit="...reset">Reset</button>
				</fieldset>
				<br>
				<fieldset>
					<button class="button special" name="return" type="button" onclick="history.back()">Return</button>
				</fieldset>
			</form>

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