<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<title>New Ninja</title>
</head>
<body>

<div class="container">
<h1>New Ninja</h1>
<br/>
<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
	<p>
		<form:label path="dojo.id">Dojo:</form:label>
		<form:errors path="dojo.id"/>
		<form:select path="dojo.id">
			<c:forEach items="${dojo}" var="dojo">
				<form:option value="${dojo.id}">${dojo.name}</form:option>
			</c:forEach>
		</form:select>
	</p>

	<p>
		<form:label path="firstName">First Name:</form:label>
		<form:errors path="firstName"/>
		<form:input path="firstName"/>
   </p>
    
    <p>
		<form:label path="lastName">Last Name:</form:label>
		<form:errors path="lastName"/>
		<form:input path="lastName"/>
   </p>
    
    <p>
		<form:label path="age">Age:</form:label>
		<form:errors path="age"/>
		<form:input path="age"/>
   </p>

	<p>
		<input id="btn" class="createbtn" type="submit" value="Create">
	</p>
</form:form> 
</div>

</body>
</html>