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
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	if(session.getAttribute("user")==null){
		out.println("You are not logged in :( !");
		response.sendRedirect("login.jsp");
	}
	else{
%>
Are you sure you want to delete this item?
<form>
	<a href="del">YES</a>
	<a href="loggedin.jsp">NO</a>
	
</form>

<%} %>
</body>
</html>