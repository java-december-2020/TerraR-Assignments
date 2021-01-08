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

<title>License dot com</title>
</head>
<body>

<div class="container">
	<h1>Welcome to License dot com!</h1>
	<br/><br/>
	<h3><a href="/persons/new">Create New Person</a></h3>
	<br/>
	<h3><a href="/licenses/new">Create New License</a></h3>
	<br/>
	<h3>Show License</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Show License</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${person}" var="person">
				<tr>
					<td>${person.firstName} ${person.lastName}</td>
					
					<c:if test='${not empty person.license}'>
						<td><a href="/persons/${person.id}">Show</a></td>
					</c:if>
					<c:if test= '${empty person.license}'>
						<td><a href="/licenses/new">Create</a></td>
					</c:if>
					
				</tr>
			</c:forEach>
			</tbody>
		</table>	
</div>



</body>
</html>