<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
      	<c:url value="/levels" var="level" ></c:url>
      	<c:url value="/batches" var="batch"></c:url>
      	<c:url value="/courses" var="course"></c:url>
        <a class="nav-link ${empty title ? 'active' : '' }" aria-current="page" href="<%=request.getContextPath()%>"><i class="fa-solid fa-house"></i>Home</a>
        <a class="nav-link ${title eq 'Level' ? 'active' : ''}" href="${level}">Level</a>
        <a class="nav-link ${title eq 'Batch'  ? 'active' : '' }" href="${batch}">Batch</a>
        <a class="nav-link ${title eq 'Course'  ? 'active' : '' }" href="${course}">Course</a>
      </div>
    </div>
  </div>
</nav>
