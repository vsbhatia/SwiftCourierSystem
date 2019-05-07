<%@ page language="java" contentType="text/html; charset=ISO-8859-1" session="true"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add your item..</title>
</head>
<body>
<% 
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //for Browser to understand!
	if(session.getAttribute("user")==null){
		response.sendRedirect("login.jsp");
	}
	else{
		out.println("Welcome "+session.getAttribute("user")+"!");
%>
<form action="additem" method="post">
	Select your item type : 
	<select name="type">
		<option value="1">Courier for food products</option>
		<option value="2">Courier for documents/parcel</option>
		<option value="3">Courier for medicine</option>
		<option value="4">Excess baggages</option>
	</select>
	<br>
	Enter item weight : <input type="number" name="wgt">
	<input type="submit" name="submit" value="submit">
</form>
	<form action="logout" method="post">
		<input type="submit" name="submit" value="logout">
	</form>
<%} %>
</body>
</html>