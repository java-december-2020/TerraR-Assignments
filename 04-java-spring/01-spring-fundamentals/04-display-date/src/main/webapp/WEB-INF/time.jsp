<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Time</title>
</head>
<body>
 <h1 id="time"><c:out value="${currentTime}"/></h1>
</body>
<script type="text/javascript" src="js/time_script.js"></script>
</html>