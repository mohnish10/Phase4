<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>First JSP</h1>
<%
Cookie ck = new Cookie("name","mohnish");
response.addCookie(ck);
%>
<a href="process6.jsp">Click</a>  
</body>
</html>