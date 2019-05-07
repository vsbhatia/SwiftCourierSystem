<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
		<link rel="stylesheet" type="text/css" href="style.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<form action="reg" method="post">
	Enter First name: <input type="text" name="fname" required="required" ><br>
	Enter Last name: <input type="text" name="lname" required="required" ><br>
	Enter email-address: <input type="text" name="mail" required="required"><br>
	Enter user-name : <input type="text" name="uname" required="required" style="background-color: lightblue"><br>
	Enter password : <input type="password" name="pwd" required="required"  style="background-color: lightblue"><br>
	<input type="submit" value="Register">
</form>
</div>
</body>
</html>
