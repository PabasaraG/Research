<%-- 
    Document   : navbar
    Created on : Sep 5, 2016, 5:04:52 PM
    Author     : Sanduni
--%>
<header role="banner" id="fh5co-header" class="navbar-fixed-top " style="background-color: #ffffff; height:90px;color:#ffffff">
    <div class="container">
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
                <a class="navbar-brand" href="index.html" style="color:#3367D6">TOUR BUDDY</a> 
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right" style="color:#ffffff">
                    <li class="active"><a href="home.jsp"><span><font size="3">Home</font></span></a></li>
                    <li><a href="#" data-nav-section="about"><span><font size="3">Destinations</font></span></a></li>
                    <li><a href="#" ><span><font size="3">Gallery</font></span></a></li>
                    <li><a href="#" data-nav-section="features"><span><font size="3">Hotels & Resorts</font></span></a></li>
                    <li><a href="#" data-nav-section="pricing"><span><font size="3">About Us</font></span></a></li>
                    <li><a href="plantour.jsp" ><span><font size="3">Contact Us</font></span></a></li>
                    <li style="padding-top:18px; padding-left:27px"><div class="person"><a href="profile.jsp"><img src="images/<%= session.getAttribute("user_image")%>" class="img-responsive img-rounded" alt="Person" style="width:40px;height:40px"></a></div></li>
                       
                </ul>
            </div>
        </nav>
    </div>
</header>

