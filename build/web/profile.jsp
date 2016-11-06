<%-- 
    Document   : profile
    Created on : Sep 3, 2016, 10:36:55 PM
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
        <title>Profile | Tour Buddy</title>
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
    </head>
    <body>

        <!--HEADER-->
        <%
            pageContext.include("common/navbar.jsp");

        %>
        <!--END OF HEADER-->

        <!--my profile bar with the image-->
        <div id="fh5co-our-services" data-section="services">
            <div class="container">
                <div class="row row-padded-lg">
                    <section>
                        <div class="col-lg-3" style="background:#ffffff;height:900px">
                            <div class="text-center to-animate">
                                <div class="person">
                                    <h3 class="name" style="color:#6173F4"><strong>MY PROFILE</strong></h3>
                                    <br/>
                                    <input type="file" name="file" id="file" class="inputfile" style="display:none"/>
                                    <label for="file"> <img src="images/<%= session.getAttribute("user_image")%>" class="img-responsive img-rounded" alt="Person"></label>
                                    <h3 class="name" style="color:#6173F4"><strong><%= session.getAttribute("first_name")%></strong></h3>
                                    <div class="position" ><strong><%= session.getAttribute("first_name")%><%=" "%><%= session.getAttribute("last_name")%></strong></div>
                                    <br/>
                                    <a href="#profile" class="btn btn-primary btn-sm" style="color:#ffffff;width:260px" data-toggle="tab" aria-expanded="false">Personal Information</a><br/><br/>
                                    <a href="#interests" class="btn btn-primary btn-sm" style="color:#ffffff;width:260px" data-toggle="tab" aria-expanded="false">Interests</a><br/><br/>
                                    <a href="index.jsp" class="btn btn-primary btn-sm" style="color:#ffffff;width:260px">Sign Out</a>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!--start tab contents-->
                    <div class="tab-content"> 
                        <!--personal Information-->
                        <div class="col-md-8 to-animate tab-pane active"  id="profile">
                            <a href="#tourBuddy" class="btn btn-primary btn-block" style="width:800px">PERSONAL INFORMATION</a>
                            <br/>
                            <div class="panel panel-default" style="width:800px">
                                <div class="panel-body"> 
                                    <!--<div class="row"><a href="#" class="pull-right" type="submit">Edit</a></div>-->
                                    <div class="col-md-6">
                                        <p>First Name:<labell id="firstname" class="form-control" placeholder="First Name" type="text" style="height:40px"><%= session.getAttribute("first_name")%></label></p>
                                            <p>Email:<labell id="email" class="form-control" placeholder="First Name" type="text" style="height:40px"><%= session.getAttribute("user_name")%></label></p>
                                                <p>Birth Date:<labell id="birthdate" class="form-control" placeholder="First Name" type="text" style="height:40px"><%= session.getAttribute("birth_date")%></label></p>
                                                    </div>
                                                    <div class="col-md-6">
                                                        <p>Last Name:<labell id="lastname" class="form-control" placeholder="First Name" type="text" style="height:40px"><%= session.getAttribute("last_name")%></label></p>
                                                            <p>Country:<labell id="country" class="form-control" placeholder="First Name" type="text" style="height:40px"><%= session.getAttribute("country")%></label></p>
                                                                <p>Gender:<labell id="gender" class="form-control" placeholder="First Name" type="text" style="height:40px"><%= session.getAttribute("gender")%></label></p>
                                                                    </div>
                                                                    <div class="row" style="padding-left:35px">
                                                                        <p>Are you a?</p>
                                                                    </div>
                                                                    <div class="row">
                                                                        <div class="col-md-3">
                                                                            <div class="funkyradio" style="padding-left:22px">
                                                                                <div class="funkyradio-danger" style="width:150px;height:50px">
                                                                                    <input type="radio" name="radio" id="student" />
                                                                                    <label for="student" style="background-color:#ffffff"><font size="2">A Student</font></label>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <div class="funkyradio" style="padding-left:22px">
                                                                                <div class="funkyradio-danger" style="width:150px;height:50px">
                                                                                    <input type="radio" name="radio" id="worker" />
                                                                                    <label for="worker" style="background-color:#ffffff"><font size="2">A Worker</font></label>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <div class="funkyradio" style="padding-left:22px">
                                                                                <div class="funkyradio-danger" style="width:150px;height:50px">
                                                                                    <input type="radio" name="radio" id="both" />
                                                                                    <label for="both" style="background-color:#ffffff"><font size="2"> Both</font></label>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <div class="funkyradio" style="padding-left:22px">
                                                                                <div class="funkyradio-danger" style="width:150px;height:50px">
                                                                                    <input type="radio" name="radio" id="retired" />
                                                                                    <label for="retired" style="background-color:#ffffff"><font size="2">Retired</font></label>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <br/><br/>
                                                                        <div class="row" style="padding-left:50px">
                                                                            <p>Relationship Status :</p>
                                                                        </div>
                                                                        <div class="row">
                                                                            <div class="col-md-3">
                                                                                <div class="funkyradio" style="padding-left:33px">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio2" id="single" />
                                                                                        <label for="single" style="background-color:#ffffff"><font size="2">Single</font></label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-3">
                                                                                <div class="funkyradio" style="padding-left:33px">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio2" id="married" />
                                                                                        <label for="married" style="background-color:#ffffff"><font size="2">Married</font></label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-3">
                                                                                <div class="funkyradio" style="padding-left:33px">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio2" id="complicated" />
                                                                                        <label for="complicated" style="background-color:#ffffff"><font size="2"> Complicated</font></label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <br/><br/>
                                                                            <div class="row" style="padding-left:65px">
                                                                                <p>Religious Views :</p>
                                                                            </div>
                                                                            <div class="row">
                                                                                <div class="col-md-3">
                                                                                    <div class="funkyradio" style="padding-left:43px">
                                                                                        <div class="funkyradio-info" style="width:150px;height:50px">
                                                                                            <input type="radio" name="radio3" id="buddhist" />
                                                                                            <label for="buddhist" style="background-color:#ffffff"><font size="2">Buddhist</font></label>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col-md-3">
                                                                                    <div class="funkyradio" style="padding-left:43px">
                                                                                        <div class="funkyradio-info" style="width:150px;height:50px">
                                                                                            <input type="radio" name="radio3" id="christian" />
                                                                                            <label for="christian" style="background-color:#ffffff"><font size="2">Christian</font></label>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col-md-3">
                                                                                    <div class="funkyradio" style="padding-left:33px">
                                                                                        <div class="funkyradio-info" style="width:150px;height:50px">
                                                                                            <input type="radio" name="radio3" id="muslim" />
                                                                                            <label for="muslim" style="background-color:#ffffff"><font size="2"> Muslim</font></label>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="col-md-3">
                                                                                    <div class="funkyradio" style="padding-left:20px">
                                                                                        <div class="funkyradio-info" style="width:140px;height:50px">
                                                                                            <input type="radio" name="radio3" id="hindu" />
                                                                                            <label for="hindu" style="background-color:#ffffff"><font size="2">Hindu</font></label>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                                <br/><br/>
                                                                                <div class="row" style="padding-left:60px">
                                                                                    <div class="col-md-8">
                                                                                        <p>About Me :<textarea name="message" id="aboutme" cols="30" rows="5" class="form-control" placeholder="About Me"></textarea></p>
                                                                                    </div>					
                                                                                </div>
                                                                                <div class="row" style="padding-left:60px">
                                                                                    <div class="col-md-9">
                                                                                    </div>
                                                                                    <div class="col-md-3">

                                                                                    </div>			
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    </div>
                                                                    </div>
                                                                    </div>
                                                                    <!--interests-->
                                                                    <div class="col-md-8 to-animate tab-pane" id="interests">
                                                                        <a href="#tourBuddy" class="btn btn-primary btn-block" style="align:left">INTERESTS</a>
                                                                        <br/>
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="row">
                                                                                    <p>Your main concern on a tour :</p>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="transportation" />
                                                                                        <label for="transportation" style="background-color:#ffffff"><font size="2">Transportation</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="accommodation" />
                                                                                        <label for="accommodation" style="background-color:#ffffff"><font size="2">Accommodation</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="foods" />
                                                                                        <label for="foods" style="background-color:#ffffff"><font size="2">Foods</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="entertainment" />
                                                                                        <label for="entertainment" style="background-color:#ffffff"><font size="2">Entertainment</font></label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="row">
                                                                                    <p>You use to travel for?</p>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="leisure" />
                                                                                        <label for="leisure" style="background-color:#ffffff"><font size="2">Leisure</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="business" />
                                                                                        <label for="business" style="background-color:#ffffff"><font size="2">Business</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:180px;height:50px">
                                                                                        <input type="radio" name="radio" id="makenewfriends" />
                                                                                        <label for="makenewfriends" style="background-color:#ffffff"><font size="2">Make new friends</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="visitnewplaces" />
                                                                                        <label for="visitnewplaces" style="background-color:#ffffff"><font size="2">Visit new places</font></label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="row">
                                                                                    <p>Have you ever visited Sri Lanka before?</p>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="yes" />
                                                                                        <label for="yes" style="background-color:#ffffff"><font size="2">Yes</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="no" />
                                                                                        <label for="no" style="background-color:#ffffff"><font size="2">No</font></label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <!--second row of interests-->
                                                                        <br/><br/>
                                                                        <div class="row">
                                                                            <div class="col-md-4">
                                                                                <div class="row">
                                                                                    <p>Most challenging problem when choosing a destination?</p>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="qualityofservice" />
                                                                                        <label for="qualityofservice" style="background-color:#ffffff"><font size="2">Quality of service</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="reliability" />
                                                                                        <label for="reliability" style="background-color:#ffffff"><font size="2">Reliability</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="languagedifficulties" />
                                                                                        <label for="languagedifficulties" style="background-color:#ffffff"><font size="2">Language Difficulties</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="price" />
                                                                                        <label for="price" style="background-color:#ffffff"><font size="2">Price</font></label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="row">
                                                                                    <p>Main reason for your visits?</p>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio2" id="fun" />
                                                                                        <label for="fun" style="background-color:#ffffff"><font size="2">Fun</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio2" id="visitrelativesandfriends" />
                                                                                        <label for="visitrelativesandfriends" style="background-color:#ffffff"><font size="2">Visit relatives and friends</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:180px;height:50px">
                                                                                        <input type="radio" name="radio2" id="religiousreasons" />
                                                                                        <label for="religiousreasons" style="background-color:#ffffff"><font size="2">Religious reasons</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio2" id="restandrelaxation" />
                                                                                        <label for="restandrelaxation" style="background-color:#ffffff"><font size="2">Rest & relaxation</font></label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="col-md-4">
                                                                                <div class="row">
                                                                                    <p>How often do you travel?</p>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="onceinayear" />
                                                                                        <label for="onceinayear" style="background-color:#ffffff"><font size="2">Once in a year</font></label>
                                                                                    </div>
                                                                                </div>
                                                                                <div class="funkyradio">
                                                                                    <div class="funkyradio-success" style="width:150px;height:50px">
                                                                                        <input type="radio" name="radio" id="onceinamonth" />
                                                                                        <label for="onceinamonth" style="background-color:#ffffff"><font size="2">Once in a month</font></label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    </div> 
                                                                    </div>
                                                                    </div>
                                                                    </div>
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
                                                                    </body>
                                                                    </html>