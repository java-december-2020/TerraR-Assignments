<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>Lookify!</title>
</head>
<body>

<div class="container">
<ul class="nav justify-content-center">
	<li class="nav-item">
	<a href="/songs/new">Add New</a>
	</li>
	<li class="nav-item">
	<a href="/search/topTen">Top Songs</a>
	</li>
	<li class="nav-item">
	<form action="/search" method="post">
		<input type="text" name="artistSearched">
		<input id="btn" type="submit" value="Search Artists">
	</form>
	</li>
</ul>

<table class="table table-striped">
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${song}" var="song">
        <tr>
            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/delete/${song.id}">delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</div>

</body>
</html>