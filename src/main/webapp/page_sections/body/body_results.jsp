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
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.userName}</td>
                    <td>${user.userPassword}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
        <input type="submit" class="btn btn-default" name="submitButton" value="delete">
        <input type="submit"  class="btn btn-default" name="submitButton" value="update">
        <input type="button" id="btnUpdate" class="btn btn-default" name="submitButton" value="JS update">
    </form>

</div>
<script src="js/updateUser.js"></script>
