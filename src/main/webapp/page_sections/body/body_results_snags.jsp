<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-8 text-left">

    <h2>Search Results: </h2>
    <form method="POST" action="adminModifySnag">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Select</th>
                <th>ID</th>
                <th>latitude</th>
                <th>longitude</th>
                <th>type</th>
                <th>hazard</th>
                <th>delay</th>
                <th>additional info</th>
                <th>date marked</th>
                <th>cleared</th>
                <th>submitted by</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="radio" name="snagCheck" value="0" checked="checked"/></td>
                <td>select</td>
                <td>none</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>

            <c:forEach items="${snags}" var="snag">
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
                    <td>${snag.userByUserId.userName}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <h4 style="color:red">${noSnagSelectedError}</h4>
        <input type="submit" class="btn btn-default" name="submitButton" value="delete">
    </form>
    <div id="updateDiv"></div>
</div>
