<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}|${course.id == 0 ? 'Add' : 'Edit' }</title>
	<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<!--nav -->
	<jsp:include page="common/nav.jsp"></jsp:include>
	<!-- body -->
	<div class="container">
		<div class="row mt-3">
			<h3 class="col-10">${course.id == 0 ? 'Add' : 'Edit' } Course</h3>
			<c:url value="/courses" var="back"></c:url>
			<a href="${back}" class="btn btn-primary col">Back</a>
		</div>
		<hr />
		<c:url value="/add-course" var="save"></c:url>
		<form action="${save}" class="form col-5 offset-3" method="post">
			
			<input type="hidden" name="courseId" class="form-control" value="${course.id}"/>
			<div class="mb-3">
				<label class="form-label">Level</label>
				<select name="level" class="form-select">
					<c:forEach items="${levels}" var="lvl">
						<option value="${lvl.id}">${lvl.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="mb-3">
				<label class="form-label">Name</label>
				<input value="${course.name}" type="text" name="name" class="form-control" required="required" placeholder="Enter Course name"/>
			</div>
			<div class="mb-3">
				<label class="form-label">Content</label>
				<textarea class="form-control" id="summernote" name="outline">${course.content}</textarea>
			</div>
			<div class="mb-3">
				<button class="btn btn-success" type="submit">Save</button>
				<button class="btn btn-danger" type="reset">Clear</button>
			</div>
		</form>
	</div>
	<script>
		$(document).ready(function() {
			$('#summernote').summernote();
		});
	</script>
	<!-- footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>