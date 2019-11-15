
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


<h1>liste des Bateau</h1>
 
    <table border='1'>
    <c:forEach items="${bateau}" var="b">
        <tr>
       
        <td> <c:out value="${b.id} "          />   <td/>
          <td> <c:out value="${b.name} "          />   <td/>
            <td> <c:out value="${b.type} "          />   <td/>
              <td> <c:out value="${b.size} "          />   <td/>
             
        </tr>
   
           
    </c:forEach>

 </table>
</body>
</html>