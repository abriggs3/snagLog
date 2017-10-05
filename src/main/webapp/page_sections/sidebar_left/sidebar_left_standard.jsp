        <div class="col-sm-2 sidenav">
            <p><a href="#">Recent Snag Log 1</a></p>
            <p><a href="#">Recent Snag Log 2</a></p>
            <p><a href="#">Recent Snag Log 3</a></p>
            <hr>
            <hr>
            <h5>user search</h5>
            <form action="search" accept-charset="utf-8">
                <input type="hidden" name="tableToSearch" value="users" />
                <input type="text" name="searchTerm"><br>

                <span>by </span><select name="searchType">
                    <option value="userName">username</option>
                    <option value="lastName">last name</option>
                    <option value="firstName">first name</option>
                    <option value="all">all</option>
                </select>

                <input type="submit" class="invisibleButton">
            </form>
            <h5><a href="/admin">admin page</a></h5>
            <h5><a href="pages_secure_admin/test.jsp">admin authentication test page</a></h5>
            <h5><a href="pages_secure/test.jsp">contributor authentication test page</a></h5>
        </div>
