<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log In Required</title>
</head>
<body>
<div class="col-sm-8 text-left">

    <div class="container">
        <div class="row centered-form">
            <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Login Required</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="j_security_check">
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="j_username" class="form-control input-sm" placeholder="username">
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <input type="text" name="j_password" class="form-control input-sm" placeholder="password">
                                    </div>
                                </div>
                            </div>


                            <input type="submit" value="Log In" class="btn btn-info btn-block">

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>
