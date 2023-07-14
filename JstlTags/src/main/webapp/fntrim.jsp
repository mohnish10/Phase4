<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <c:set var="str1" value="Welcome to JSP        programming         "/>
<p>String-1 Length is:${fn:length(str1)}</p>


<%-- <c:set var="str2" value="${fn:trim(str1)}"/>
<p>String-2 Length is:${fn:length(str2)}</p>
<p>Final value of string is :${str2}</p> --%>


<%-- <c:set var="msg" value="The example of JSTL fn:startsWith function"/>
The string starts with "The": ${fn:startsWith(msg,'The')}
<br>The string starts with "Example": ${fn:startsWith(msg,'Example')} --%>


<%-- <c:set var="str1" value="Welcome-to-JSP-Programming."/>
<c:set var="str2" value="${fn:split(str1,'-')}"/>
<c:set var="str3" value="${fn:join(str2,'')}"/>


<p>String-3 : ${str3}</p>
<c:set var="str4" value="${fn:split(str3,'')}"/>
<c:set var="str5" value="${fn:join(str4,'-')}"/>


<p>String-5 : ${str5}</p> --%>


<%-- <c:set var="string" value="Welcome to JSP Programming"/>
${fn:toLowerCase("HELLO,")}
${fn:toLowerCase(string)} --%>


<%-- <c:set var="site" value="javatpoint.com"/>
<c:set var="author" value="Sonoo Jaiswal"/>
Hi, This is ${fn:toUpperCase(site)} developed by ${fn:toUpperCase(author)}.   --%>


<%-- <c:set var="string" value="This is the first string"/>
${fn:substring(string,5,17)} --%>


<%-- <c:set var="string" value="Nakul Jain"/>
${fn:substringAfter(string,"Nakul")}	 --%>


<%-- <c:set var="string" value="Hi, This is JAVATPOINT.COM developed by SONOO JAISWAL"/>
${fn:substringBefore(string,"developed")} --%>


<c:set var="str1" value="This is first string"/>
<c:set var="str2" value="Hello"/>
Length of the String-1 is: ${fn:length(str1)}<br>
Length of the String-2 is: ${fn:length(str2)}
 



</body>
</html>