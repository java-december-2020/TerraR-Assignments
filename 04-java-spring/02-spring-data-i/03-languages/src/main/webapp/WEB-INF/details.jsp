<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	<title>Language Details</title>
</head>
<body>

<div class="container">
<a href="/languages">Dashboard</a>
	<form>
  		<div class="form-group row">
    		<div class="col-sm-10">
      			<input type="text" readonly class="form-control-plaintext" value="${language.name}"/>
    		</div>
  		</div>
  		<div class="form-group row">
    		<div class="col-sm-10">
      			<input type="text" readonly class="form-control-plaintext" value="${language.creator}"/>
    		</div>
  		</div>
  		<div class="form-group row">
    		<div class="col-sm-10">
      			<input type="text" readonly class="form-control-plaintext" value="${language.currentVersion}"/>
    		</div>
  		</div>
	</form>
	<a href="/languages/edit/${language.id}">Edit</a>
	<br/>
	<a href="/languages/delete/${language.id}">Delete</a>
</div>
</body>
</html>