<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style1.css" />
<title>Ajouter groupe</title>
</head>
<body>
	<%
	String groupName = (request.getAttribute("group_name") != null)? (String) request.getAttribute("group_name") : "";
	String errors = (request.getAttribute("errors") != null) ? (String) request.getAttribute("errors") : "";
%>
	<div class="container">
		<form id="contact" action="addGroup" method="post">
			<h3>Ajouter un groupe</h3>
			<h4 style="color: red;">
				<%
							out.print(errors);
						%>
			</h4>
			<fieldset>
				<input name="group_name" value="<%out.print(groupName);%>"
					placeholder="group name" type="text" tabindex="1">
			</fieldset>
			<fieldset>
				<button class="button special" name="submit" type="submit"
					id="contact-submit" data-submit="...Sending">Add</button>
			</fieldset>
			<fieldset>
				<button class="button special" name="reset" type="reset"
					id="contact-reset" data-submit="...reset">Reset</button>
			</fieldset>
			<fieldset>
				<button class="button special" name="return" type="button"
					onclick="location.href='accueil';">Return</button>
			</fieldset>
		</form>

	</div>

</body>
</html>