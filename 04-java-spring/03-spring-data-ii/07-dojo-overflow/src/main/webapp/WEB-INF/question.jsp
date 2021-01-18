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

<title>New Question</title>
</head>
<body>

<div class="container">

	<h1>What is your question?</h1>
	<br/>

	<form:form action="/questions/new" method="POST" modelAttribute="questionTag">
	
    <div class="form-group row">
		<form:label class="col-sm-1 col-form-label" path="question_asked">Question:</form:label>
    	<div class="col-sm-5">
        	<form:textarea class="form-control" rows="5" cols="30" path="question_asked"/>
        	<form:errors class="errors" path="question_asked"/>
    	</div>
    </div>

    <div class="form-group row">
	<form:label class="col-sm-1 col-form-label" path="subject">Tags:</form:label>
    	<div class="col-sm-3">
        	<form:input class="form-control" path="subject"/>
        	<form:errors class="errors" path="subject"/>
    	</div>
    </div>

    <div class="form-group row">
    	<label class="col-sm-1 col-form-label"></label>
    	<div class="col-sm-5">
    		<input class="btn btn-outline-dark float-right" type="submit" value="Submit">
      	</div>
    </div>
		
	</form:form> 

</div>

</body>
</html>