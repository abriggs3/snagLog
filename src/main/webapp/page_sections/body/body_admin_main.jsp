<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-8 text-left">

    <h2>Admin Main is here</h2>
    <h5>user search</h5>
    <div class="form-group">
        <form action="search" accept-charset="utf-8">
            <input type="hidden" name="tableToSearch" value="users" />
            <input type="text" class="form-control" name="searchTerm"><br>

            <span>by </span><select class="form-control" name="searchType">
            <option value="userName">username</option>
            <option value="lastName">last name</option>
            <option value="firstName">first name</option>
            <option value="all">all</option>
        </select>

            <input type="submit" class="invisibleButton">
        </form>
    </div>

</div>