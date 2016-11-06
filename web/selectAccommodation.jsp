<%-- 
    Document   : locations
    Created on : Aug 26, 2016, 9:46:00 PM
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
        <title>Select Accommodation | Tour Buddy</title>
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
        <!-- Style for Radio/Checkboxes -->
        <link rel="stylesheet" href="css/funckyradio.css">
        <!-- End demo purposes only -->
        <style>
            #myProgress {
                position: relative;
                width: 100%;
                height: 30px;
                background-color: #ddd;
            }

            #myBar {
                position: absolute;
                width: 1%;
                height: 100%;
                background-color: #4CAF50;
            }
        </style>
        <!-- Modernizr JS -->
        <script src="js/modernizr-2.6.2.min.js"></script>
    </head>
    <body>
        <!--HEADER-->
        <%
            pageContext.include("common/navbar.jsp");

        %>
        <p hidden id="tourName"><%= session.getAttribute("tour_name")%></p>
        <!--END OF HEADER-->
        <!--Select Accommodation-->
        <div id="fh5co-our-services" data-section="services">
            <div class="container">
                <div class="row" id="team">
                    <div class="col-md-12  text-center">
                        <h2 class="to-animate">Select Your Accommodation</h2>
                        <div id="accomvalidationmsg"></div>
                        <br/>
                    </div>
                    <div class="row" id="topsection">
                        <div class="col-md-6" id="topmessage" >
                            <h4 class="text-primary to-animate">Displaying Accommodations for Accommodation Type<a href="register.jsp" style="color:#3367D6"> 5 STAR </a></h4>
                            <p>To change the Accommodation Type of your tour <a href="#" data-toggle="modal" data-target="#changeBudgetRangeModal"><font size="3">Please Click Here!</font></a></p>
                        </div>
                        <div class="col-md-6"><a href="#" onclick="getSelectedAccommodations()" class="btn btn-primary btn-sm pull-right">Use This</a></div>   
                    </div>
                    <div class="row">
                        <div id="location">
                        </div>
                        <br/><br/><br/>
                    </div>
                    <div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--End of Select Accommodation-->
<!--change accommodation type modal-->
<div class="modal fade" id="changeBudgetRangeModal" role="dialog" >
    <div class="modal-dialog modal-md">
        <div class="modal-content primary">
            <div class="modal-header" style="background-color:#6173F4">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" style="color:#ffffff">Change your Budget Range</h4>
            </div>
            <div class="modal-body primary">
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <div class="top-margin">
                            <label>Accommodation Type</label>
                            <select class="form-control" id="category">
                                <option>Select your Accommodation Type...</option>
                                <option>5 Star</option>
                                <option>4 Star</option>
                                <option>3 Star</option>
                                <option>2 Star</option>
                                <option>Budget Hotel</option>
                                <option>Guest House</option>
                            </select>
                        </div>
                        <div class=" text-right">
                            <br/><br/>
                            <input type="button" class="btn btn-primary btn-sm" onclick="displayLocations()" style="background-color:#6173F4" value="Apply"/>         
                        </div>
                    </div>
                    <div class="col-md-4"></div>
                </div>
            </div>			
        </div>
    </div>
</div>
<!-- end of change budget range modal-->
<!--accommodation more detail modal-->
<div class="modal fade" id="moreDetailModal" role="dialog">
    <div class="modal-dialog modal-lg" style="width:1100px">
        <div class="modal-content default">
            <div class="modal-header" style="background-color:#6173F4">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title" style="color:#ffffff" id="accomTitle"></h4>
            </div>
            <div class="modal-body primary">
                <div class="row">
                    <div class="col-lg-4">
                        <img id="accom_img" src="images/heritage.jpg" class="media-object" alt="Heritage" style = "width:310px; height:300px;">
                    </div>
                    <div class="col-lg-8">
                        <div class="row">
                            <div class="top-margin">
                                <label style="padding-left:2px">Hotel Name: </label>
                                <p id="locname" style="display:inline;padding-left:5px"></p>  
                            </div>
                            <div>
                                <label style="padding-left:2px">Category:</label>
                                <p style="display:inline;padding-left:3px" id="cat"></p>
                            </div>
                            <div>
                                <label style="padding-left:2px">Address :</label>
                                <p style="display:inline;padding-left:3px" id="add"></p>
                            </div>
                            <div>
                                <label style="padding-left:2px">Contact Number :</label>
                                <p style="display:inline;padding-left:3px" id="no"></p>
                            </div>
                            <div>
                                <label style="padding-left:2px">Description:  </label>
                                <p style="text-align:justify" style="display:inline;padding-left:3px;padding-right:5px" id="des"></p>
                            </div> 
                        </div>

                    </div>
                </div>
            </div>			
        </div>
    </div>
</div>
<!--end of accommodation more details modal-->
<!--FOOTER-->
<%     pageContext.include("common/footer.jsp");

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
<script src="js/controller/locationController.js" type="text/javascript"></script>
<script src="js/controller/routesController.js" type="text/javascript"></script>
</body>
</html>