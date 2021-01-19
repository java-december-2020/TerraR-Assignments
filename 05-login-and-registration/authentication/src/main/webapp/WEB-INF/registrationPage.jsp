<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>Registration Page</title>
</head>
<body>
<div class="container">
    <h1>Register!</h1>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="email">Email:</form:label>
            <form:errors path="email"/>
            <form:input class="form-control" type="email" path="email"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:errors path="password"/>
            <form:password class="form-control" path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:errors path="passwordConfirmation"/>
            <form:password class="form-control" path="passwordConfirmation"/>
        </p>
        <input class="btn btn-dark" type="submit" value="Register!"/>
    </form:form>
</div>
</body>
</html>