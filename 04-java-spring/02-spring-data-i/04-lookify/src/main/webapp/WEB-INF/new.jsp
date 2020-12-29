<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>Add Song</title>
</head>
<body>

<div class="container">
<ul class="nav">
	<li class="nav-item">
		<a class="nav-spacer" href="/dashboard">Dashboard</a>
	</li>
</ul>

<form:form action="/songs/new" method="post" modelAttribute="song">
    <p>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:input path="artist"/>
    </p>
    <p>
	<form:label path="rating">Rating (1-10)</form:label>
	<form:errors path="rating"/>
	<form:select path="rating">
		<form:option value="1">1</form:option>
		<form:option value="2">2</form:option>
		<form:option value="3">3</form:option>
		<form:option value="4">4</form:option>
		<form:option value="5">5</form:option>
		<form:option value="6">6</form:option>
		<form:option value="7">7</form:option>
		<form:option value="8">8</form:option>
		<form:option value="9">9</form:option>
		<form:option value="10">10</form:option>
	</form:select>
    </p>   
    <input id="btn" class="addbtn" type="submit" value="Add Song">
</form:form> 
</div>

</body>
</html>