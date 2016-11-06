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
	<title>Select Destinations | Tour Buddy</title>
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
     <%
            pageContext.include("common/navbar.jsp");

        %>
        <!--END OF HEADER-->
        

        <!--SIGN IN PANEL-->
       
        <div id="fh5co-our-services" data-section="services">
            <div class="container">
                  <div class="col-md-12  text-center">
                        <h2 class="to-animate">Predicted Locations</h2>
                        <div id="accomvalidationmsg"></div>
                        <br/>
                    </div>
                <br/><br/>
                <div class="row" id="catList"></div>
                 <input type="button" class="btn btn-primary btn-sm" onclick="getSelectedPlaces()" style="background-color:#6173F4;margin-left:1000px" value="getplaces"/>
            </div>
             <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        </div>
        <!--END OF LOGIN PANEL-->
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
                                <label style="padding-left:2px">Location Name: </label>
                                <p id="locname" style="display:inline;padding-left:5px"></p>  
                            </div>
                            <div>
                                <label style="padding-left:2px">Category:</label>
                                <p style="display:inline;padding-left:3px" id="cat"></p>
                            </div>
                           
                            <div>
                                <label style="padding-left:2px">Description:  </label>
                                <p style="text-align:justify" style="display:inline;padding-left:3px;padding-right:5px" id="des"></p>
                            </div> 
                        </div>
                         <div> <br/><br/><br/> <br/><br/><br/> <br/><br/><br/></div>

                    </div>
                </div>
            </div>			
        </div>
    </div>
</div>
<!--end of accommodation more details modal-->
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
        <script src="js/controller/categoryController.js" type="text/javascript"></script>
    </body>
</html>


