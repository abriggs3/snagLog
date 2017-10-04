<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="index">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="pages_secure/post_a_log">Post a Snag Log</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" data-toggle="modal" data-target="#login-modal"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>



            <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                <div class="modal-dialog">
                    <div class="loginmodal-container">
                        <h1>Login to Your Account</h1><br>
                        <form ACTION="j_security_check" METHOD="POST">
                            <input type="text" name="j_username" placeholder="Username">
                            <input type="password" name="j_password" placeholder="Password">
                            <input type="submit" name="login" class="login loginmodal-submit" value="Log In">
                        </form>

                        <div class="login-help">
                            <a href="register">Register</a> - <a href="forgotPassword">Forgot Password</a>
                        </div>
                    </div>
                </div>
            </div>


                <li><a href="pages/logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>



            </ul>
        </div>
    </div>
</nav>



