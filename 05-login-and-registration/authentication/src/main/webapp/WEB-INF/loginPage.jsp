<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <title>Login Page</title>
</head>
<body>
<div class="container">
    <h1>Login</h1>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/login">
        <p>
            <label for="email">Email</label>
            <input class="form-control" type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input class="form-control" type="password" id="password" name="password"/>
        </p>
        <input class="btn btn-dark" type="submit" value="Login!"/>
    </form>
 </div>
</body>
</html>