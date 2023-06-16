<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("uname");
out.print("welcome " +name);
%>
<br><br>
<%= "welcome to jsp" %>
<br><br>
Current Time: <%= java.util.Calendar.getInstance().getTime() %>
</body>
</html>