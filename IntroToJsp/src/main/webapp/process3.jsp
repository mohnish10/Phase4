<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="u" class="com.mohnish.User"></jsp:useBean>
<% String name="arjun"; %>  
<jsp:setProperty property="name" name="u" value="<%=name %>"/>  

Record:<br>
<jsp:getProperty property="name" name="u"/><br>
</body>
</html>