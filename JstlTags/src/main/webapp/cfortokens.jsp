<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tags Example</title>
</head>
<body>
<c:forTokens items="Rahul-Nakul-Rajesh-Umesh-Mohnish" delims="-" var="name">
<p><c:out value="${name}"/></p>
</c:forTokens>
</body>
</html>