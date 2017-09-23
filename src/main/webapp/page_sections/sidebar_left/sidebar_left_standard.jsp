        <div class="col-sm-2 sidenav">
            <p><a href="#">Recent Snag Log 1</a></p>
            <p><a href="#">Recent Snag Log 2</a></p>
            <p><a href="#">Recent Snag Log 3</a></p>
            <hr>
            <hr>
            <h3>Search SnagLog</h3>
            <form action="/search">
                <label for="searchTerm">Search by </label>
                <input type="text" name="searchTerm" id="searchTerm"><br>
                <input type="radio" name="searchType" value="last_name" checked> last name<br>
                <input type="radio" name="searchType" value="first_name"> first name<br>
                <input type="radio" name="searchType" value="user_name"> username<br>
                <input type="radio" name="searchType" value="all"> all users<br>

                <input type="submit" value="search">
            </form>
        </div>
