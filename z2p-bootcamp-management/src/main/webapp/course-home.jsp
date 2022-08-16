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
						<td>${course.updated_at}</td>
						<td>
							<c:url var="edit" value="/edit-course">
								<c:param name="id">${course.id}</c:param>
							</c:url>
							<a href="${edit}" class="btn btn-outline-info btn-sm">Edit</a>
							<a href="#" class="btn btn-outline-danger btn-sm btn-remove" data-id="${course.id}">
							<i class="fa-solid fa-minus"></i> Remove</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.btn-remove').click(function() {
				let levelId = $(this).data('id');
				//alert($(this).data('id'));
				if(confirm('Are you sure to delete?')) {
					window.location.href="delete-course?id=" + levelId;
				}
			});
		});
	</script>
	<!-- footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>