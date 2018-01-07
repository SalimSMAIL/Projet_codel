<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ajouter contact</title>
</head>
<body>
<section class="container">
    <div class="create">
      <h1>Veuillez remplir le formulaire : </h1>
      <form method="post" action="add">
        <p><label for="Nom">Nom : </label><input type="text" name="last_name" value="" placeholder="Nom"></p>
        <p><label for="Prenom">Prenom : </label><input type="text" name="first_name" value="" placeholder="Prenom"></p>
        <p><label for="email">Email : </label><input type="email" name="email" value="" placeholder="Email"></p>
        
        <p><label for="address">Adresse : </label>
        <input type="number" name="number_street" value="" placeholder="N&deg;" min="1" max="999">
       <select name="type_street">
           <option value="rue" selected>Rue</option>
           <option value="boulevard">Boulevard</option>
           <option value="avenue">Avenue</option>
       </select>
        <input type="text" name="street" value="" placeholder="Nom de rue">
        <input type="text" name="city" value="" placeholder="Ville">
        <input type="text" name="code_postal" value="" placeholder="Code Postal">
        <input type="text" name="country" value="" placeholder="Pays">
        </p>

        <p><input type="tel" name="mobile_phone" value="" placeholder="Telephone mobile"></p>

        <p><input type="tel" name="fixed_phone" value="" placeholder="Telephone fixe"></p>

        <p><input type="submit" name="submit" value="add"><input type="reset" name="reset" value="reset"></p>
      </form>
    </div>
  </section>
</body>
</html>