<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sql:setDataSource Tag</title>
</head>
<body>

<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/restfuldb" user="root" password="@theultimateone1"/>

<%-- <sql:query dataSource="${db}" var="rs">Select * from shoes;</sql:query>

<table border="2" width="100%">
<tr align="center">
<th>shoe_id</th>
<th>name</th>
<th>color</th>
<th>size</th>
<th>price</th>
</tr>

<c:forEach var="table" items="${rs.rows}">
<tr>
<td><c:out value="${table.shoe_id}"></c:out></td>
<td><c:out value="${table.name}"></c:out></td>
<td><c:out value="${table.color}"></c:out></td>
<td><c:out value="${table.size}"></c:out></td>
<td><c:out value="${table.price}"></c:out></td>
</tr>
</c:forEach>
</table> --%>


<sql:update dataSource="${db}" var="count">
INSERT INTO shoes values('yellow','Bata school shoes',5000.5,6,7);
</sql:update>


<sql:query dataSource="${db}" var="rs">
Select * from shoes;
</sql:query>


<table border="1" width="100%">
<tr>
<th>shoe_id</th>
<th>name</th>
<th>color</th>
<th>size</th>
<th>price</th>
</tr>


<c:forEach var="table" items="${rs.rows}">
<tr>
<td><c:out value="${table.shoe_id}"></c:out></td>
<td><c:out value="${table.name}"></c:out></td>
<td><c:out value="${table.color}"></c:out></td>
<td><c:out value="${table.price}"></c:out></td>
<td><c:out value="${table.size}"></c:out></td>
</tr>
</c:forEach>
</table>


</body>
</html>