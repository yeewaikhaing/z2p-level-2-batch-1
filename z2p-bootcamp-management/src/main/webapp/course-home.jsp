<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
	<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<!--nav -->
	<jsp:include page="common/nav.jsp"></jsp:include>
	<!-- body -->
	<div class="container">
		<div class="row mt-3">
			<h3 class="col-10">All Course</h3>
			<c:url value="/add-course" var="add"></c:url>
			<a href="${add}" class="btn btn-primary col">Add Course</a>
		</div>
		<hr />
		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Course Name</th>
					<th>Level Name</th>
					<th>Create At</th>
					<th>Update At</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<!-- course list -->
				<c:forEach items="${courses}" var="course" varStatus="i">
					<tr>
						<td>${i.count}</td>
						<td>${course.name}</td>
						<td>${course.level.name}</td>
						<td>${course.created_at}</td>
						<th>${course.updated_at}</th>
						<td>
							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>