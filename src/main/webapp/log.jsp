<!DOCTYPE html>
<%@include file="tagLibrary.jsp"%>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Snag Log - Log</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Place your favicon.ico and apple-touch-icon.png in the template root directory -->
    <link href="favicon.ico" rel="shortcut icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Raleway:300,400,500,700,800" rel="stylesheet">

    <!-- Bootstrap CSS File -->
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Libraries CSS Files -->
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="lib/animate-css/animate.min.css" rel="stylesheet">

    <!-- Main Stylesheet File -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style_for_maps.css" rel="stylesheet">

    <!-- for datepicker -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

    <link rel="stylesheet" href="css/snaglog_custom.css">
    <link rel="stylesheet" href="css/snaglog_modal.css">





</head>

<body>
<!-- disables forms when user is not logged in -->
<c:set var="disabledByDefault" value="${(empty disabledByDefault) ? 'disabled' : ''}" />
<div id="preloader"></div>

<!--==========================
Hero Section
============================-->
<section id="hero">
    <div class="hero-container">
        <div class="wow fadeIn">
            <div class="hero-logo">
                <img class="" src="img/logo.png" alt="Snag Log">
            </div>

            <h1>Log Your Trip</h1>
            <c:choose>
                <c:when test="${not empty loggedInUsersName}">
                    <h2>Hi ${loggedInUsersName}, <span class="rotating">nice to see you, thanks for coming </span></h2>
                </c:when>
                <c:otherwise>
                    <h4><a href="login">In order to create your log, sign in now.</a></h4>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</section>

<!--==========================
 Header Section
 ============================-->
<header id="header">
    <div class="container">

        <div id="logo" class="pull-left">
            <a href="#hero"><img src="img/logo.png" alt="Snag Log" title="Snag Log" /></a>
        </div>

        <nav id="nav-menu-container">
            <ul class="nav-menu">
                <li class="menu-active"><a href="#hero">Home</a></li>
                <li><a href="#instructions">Get Started</a></li>
                <li><a href="#services">Mark a Snag</a></li>
                <li><a href="#portfolio">Recent Logs</a></li>
                <li><a href="requestDirectorAdmin?destination=adminMain">admin</a></li>
                <li><a href="requestDirector?destination=log">log your trip</a></li>

                <c:choose>
                    <c:when test="${not empty loggedInUsersName}">
                        <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${loggedInUsersName}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login </a></li>
                    </c:otherwise>
                </c:choose>
                <li><a href="#DecisionMaker">Decision Maker</a></li>
            </ul>
        </nav>
        <!-- #nav-menu-container -->
    </div>
</header>
<!-- #header -->





<div id="map"></div>
<!--==========================
Services Section
============================-->
<section id="services">
    <div class="container wow fadeInUp">
        <div class="row">
            <div class="col-md-12">
                <h3 class="section-title">Your Log</h3>
                <div class="section-title-divider"></div>
                <p class="section-description">Click map above to mark to add starting and ending coordinates to form</p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <!-- Map Section -->

                <div class="eventtext">
                    <form class="form-group" method="post" action="createSnagLog" id="logForm">
                        <div>
                            <c:choose>
                                <c:when test="${not empty loggedInUsersName}">
                                </c:when>
                                <c:otherwise>
                                    <h4><a href="login">In order to create your log, sign in now.</a></h4>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div>
                            <input class="input-sm" type="text" id="datepicker" name="datepicker" placeholder="launch date" ${disabledByDefault}>
                        </div>
                        <div>
                            <input class="input-sm" type="text" id="tripLength" name="tripLength" placeholder="trip duration in hours" ${disabledByDefault}>
                        </div>
                        <div>Latitude: <span id="latspan"></span></div>
                        <div>Longitude: <span id="lngspan"></span></div>
                        <div><label>Selected Coordinates:</label><br>
                            <input class="input-sm" type="text" id="latitudeClicked"  name="latitudeClicked" ${disabledByDefault}> latitude<br>
                            <input class="input-sm" type="text" id="longitudeClicked"  name="longitudeClicked" ${disabledByDefault}> longitude<br>
                            <label>Use coordinates for</label>
                            <input class="btn-select-start-end-point" type="button" id="btnStartCoordinates" value="start point" ${disabledByDefault}>
                            <input class="btn-select-start-end-point" type="button" id="btnEndCoordinates" value="end point" ${disabledByDefault}><br>
                        </div>
                        <div>
                            <label>Start Point</label>
                            <input class="input-sm" type="text" id="startPointLat" name="startPointLat" placeholder="populate" ${disabledByDefault}>
                            <input class="input-sm" type="text" id="startPointLon" name="startPointLon" placeholder="with map" ${disabledByDefault}><br>
                            <label>End Point</label>
                            <input class="input-sm" type="text" id="endPointLat" name="endPointLat" placeholder="populate" ${disabledByDefault}>
                            <input class="input-sm" type="text" id="endPointLon" name="endPointLon" placeholder="with map" ${disabledByDefault}><br>
                        </div>
                        <div>
                            <label>Name of primary water body</label><br>
                            <input class="input-sm" type="text" id="waterBodyName" name="waterBodyName" placeholder="for example, Namkagon" ${disabledByDefault}><br>
                        </div>
                        <div>
                        <label>Type of water</label>
                            <select class="form-control" id="waterBodyType" name="waterBodyType" ${disabledByDefault}>
                                <option value="noSelection">click to select</option>
                                <option value="flatWater">flat-water - out and back paddle possible</option>
                                <option value="whiteWater">white-water - current prevents out and back paddle</option>
                            </select>
                        </div>
                        <div id="waterTypeSubSelect"></div>
                        <div>
                            <textarea class="form-control" rows="10" name="logText" form="logForm" ${disabledByDefault}>Tell about your trip</textarea>

                        </div>

                        <div>
                        <c:choose>
                            <c:when test="${not empty loggedInUsersName}">
                                <input type="submit" value="publish">
                            </c:when>
                            <c:otherwise>
                                <h4><a href="login">In order to create your log, sign in now.</a></h4>
                            </c:otherwise>
                        </c:choose>
                        </div>
                    </form>
                </div>
            </div>
            <script>

            </script>
            <script async defer
                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyABhJ9Hbp5gF8WEyv4agisgqh-k4pVZSs0&callback=initMap">
            </script>
        </div>
    </div>
    </div>

