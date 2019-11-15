
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


<h1>liste des moussaillons By ID </h1>
<table border='1'>

     <tr>

       
        <td> <c:out value="${moussaillons.id} "          />   <td/>
          <td> <c:out value="${moussaillons.firstName} "          />   <td/>
            <td> <c:out value="${moussaillons.lastName} "          />   <td/>
              <td> <c:out value="${moussaillons.config} "          />   <td/>
              <td> <c:out value="${moussaillons.bateau_id} "          />   <td/>
             
        </tr>

 </table>
</body>
</html>