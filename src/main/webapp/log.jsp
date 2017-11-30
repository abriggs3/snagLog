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


<!--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->

    <link rel="stylesheet" href="css/snaglog_custom.css">
    <link rel="stylesheet" href="css/snaglog_modal.css">



    <!-- for bootstrap toggles and DecisionMaker widget -->
    <script src="js/decisionMaker.js"></script>
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">

    <link rel="stylesheet" href="css/decisionMaker.css">

    <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
          rel = "stylesheet">
  

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
                <li class="menu-active"><a href="index">Home</a></li>
                <li><a href="#instructions">Get Started</a></li>
                <li><a href="#services">Mark a Snag</a></li>
                <li><a href="#portfolio">Recent Logs</a></li>
                <li><a href="#testimonials">Testimonials</a></li>

                <li class="menu-has-children"><a href="#subscribe">Log Your Trip</a>
                    <ul>
                        <li><a href="#subscribe">Document Your Trip</a></li>
                        <li><a href="practice.jsp">practice page</a></li>
                        <li class="menu-has-children"><a href="#">Drop Down 2</a>
                            <ul>
                                <li><a href="#">Deep Drop Down 1</a></li>
                                <li><a href="#">Deep Drop Down 2</a></li>
                                <li><a href="#">Deep Drop Down 3</a></li>
                                <li><a href="#">Deep Drop Down 4</a></li>
                                <li><a href="#">Deep Drop Down 5</a></li>
                            </ul>
                        </li>
                        <li><a href="practice_geolocation.jsp">geolocation practice page</a></li>
                        <li><a href="#">Drop Down 4</a></li>
                        <li><a href="#">Drop Down 5</a></li>
                    </ul>
                </li>
                <c:choose>
                    <c:when test="${not empty loggedInUsersName}">
                        <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout, ${loggedInUsersName}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login ${loggedInUsersName}</a></li>
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
                    <form class="form-group" method="post" action="markSnag">
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
                            <input class="input-sm" type="text" id="waterBodyName" placeholder="for example, Namkagon" ${disabledByDefault}><br>
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
                            <input type="text" id="datepicker">
                        </div>

                        <!--
                        <div>
                            <lable for="hazardOrNot">Snag is </lable><br>
                            <select class="form-control" name="hazardOrNot">
                                <option value="noSelection">click to select</option>
                                <option value="annoying">annoying</option>
                                <option value="slight">slight hazard</option>
                                <option value="major">major hazard</option>
                            </select>
                        </div>
                        <div>
                            <lable for="timeDelay">Time required to navigate blockage in minutes</lable><br>
                            <input type="text" class="input-small" name="timeDelay">
                        </div>
                        <div>
                            <lable for="additionalBlockageInformation">Additional description or information</lable><br>
                            <input class="input-sm" type="text" name="additionalBlockageInformation">
                        </div>
                        -->
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
                <a class="portfolio-item" style="background-image: url(img/portfolio-1.jpg);" href="">
                    <div class="details">
                        <h4>Portfolio 1</h4>
                        <span>Alored dono par</span>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-2.jpg);" href="">
                    <div class="details">
                        <h4>Portfolio 2</h4>
                        <span>Alored dono par</span>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-3.jpg);" href="">
                    <div class="details">
                        <h4>Portfolio 3</h4>
                        <span>Alored dono par</span>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-4.jpg);" href="">
                    <div class="details">
                        <h4>Portfolio 4</h4>
                        <span>Alored dono par</span>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-5.jpg);" href="">
                    <div class="details">
                        <h4>Portfolio 5</h4>
                        <span>Alored dono par</span>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-6.jpg);" href="">
                    <div class="details">
                        <h4>Portfolio 6</h4>
                        <span>Alored dono par</span>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-7.jpg);" href="">
                    <div class="details">
                        <h4>Portfolio 7</h4>
                        <span>Alored dono par</span>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a class="portfolio-item" style="background-image: url(img/portfolio-8.jpg);" href="">
                    <div class="details">
                        <h4>Portfolio 8</h4>
                        <span>Alored dono par</span>
                    </div>
                </a>
            </div>

        </div>
    </div>
</section>

<!--==========================
Testimonials Section
============================-->
<section id="testimonials">
    <div class="container wow fadeInUp">
        <div class="row">
            <div class="col-md-12">
                <h3 class="section-title">Testimonials</h3>
                <div class="section-title-divider"></div>
                <p class="section-description">Erdo lide, nora porodo filece, salvam esse se, quod concedimus ses haec dicturum fuisse</p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3">
                <div class="profile">
                    <div class="pic"><img src="img/client-1.jpg" alt=""></div>
                    <h4>Saul Goodman</h4>
                    <span>Lawless Inc</span>
                </div>
            </div>
            <div class="col-md-9">
                <div class="quote">
                    <b><img src="img/quote_sign_left.png" alt=""></b> Proin iaculis purus consequat sem cure digni ssim donec porttitora entum suscipit rhoncus. Accusantium quam, ultricies eget id, aliquam eget nibh et. Maecen aliquam, risus at semper. <small><img src="img/quote_sign_right.png" alt=""></small>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-9">
                <div class="quote">
                    <b><img src="img/quote_sign_left.png" alt=""></b> Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis architecto beatae. <small><img src="img/quote_sign_right.png" alt=""></small>
                </div>
            </div>
            <div class="col-md-3">
                <div class="profile">
                    <div class="pic"><img src="img/client-2.jpg" alt=""></div>
                    <h4>Sara Wilsson</h4>
                    <span>Odeo Inc</span>
                </div>
            </div>
        </div>

    </div>
</section>

