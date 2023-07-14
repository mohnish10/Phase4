<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tag Example</title>
</head>
<body>

<%-- <c:url value="/index1.jsp" var="completeURL">
<c:param name="trackingId" value="786"/>
<c:param name="user" value="Nakul"/>
</c:url>
${completeURL}	 --%>



<%-- <c:set var="url" value="2" scope="request"/> 
<c:if test="${url<1}">
<c:redirect url="http://javatpoint.com"/>
</c:if>
<c:if test="${url>1}">
<c:redirect url="http://facebook.com"/>
</c:if> --%>


<c:url value="/RegisterDao.jsp"/>






</body>
</html>