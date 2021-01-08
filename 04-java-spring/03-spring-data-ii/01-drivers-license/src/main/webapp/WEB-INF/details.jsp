<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<title>Profile Page</title>
</head>
<body>

<div class="container">
	<h1>${license.person.firstName} ${license.person.lastName}</h1>
	<br/>
<table class="table-borderless">
        <tr>
            <td class="td-spacer"><b>License Number:</b></td>
            <td class="td-spacer">${license.number}</td>
        </tr>
        <tr>
            <td class="td-spacer"><b>State</b></td>
            <td class="td-spacer">${license.state}</td>
        </tr>
        <tr>
            <td class="td-spacer"><b>Expiration Date</b></td>
            <td class="td-spacer"><fmt:formatDate pattern = "dd/MM/yyyy" value ="${license.expiration_date}" /></td>
        </tr>
</table>
</div>

</body>
</html>