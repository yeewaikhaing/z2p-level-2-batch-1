<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Without EL</h3>
	<%
	String name = request.getParameter("uname");
	String mail = request.getParameter("email");
	if(name == null)
		name = "";
	if(mail == null)
		mail = "";
	%>
	<form action="">
		<table>
			<tr>
				<td>Username</td>
				<td>
					<input type="text" name="uname" value="<%= name%>" />
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<input type="text"  name="email" value="<%= mail%>"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" />
				</td>
			</tr>
		</table>
	</form>
	<hr />
	<%
	if(!name.equals("") && !mail.equals("")) {
		%>
		<h3>Result</h3>
		<p>Name: <%=name %></p>
		<p>Email: <%=mail %></p>
	<% }
	%>
	<hr />
	
	<h3>EL Example</h3>
	${3 + 6} <br />
	${3 == 5 } <br />
	${empty name} <br />
	
</body>
</html>