<%@ page language="java" contentType="text/html; charset=ISO-8859-1" session="true"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if(session.getAttribute("user")==null){
		out.println("You have to login to enter this page!");
		response.sendRedirect("login.jsp");
	}
	else{
		out.println("You have successfully logged in!"+session.getAttribute("user"));

%>
	<form action="addItem.jsp" method="post">
		<input type="submit" name="submit" value="Add Item">
	</form>
	
	<form action="removeItem.jsp" method="post">
		<input type="submit" name="submit" value="Delete ...Item">
	</form>
	
	<form action="logout" method="post">
		<input type="submit" name="submit" value="logout">
	</form>

<%} %>
</body>
</html>