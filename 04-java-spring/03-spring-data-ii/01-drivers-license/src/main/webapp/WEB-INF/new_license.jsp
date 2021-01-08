<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">

<!--  jQuery -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!--  Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<!--  CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />

<title>New License</title>

<script>
	$(function () {
		$("#datepicker").datepicker();
	});
</script>

</head>

<body>

<div class="container-fluid">
<h1>New License</h1>
<br/>
<form:form action="/licenses/new" method="POST" modelAttribute="license">
	<p>
		<form:label path="person.id">Person:</form:label>
		<form:errors path="person.id"/>
		<form:select path="person.id">
			<c:forEach items="${person}" var="person">
				<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
			</c:forEach>
		</form:select>
	</p>

	<p>
		<form:label path="state">State</form:label>
		<form:errors path="state"/>
		<form:input path="state"/>
   </p>
    
	<p>
		<form:label path="expiration_date">Expiration Date:</form:label>
		<form:errors path="expiration_date"/>
		<form:input id="datepicker" placeholder="MM/DD/YYYY" type="text" path="expiration_date"/>
    </p>

	<p>
		<input id="btn" class="addbtn" type="submit" value="Create">
	</p>
</form:form> 
</div>

</body>
</html>