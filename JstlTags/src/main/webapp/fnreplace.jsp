<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using JSTL function</title>
</head>
<body>
<c:set var="author" value="Ramesh Kumar"/>
<c:set var="string" value="pqr xyz abc PQR"/>
${fn:replace(author,"Ramesh","Suresh")}
${fn:replace(string,"pqr","hello")}
</body>
</html>