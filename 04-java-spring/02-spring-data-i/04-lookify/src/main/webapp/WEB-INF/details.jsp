<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>Details</title>
</head>
<body>

<div class="container">
<ul class="nav">
	<li class="nav-item">
		<a class="nav-spacer" href="/dashboard">Dashboard</a>
	</li>
</ul>
	
<table class="table-borderless">
        <tr>
            <td class="td-spacer"><b>Title</b></td>
            <td class="td-spacer">${song.title}</td>
        </tr>
        <tr>
            <td class="td-spacer"><b>Artist</b></td>
            <td class="td-spacer">${song.artist}</td>
        </tr>
        <tr>
            <td class="td-spacer"><b>Rating (1-10)</b></td>
            <td class="td-spacer">${song.rating}</td>
        </tr>
        <tr>
        	<td class="td-spacer"><a href="/delete/${song.id}">Delete</a></td>
        </tr>
</table>
	


</div>

</body>
</html>