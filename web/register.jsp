<%-- 
    Document   : register
    Created on : Aug 24, 2016, 8:45:17 PM
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
        <title>Register | Tour Buddy</title>
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
        <header role="banner" id="fh5co-header" class="navbar-fixed-top " style="background-color: #ffffff; height:70px;color:#ffffff">
            <div class="container">
                <nav class="navbar navbar-default">
                    <div class="navbar-header">
                        <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
                        <a class="navbar-brand" href="index.html" style="color:#3367D6">TOUR BUDDY</a> 
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right" style="color:#ffffff">
                            <li><a href="index.jsp" data-nav-section="home"><span>Home</span></a></li>
                            <li><a href="#" data-nav-section="about"><span>Destinations</span></a></li>
                            <li><a href="#" data-nav-section="team"><span>Gallery</span></a></li>
                            <li><a href="#" data-nav-section="features"><span>Hotels & Resorts</span></a></li>
                            <li><a href="#" data-nav-section="pricing"><span>About Us</span></a></li>
                            <li><a href="#" data-nav-section="pricing"><span>Contact Us</span></a></li>
                            <li class="active"><a href="#" data-nav-section="services"><span>Register</span></a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <!--END OF HEADER-->
        <!--REGISTER PANEL-->
        <div id="fh5co-our-services" data-section="services">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 to-animate"  id="profile">
                        <div class="col-md-12  text-center">
                            <br/>
                            <h2 class="to-animate"><font size="8">REGISTER</font></h2>
                            <br/>
                            <div class="col-md-8 col-md-offset-2 to-animate">
                                <p>It's FREE and always will be...</p>
                                <p>Already have an Account? Then <a href="signin.jsp">Sign In</a> with Tour Buddy..</p>
                                <div id="validationmsg"></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-2"></div>
                            <div class="col-md-8">
                                <form>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="top-margin">
                                                <input id="firstName" class="form-control" placeholder="First Name" type="text">
                                            </div>
                                            <br/>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="top-margin">
                                                <input id="lastName" class="form-control" placeholder="Last Name" type="text">
                                            </div>
                                            <br/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="top-margin">
                                                <input id="email" class="form-control" placeholder="Email" type="text">
                                            </div>
                                            <br/>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="top-margin">
                                                <select class="form-control" id="country">
                                                    <option>Select Your Country</option>
                                                    <option>Canada</option>
                                                    <option>Australia</option>
                                                    <option>United Kingdom</option>
                                                    <option>France</option>
                                                    <option>China</option>
                                                </select>
                                            </div>
                                            <br/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="top-margin">
                                                <input id="password" class="form-control" placeholder="Password" type="password">
                                            </div>
                                            <br/>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="top-margin">
                                                <input id="confirmPassword" class="form-control" placeholder="Confirm Password" type="password">
                                            </div>
                                            <br/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="top-margin">
                                                <div class="row">
                                                    <div class="col-lg-4">
                                                        <select class="form-control" id="bDay">
                                                            <option>Day</option>
                                                            <option>1</option>
                                                            <option>2</option>
                                                            <option>3</option>
                                                            <option>4</option>
                                                            <option>5</option>
                                                            <option>6</option>
                                                            <option>7</option>
                                                            <option>8</option>
                                                            <option>9</option>
                                                            <option>10</option>
                                                            <option>11</option>
                                                            <option>12</option>
                                                            <option>13</option>
                                                            <option>14</option>
                                                            <option>15</option>
                                                            <option>16</option>
                                                            <option>17</option>
                                                            <option>18</option>
                                                            <option>19</option>
                                                            <option>20</option>
                                                            <option>21</option>
                                                            <option>22</option>
                                                            <option>23</option>
                                                            <option>24</option>
                                                            <option>25</option>
                                                            <option>26</option>
                                                            <option>27</option>
                                                            <option>28</option>
                                                            <option>29</option>
                                                            <option>30</option>
                                                            <option>31</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-lg-4">
                                                        <select class="form-control" id="bMonth">
                                                            <option>Month</option>
                                                            <option>January</option>
                                                            <option>February</option>
                                                            <option>March</option>
                                                            <option>April</option>
                                                            <option>May</option>
                                                            <option>June</option>
                                                            <option>July</option>
                                                            <option>August</option>
                                                            <option>September</option>
                                                            <option>October</option>
                                                            <option>November</option>
                                                            <option>December</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-lg-4">
                                                        <select class="form-control" id="bYear">
                                                            <option>Year</option>
                                                            <option>1980</option>
                                                            <option>1981</option>
                                                            <option>1982</option>
                                                            <option>1983</option>
                                                            <option>1984</option>
                                                            <option>1985</option>
                                                            <option>1986</option>
                                                            <option>1987</option>
                                                            <option>1988</option>
                                                            <option>1989</option>
                                                            <option>1990</option>
                                                            <option>1991</option>
                                                            <option>1992</option>
                                                            <option>1993</option>
                                                            <option>1994</option>
                                                            <option>1995</option>
                                                            <option>1996</option>
                                                            <option>1997</option>
                                                            <option>1998</option>
                                                            <option>1999</option>
                                                            <option>2000</option>
                                                            <option>2001</option>
                                                            <option>2002</option>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                            <br/>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="top-margin">
                                                <div class="row">
                                                    <div class="col-lg-6">
                                                        <div class="funkyradio">
                                                            <div class="funkyradio-primary">
                                                                <input type="radio" name="radio" id="radio1" value="male"/>
                                                                <label for="radio1" style="background-color:#ffffff"><font size="2">Male</font></label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-6">
                                                        <div class="funkyradio">
                                                            <div class="funkyradio-danger">
                                                                <input type="radio" name="radio" id="radio3" value="female"/>
                                                                <label for="radio3" style="background-color:#ffffff"><font size="2">Female</font></label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <br/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-5">
                                            <div class="funkyradio">
                                                <div class="funkyradio-success">
                                                    <input type="checkbox" name="checkbox" id="checkbox1"/>
                                                    <label for="checkbox1" style="background-color:#ffffff"><font size="2">Agree with <a href="#" data-toggle="modal" data-target="#termsConditionsModal">Terms & Conditions</a> ?</font></label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <hr>
                                            <div class="col-lg-8">
                                            </div>
                                            <div class="col-lg-4 text-right">
                                                <input type="button" class="btn btn-primary btn-sm" onclick="register()" style="background-color:#6173F4" value="Register"/>
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
        <!--terms & conditions modal-->
        <div class="modal fade" id="termsConditionsModal" role="dialog" >
            <div class="modal-dialog modal-md">
                <div class="modal-content primary">
                    <div class="modal-header" style="background-color:#6173F4">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title" style="color:#ffffff">TERMS & CONDITIONS</h4>
                    </div>
                    <div class="modal-body primary">
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-10">
                                <p style="text-align:justify">Acceptance of Privacy Statement
                                    Your use of our website(s), including any dispute concerning privacy, is subject to this privacy statement and the accompanying Terms of Use Agreement. BY USING OUR WEBSITE, YOU ARE ACCEPTING THE PRACTICES SET OUT IN THIS PRIVACY STATEMENT AND THE TERMS OF USE AGREEMENT. If we decide to change our privacy policy, we will post those changes to this privacy statement page and any other places we deem appropriate so that you are aware of what information we collect, how we use it, and under what circumstances, if any, we disclose it. We reserve the right to modify this privacy statement at any time, so please review it frequently. If we make material changes to this policy, we will notify you here, or by other means, such as email, at our discretion. Your continued use of any portion of the site following posting of the updated privacy statement will constitute your acceptance of the changes.</p>
                                <h4 style="color:#6173F4"><b>Effective Date :</b></h4>
                                <p>This privacy statement was last revised on<b> September 07, 2016</b>.</p>
                            </div>
                            <div class="col-md-1"></div>
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

