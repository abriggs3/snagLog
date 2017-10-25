<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-sm-2 sidenav">
    <div class="well">
        <p>Current Weather</p>
    </div>
    <div id="decisionMakerWell" class="well well-lg">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">The Decision Maker</h3>
            </div>
            <div class="panel-body">
                <form role="form" action="">
                    <div class="form-group">
                        <input type="text" name="userQuestion" id="userProblem" class="form-control input-sm" placeholder="state your problem">
                    </div>


                    <div class="row">
                        <input checked data-toggle="toggle" data-onstyle="default" data-on="crudeness filter<br>ON" data-offstyle="danger" data-off="crudeness filter<br>OFF" type="checkbox">
                    </div>
                    <hr>
                    <div class="row">
                        <input checked data-toggle="toggle" data-onstyle="default" data-on="indecisive filter<br>ON" data-offstyle="warning" data-off="indecisive filter<br>OFF" type="checkbox">
                    </div>
                    <hr>
                    <div class="row">
                        <input checked data-toggle="toggle" data-onstyle="default" data-on="irritated filter<br>ON" data-offstyle="warning" data-off="irritated filter<br>OFF" type="checkbox">
                    </div>
                    <hr>


                    <input type="submit" value="Get Your Answer" class="btn btn-info btn-block">
                    <div id="answerContainer"><p>The answer will appear here</p></div>

                </form>
            </div>
        </div>
    </div>
</div>