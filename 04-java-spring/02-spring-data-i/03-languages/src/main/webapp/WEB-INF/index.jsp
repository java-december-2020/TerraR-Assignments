<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<title>Languages</title>
</head>
<body>

<div class="container">

<table class="table table-striped">
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${languages}" var="language">
        <tr>
            <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
            <td><c:out value="${language.creator}"/></td>
			<td><c:out value="${language.currentVersion}"/></td>
            <td>
            	<a href="/languages/delete/${language.id}">delete</a>
            	<a href="/languages/edit/${language.id}">edit</a>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<br/>

<form:form action="/languages" method="post" modelAttribute="language">
<div class="formDiv">
	<div>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
	</div>
	<br/>
    <div>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </div>
    <br/>
    <div>
        <form:label path="currentVersion">Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </div>
    <br/>
    <button class="btn btn-outline-primary">Submit</button>
</div>
</form:form> 
</div>

</body>
</html>