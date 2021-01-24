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
<!--  
<script>
	$(function () {
		return document.title = ${event_name};
	});
</script>
-->

<title>${event.name}</title>
</head>
<body>

 <div class="container">
 	<h1>${event.name}</h1>
 	<br/>
 	
 	<div class="box d-inline-block" id="left-box">
		<p>Host:   ${event.host.first_name} ${event.host.last_name}</p>
		<p>Date:   <fmt:formatDate pattern = "MMMM d, yyyy" value ="${event.date}" /></p>
		<p>Location:   ${event.location}, ${event.state}</p>
		<p>People who are attending this event: ${event.joiner.size()}</p>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Name</th>
					<th>Location</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${event.joiner}" var="joiner">
					<tr>
						<td>${joiner.first_name} ${joiner.last_name}</td>
						<td>${joiner.location}</td>	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

   	<div class="box d-inline-block" id="right-box">
		<h3>Message Wall</h3>
		
		<div id="outer" class="card overflow-auto row mb-12 h-10">
  			<div id="message" class="card-body">

    			<c:forEach items="${comments}" var="comment">

				<c:if test="${event.id eq comment.event.id}">
						<c:if test="${user.id eq comment.commenter.id}">
							<p><b>${comment.commenter.first_name} says:</b>  ${comment.message}</p>
						</c:if>

						<c:if test="${user.id ne comment.commenter.id}">
							<p><b>${comment.commenter.first_name} ${comment.commenter.last_name}:</b>  ${comment.message}</p>
						</c:if>
						<p>--------------------------------</p>
				</c:if>
				
				</c:forEach>
				
  			</div>
		</div>
		
		<br/>
		<form action="/events/${event.id}" method="POST">

    		<div class="row mb-12">
				<label class="col-form-label">Add Comment:</label>
        			<textarea class="form-control" rows="2" cols="25" name="message"></textarea>
    		</div>

    		<div>
    			<br/>
    			<input class="btn btn-outline-dark float-right" type="submit" value="Submit">
    		</div>
		
		</form>
		 
	</div>

</div>

</body>
</html>