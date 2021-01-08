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

<title>New Product</title>
</head>
<body>

<div class="container">
<h1>New Product</h1>
<br/>
<form:form action="/products/new" method="POST" modelAttribute="product">
	<p>
		<form:label class="labelAlign" path="name">Name:</form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
   </p>
    
	<p>
		<form:label class="labelAlign" path="description">Description:</form:label>
		<form:errors path="description"/>
		<form:textarea path="description"/>
   </p>
   
   	<p>
		<form:label class="labelAlign" path="price">Price:</form:label>
		<form:errors path="price"/>
		<form:input path="price"/>
   </p>

	<p>
		<input id="btn" class="createbtn" type="submit" value="Create">
	</p>
</form:form> 
</div>

</body>
</html>