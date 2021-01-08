<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<title>Welcome</title>
</head>
<body>

<div class="container">

	<h1>Dojo and Ninja Tracking Application</h1>
	<br/><br/>
	
	<nav class="nav">	
		<a class="nav-link" href="/dojos/new">Create New Dojo</a>
		<a class="nav-link" href="/ninjas/new">Create New Ninja</a>
	</nav>
	<br/><br/>
	
	<h3>Show Ninjas by Location</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Dojo Name</th>
					<th>Show Ninjas</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${dojo}" var="dojo">
				<tr>
					<td>${dojo.name}</td>				
					
					<c:if test='${not empty dojo.ninjas}'>
						<td><a href="/dojos/${dojo.id}">Show</a></td>
					</c:if>
					<c:if test= '${empty dojo.ninjas}'>
						<td><a href="/ninjas/new">Create</a></td>
					</c:if>
				</tr>
			</c:forEach>
			</tbody>
		</table>	
</div>

</body>
</html>