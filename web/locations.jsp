<%-- 
    Document   : locations
    Created on : Aug 26, 2016, 9:46:00 PM
    Author     : Sanduni
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Always force latest IE rendering engine -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Meta Keyword -->
        <meta name="keywords" content="one page, business template, single page, onepage, responsive, parallax, creative, business, html5, css3, css3 animation">
        <!-- meta character set -->
        <meta charset="utf-8">

        <!-- Site Title -->
        <title>Plan Your Tour| Tour Buddy</title>



        <!--
        Google Fonts
        ============================================= -->
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700" rel="stylesheet" type="text/css">

        <!--
        CSS
        ============================================= -->
        <!-- Fontawesome -->
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <!-- Bootstrap -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Fancybox -->
        <link rel="stylesheet" href="css/jquery.fancybox.css">
        <!-- owl carousel -->
        <link rel="stylesheet" href="css/owl.carousel.css">
        <!-- Animate -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Main Stylesheet -->
        <link rel="stylesheet" href="css/main.css">
        <!-- Main Responsive -->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- Style CSS -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Style for Radio/Checkboxes -->
        <link rel="stylesheet" href="css/funckyradio.css">


        <!-- Modernizer Script for old Browsers -->
        <script src="js/vendor/modernizr-2.6.2.min.js"></script>

        
        <script>
            var selectedDestinations = [];
            function getSelectedLocations() {

                var loc1 = document.getElementById("7.306997");
                var loc2 = document.getElementById("loc2");

                if (loc1.checked)
                {
                    var value1 = loc1.value;
                    selectedDestinations.push([7.2937, 80.6414]);
                    alert(value1);
                    alert(loc1);
                }
                if (loc2.checked)
                {
                    selectedDestinations.push([7.9563, 80.7601]);
                    // alert("hi");
                    //var value2=loc2.value;
                    //alert(value2);
                }


            }
        </script>
        <style>
            #gmap1 {
                position: absolute;
                left: 10px;
                top: 10px;
            }
            #cover {
                position:absolute;
                left:10px;
                top: 10px;
                z-index:3;
            }
            #floating {
                position: absolute;
                top: 10px;
                left: 25%;
                z-index: 5;
                background-color: #fff;
                padding: 5px;
                border: 1px solid #999;
                text-align: center;
                font-family: 'Roboto','sans-serif';
                line-height: 30px;
                padding-left: 10px;
            }
        </style>
    </head>

    <body>

        <!--
        Fixed Navigation
        ==================================== -->
        <header id="navigation1" class="navbar-fixed-top " style="background-color: #3C8DBC; height:90px">
            <div class="container">

                <div class="navbar-header">
                    <!-- responsive nav button -->
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- /responsive nav button -->

                    <!-- logo -->
                    <h1 class="navbar-brand">
                        <a href="#body">
                            <img src="img/logo.png" alt="Kasper Logo">
                        </a>
                    </h1>
                    <!-- /logo -->

                </div>

                <!-- main nav -->
                <nav class="collapse navigation navbar-collapse navbar-right" role="navigation">
                    <ul id="nav1" class="nav navbar-nav">
                        <li><br/><a href="index.html">Home</a></li>
                        <li><br/><a href="#service">Destinations</a></li>
                        <li><br/><a href="#portfolio">Gallery</a></li>
                        <li><br/><a href="#">Hotels</a></li>
                        <li><br/><a href="#pricing">About Us</a></li>

                        <li class="dropdown user user-menu" >
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="img/client/3.jpg" alt="Client" class="img-circle" style="width:50px;height:50px;">
                            </a>
                            <ul class="dropdown-menu dropdown-custom dropdown-menu-right">
                                <li class="dropdown-header text-center">READ ME</li>

                                <li>
                                    <a href="#">
                                        <i class=" pull-right"></i>
                                        <span class="badge badge-success pull-right"></span>W.W.S. Rukshani</a>
                                    <a href="#">
                                        <i class="pull-right"></i>
                                        <span class="badge badge-danger pull-right"></span>IT13046958</a>
                                    <a href="#"><i class=" pull-right"></i>
                                        <span class="badge badge-info pull-right"></span>EAD</a>
                                    <a href="#"><i class=" pull-right"></i> <span class=
                                                                                  "badge pull-right"></span>Assignment 1</a>
                                </li>

                                <li class="divider"></li>

                                <li>
                                    <a href="#">
                                        <i class=" pull-right"></i>
                                        Year 4 - Semester 2
                                    </a>
                                    <a data-toggle="modal" href="#modal-user-settings">
                                        <i class=" pull-right"></i>
                                        SLIIT
                                    </a>
                                </li>

                                <li class="divider"></li>


                            </ul>
                        </li>

                    </ul>
                </nav>
                <!-- /main nav -->
            </div>

        </div>
    </header>
    <!--
    End Fixed Navigation
    ==================================== -->

    <section>
        <div class="row">
            <div class="col-lg-2">
            </div>
            <div class="col-lg-8">
                <!--checkboxes here-->
                <button onclick="routeGenerator()" class="button special text-center" style="align:center">Route Generator</button>
                <div id="location"></div>
            </div>
            <div class="col-lg-2">
            </div>

        </div>
    </section>
    <section>
    </section>
    <!--change budget range modal-->
    <div class="modal fade" id="changeBudgetRangeModal" role="dialog" >
        <div class="modal-dialog modal-md">
            <div class="modal-content primary">
                <div class="modal-header" style="background-color:#2BAF67">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title" style="color:#ffffff">Change your Budget Range</h4>
                </div>
                <div class="modal-body primary">
                    <div class="row">
                        <div class="col-md-2"></div>
                        <div class="col-md-8">
                            <div class="top-margin">
                                <label>Budget Range</label>
                                <option>Select...</option>						<select class="form-control" id="sel1">
                                    <option>five</option>
                                    <option>four</option>
                                    <option>three</option>

                                </select>
                            </div>

                            <div class=" text-right">
                                <br/><br/>
                                <button onclick="" class="button special">Apply</button>
                            </div>

                        </div>
                        <div class="col-md-4"></div>
                    </div>
                </div>			
            </div>
        </div>
    </div>

