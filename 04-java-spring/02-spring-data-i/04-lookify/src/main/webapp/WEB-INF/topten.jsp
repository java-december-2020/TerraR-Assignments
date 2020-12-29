<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>Search</title>
</head>
<body>

<div class="container">
<ul class="nav">
	<li class="nav-item">
		<h4>Top Ten Songs:</h4>
	</li>
	<li class="nav-item">
		<a class="nav-spacer" href="/dashboard">Dashboard</a>
	</li>
</ul>

<div id="topten">
	<c:forEach items="${song}" var="song">
		<p>${song.rating} - <a href="/songs/${song.id}">${song.title} - ${song.artist}</a></p>
	</c:forEach>
</div>
</div>

</body>
</html>