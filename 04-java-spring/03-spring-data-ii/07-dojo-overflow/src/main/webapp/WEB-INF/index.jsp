<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<title>Questions Dashboard</title>
</head>
<body>

<div class="container">

	<h1>Questions Dashboard</h1>
	<br/>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Question</th>
					<th class="text-center">Tags</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${question}" var="question">
				<tr>
					<td><a href="/questions/${question.id}">${question.question_asked}</a></td>

					<c:forEach items="${question.tags}" var="tag" varStatus="status">
						<c:choose>
					    	<c:when test="${not status.last}">
								<c:set value = " ${tagString} ${tag.subject}${empty tag.subject ? '' : ','}" var = "tagString" />
					    	</c:when>    
					    	<c:otherwise>
								<c:set value = " ${tagString} ${tag.subject}" var = "tagString" />
					    	</c:otherwise>
						</c:choose>
					</c:forEach>

					<td>${tagString}</td>
					<c:remove var = "tagString"/>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<a class="link" href="/questions/new">New Question</a>
</div>


</body>
</html>