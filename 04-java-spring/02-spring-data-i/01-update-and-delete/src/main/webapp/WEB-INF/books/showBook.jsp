<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<title>Retrieve a Book</title>
</head>
<body>
<div class="container">
	<h1><c:out value="${book.title}"/></h1>
	<br/>
	<form>
  		<div class="form-group row">
    		<label class="col-sm-2 col-form-label font-weight-bold">Description:</label>
    		<div class="col-sm-10">
      			<input type="text" readonly class="form-control-plaintext" value="${book.description}"/>
    		</div>
  		</div>
  		<div class="form-group row">
    		<label class="col-sm-2 col-form-label font-weight-bold">Language:</label>
    		<div class="col-sm-10">
      			<input type="text" readonly class="form-control-plaintext" value="${book.language}"/>
    		</div>
  		</div>
  		<div class="form-group row">
    		<label class="col-sm-2 col-form-label font-weight-bold">Number of Pages:</label>
    		<div class="col-sm-10">
      			<input type="text" readonly class="form-control-plaintext" value="${book.numberOfPages}"/>
    		</div>
  		</div>
	</form>
	<a href="/books/edit/${book.id}">Edit Book</a>
	<br/>
	<form action="/books/delete/${book.id}" method="get">
		<input type="hidden" name="_method" value="delete">
		<button class="btn btn-success">Delete</button>
	</form>
</div>	
</body>
</html>