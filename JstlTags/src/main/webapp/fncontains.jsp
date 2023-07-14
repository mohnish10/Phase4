<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored = "false" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Using JSTL functions</title>
</head>
<body>

<%-- <c:set var="String" value="Welcome to Javatpoint"/>
<cif test="${fn:contains(String,'Javatpoint')}">
<p>Found Javatpoint string</p>
</cif>
<c:if test="${fn:contains(String,'javatpoint')}">
<p>Found javatpoint string</p>
</c:if> --%>


<%-- <c:set var="String" value="Welcome to Javatpoint"/>

<c:if test="${fn:containsIgnoreCase(String,'Javatpoint')}">
<p>Found Javatpoint String</p>
</c:if>

<c:if test="${fn:containsIgnoreCase(String,'JAVATPOINT')}">
<p>Found JAVATPOINT String</p>
</c:if> --%>


<%-- <c:set var="String" value="Welcome to JSP programming"/> --%>

<%-- <c:if test="${fn:endsWith(String,'programming')}">
<p>String ends with programming</p>
</c:if>


<c:if test="${fn:endsWith(String,'JSP')}">
<p>String ends with JSP</p>
</c:if> --%>


<%-- <c:set var="string1" value="It is first String"/>
<c:set var="string2" value="It is <xyz>second String.</xyz>"/>


<p>With escapeXml() function.</p>
<p>string-1 : ${fn:escapeXml(string1)}</p>
<p>string-2 : ${fn:escapeXml(string2)}</p>


<p>Without escapeXml() function.</p>
<p>string-1 : ${string1}</p>
<p>string-2 : ${string2}</p>  --%>


<c:set var="string1" value="It is first string"/>
<c:set var="string2" value="It is <xyz>second string"/>


<p>Index-1: ${fn:indexOf(string1,"first")}</p>
<p>Index-2: ${fn:indexOf(string2,"second")}</p>










</body>
</html>