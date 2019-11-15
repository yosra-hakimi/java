<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion</title>
</head>
<body>

 <a href="./home">home</a> 
  <a href="./signin">signin</a> 
   <a href="./signup">signup</a> 
   <a href="./announcement">announcement</a>   
   <a href="./announcements">announcements</a> 
<br></br>
Connexion :
<br></br>
<form action="ConnectionController"  method="GET">

 E-mail: <br>
  <input type="email" name="email">
<br><br>
User password:<br>
<input type="password" name="psw">
<br><br>
  <input type="submit" value="Submit">
</form>

</body>
</html>