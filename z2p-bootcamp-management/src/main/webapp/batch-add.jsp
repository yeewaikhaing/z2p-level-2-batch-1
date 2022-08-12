<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}|${batch.id == 0 ? 'Add' : 'Edit' }</title>
	<jsp:include page="common/res.jsp"></jsp:include>
</head>
<body>
	<!--nav -->
	<jsp:include page="common/nav.jsp"></jsp:include>
	<!-- body -->
	<div class="container">
		<div class="row mt-3">
			<h3 class="col-10">${batch.id == 0 ? 'Add' : 'Edit' } Batch</h3>
			<c:url value="/batches" var="back"></c:url>
			<a href="${back}" class="btn btn-primary col">Back</a>
		</div>
		<hr />
		<c:url value="/add-batch" var="save"></c:url>
		<form action="${save}" class="form col-5 offset-3" method="post">
			
			<input type="hidden" name="batchId" class="form-control" value="${batch.id}"/>
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
				<input value="${batch.name}" type="text" name="name" class="form-control" required="required" placeholder="Enter Batch name"/>
			</div>
			<div class="mb-3">
				<label class="form-label">Start Date</label>
				<input value="${batch.startDate}" type="date" name="startDate" class="form-control" required="required" placeholder="Enter Start Date"/>
			</div>
			<div class="mb-3">
				<button class="btn btn-success" type="submit">Save</button>
				<button class="btn btn-danger" type="reset">Clear</button>
			</div>
		</form>
	</div>
	<!-- footer -->
	<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>