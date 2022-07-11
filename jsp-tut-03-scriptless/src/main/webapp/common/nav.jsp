<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
      	<c:url value="/students" var="student" ></c:url>
        <a class="nav-link ${empty title ? 'active' : '' }" aria-current="page" href="<%=request.getContextPath()%>">Home</a>
        <a class="nav-link ${title eq 'Batch' ? 'active' : ''}" href="#">Batch</a>
        <a class="nav-link ${title eq 'Student' or title eq 'Student|Add' ? 'active' : '' }" href="${student}">Student</a>
      </div>
    </div>
  </div>
</nav>
