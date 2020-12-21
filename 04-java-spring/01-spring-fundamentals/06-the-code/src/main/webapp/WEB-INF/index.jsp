<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="style.css">
<title>Secret Code</title>
</head>

<body>
<div>
	<p><c:out value="${incorrect}" default="" />	</p>
	<h3>What is the code?</h3>
	<form action="/" method="POST">
		<input type="text" name="code" />
		<br/><br/>
		<button>Try Code</button>
	</form>
</div>
</body>
</html>