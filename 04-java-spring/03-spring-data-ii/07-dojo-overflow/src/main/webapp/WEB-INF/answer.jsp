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

<title>Question Profile</title>
</head>
<body>

 <div class="container">
	<h1>${question.question_asked}</h1>
	<br/>
	
	<div class="nav">
		<h3 class=answerh3>Tags:</h3>
		<ul class="list-group list-group-horizontal">
			<c:forEach items="${question.tags}" var="tag" >
				<li class="borderlist">${tag.subject}</li>
			</c:forEach>
		</ul>
	</div>
		
	<br/>

<div class="main">

	<div class="box d-inline-block" id="left-box">
		<table class="table table-striped">
			<thead>
				<tr><th>Answers</th></tr>
			</thead>
			
			<tbody>
				<c:forEach items="${answers}" var="answer">
					<tr>	
						<td>${answer.answer_submitted}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

   	<div class="box d-inline-block" id="right-box">
		<h3>Add your answer:</h3>
		
		<form:form action="/questions/${question.id}" method="POST" modelAttribute="answer">

    		<div class="row mb-3">
				<form:label class="col-sm-2 col-form-label" path="answer_submitted">Answer:</form:label>
    			<div>
        			<form:textarea class="form-control" rows="4" cols="36" path="answer_submitted"/>
        			<form:errors class="errors" path="answer_submitted"/>
    			</div>
    		</div>

    		<div>
    				<input class="btn btn-outline-dark float-right" type="submit" value="Answer it!">
    		</div>
		
		</form:form>
		 
	</div>
</div>
</div>
</body>
</html>