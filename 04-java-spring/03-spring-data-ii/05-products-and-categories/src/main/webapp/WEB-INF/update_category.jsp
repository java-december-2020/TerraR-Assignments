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

<title>Category Page</title>
</head>
<body>

<div class="container">
	<h1>${category.name}</h1>
	<br/>
	
	<div class="main">
	<div class="box d-inline-block" id="left-box">
		<h3>Products:</h3>
		<ul>
			<c:forEach items="${category.products}" var="product">
				<li>${product.name}</li>
			</c:forEach>
		</ul>
	</div>
	
	<div class="box d-inline-block" id="right-box">
		<form action="/categories/${category.id}" method="POST" name="product_id">
			<p>
				<label id="update-label" for="product_id">Add Product:</label>
				<select name="product_id">
					<c:forEach items="${product}" var="product">
						<option value="${product.id}">${product.name}</option>
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