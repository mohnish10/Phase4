<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tag Example</title>
</head>
<body>
<h1>JSTL c:when, c:otherwise, c:choose</h1>

<c:set value="10" var="num"/>  
<c:choose>
<c:when test="${num%2==0}">
<c:out value="${num} is even number"/>
</c:when>
<c:otherwise>
<c:out value="${num} is a odd number"/>
</c:otherwise>
</c:choose>






















</body>
</html>