<!--==========================
Team Section
============================-->
<section id="team">
    <div class="container wow fadeInUp">
        <div class="row">
            <div class="col-md-12">
                <h3 class="section-title">Our Team</h3>
                <div class="section-title-divider"></div>
                <p class="section-description">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque</p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3">
                <div class="member">
                    <div class="pic"><img src="img/team-1.jpg" alt=""></div>
                    <h4>Walter White</h4>
                    <span>Chief Executive Officer</span>
                    <div class="social">
                        <a href=""><i class="fa fa-twitter"></i></a>
                        <a href=""><i class="fa fa-facebook"></i></a>
                        <a href=""><i class="fa fa-google-plus"></i></a>
                        <a href=""><i class="fa fa-linkedin"></i></a>
                    </div>
                </div>
            </div>

            <div class="col-md-3">
                <div class="member">
                    <div class="pic"><img src="img/team-2.jpg" alt=""></div>
                    <h4>Sarah Jhinson</h4>
                    <span>Product Manager</span>
                    <div class="social">
                        <a href=""><i class="fa fa-twitter"></i></a>
                        <a href=""><i class="fa fa-facebook"></i></a>
                        <a href=""><i class="fa fa-google-plus"></i></a>
                        <a href=""><i class="fa fa-linkedin"></i></a>
                    </div>
                </div>
            </div>

            <div class="col-md-3">
                <div class="member">
                    <div class="pic"><img src="img/team-3.jpg" alt=""></div>
                    <h4>William Anderson</h4>
                    <span>CTO</span>
                    <div class="social">
                        <a href=""><i class="fa fa-twitter"></i></a>
                        <a href=""><i class="fa fa-facebook"></i></a>
                        <a href=""><i class="fa fa-google-plus"></i></a>
                        <a href=""><i class="fa fa-linkedin"></i></a>
                    </div>
                </div>
            </div>

            <div class="col-md-3">
                <div class="member">
                    <div class="pic"><img src="img/team-4.jpg" alt=""></div>
                    <h4>Amanda Jepson</h4>
                    <span>Accountant</span>
                    <div class="social">
                        <a href=""><i class="fa fa-twitter"></i></a>
                        <a href=""><i class="fa fa-facebook"></i></a>
                        <a href=""><i class="fa fa-google-plus"></i></a>
                        <a href=""><i class="fa fa-linkedin"></i></a>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>

<!--==========================
Contact Section
============================-->
<section id="contact">
    <div class="container wow fadeInUp">
        <div class="row">
            <div class="col-md-12">
                <h3 class="section-title">Contact Us</h3>
                <div class="section-title-divider"></div>
                <p class="section-description">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque</p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3 col-md-push-2">
                <div class="info">
                    <div>
                        <i class="fa fa-map-marker"></i>
                        <p>A108 Adam Street<br>New York, NY 535022</p>
                    </div>

                    <div>
                        <i class="fa fa-envelope"></i>
                        <p>info@example.com</p>
                    </div>

                    <div>
                        <i class="fa fa-phone"></i>
                        <p>+1 5589 55488 55s</p>
                    </div>

                </div>
            </div>

            <div class="col-md-5 col-md-push-2">
                <div class="form">
                    <div id="sendmessage">Your message has been sent. Thank you!</div>
                    <div id="errormessage"></div>
                    <form action="" method="post" role="form" class="contactForm">
                        <div class="form-group">
                            <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                            <div class="validation"></div>
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email" />
                            <div class="validation"></div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                            <div class="validation"></div>
                        </div>
                        <div class="form-group">
                            <textarea class="form-control" name="message" rows="5" data-rule="required" data-msg="Please write something for us" placeholder="Message"></textarea>
                            <div class="validation"></div>
                        </div>
                        <div class="text-center"><button type="submit">Send Message</button></div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</section>

<!--==========================
Decision Maker Section
============================-->
<section id="DecisionMaker" style="padding-top: 5em;">
    <div class="container wow fadeInUp">
        <div class="row">
            <div class="col-md-12">
                <h3 class="section-title">The Decision Maker</h3>
                <div class="section-title-divider"></div>
                <p class="section-description">An implementation of the world famous and highly acclaimed Decision Maker API</p>
            </div>
        </div>

        <div class="col-md-4">
            <div class="member">
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <div class="member">
                </div>
                <div id="decisionMakerWell" class="well well-lg">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title" style="text-align: center">The Decision Maker</h3>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <input type="text" id="userProblem" class="form-control input-sm" placeholder="state your problem">
                            </div>
                            <div class="row" style="margin: auto; width: 50%;">
                                <input checked name="isCrude" id="isCrude" data-toggle="toggle" data-onstyle="default" data-on="crudeness filter<br>ON" data-offstyle="danger" data-off="crudeness filter<br>OFF" type="checkbox">
                            </div>
                            <hr>
                            <div class="row" style="margin: auto; width: 50%;">
                                <input checked name="isIndecisive" id="isIndecisive" data-toggle="toggle" data-onstyle="default" data-on="indecisive filter<br>ON" data-offstyle="warning" data-off="indecisive filter<br>OFF" type="checkbox">
                            </div>
                            <hr>
                            <div class="row" style="margin: auto; width: 50%;">
                                <input checked name="isIrritated" id="isIrritated" data-toggle="toggle" data-onstyle="default" data-on="irritated filter<br>ON" data-offstyle="warning" data-off="irritated filter<br>OFF" type="checkbox">
                            </div>
                            <hr>
                            <input type="button" id="btnSubmit" value="Get Your Answer" class="btn btn-info btn-block">
                            <div id="answerContainer" style="text-align: center"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-3">
            <div class="member">
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

<!-- for maps -->
<script src="js/log.js"></script>
<!-- for decision maker -->
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<script src="js/validate.js"></script>


</body>

</html>