</div>

</div> 
</div> 
</div>

<!--
#footer
========================== -->
<footer id="footer" class="text-center">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">

                <div class="footer-logo wow fadeInDown">
                    <img src="img/logo.png" alt="logo">
                </div>

                <div class="footer-social wow fadeInUp">
                    <h3>We are social</h3>
                    <ul class="text-center list-inline">
                        <li><a href="http://goo.gl/RqhEjP"><i class="fa fa-facebook fa-lg"></i></a></li>
                        <li><a href="http://goo.gl/hUfpSB"><i class="fa fa-twitter fa-lg"></i></a></li>
                        <li><a href="http://goo.gl/r4xzR4"><i class="fa fa-google-plus fa-lg"></i></a></li>

                    </ul>
                </div>

                <div class="copyright">

                    <p>© 2016 All Rights Reserved.</p>
                </div>

            </div>
        </div>
    </div>
</footer>
<!--
End #footer
========================== -->


<!--
JavaScripts
========================== -->

<!-- main jQuery -->
<script src="js/vendor/jquery-1.11.1.min.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- jquery.nav -->
<script src="js/jquery.nav.js"></script>
<!-- Portfolio Filtering -->
<script src="js/jquery.mixitup.min.js"></script>
<!-- Fancybox -->
<script src="js/jquery.fancybox.pack.js"></script>
<!-- Parallax sections -->
<script src="js/jquery.parallax-1.1.3.js"></script>
<!-- jQuery Appear -->
<script src="js/jquery.appear.js"></script>
<!-- countTo -->
<script src="js/jquery-countTo.js"></script>
<!-- owl carousel -->
<script src="js/owl.carousel.min.js"></script>
<!-- WOW script -->
<script src="js/wow.min.js"></script>
<!-- theme custom scripts -->
<script src="js/main2.js"></script>

<script src="js/controller/locationController.js" type="text/javascript"></script>
<script src="js/controller/routesController.js" type="text/javascript"></script>
</body>
</html>

