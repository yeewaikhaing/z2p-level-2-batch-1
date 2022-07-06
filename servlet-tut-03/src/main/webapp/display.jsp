<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scopes</title>
</head>
<body>
	<h2>Scope Objects</h2> <!-- scripting element/ script expression -->
	<h3>Application: <% out.println(application.getAttribute("contextScope")); %> </h3>
	<h3>Session: <%= session.getAttribute("sessionScope") %> </h3>
	<h3>Request: <%= request.getAttribute("requestScope")%></h3>
	
	<h2>Current Date: <%= LocalDate.now() %> </h2>
	
	
</body>
</html>