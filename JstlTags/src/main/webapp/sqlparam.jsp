<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.Date"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sql:dateParam tag</title>
</head>
<body>

<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/restfuldb" user="root" password="@theultimateone1"/>

<%-- <c:set var="shoe_id" value="7"/>	

<sql:update dataSource="${db}" var="count">  
DELETE FROM shoes WHERE shoe_id = ?  
 <sql:param value="${shoe_id}" />  
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
<td><c:out value="${table.size}"></c:out></td>
<td><c:out value="${table.price}"></c:out></td>
</tr>
</c:forEach>
</table> --%>

<%-- <% 
Date dob = new Date("2023/06/20");
int shoe_id=4;
%>


<sql:update dataSource="${db}" var="count">
Update shoes set dob=? where shoe_id=?
<sql:dateParam value="<%=dob%>" type="DATE"/> 
<sql:param value="<%=shoe_id%>"/>
</sql:update>


<sql:query dataSource="${db}" var="rs">
Select * from shoes;
</sql:query>


<table border="2" width="100%">
<tr>
<th>shoe_id</th>
<th>name</th>
<th>color</th>
<th>size</th>
<th>price</th>
<th>dob</th>
</tr>
<c:forEach var="table" items="${rs.rows}">
<tr>
<td><c:out value="${table.shoe_id}"></c:out></td>
<td><c:out value="${table.name}"></c:out></td>
<td><c:out value="${table.color}"></c:out></td>
<td><c:out value="${table.size}"></c:out></td>
<td><c:out value="${table.price}"></c:out></td>
<td><c:out value="${table.dob}"></c:out></td>
</tr>
</c:forEach>
</table> --%>


<%
Date dob = new Date("2023/06/20");
int shoe_id=4;
%>


<sql:transaction dataSource="${db}">
<sql:update var="count">
UPDATE shoes set dob="2023/05/28" where shoe_id=1
</sql:update>
<sql:update var="count">
UPDATE shoes set dob="2023/05/01" where shoe_id=2
</sql:update>
<sql:update var="count">
insert into shoes values('red','Myntra sneakers',7500.25,9,7,'2023/08/01');
</sql:update>
</sql:transaction>


<sql:query dataSource="${db}" var="rs">
select * from shoes;
</sql:query>


<table border="2" width="100%">
<tr>
<th>shoe_id</th>
<th>name</th>
<th>color</th>
<th>size</th>
<th>price</th>
<th>dob</th>
</tr>
<c:forEach var="table" items="${rs.rows}">
<tr>
<td><c:out value="${table.shoe_id}"></c:out></td>
<td><c:out value="${table.name}"></c:out></td>
<td><c:out value="${table.color}"></c:out></td>
<td><c:out value="${table.size}"></c:out></td>
<td><c:out value="${table.price}"></c:out></td>
<td><c:out value="${table.dob}"></c:out></td>
</tr>
</c:forEach>
</table>







</body>
</html>