<%@include file="tagLibrary.jsp"%>
<c:set var="title" value="SnagLog Search User" />
<%@include file="head.jsp"%>
<html>
<body>
<h2>Search SnagLog Users</h2>
<form action="/searchUser">
    <label for="searchTerm">Search by </label>
    <input type="text" name="searchTerm" id="searchTerm"><br>
    <input type="radio" name="searchType" value="last_name" checked> Last Name
    <input type="radio" name="searchType" value="first_name"> First Name
    <input type="radio" name="searchType" value="id"> Employee ID
    <input type="radio" name="searchType" value="all"> See All<br>

    <input type="submit" value="search">
</form>

</body>
</html>

