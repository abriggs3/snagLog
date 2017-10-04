<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-8 text-left">

    <%@ page session="true"%>

    <h1>User '<%=request.getRemoteUser()%>' has been logged out.</h1>

    <% session.invalidate(); %>

</div>