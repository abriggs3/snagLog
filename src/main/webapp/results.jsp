<%@include file="tagLibrary.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>


<html><body>
<div class="container-fluid">
    <h2>Search Results: </h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.userName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
