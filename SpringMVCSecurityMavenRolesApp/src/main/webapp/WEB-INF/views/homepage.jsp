<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome to JournalDev Tutorials</h3>
<ul>
<li>Java 8 tutorial</li>
<li>Spring tutorial</li>
<li>Gradle tutorial</li>
<li>BigData tutorial</li>
</ul>

<c:url value="/logout" var="logoutUrl"/>
<form id="logout" action="${logoutUrl}" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<c:if test="${pageContext.request.userPrincipal.name!=null}">
<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</c:if>
</body>
</html>