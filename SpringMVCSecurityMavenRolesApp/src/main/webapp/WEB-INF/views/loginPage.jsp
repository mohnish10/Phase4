<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload='document.loginForm.username.focus();'>

<h3>JournalDev Tutorials</h3>

<c:if test="${not empty error}"><div>${error}</div></c:if>
<c:if test="${not empty message}"><div>${message}</div></c:if>


<form name="login" action="<c:url value='/loginPage'/>" method='POST'>
<table>
<tr>
<td>Username :</td>
<td><input type='text' name='username' value=''></td>
</tr>
<tr>
<td>Password</td>
<td><input type='password' name='password'></td>
</tr>
<tr>
<td colspan="2"><input name="submit" type="submit" value="submit"></td> 
</tr>
</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>