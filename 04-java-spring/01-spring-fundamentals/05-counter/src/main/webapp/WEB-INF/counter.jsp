<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current visit count</title>
</head>
<body>
	<p>You have visited <span>http://localhost:8080/</span><c:out value="${count}"/> times.</p>
	<p><span><a href="/">Test another visit?</a></span></p>
</body>
</html>