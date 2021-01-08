<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<title>New Dojo</title>
</head>
<body>

<div class="container">
<h1>New Dojo</h1>

<form:form action="/dojos/new" method="POST" modelAttribute="dojo">
    <p>
        <form:label path="name">Name:</form:label>
        <form:errors path="name"/>
		<form:input path="name"/>
    </p> 
    <input id="btn" class="createbtn" type="submit" value="Create">
</form:form> 
</div>

</body>
</html>