<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tag Example</title>
</head>
<body>
<c:import var="data" url="http://www.google.com"/>
<c:out value="${data}"/>
</body>
</html>