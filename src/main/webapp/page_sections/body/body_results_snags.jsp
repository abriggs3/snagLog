<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-8 text-left">

    <h2>Search Results: </h2>
    <form method="POST" action="adminModifySnag">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Select</th>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Password</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="radio" name="userCheck" value="0" checked="checked"/></td>
                <td>select</td>
                <td>none</td>
                <td></td>
                <td></td>
                <td></td>
            </tr>

            <c:forEach items="${snags}" var="user">
                <tr>
                    <td><input type="radio" name="snagCheck" value="${snag.snagId}"/></td>
                    <td>${snag.snagId}</td>
                    <td>${snag.locationLat}</td>
                    <td>${snag.locationLon}</td>
                    <td>${snag.blockageType}</td>
                    <td>${snag.hazard}</td>
                    <td>${snag.estimatedDelay}</td>
                    <td>${snag.additionalInformation}</td>
                    <td>${snag.dateMarked}</td>
                    <td>${snag.cleared}</td>
                    <td>${snag.userByUserId}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <h4 style="color:red">${noSnagSelectedError}</h4>
        <input type="submit" class="btn btn-default" name="submitButton" value="delete">
    </form>
    <div id="updateDiv"></div>
</div>
