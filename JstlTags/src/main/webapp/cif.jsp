<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tag Example</title>
</head>
<body>
<c:set var="income" scope="session" value="${2000*10}"/>
<c:if test="${income>8000}">
<p>My income is: <c:out value="${income}"/></p>
</c:if>
</body>
</html>