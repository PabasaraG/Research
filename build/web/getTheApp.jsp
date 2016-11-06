<%-- 
    Document   : getTheApp
    Created on : Sep 7, 2016, 9:11:45 AM
    Author     : Sanduni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Get the App| Tour Buddy</title>
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

        <!-- Modernizr JS -->
        <script src="js/modernizr-2.6.2.min.js"></script>
    </head>
    <body>

        <!--HEADER-->
        <%
            pageContext.include("common/navbar.jsp");

        %>
        <!--END OF HEADER-->
        <!--get the app-->
        <div id="fh5co-our-services" data-section="services">
            <div class="container">
                <div class="row row-bottom-padded-lg" id="team">
                    <div class="row">
                        <div class="col-md-12  text-center">
                            <h1 class="to-animate">Get The App</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5 to-animate">
                            <br/><br/>
                            <img src="images/gettheapp.png" class="img-responsive img-rounded" alt="Free HTML5 Template">
                        </div>
                        <div class="col-md-7 to-animate">
                            <br/><br/>
                            <h2>Tour Buddy is your Smart Tour Guide</h2>
                            <h3></h3>
                            <h4>Download our free app on your Android smartphones or tablets.</h4>
                            <p>Discover and book hotels, restaurants, local experiences & activities in 50,000 destinations worldwide. Triposo works offline so you can wander freely.</p>
                            <br/><p><a href="home.jsp" class="btn btn-primary btn-sm">I already have It!</a><a href="https://play.google.com/store?hl=en" style="padding-left:30px"><img src="images/gplay.png" style="width:300px;height:70px;"></a></p>
                            <p>Enter your Mobile phone Number to receive a direct link to download the app:</p>
                            <div class="row">
                                <div class="col-md-5">
                                    <input type="text" class="form-control" id="username" placeholder="+1 (123)123-1234">
                                </div>
                                <a href="#" class="btn btn-primary btn-sm">Send</a>  
                            </div>
                        </div>
                    </div>
                    <div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--end of get the app-->
<!--FOOTER-->
<%    pageContext.include("common/footer.jsp");
%>
<!--END OF FOOTER-->
<!--SCRIPTS-->	
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
<script src="js/main.js"></script>
<!--END OF SCRIPTS-->
</body>
</html>