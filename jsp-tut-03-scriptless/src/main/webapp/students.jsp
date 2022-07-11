<%@page import="com.mmit.entity.Student"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${requestScope.title}</title>
	<%-- <jsp:include page="common/res.jsp"></jsp:include> --%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
      	<c:url value="/students" var="student" ></c:url>
        <a class="nav-link ${empty requestScope.title ? 'active' : '' }" aria-current="page" href="<%=request.getContextPath()%>">Home</a>
        <a class="nav-link ${title eq 'Batch' ? 'active' : ''}" href="#">Batch</a>
        <a class="nav-link ${title eq 'Student' or title eq 'Student|Add' ? 'active' : '' }" href="${student}">Student</a>
      </div>
    </div>
  </div>
</nav>
</head>
<body>
	<!-- nav -->
	<jsp:include page="common/nav.jsp"></jsp:include>
	<!-- body -->
	<div class="container">
		<div class="row mt-2">
			<h3 class="col-10">Student List</h3>
			<c:url value="/student-add" var="add"></c:url>
			<a href="${add}" class="btn btn-primary col"><i class="fa-solid fa-plus fa-lg"></i> Add Student</a>
		</div>
		<hr />
		<table class="table">
			<thead>
				<tr>
					<th>No</th>
					<th>Student Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Batch</th>
					<th>Register Date</th>
					<th>Old Student</th>
				</tr>
			</thead>
			<tbody>
				<!-- student list -->
				<c:forEach items="${students}" var="s" varStatus="i">
					<tr>
							<td>${i.count}</td>
							<td>${s.name}</td>
							<td>${s.phone}</td>
							<td>${s.email}</td>
							<td>${s.batch}</td>
							<td>${s.registerDate}</td>
							<td>${s.oldStudent}</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>