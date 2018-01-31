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
<body class="landing">
	<div id="page-wrapper">
		<%
			String firstName = (request.getAttribute("first_name") != null)
					? (String) request.getAttribute("first_name")
					: "";
			String lastName = (request.getAttribute("last_name") != null) ? (String) request.getAttribute("last_name")
					: "";
			String email = (request.getAttribute("email") != null) ? (String) request.getAttribute("email") : "";
			String streetNumber = (request.getAttribute("street_number") != null)
					? (String) request.getAttribute("street_number")
					: "";
			String streetType = (request.getAttribute("street_type") != null)
					? (String) request.getAttribute("street_type")
					: "";
			String streetName = (request.getAttribute("street_name") != null)
					? (String) request.getAttribute("street_name")
					: "";
			String codePostal = (request.getAttribute("code_postal") != null)
					? (String) request.getAttribute("code_postal")
					: "";
			String city = (request.getAttribute("city") != null) ? (String) request.getAttribute("city") : "";
			String country = (request.getAttribute("country") != null) ? (String) request.getAttribute("country") : "";
			String numSiret = (request.getAttribute("num_siret") != null)
					? (String) request.getAttribute("num_siret")
					: "";
			String errors = (request.getAttribute("errors") != null) ? (String) request.getAttribute("errors") : "";
		%>

		<div class="containerMenu">  
			<div class="menun">
			<form id="contact" action="addEntreprise" method="post">
				<h3>Ajouter un contact</h3>
				<h4 style="color: red;">
					<%
						out.print(errors);
					%>
				</h4>
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
					<input name="city" value="<%out.print(city);%>"
						placeholder="City" type="text" tabindex="7">
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
					<input name="num_siret" value="<%out.print(numSiret);%>"
						placeholder="Num Siret" type="text" tabindex="9">
				</fieldset>
				<br>
				<fieldset>
					<button class="button special" name="submit" type="submit" id="contact-submit"
						data-submit="...Sending"> Add </button>
				</fieldset>
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

		<!-- Footer -->
		<footer id="footer">
			<ul class="icons">
				<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
				<li><a href="#" class="icon fa-facebook"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon fa-instagram"><span
						class="label">Instagram</span></a></li>
			</ul>
			<ul class="copyright">
				<li>&copy; Untitled. All rights reserved.</li>
				<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
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