<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<title>Edit Language</title>
</head>
<body>

<div class="container">

<a href="/languages/delete/${language.id}">Delete</a>
<a href="/languages">Dashboard</a>

<form:form action="/languages/update/${language.id}" method="post" modelAttribute="language">
<div>
	<div>
        <form:label path="name">Name
        <form:errors path="name"/>
        <form:input path="name"/>
        </form:label>
    </div>
    <div>
        <form:label path="creator">Creator
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
        </form:label>
    </div>
    <div>
        <form:label path="currentVersion">Version
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
        </form:label>
    </div>   
    <button class="btn btn-outline-primary">Submit</button>
</div>
</form:form> 
</div>

</body>
</html>