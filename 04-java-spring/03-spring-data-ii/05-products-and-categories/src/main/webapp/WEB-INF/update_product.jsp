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

<title>Product Page</title>
</head>
<body>

<div class="container">
	<h1>${product.name}</h1>
	<br/>
	
	<div class="main">
	<div class="box d-inline-block" id="left-box">
		<h3>Categories:</h3>
		<ul>
			<c:forEach items="${product.categories}" var="category">
				<li>${category.name}</li>
			</c:forEach>
		</ul>
	</div>

   <div class="box d-inline-block" id="right-box">
		<form action="/products/${product.id}" method="POST" name="category_id">
			<p>
				<label id="update-label" for="category_id">Add Category:</label>
				<select name="category_id">
					<c:forEach items="${category}" var="category">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<input id="btn" class="addbtn" type="submit" value="Add">
			</p>
		</form> 
	</div>
	</div>
</div>

</body>
</html>