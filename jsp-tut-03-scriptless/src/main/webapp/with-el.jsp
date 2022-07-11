<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>With EL</h3>
	
	<form action="">
		<table>
			<tr>
				<td>Username</td>
				<td>
					<input type="text" name="uname" value="${param.uname}" />
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<input type="text"  name="email" value="${param.email}"/>
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
	
		<div style="display:${(param.uname == '' or empty param.email) ? 'none' : 'block'}">
			<h3>Result</h3>
		<p>Name: ${param.uname}</p>
		<p>Email: ${param.email }</p>
	
		</div>
</body>
</html>