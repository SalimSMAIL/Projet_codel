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
		

		<div class="containerMenu">  
			<div class="menun">
			<form id="contact" action="add" method="post">
				<h3>Ajouter un nouveau groupe</h3>
				<fieldset>
					<input name="first_name" value="<%out.print(firstName);%>"
						placeholder="Firstname" type="text" tabindex="1">
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