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

<title>Products and Categories</title>
</head>
<body>

<div class="container">
	<h1>Products and Categories Application</h1>
	<br/><br/>
	
	<nav class="nav">
		<a class="nav-link" href="/products/new">Create New Product</a>
		<a class="nav-link" href="/categories/new">Create New Category</a>
	</nav>
	<br/> <br/>
	
	<h3>Product Listing</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Categories</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${product}" var="product">
				<tr>
					<td>${product.name}</td>				
					
					<c:if test='${not empty product.categories}'>
						<td><a href="/products/${product.id}">Show</a></td>
					</c:if>
					<c:if test= '${empty product.categories}'>
						<td><a href="/products/${product.id}">Add Categories</a></td>
					</c:if>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
	<br/>
	<h3>Category Listing</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Category Name</th>
					<th>Product</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${category}" var="category">
				<tr>
					<td>${category.name}</td>				
					
					<c:if test='${not empty category.products}'>
						<td><a href="/categories/${category.id}">Show</a></td>
					</c:if>
					<c:if test= '${empty category.products}'>
						<td><a href="/categories/${category.id}">Add Products</a></td>
					</c:if>
				</tr>
			</c:forEach>
			</tbody>
		</table>		
</div>


</body>
</html>