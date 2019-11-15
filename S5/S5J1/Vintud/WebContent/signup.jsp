<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
<body>

 <a href="./home">home</a> 
  <a href="./signin">signin</a> 
   <a href="./signup">signup</a> 
   <a href="./announcement">announcement</a>   
   <a href="./announcements">announcements</a> 
<br></br>
Inscription :
<br></br>
<form action="Servlet" target="_blank" method="GET">

  First name:<br>
  	<input type="text" name="firstname" value="Yosra">
  <br><br>
  
  Last name:<br>
  	<input type="text" name="lastname" value="Hakimi">
  <br><br>
  
  Pseudo:<br>
	<input type="text" name="userid">
 <br><br>
 
  E-mail: <br>
  <input type="email" name="email">
<br><br>
 
User password: <br>

<input type="password" name="psw">
 <br><br>
 
 Phone: <br>
 
  <input type="text" name="phone" value="">
  <br><br>
  
   Address: <br>
  <input type="text" name="address" value="">
  
  <br><br>
  
  <input type="submit" value="Submit">
  
</form>
</body>
</html>