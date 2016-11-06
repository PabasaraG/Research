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
          <%
            pageContext.include("common/navbar.jsp");

        %>
        <!--END OF HEADER-->

        <!--SIGN IN PANEL-->
        <div id="fh5co-our-services" data-section="services">
            <div class="container">
                <br/>
            <!--    <div class="row row-bottom-padded-lg" id="team">-->
             <div class="col-md-12 to-animate"  id="profile">
                    <div class="col-md-12 text-center">
                       <br/>
                            <h2 class="to-animate"><font size="8">CREATE A TOUR</font></h2>
                     
                   
                        <div class="col-md-8 col-md-offset-2 to-animate">
                            <p>Not Created a Tour yet? Then <a href="createtour.jsp" style="color:#3367D6">Create Tour</a> with Tour Buddy today.</p>
                           
                        </div>
                    </div>
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <div>
                            <div class="to-animate">
                                <div id="validationmsg" style="color:#d43f3a"></div>
                                <form>
                                    
                              <h1 style="color:#696969"><font size="3">Tour Name:</font></h1>
                                         
                               <div class="row">
                                        <div class="col-lg-12">
                                                <div class="top-margin">
                                               
                                                <input id="tname" class="form-control" placeholder="Tour Name" type="text">
                                            </div>
                                       
                                        </div>
                                                    
                                    </div>
                                    <!--					   <div class="input-group date" data-provide="datepicker">
                                        <input type="text" class="form-control">
                                        <div class="input-group-addon">
                                            <span class="glyphicon glyphicon-th"></span>
                                        </div>
                                    </div>-->

                                    <div class="row">
                                        <div class="col-lg-6">
                                                <div class="top-margin">
                                                     <h1 style="color:#696969"><font size="3">Start Date:</font></h1>
                                                <div class="input-group date" data-provide="datepicker">
                                                    <input type="date" class="form-control" placeholder="Start Date" id="tstartdate">
                                                    <div class="input-group-addon">
                                                        <span class="glyphicon glyphicon-th"></span>
                                                    </div>
                                                </div>
                                            </div>
                                           
                                        </div>
                                          
                                        <div class="col-lg-6">
                                            
                                                <div class="top-margin">
                                               <h1 style="color:#696969"><font size="3">End Date:</font></h1>           
                                                <div class="input-group date" data-provide="datepicker">
                                                    <input type="date" class="form-control" placeholder="End Date" id="tenddate">
                                                    <div class="input-group-addon">
                                                        <span class="glyphicon glyphicon-th"></span>
                                                    </div>
                                                </div>
                                            
                                           
                                        </div>
                                    </div>
                                               
                                    <div class="row">
                                        <div class="col-lg-4">
                                                <div class="top-margin">
                                                <h1 style="color:#696969"><font size="3">Accommodation Type:</font></h1> 
                                                <select class="form-control" id="tacc" placeholder="Select your Accommodation Type" >
                                                    <option disabled selected>Select your Accommodation Type</option>
                                                    <option value="5 star" >5 star</option>
                                                    <option value="4 star">4 star</option>
                                                    <option value="3 star">3 star</option>
                                                    <option value="2 star">2 star</option>
                                                    <option value="Guest House">Guest House</option>
                                                </select>
                                            </div>
                                         
                                        </div>
                                         
                                        <div class="col-lg-4">
                                                <div class="top-margin">
                                                       <h1 style="color:#696969"><font size="3">Budget Range:</font></h1>              
                                                <select class="form-control" id="tbudget" placeholder="Select your Budget Range" >
                                                    <option disabled selected>Select your Budget Range</option>
                                                    <option value="500$ - 999$" >500$ - 999$</option>
                                                    <option value="1000$ - 1499$">1000$ - 1499$</option>
                                                    <option value="1500$ - 1999$">1500$ - 1999$ </option>
                                                    <option value="2000$ - 4999$">2000$ - 4999$</option>
                                                    <option value="Above 5000$<">Above 5000$</option>
                                                </select>
                                            </div>
                                           
                                        </div>
                                           
                                        <div class="col-lg-4">
                                                <div class="top-margin">
                                                <h1 style="color:#696969"><font size="3">Travel Type:</font></h1>
                                                <select class="form-control" id="ttravel" placeholder="Select your Traveling Type" >
                                                    <option disabled selected>Select your Travel Type</option>
                                                    <option value="Public_Bus">Public Bus</option>
                                                    <option value="Train">Train</option>
                                                    <option value="Private_Vehicle">Private Vehicle</option>
                                                    <option value="Three_Wheeler ">Three Wheeler</option>
                                                    
                                                </select>
                                            </div>
                                          
                                        </div>
                                    </div>
                                               
                                    <div class="row">
                                        <div class="col-lg-5">
                                                <div class="funkyradio">
                                                                     
                                                                     
                                            </div>
                                        </div>
                    
                    
                    
                    
                                        <div class="row">
                                            <hr>
                                                <div class="col-lg-8">
                                                                            
                                            </div>
                                                <div class="col-lg-4 text-right">
                                                                        
                                                <input type="button" class="btn btn-primary btn-sm" onclick="addTour()" data-toggle="modal"  data-target="#typemodal" style="background-color:#6173F4" value="Create Tour"/>
                                                                                    
                                            </div>
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
    <div class="modal fade" id="typemodal" role="dialog" >
        <div class="modal-dialog modal-md">
            <div class="modal-content primary">
                <div class="modal-header" style="background-color:#01BFF3">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" style="color:#ffffff">SELECT YOUR PLAN TYPE</h4>
                </div>
                <div class="modal-body primary">
                   
                    <div class="row">
                        
                        <div class="top-margin">
                        
                        <div class="col-lg-6"> 
                            <img src="images/survey.png" style="height:150px;width:150px;margin-left:75px;margin-top:26px"/>
                          
                        </div>
                         <div class="col-lg-6"> 
                            <img src="images/twitter.jpg" style="height:200px;width:200px;margin-left:20px;margin-right:75px"/>
                          
                        </div>
                         
                        </div>
                    </div>
                     <div class="row">
                        
                        <div class="top-margin">
                      
                        <div class="col-lg-6 "> 
                         
                            <a href="survey.jsp" class="btn btn-info btn-sm" style="height:30px;width:200px;margin-left:55px">Let a Survey to Plan</a>
                           
                       
                          
                        </div>
                         <div class="col-lg-6"> 
                            <a href="/tourbuddy/login" class="btn btn-info btn-sm" style="height:30px;width:200px;margin-left:25px">Let Twitter to Plan</a>
                          
                        </div>
                         
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
<script src="js/controller/tourController.js" type="text/javascript"></script>
</body>
</html>

