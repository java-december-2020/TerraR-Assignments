<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
		$("#datepicker").datepicker({minDate : 1});
	});
</script>

</head>
<body>

<div class="container">

	<h1>Welcome, ${user.first_name}</h1>
	
	<a class="link" href="/logout">Logout</a>
	<br/>
	
	<h4>Here are some of the events in your state:</h4>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th class="thWidth" colspan="2">Action / Status</th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${events}" var="event">

			<c:if test="${user.state eq event.state}">
				<tr>
					<td><a href="/events/${event.id}">${event.name}</a></td>
					<td><fmt:formatDate pattern = "MMMM d, yyyy" value ="${event.date}" /></td>
					<td>${event.location}</td>
					<td>${event.host.first_name}</td>
					
					
					<c:choose>
						<c:when test="${user.id eq event.host.id}">
							<td><a href="/events/${event.id}/edit">Edit</a></td>
							<td
							 class="noBorder"><a href="/events/delete}">Delete</a></td>
						</c:when>
						
						<c:otherwise>
				
						<c:choose>
							<c:when test="${event.joiner.contains(user)}">
								<td><a href="/event/cancel/${event.id}">Joining</a></td>
								<td class="noBorder"><a href="/event/cancel/${event.id}">Cancel</a></td>
							</c:when>
							<c:otherwise>
								<td colspan="2"><a href="/event/join/${event.id}">Join</a></td>
							</c:otherwise>
						</c:choose>
						</c:otherwise>
					</c:choose>
					
				</tr>
			</c:if>
			</c:forEach>
			</tbody>
		</table>

		<br/><br/>

	<h4>Here are some of the events in other states:</h4>
	
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>Host</th>
					<th>Action</th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${events}" var="event">
			<c:if test="${user.state ne event.state}">
				<tr>
					<td><a href="/events/${event.id}">${event.name}</a></td>
					<td><fmt:formatDate pattern = "MMMM d, yyyy" value ="${event.date}" /></td>
					<td>${event.location}</td>
					<td>${event.host.first_name}</td>
					<td>
						<c:choose>
							<c:when test="${event.joiner.contains(user)}">
								<p>Joining<span><a class="join" href="/event/cancel/${event.id}">Cancel</a></span></p>
							</c:when>
							<c:otherwise>
								<a href="/event/join/${event.id}">Join</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:if>
			</c:forEach>
			</tbody>
		</table>		

		<br/><br/>

<h2>Create an Event</h2>
<form:form action="/events" method="post" modelAttribute="event">
    
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
        	<form:input class="form-control" rows="5" cols="30" id="datepicker" placeholder="MM/DD/YYYY" type="text" path="date" />
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
    		<input type="submit" class="btn btn-dark float-right" value="Submit">
      	</div>
    </div>
    
    <form:hidden path="host" value="${user.id}"/>
</form:form>

</div>

</body>
</html>