<%-- 
    Document   : tourPlanSum
    Created on : Sep 3, 2016, 4:58:47 PM
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
        <title>Tour Plan Summary | Tour Buddy</title>
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
        <!--tour plan summary-->
        <div id="fh5co-our-services" data-section="services">
            <div class="container">
                <br/>
                <div class="row row-bottom-padded-lg" id="team">
                    <div class="col-md-12  text-center">
                        <a href="#tourBuddy" class="btn btn-primary btn-block" style="align:left; height:40px">TOUR SUMMARY</a>
                        <br/>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <a href="#activity" class="btn btn-primary btn-sm" data-toggle="tab" style="background-color:#2BAF67"><b>TOUR DETAILS</b></a>
                            <a href="#timeline" onclick="mymethod()" class="btn btn-primary btn-sm" data-toggle="tab"  style="background-color:#01BFF3"><b>SELECTED DESTINATIONS</b></a>
                            <a href="#settings" class="btn btn-primary btn-sm" data-toggle="tab"  style="background-color:#F26522"><b>SELECTED ACCOMMODATION</b></a>
                            <a href="getTheApp.jsp" class="btn btn-primary btn-sm pull-right"  style="background-color:#6173F4"><b>FINISH</b></a>
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div class="active tab-pane" id="activity">
                                        <br/>
                                        <h2>YOUR TOUR DETAILS</h2>
                                        <div class="panel panel-default" style="width:1160px">
                                            <div class="panel-heading" style="background-color:#2BAF67;height:20px"></div>
                                            <div class="panel-body">
                                                <div class="col-md-6 to-animate">
                                                    <p>Tour Name :<label id="tourName" class="form-control" placeholder="First Name" type="text" style="height:40px"><%= session.getAttribute("tour_name")%></label></p>
                                                    <p>Start Date :<label id="startDate" class="form-control" placeholder="First Name" type="text" style="height:40px"><%= session.getAttribute("start_date")%></label></p>
                                                    <p>End Date :<label id="endDate" class="form-control" placeholder="First Name" type="text" style="height:40px"><%= session.getAttribute("end_date")%></label></p>
                                                </div>
                                                <div class="col-md-6 to-animate">
                                                    <p>Budget Range :<label id="budgetRange" class="form-control" placeholder="First Name" type="text" style="height:40px"><%= session.getAttribute("budget_range")%></label></p>
                                                    <p>Accommodation Type:<label id="accType" class="form-control" placeholder="First Name" type="text" style="height:40px"><%= session.getAttribute("accom_type")%></label></p>
                                                    <p>Traveling Type :<label id="travelType" class="form-control" placeholder="First Name" type="text" style="height:40px"><%= session.getAttribute("travel_type")%></label></p>
                                                </div>
                                                <button class="btn btn-primary btn-sm pull-right" type="submit" style="background-color:#2BAF67">Change My Tour Details</button>
                                            </div>
                                            <div class="panel-footer"  style="background-color:#2BAF67;height:20px"></div>
                                        </div>
                                    </div><!-- /.tab-pane -->
                                    <div class="tab-pane" id="timeline">
                                        <br/>
                                        <h2>YOUR DESTINATIONS</h2>
                                        <div class="panel panel-default" style="width:1160px">
                                            <div class="panel-heading" style="background-color:#01BFF3;height:20px"></div>
                                            <div class="panel-body" id="san">
                                                <div class="col-md-3 col-sm-6 to-animate">
                                                    <a href="#" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#charterModal" style="background-color:#01BFF3;width:260px"><b>TEMPLE OF TOOTH RELIC</b></a>
                                                    <a href="#" class="pull-left">
                                                        <img src="images/categories/heritage.jpg" class="media-object" alt="Heritage" style = "width:260px; height:260px;">
                                                    </a>
                                                    <hr>
                                                </div>
                                            </div><br/>
                                            <button class="btn btn-primary btn-sm pull-right" type="submit" style="background-color:#01BFF3">Change My Destinations</button>
                                        </div>
                                        <div class="panel-footer"  style="background-color:#01BFF3;height:20px"></div>
                                    </div>
                                </div><!-- /.tab-pane -->
                                <div class="tab-pane" id="settings">
                                    <br/>
                                    <h2>YOUR ACCOMMODATION</h2>
                                    <div class="panel panel-default" style="width:1160px">
                                        <div class="panel-heading" style="background-color:#F26522;height:20px"></div>
                                        <div class="panel-body" id="ruk">
                                            <br/>
                                            <button class="btn btn-primary btn-sm pull-right" type="submit" style="background-color:#F26522">Change My Accommodation</button>
                                        </div>
                                        <div class="panel-footer"  style="background-color:#F26522;height:20px"></div>
                                    </div>
                                </div><!-- /.tab-pane -->
                                <div class="tab-pane" id="route">
                                    <br/>
                                    <h2>YOUR TOUR ROUTE</h2>
                                    <div class="panel panel-default" style="width:1160px">
                                        <div class="panel-heading" style="background-color:#E52B50;height:20px"></div>
                                        <div class="panel-body">
                                            <p hidden id="selectedRoute"><%= session.getAttribute("selected_route")%></p>
                                        </div>
                                        <div class="panel-footer"  style="background-color:#E52B50;height:20px"></div>
                                    </div>
                                </div><!-- /.tab-pane -->
                            </div><!-- /.tab-content -->
                        </div><!-- /.nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
                <div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!--end of tour summary-->
<!--FOOTER-->
<%
    pageContext.include("common/footer.jsp");

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
<script src="js/controller/plansum.js" type="text/javascript"></script>
<!--END OF SCRIPTS-->
</body>
</html>
