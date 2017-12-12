<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-8 text-left">

    <h2>Search Results: </h2>
    <form method="POST" action="adminModifyRecord">
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

            <c:forEach items="${users}" var="user">
                <tr>
                    <td><input type="radio" name="userCheck" value="${user.usersId}"/></td>
                    <td>${user.usersId}</td>
                    <td><input type="text" value="${user.firstName}" name="firstName${user.usersId}"></td>
                    <td><input type="text" value="${user.lastName}" name="lastName${user.usersId}"></td>
                    <td>${user.userName}</td>
                    <td><input type="text" value="${user.userPassword}" name="password${user.usersId}"></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <h4 style="color:red">${noUserSelectedError}</h4>
        <input type="submit" class="btn btn-default" name="submitButton" value="delete">
        <input type="submit"  class="btn btn-default" name="submitButton" value="update">
    </form>
    <div id="updateDiv"></div>
</div>

