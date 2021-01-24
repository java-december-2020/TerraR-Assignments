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

<title>Welcome</title>
</head>
<body>

<div class="container">

<h1>Welcome</h1>

<fieldset class="fs-border box d-inline-block" id="left-box">
	<legend class="fs-legend"><b>Register</b></legend>

<form:form action="/registration" method="post" modelAttribute="user">

    <div class="form-group row">
        <form:label class="col-sm-3 col-form-label" path="first_name">First Name</form:label>
    	<div class="col-sm-9">
        	<form:input class="form-control" rows="5" cols="30" path="first_name"/>
    		<form:errors class="errors" path="first_name"/>
    	</div>
    </div>
    
    <div class="form-group row">
        <form:label class="col-sm-3 col-form-label" path="last_name">Last Name</form:label>
    	<div class="col-sm-9">
        	<form:input class="form-control" rows="5" cols="30" path="last_name"/>
    		<form:errors class="errors" path="last_name"/>
    	</div>
    </div>
    
    <div class="form-group row">
        <form:label class="col-sm-3 col-form-label" path="email">Email:</form:label>
    	<div class="col-sm-9">
        	<form:input class="form-control" rows="5" cols="30" type="email" path="email"/>
    		<form:errors class="errors" path="email"/>
    	</div>
    </div>
    
    <div class="form-group row">
        <form:label class="col-sm-3 col-form-label" path="location">Location:</form:label>
    	<div class="col-sm-6">
        	<form:input class="form-control" rows="5" cols="30" path="location"/>
    		<form:errors class="errors" path="location"/>
    	</div>
    	<div class="col-sm-3">
        	<form:select class="form-control" rows="5" cols="30" path="state">
				<c:forEach items="${state}" var="state">
					<form:option class="form-control" value="${state}">${state}</form:option>
				</c:forEach>
			</form:select>
    		<form:errors class="errors" path="state"/>
    	</div>
    </div>    
    
    <div class="form-group row">
        <form:label class="col-sm-3 col-form-label" path="password">Password:</form:label>
    	<div class="col-sm-9">
        	<form:input class="form-control" rows="5" cols="30" type="password" path="password"/>
    		<form:errors class="errors" path="password"/>
    	</div>
    </div>
    
    <div class="form-group row">
        <form:label class="col-sm-3 col-form-label" path="passwordConfirmation">PW Conf:</form:label>
    	<div class="col-sm-9">
        	<form:input class="form-control" rows="5" cols="30" type="password" path="passwordConfirmation"/>
    		<form:errors class="errors" path="passwordConfirmation"/>
    	</div>
    </div>
    
    <div class="form-group row">
    	<label class="col-sm-2 col-form-label"></label>
    	<div class="col-sm-10">
    		<input type="submit" class="btn btn-dark float-right" value="Register">
      	</div>
    </div>
</form:form>
</fieldset>


<fieldset class="fs-border box d-inline-block" id="left-box">
	<legend class="fs-legend"><b>Login</b></legend>

<form:form action="/login" method="post" modelAttribute="user">
    
    <div class="form-group row">
        <form:label class="col-sm-3 col-form-label" type="email" path="email">Email:</form:label>
    	<div class="col-sm-9">
        	<form:input class="form-control" rows="5" cols="30" path="email"/>
    		<form:errors class="errors" path="email"/>
    	</div>
    </div> 
    
    <div class="form-group row">
        <form:label class="col-sm-3 col-form-label" path="password">Password:</form:label>
    	<div class="col-sm-9">
        	<form:input class="form-control" rows="5" cols="30" type="password" path="password"/>
    		<form:errors class="errors" path="password"/>
    	</div>
    </div>
    
    <div class="form-group row">
    	<label class="col-sm-2 col-form-label"></label>
    	<div class="col-sm-10">
    		<input type="submit" class="btn btn-dark float-right" value="Login">
      	</div>
    </div>
</form:form>
</fieldset>



</div>


</body>
</html>