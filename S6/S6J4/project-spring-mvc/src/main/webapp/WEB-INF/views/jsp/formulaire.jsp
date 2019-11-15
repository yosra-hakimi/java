



<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!-- controle, iterations, tests, variables -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- traitement XML -->
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!-- formattage des donnees -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- SQL/JDBC -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>




<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form method="post" >

 ID:<br>
  <input type="text" name="id" value="<c:out value="${param.id}"/>">
  <br>
  FIRSTNAME: <br>
  <input type="text" name="firstName" value="<c:out value="${param.firstName}"/>">
  <br>
 LASTNAME : <br>
  <input type="text" name="lastName" value="<c:out value="${param.lastName}"/>">
  <br>
  Config:<br>
  <input type="text" name="config" value="<c:out value="${param.config}"/>">
  <br>
  BateauID:<br>
  <input type="text" name="bateau_id" value="<c:out value="${param.bateau_id}"/>">
  <br><br>
  <input type="submit" value="Submit">
</form>



</body>
</html>