<!DOCTYPE html>
<%@include file="tagLibrary.jsp"%>
<!-- disables forms when user is not logged in -->
<c:set var="disabledByDefault" value="${(empty disabledByDefault) ? 'disabled' : ''}" />
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Snag Log</title>
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


  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/snaglog_custom.css">
  <link rel="stylesheet" href="css/snaglog_modal.css">

  <script src="js/validate.js"></script>

  <!-- for bootstrap toggles and DecisionMaker widget -->
  <script src="js/decisionMaker.js"></script>
  <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">

  <link rel="stylesheet" href="css/decisionMaker.css">



</head>

<body>
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

        <h1>Welcome to Snag Log</h1>
        <h2>The paddler's source for <span class="rotating">paddle times, flow conditions, blockage locations, community </span></h2>
        <div class="actions">
          <a href="#instructions" class="btn-get-started">Get Started</a>
          <a href="#services" class="btn-services">Mark a Snag</a>
        </div>
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

  <!--==========================
  About Section
  ============================-->
  <section id="instructions">
    <div class="container wow fadeInUp">
      <div class="row">
        <div class="col-md-12">
          <h3 class="section-title">How to Use Snag Log</h3>
          <div class="section-title-divider"></div>
          <p class="section-description"> Snag Log is the paddling community's place for current information </p>
        </div>
      </div>
    </div>
    <div class="container about-container wow fadeInUp">
      <div class="row">
        <div class="col-md-6 col-md-push-6 about-content">
          <h2 class="about-title">Your source for paddling information</h2>
          <p class="about-text">
            SnagLog provides near point and click marking of tree falls, low water areas, and
            general obstructions with use of a smart phone. Additionally, SnagLog gives paddlers
            access to quick tools to document the paddling adventures in a community atmosphere.
            <br>
            <br>
          </p>
          <p class="about-text">
            Paddling blockages can range from mere annoyances to outright dangers.
            Before you go, check the master map of snags along your route.
            Join the SnagLog community to mark new found snags with just a phone and a few clicks.
            <br><a href="#map">View the snag map.</a>
            <br>
          </p>
          <p class="about-text">
            Need ideas for your next adventure, check the list of user added trips.
            On return, chronicle your adventures in a snag log.
            Rate your trip, add recommendations, and give updated conditions and travel times.
            Be part of the community.
            <br><a href="#portfolio">View recent logs.</a>
            <br><a href="#">See the log map</a>
            <br>
          </p>
        </div>
      </div>
    </div>
  </section>



  <div id="map"></div>
  <!--==========================
  Services Section
  ============================-->
  <section id="services">
    <div class="container wow fadeInUp">
      <div class="row">
        <div class="col-md-12">
          <h3 class="section-title">Mark a Snag</h3>
          <div class="section-title-divider"></div>
          <p class="section-description">Click map above to add snag coordinates to form
            <c:choose>
              <c:when test="${not empty loggedInUsersName}">
                <!-- don't do anything if user is logged in -->
              </c:when>
              <c:otherwise>
                <br><h4><a href="login">Login to Mark Snag</a></h4>
              </c:otherwise>
            </c:choose>
          </p>
        </div>
      </div>
     <div class="row">
       <div class="col-md-12">
         <!-- Map Section -->

             <div class="eventtext">
               <form class="form-group" method="post" action="markSnag">
                 <div>Latitude: <span id="latspan"></span></div>
                 <div>Longitude: <span id="lngspan"></span></div>
                 <div><lable>Selected Coordinates:</lable><br>
                   <input class="input-sm" type="text" id="latitudeClicked"  name="latitudeClicked" ${disabledByDefault}> latitude<br>
                   <input class="input-sm" type="text" id="longitudeClicked"  name="longitudeClicked" ${disabledByDefault}> longitude
                 </div>
                 <div>
                   <lable for="blockageType">Blockage Type</lable><br>
                   <select class="form-control" name="blockageType" ${disabledByDefault}>
                     <option value="noSelection">click to select</option>
                     <option value="rocks">low water exposed rocks</option>
                     <option value="mud">low water mud</option>
                     <option value="treeFall">tree fall</option>
                     <option value="other">other</option>
                   </select>
                 </div>
                 <div>
                   <lable for="hazardOrNot">Snag is </lable><br>
                   <select class="form-control" name="hazardOrNot" ${disabledByDefault}>
                     <option value="noSelection">click to select</option>
                     <option value="annoying">annoying</option>
                     <option value="slight">slight hazard</option>
                     <option value="major">major hazard</option>
                   </select>
                 </div>
                 <div>
                   <lable for="timeDelay">Time required to navigate blockage in minutes</lable><br>
                   <input type="text" class="input-small" name="timeDelay" ${disabledByDefault}>
                 </div>
                 <div>
                   <lable for="additionalBlockageInformation">Additional description or information</lable><br>
                   <input class="input-sm" type="text" name="additionalBlockageInformation" ${disabledByDefault}>
                 </div>
                 <div>
                   <c:choose>
                     <c:when test="${not empty loggedInUsersName}">
                       <input type="submit" value="mark the snag">
                     </c:when>
                     <c:otherwise>
                       <h4><a href="login">Login to Mark Snag</a></h4>
                     </c:otherwise>
                   </c:choose>
                 </div>
               </form>
             </div>
           </div>

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
          <a class="subscribe-btn" href="requestDirector?destination=log">Log it Now!</a>
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
  <script src="js/maps.js"></script>
  <script src="js/grabLogsReverseOrder.js"></script>

  <!-- for decision maker -->
  <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>


</body>

</html>
