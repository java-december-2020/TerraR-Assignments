<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="style-index.css">
	<title>Dojo Survey Index</title>
</head>
<body>
	<form method="POST" action="/result">
		<div class="block">
			<label>Your Name:  </label>
			<input type="text" name="name"/>
		</div>
		<div class="block">
			<label>Dojo Location:  </label>   
			<select name="location">
				<option>Arlington</option>
				<option>Bellevue</option>
				<option>Boise</option>
				<option>Chicago</option>
				<option>Dallas</option>
				<option>Los Angeles</option>
				<option>Online</option>
				<option>Tulsa</option>
			</select>
		</div>
		<div class="block">
			<label>Favorite Language:  </label>  
			<select name="language">
				<option>C#</option>
				<option>Java</option>
				<option>JavaScript</option>
				<option>Python</option>
				<option>Ruby</option>
			</select>
		</div>
		<div id="comments">
			<p>Comment (optional):  </p>
			<textarea name="comment" rows="3" cols="20"></textarea>
		</div>	 
		<button>Button</button>
		
	</form>
</body>
</html>