</section>

<!--==========================
Log intro Section
============================-->
<section id="subscribe">
    <div class="container wow fadeInUp">
        <div class="row">
            <div class="col-md-8">
                <h3 class="subscribe-title">Create a Snag Log</h3>
                <p class="subscribe-text">Document your trips. Mark put in and take out locations. Share your experiences.</p>
            </div>
            <div class="col-md-4 subscribe-btn-container">
                <a class="subscribe-btn" href="#">Log it Now!</a>
            </div>
        </div>
    </div>
</section>

<!--==========================
Current log Section
============================-->
<section id="portfolio">
    <div class="container wow fadeInUp">
        <div class="row">
            <div class="col-md-12">
                <h3 class="section-title">Log Summary</h3>
                <div class="section-title-divider"></div>
                <p class="section-description">Newest Snag Logs</p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-1.jpg);" href="#testimonials" >
                    <div class="details">
                        <div id="logThumb0">

                        </div>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-2.jpg);" href="#testimonials" >
                    <div class="details">
                        <div id="logThumb1">

                        </div>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-3.jpg);" href="#testimonials" >
                    <div class="details">
                        <div id="logThumb2">

                        </div>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-4.jpg);" href="#testimonials" >
                    <div class="details">
                        <div id="logThumb3">

                        </div>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-5.jpg);" href="#testimonials" >
                    <div class="details">
                        <div id="logThumb4">

                        </div>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-6.jpg);" href="#testimonials" >
                    <div class="details">
                        <div id="logThumb5">

                        </div>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-7.jpg);" href="#testimonials" >
                    <div class="details">
                        <div id="logThumb6">

                        </div>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-8.jpg);" href="#testimonials" >
                    <div class="details">
                        <div id="logThumb7">

                        </div>
                    </div>
                </a>
            </div>

        </div>
    </div>
</section>

<!--==========================
  Log Display Section
  ============================-->
<section id="testimonials">
    <div class="container wow fadeInUp">
        <div class="row">
            <div class="col-md-12">
                <h3 class="section-title">Read Logs</h3>
                <div class="section-title-divider"></div>
                <p class="section-description">Make Memories</p>
            </div>
        </div>
        <div id="logDisplayDiv">
            <div class="row">
                <div class="col-md-3">
                    <div class="profile">
                        <div class="pic"><img id="userImage" src="img/client-1.jpg" alt="userImage"></div>
                        <h4 id="firstNameLastName">First and last name</h4>
                        <span id="userName">user name</span>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="quote" >
                        <b><img src="img/quote_sign_left.png" alt="image of quotation mark"></b><span id="userLogDescription"> User log description goes here. </span><small><img src="img/quote_sign_right.png" alt="mage of quotation mark"></small>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<!--==========================
Footer
============================-->
<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="copyright">
                    &copy; Copyright <strong>SnagLog</strong>. All Rights Reserved
                </div>
                <div class="credits">
                    Bootstrap Templates by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- #footer -->

<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

<!-- Required JavaScript Libraries -->
<script src="lib/jquery/jquery.min.js"></script>
<script src="lib/bootstrap/js/bootstrap.min.js"></script>
<script src="lib/superfish/hoverIntent.js"></script>
<script src="lib/superfish/superfish.min.js"></script>
<script src="lib/morphext/morphext.min.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="lib/stickyjs/sticky.js"></script>
<script src="lib/easing/easing.js"></script>

<!-- Template Specisifc Custom Javascript File -->
<script src="js/custom.js"></script>

<script src="contactform/contactform.js"></script>



<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="js/log.js"></script>
<script src="js/grabLogsReverseOrder.js"></script>
</body>

</html>
