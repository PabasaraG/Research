<%-- 
    Document   : signin
    Created on : Aug 24, 2016, 7:32:46 PM
    Author     : Sanduni
--%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Central Province Locations | Tour Buddy</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
        <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
        <meta name="author" content="FREEHTML5.CO" />

        <link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,600,400italic,700' rel='stylesheet' type='text/css'>
        <!-- Animate.css -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="css/icomoon.css">
        <!-- Simple Line Icons -->
        <link rel="stylesheet" href="css/simple-line-icons.css">
        <!-- Owl Carousel -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <!-- Bootstrap  -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/style.css">
        <!-- Styleswitcher ( This style is for demo purposes only, you may delete this anytime. ) -->
        <link rel="stylesheet" id="theme-switch" href="css/style.css">
        <!-- End demo purposes only -->
        <link rel="stylesheet" href="css/funckyradio.css">
        <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">   
        <link rel="stylesheet" href="css/jquery.fancybox.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <!-- Modernizr JS -->
        <script src="js/modernizr-2.6.2.min.js"></script>
    </head>
    <body>
        <!--HEADER-->
        <header role="banner" id="fh5co-header" class="navbar-fixed-top " style="background-color: #ffffff; height:90px;color:#ffffff">
            <div class="container">
                <nav class="navbar navbar-default">
                    <div class="navbar-header">
                        <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
                        <a class="navbar-brand" href="index.html" style="color:#3367D6">TOUR BUDDY</a> 
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right" style="color:#ffffff">
                            <li><a href="#" data-nav-section="home"><span>Home</span></a></li>
                            <li><a href="#" data-nav-section="about"><span>Destinations</span></a></li>
                            <li><a href="#" data-nav-section="team"><span>Gallery</span></a></li>
                            <li><a href="#" data-nav-section="features"><span>Hotels & Resorts</span></a></li>
                            <li><a href="#" data-nav-section="pricing"><span>About Us</span></a></li>
                            <li class="active"><a href="#" data-nav-section="services"><span>Sign In</span></a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <!--END OF HEADER-->
        <!--Select Locations-->
        <div id="fh5co-our-services" data-section="services">
            <div class="container">
                <div class="row" id="team">
                    <div class="col-md-12  text-center">
                        <h2 class="to-animate">Select Your favourite Locations</h2>
                        <div id="accomvalidationmsg"></div>
                        <br/>
                    </div>
                    <div class="row" id="topsection">
                        <div class="col-md-6" id="topmessage" >
                            <h4 class="text-primary to-animate">Best suited Destination Categories for your preferences.</h4>
                            <a><h1 style="color:#2BAF67"><b>Historical | Beaches | WildLife </b></h1></a>
                            <br/>
                        </div>
                        <div class="col-md-6"><a href="#" onclick="getSelectedAccommodations()" class="btn btn-primary btn-sm pull-right">Use This</a></div>   
                    </div>
                    <div class="row">
                        <div class="col-lg-7">
                            <h4> Select or Search your favourite destinations from Central Province here.</h4>
                        </div>
                        <div class="col-lg-3">
                            <input class="form-control" placeholder="Search your favourite destinations here" name="srch-term" id="srch-term" type="text">
                        </div>
                        <div class="col-md-2">
                            <input type="button" class="form-control" onclick="search()" value="Search"/>
                        </div>
                        <br/><br/><br/>
                        <div class="container">
                            <div class="row" id="catList"></div>
                            <input type="button" class="btn btn-primary btn-sm" onclick="sendSelectedPlaces()" style="background-color:#6173F4;margin-left: 270px" value="getplaces"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--End of Select Locations-->



    <%
        pageContext.include("common/footer.jsp");
    %>
    <!--SCRIPTS-->	
    <!-- jQuery -->
    <!-- jQuery -->
    <script src="js/jquery.min.js"></script>
    <!-- jQuery Easing -->
    <script src="js/jquery.easing.1.3.js"></script>
    <!-- Bootstrap -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Waypoints -->
    <script src="js/jquery.waypoints.min.js"></script>
    <!-- Owl Carousel -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- Main JS (Do not remove) -->

    <script src="js/jquery.fancybox.pack.js"></script>
    <!-- Main JS (Do not remove) -->
    <script src="js/main.js"></script>
    <script src="js/meta/queryString.js" type="text/javascript"></script>
    <script src="js/controller/centralLocationController.js" type="text/javascript"></script>
</body>
</html>


