<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-8 text-left">

    <h2>Search Results: </h2>
    <form method="POST" action="adminModifyLog">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Select</th>
                <th>ID</th>
                <th>launch date</th>
                <th>time(hours)</th>
                <th>start lat</th>
                <th>start lon</th>
                <th>end lat</th>
                <th>end lon</th>
                <th>water name</th>
                <th>water type</th>
                <th>water detail</th>
                <th>user entered text</th>
                <th>city</th>
                <th>state</th>
                <th>weather</th>
                <th>temp</th>
                <th>contributor</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><input type="radio" name="logCheck" value="0" checked="checked"/></td>
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
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>

            <c:forEach items="${logs}" var="log">
                <tr>
                    <td><input type="radio" name="logCheck" value="${log.logId}"/></td>
                    <td>${log.logId}</td>
                    <td>${log.launchDate}</td>
                    <td>${log.tripDuration}</td>
                    <td>${log.startLocationLat}</td>
                    <td>${log.startLocationLon}</td>
                    <td>${log.endLocationLat}</td>
                    <td>${log.endLocationLon}</td>
                    <td>${log.waterBodyName}</td>
                    <td>${log.waterBodyType}</td>
                    <td>${log.waterSubChoice}</td>
                    <td>${log.logText}</td>
                    <td>${log.city}</td>
                    <td>${log.state}</td>
                    <td>${log.weatherDescription}</td>
                    <td>${log.temperature}</td>
                    <td>${log.userByUserId.userName}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <h4 style="color:red">${noLogSelectedError}</h4>
        <input type="submit" class="btn btn-default" name="submitButton" value="delete">
    </form>
    <div id="updateDiv"></div>
</div>
