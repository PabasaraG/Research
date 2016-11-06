<%-- 
    Document   : plantour
    Created on : Aug 22, 2016, 6:30:37 PM
    Author     : Sanduni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Tour Route | Tour Buddy</title>
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
        <!-- Style for Radio/Checkboxes -->
        <link rel="stylesheet" href="css/funckyradio.css">
        <!-- Modernizr JS -->
        <script src="js/modernizr-2.6.2.min.js"></script>
        <!--load the google maps API-->
        <script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAjtT69xOAvOW1nqdqYgLs0BDGsJeQVqJA"></script>
    </head>
    <body>
        <!--HEADER-->
        <%
            pageContext.include("common/navbar.jsp");

        %>
        <p hidden id="tourName"><%= session.getAttribute("tour_name")%></p>
        <p hidden id="startDate"><%= session.getAttribute("start_date")%></p>
        <p hidden id="endDate"><%= session.getAttribute("end_date")%></p>
        <!--END OF HEADER-->
        <!--tour route-->
        <div id="fh5co-our-services" data-section="services">
            <div class="container">
                <br/>
                <div class="row" id="team">
                    <div class="col-md-12  text-center">
                        <a href="#tourBuddy" class="btn btn-primary btn-block" style="align:left; height:40px">YOUR TOUR ROUTE & DAY PLAN</a>
                        <br/>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <button onclick="drawRoute()" class="btn btn-primary btn-sm text-center" style="align:center">View Tour Route</button>
                            <!-- <button onclick="viewAlgo()" class="btn btn-primary btn-sm text-center" style="align:center">View Algo</button>-->
                            <div class="col-md-3 pull-right" id="selectRouteMap">
                            </div>
                        </div>
                    </div>


                </div><br/>
                <div id="tourMapMessage">
                </div>
                <div id="tourMapMessageCheckBox">
                    <div class="row">
                        <div id="premium" class="col-md-6">
                        </div>
                        <div id="alternative" class="col-md-6">
                        </div>
                    </div>
                </div>
                
            </div>
            <div class="row" >
                <div class="col-md-4"></div>
                <div class="col-md-8">
                    <div class="row" id="dayOptions"></div>
                </div>
                
                </div>
            <div class="row">
                 <div class="col-md-4">
                   
                    <div class="box to-animate">
                        <div class="icon colored-6"><span><i class="icon-user"></i></span></div>
                        <h3>For creative like you!</h3>
                        <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    </div>
                </div>
                <div class="col-md-8">
                    <div  style = "width:1400px; height:520px;">
                        <div > 
                            <div id="gmap"  style = "width:1000px; height:490px;">
                            </div>
                        </div> 
                    </div>
                </div>
               

            </div>
        </div>
        <!--end of tour route-->
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
        <script src="js/controller/routesController.js" type="text/javascript"></script>
        <!--END OF SCRIPTS-->
    </body>
</html>
