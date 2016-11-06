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
        <title>Sign In | Tour Buddy</title>
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
        <header role="banner" id="fh5co-header" class="navbar-fixed-top " style="background-color: #ffffff; height:70px;color:#ffffff">
            <div class="container">
                <nav class="navbar navbar-default">
                    <div class="navbar-header">
                        <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
                        <a class="navbar-brand" href="index.html" style="color:#3367D6">TOUR BUDDY</a> 
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right" style="color:#ffffff">
                            <li><a href="index.jsp"><span>Home</span></a></li>
                            <li><a href="#" data-nav-section="about"><span>Destinations</span></a></li>
                            <li><a href="#" data-nav-section="team"><span>Gallery</span></a></li>
                            <li><a href="#" data-nav-section="features"><span>Hotels & Resorts</span></a></li>
                            <li><a href="#" data-nav-section="pricing"><span>About Us</span></a></li>
                            <li><a href="#" data-nav-section="pricing"><span>Contact Us</span></a></li>
                            <li class="active"><a href="#" data-nav-section="services"><span>Sign In</span></a></li> </ul>
                    </div>
                </nav>
            </div>
        </header>
        <!--END OF HEADER-->
        <!--SIGN IN PANEL-->
        <div id="fh5co-our-services" data-section="services">
            <div class="container">
                <br/><br/>
                <div class="row row-bottom-padded-lg" id="team">
                    <div class="col-md-12  text-center">
                        <h2 class="to-animate"><font size="8">SIGN IN</font></h2>
                        <br/>
                        <div class="col-md-8 col-md-offset-2 to-animate">
                            <p>Not Having a Tour Buddy account yet? Then <a href="register.jsp" style="color:#3367D6">Register</a> with Tour Buddy today.</p>
                            <div id="validationmsg"></div>
                            <br/>
                        </div>
                    </div>
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <div>
                            <div class="to-animate">
                                <form>
                                    <div class="form-group">
                                        <input type="email" class="form-control" id="username" placeholder="Enter Username">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" class="form-control" id="password" placeholder="Enter password">
                                    </div>
                                    <div class="checkbox">
                                        <b><a href="#" data-toggle="modal" data-target="#forgotpaswordModal"><font size="2">Forgot password?</font></a></b>
                                    </div>
                                    <div class="row">
                                        <hr>
                                        <div class="col-lg-8">
                                        </div>
                                        <div class="col-lg-4 text-right">
                                            <input type="button" class="btn btn-primary btn-sm" onclick="login()" style="background-color:#6173F4" value="Sign In"/>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--END OF LOGIN PANEL-->
<!--forgot password modal-->
<div class="modal fade" id="forgotpaswordModal" role="dialog" >
    <div class="modal-dialog modal-md">
        <div class="modal-content primary">
            <div class="modal-header" style="background-color:#6173F4">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" style="color:#ffffff">Forgot Password?</h4>
            </div>
            <div class="modal-body primary">
                <div class="top-margin">

                    <label>Enter your Email address to send the verification code. <span class="text-danger"></span></label>
                    <br/>
                    <input type="text" class="form-control" id="forgotemail" placeholder="Your Tour Buddy Email Address">
                    <br/>
                    <div class="text-right">
                        <button onclick="" class="btn btn-primary btn-sm">Send</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--end of modal-->
<%
    pageContext.include("common/footer.jsp");

%>
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
<script src="js/controller/userController.js" type="text/javascript"></script>
</body>
</html>

