<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:formatDate pattern = "dd/MM/yyyy" value ="${event.date}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!--  jQuery -->
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<title>Events</title>

<script>
	$(function () {
		$("#datepicker").datepicker();
	});
</script>

</head>
<body>

<div class="container">
<h1>GoT Party</h1>
<br/>
<h2>Edit Event</h2>
<form:form action="/events/${event.id}/edit" method="post" modelAttribute="event">
    
    <div class="form-group row">
        <form:label class="col-sm-1 col-form-label" path="name">Name</form:label>
    	<div class="col-sm-4">
        	<form:input class="form-control" rows="5" cols="30" path="name"/>
    		<form:errors class="errors" path="name"/>
    	</div>
    </div> 
    
    <div class="form-group row">
        <form:label class="col-sm-1 col-form-label" path="date">Date</form:label>
    	<div class="col-sm-4">
        	<form:input class="form-control" rows="5" cols="30" id="datepicker" placeholder="MM/DD/YYYY" type="text" path="date"/>
    		<form:errors class="errors" path="date"/>
    	</div>
    </div>
    
    <div class="form-group row">
        <form:label class="col-sm-1 col-form-label" path="location">Location:</form:label>
    	<div class="col-sm-3">
        	<form:input class="form-control" rows="5" cols="30" path="location"/>
    		<form:errors class="errors" path="location"/>
    	</div>
    	<div class="col-sm-1">
        	<form:select class="form-control" rows="5" cols="30" path="state">
				<c:forEach items="${state}" var="state">
					<form:option class="form-control" value="${state}">${state}</form:option>
				</c:forEach>
			</form:select>
    		<form:errors class="errors" path="state"/>
    	</div>
    </div>   
    
    <div class="form-group row">
    	<label class="col-sm-1 col-form-label"></label>
    	<div class="col-sm-4">
    		<input type="submit" class="btn btn-dark float-right" value="Edit">
      	</div>
    </div>
</form:form>

</div>

</body>
</html>