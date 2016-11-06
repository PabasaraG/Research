
window.routeResponse;
var map, map2, map3;
var directionsDisplay;
var google;

google.maps.event.addDomListener(window, 'load', initialize);
$(window).load(function () {
    drawRoute();
});


/**
 * to display the map initially
 * @returns {undefined}
 */
function initialize() {

    var mapProp = {
        center: new google.maps.LatLng(6.9271, 79.8612),
        zoom: 12,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("gmap"), mapProp);
}


/**
 * get defeult route to the map -pathType-premium
 * @returns {undefined}
 */
function drawRoute()
{
    var dfrd2 = $.Deferred();
    //var to = "my tour";//get this from session
    //var tourInfo = {tourId: to};
    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'DRAWROUTE'}, function (response) {

        console.log(response);
        if (response.code === 200)
        {
            routeResponse = response.payload;

            var directionsService = new google.maps.DirectionsService();
            var directionsDisplay = new google.maps.DirectionsRenderer({
                polylineOptions: {
                    strokeColor: '#E52B50',
                    strokeOpacity: 0.8,
                    strokeWeight: 4
                }});
            var start = new google.maps.LatLng(response.payload[0].sourceLatitude, response.payload[0].sourceLongitude);
            var end = new google.maps.LatLng(response.payload[response.payload.length - 1].destinationLatitude, response.payload[response.payload.length - 1].destinationLongitude);

            var waypts = [];
            for (var i = 1; i <= response.payload.length - 1; i++)
            {
             //   alert(response.payload[i].destinationLatitude + " " + response.payload[i].destinationLongitude);
                var w1 = new google.maps.LatLng(response.payload[i].sourceLatitude, response.payload[i].sourceLongitude);
                var item = {
                    location: w1,
                    stopover: true
                };
                waypts.push(item);
            }
            directionsDisplay.setMap(map);
            var request = {
                origin: start,
                destination: end,
                waypoints: waypts,
                optimizeWaypoints: true,
                travelMode: google.maps.TravelMode.DRIVING,
            };
            directionsService.route(request, function (response, status) {
                if (status === google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(response);

                    /*var route = response.routes[0];
                     var summaryPanel = document.getElementById('route1');
                     summaryPanel.innerHTML = '';
                     // For each route, display summary information.
                     for (var i = 0; i < route.legs.length; i++) {
                     var routeSegment = i + 1;
                     summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                     '</b><br>';
                     summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
                     summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
                     summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
                     }*/
                }
            });
            var noOfDays = response.payload[response.payload.length - 1].date;

            var start = document.getElementById("startDate").innerHTML;
            var end = document.getElementById("endDate").innerHTML;
            start.substring(8);
            end.substring(8);
            var tourDuration1 = parseInt(end.substring(8)) - parseInt(start.substring(8));
            var tourDuration = tourDuration1.toString();
        //    alert(tourDuration);

            if (noOfDays === tourDuration)//if tour plan fits with tour duration
            {
                $('#tourMapMessage').empty();
                $('#tourMapMessage').append("<div class=\"col-md-7 fh5co-service\">"
                        + "<h3 class=\"text-success\">Your Tour Plan fits with Your Tour Duration.</h3>"
                        + "<p>Created Tour Plan Fits With Your Tour Duration of<font size=\"5\"> 0" + noOfDays + " DAYS</font>.</p>"
                        + "</div>"
                        + "<div class=\"col-md-5 fh5co-service\">"
                        + "<div class=\"row\">"
                        + "<br/>"
                        + "<div class=\"col-md-6\"><a href=\"getTheApp.jsp\" class=\"btn btn-success btn-sm pull-right\">Use This</a></div>"
                        + "</div>"
                        + "</div>"
                        + "</div>");
                $('#sidePanel').empty();
                $('#sidePanel').append("<div class=\"icon colored-2\" id=\"dayNo\" style=\"background-color:#0E8128;color:#ffffff\"></div>"

                        + "<div class=\"person\" id=\"dayList\">"
                        + "</div>");


                $('#dayOptions').empty();
                for (var i = 0; i <= noOfDays; i++) {
                    //var dayImage="charter"+i+".png";
                    $('#dayOptions').append("<div class=\"col-md-1\">"
                            + "<a href=\"#body\" id=\"" + i + "\" onclick=\"showSelectedRouteMap('" + i + "')\">"
                            + "<img src=\"images/routeplan/greenDay" + i + ".png\" alt=\"charter\" style=\"width:90px;height:90px\">"
                            + " </a></div>");
                }
                /*$('#tourMapMessage').append("<div class=\"alert alert-success\" style=\"height:60px\">"
                 + "<p> Your CREATED Tour Plan fits with your TOUR DURATION with " + noOfDays + " DAYS...!</p>"
                 + "<br/><br/>"
                 + "</div>");*/
            } else if (parseInt(noOfDays) < parseInt(tourDuration)) {//if tour plan has additional days

                var additional = tourDuration - noOfDays;
                $('#tourMapMessage').empty();
                $('#tourMapMessage').append("<div class=\"col-md-7 fh5co-service\">"
                        + "<h3 class=\"text-warning\">Your Tour Plan fits with Your Tour Duration.</h3>"
                        + "<p>Created Tour Plan Fits With Your Tour Duration of<font size=\"5\"> 0" + noOfDays + " DAYS</font>.</p>"
                        + "<p>You have <font size=\"5\">addtional 0" + additional + " DAYS</font>.</p>"
                        + "</div>"
                        + "<div class=\"col-md-5 fh5co-service\">"
                        + "<div class=\"row\">"
                        + "<br/>"
                        + "<div class=\"col-md-6\"><a href=\"getTheApp.jsp\" class=\"btn btn-warning btn-sm pull-right\">Use This</a></div>"
                        + "</div>"
                        + "</div>"
                        + "</div>");

                $('#dayOptions').empty();
                for (var i = 0; i <= noOfDays; i++) {
                    //var dayImage="charter"+i+".png";
                    $('#dayOptions').append("<div class=\"col-md-1\">"
                            + "<a href=\"#body\" id=\"" + i + "\" onclick=\"showSelectedRouteMap('" + i + "')\">"
                            + "<img src=\"images/srs.png\" alt=\"charter\" style=\"width:90px;height:90px\">"
                            + " </a></div>");
                }
                /*$('#tourMapMessage').empty();
                 $('#tourMapMessage').append("<div class=\"alert alert-warning\" style=\"height:100px\">"
                 + "<p> Your CREATED Tour Plan fits with your TOUR DURATION with " + noOfDays + " DAYS...!</p>"
                 + "<p> And You have ADDITIONAL " + additional + " DAYS...!</p>"
                 + "<br/><br/>"
                 + "</div>");*/
            } else {
                //alert("no of days" + noOfDays);
                viewAlgo();
                $('#tourMapMessage').empty();
                $('#tourMapMessage').append("<div class=\"col-md-7 fh5co-service\">"
                        + "<h3 class=\"text-danger\">Your Tour Plan Exceeds Your Tour Duration.</h3>"
                        + "<p>Created Tour Plan fits with<font size=\"5\"> 0" + noOfDays + " DAYS </font>and your tour plan only contains<font size=\"5\"> 0" + tourDuration + " DAYS</font>.</p>"
                        + "</div>"
                        + "<div class=\"col-md-5 fh5co-service\">"
                        + "<div class=\"row\">"
                        + "<br/>"
                        + "<div class=\"col-md-6\"><a href=\"getTheApp.jsp\" class=\"btn btn-danger btn-sm pull-right\">Use This</a></div>"
                        + "<div class=\"col-md-6\"><a href=\"#\" onclick=\"drawAlternativeRoute()\" class=\"btn btn-danger btn-sm pull-right\">Suggest Me a Tour Plan</a>"
                        + "</div>"
                        + "</div>"
                        + "</div>");

                $('#sidePanel').empty();
                $('#sidePanel').append("<div class=\"icon colored-2\" id=\"dayNo\" style=\"background-color:#B91010;color:#ffffff\"></div>"

                        + "<div class=\"person\" id=\"dayList\">"
                        + "</div>");

                //round day images
                $('#dayOptions').empty();

                for (var i = 0; i <= noOfDays; i++) {
                    //var dayImage="charter"+i+".png";
                    $('#dayOptions').append("<div class=\"col-md-1\">"
                            + "<a href=\"#body\" id=\"" + i + "\" onclick=\"showSelectedRouteMap('" + i + "')\">"
                            + "<img src=\"images/routeplan/redDay" + i + ".png\" alt=\"charter\" style=\"width:90px;height:90px\">"
                            + " </a></div>");
                }
                /*$('#tourMapMessage').append("<div class=\"alert alert-danger\" style=\"height:100px\">"
                 + "<div class=\"row\">"
                 + "<div class=\"col-md-7\">"
                 + "<p> Your Tour Plan EXCEEDS the<font style=\"color:red\"><b>TOUR DURATION</b></font> that you specified for this tour...!</p>"
                 + "<p> Your Created Tour Plan fits with <font style=\"color:red\"><b>0" + noOfDays + " DAYS</b></font>approximately...!</p>"
                 + "</div>"
                 + "<div class=\"col-md-2\">"
                 + "<a href=\"tourPlanSum.jsp\" class=\"btn btn-primary btn-sm text-center\" style=\"align:center\">It's Okay.Continue</a>"
                 + "</div>"
                 + "<div class=\"col-md-3\">"
                 + "<button onclick=\"viewAlgo('" + noOfDays + "')\" class=\"btn btn-primary btn-sm text-center\" style=\"align:center\">Suggest Me a Tour Plan</button>"
                 + "<br/>"
                 + "</div>"
                 + "</div>"
                 + "<br/><br/>"
                 + "</div>");*/
                //document.getElementById("route1").innerHTML ="<h5><strong>Please Enter Your Username and Password to SignIn!</strong></h5><br/><br/>";


            }
        }
        /*$('#selectRouteMap').empty();
         $('#selectRouteMap').append("<select class=\"form-control btn btn-primary btn-sm col-md-3\" style=\"height:30px\" id=\"addDay\" onchange=\"showSelectedRouteMap(this.value);\">\n\
         " + "<option>Full Tour Plan</option>");
         var temp = 0;
         for (var i = 0; i < response.payload.length; i++) {
         if (temp !== response.payload[i].date)
         {
         temp = response.payload[i].date;
         $('#addDay').append("<option value=" + response.payload[i].date + ">" + "Day " + " " + response.payload[i].date + " " + "Route Map" + "</option><br/><br/>");
         }
         }
         $('#addDay').append("</select>");*/


        //side information panel
        $('#dayNo').empty();
        $('#dayNo').append("<span style=\"color:#ffffff\"><font size=\"4\">ALL DAYS</font></span>");
        $('#dayList').empty();
        for (var i = 0; i < response.payload.length; i++)
        {
            $('#dayList').append("<img src=\"images/routeplan/" + response.payload[i].sourceLatitude + ".jpg\" style=\"width:70px;height:70px\" class=\"img-rounded\"/>"
                    + "<h4>" + response.payload[i].sourcePlaceName + "</h4>"
                    + "<h3 style=\"color:#2FC5CC\"> Distance: " + response.payload[i].distance + "Duration :" + response.payload[i].duration + "</h3>");
        }
        $('#dayList').append("<img src=\"images/routeplan/" + response.payload[response.payload.length - 1].destinationLatitude + ".jpg\" style=\"width:70px;height:70px\" class=\"img-rounded\"/>"
                + "<h4>" + response.payload[response.payload.length - 1].destinationPlaceName + "</h4>");

    }));
    dfrd2.resolve();
    return dfrd2.promise();
}

/**
 * show route according to the selected route map from the drop down
 * @param {type} value
 * @returns {undefined}
 */
function showSelectedRouteMap(value)
{

    if (value === "0")
    {
        //alert("value is 0");
        initialize();
        drawRoute();
    } else {
        var routeInfo = {date: value};//get tourId from the session
        $.when($.post('/tourbuddy/EntityFacade', {cmd: 'SELECTEDROUTE', data: JSON.stringify(routeInfo)}, function (response) {

            console.log(response);

            if (response.code === 200)
            {
                var mapProp = {
                    center: new google.maps.LatLng(6.9271, 79.8612),
                    zoom: 12,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
                map2 = new google.maps.Map(document.getElementById("gmap"), mapProp);

                var directionsService = new google.maps.DirectionsService();
                var directionsDisplay = new google.maps.DirectionsRenderer({
                    polylineOptions: {
                        strokeColor: '#E52B50',
                        strokeOpacity: 0.8,
                        strokeWeight: 4
                    }});
                var start;
                var end;
                if (response.payload.length === 1)//if only one edge is returned
                {
                    start = new google.maps.LatLng(response.payload[0].sourceLatitude, response.payload[0].sourceLongitude);
                    end = new google.maps.LatLng(response.payload[0].destinationLatitude, response.payload[0].destinationLongitude);

                    directionsDisplay.setMap(map2);

                    var request = {
                        origin: start,
                        destination: end,
                        optimizeWaypoints: true,
                        travelMode: google.maps.TravelMode.DRIVING,
                    };
                    directionsService.route(request, function (response, status) {
                        if (status === google.maps.DirectionsStatus.OK) {
                            directionsDisplay.setDirections(response);

                            var route = response.routes[0];
                            var summaryPanel = document.getElementById('route1');
                            summaryPanel.innerHTML = '';
                            // For each route, display summary information.
                            for (var i = 0; i < route.legs.length; i++) {
                                var routeSegment = i + 1;
                                summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                                        '</b><br>';
                                summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
                                summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
                                summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
                            }
                        }
                    });
                }
                if (response.payload.length > 1)//if more than one edge is returned
                {
                    start = new google.maps.LatLng(response.payload[0].sourceLatitude, response.payload[0].sourceLongitude);
                    end = new google.maps.LatLng(response.payload[response.payload.length - 1].destinationLatitude, response.payload[response.payload.length - 1].destinationLongitude);

                    var waypts = [];
                    for (var i = 1; i <= response.payload.length - 1; i++)
                    {
                        var w1 = new google.maps.LatLng(response.payload[i].sourceLatitude, response.payload[i].sourceLongitude);
                        var item = {
                            location: w1,
                            stopover: true
                        };
                        waypts.push(item);
                    }
                    directionsDisplay.setMap(map2);

                    var request = {
                        origin: start,
                        destination: end,
                        waypoints: waypts,
                        optimizeWaypoints: true,
                        travelMode: google.maps.TravelMode.DRIVING,
                    };
                    directionsService.route(request, function (response, status) {
                        if (status === google.maps.DirectionsStatus.OK) {

                            directionsDisplay.setDirections(response);

                            var route = response.routes[0];
                            var summaryPanel = document.getElementById('route1');
                            summaryPanel.innerHTML = '';
                            // For each route, display summary information.
                            for (var i = 0; i < route.legs.length; i++) {
                                var routeSegment = i + 1;
                                summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                                        '</b><br>';
                                summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
                                summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
                                summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
                            }
                        }
                    });
                }
                $('#specificRoute').empty();
                // $('#specificRoute').append(" <h3> DAY 0"+value+" ROUTE MAP</h3>"
                //  +"");
                $('#dayNo').empty();
                $('#dayNo').append("<span style=\"color:#ffffff\"><font size=\"5\">DAY 0" + value + "</font></span>");
                $('#dayList').empty();

                for (var i = 0; i < response.payload.length; i++)
                {
                    $('#dayList').append("<img src=\"images/routeplan/" + response.payload[i].sourceLatitude + ".jpg\" style=\"width:70px;height:70px\" class=\"img-rounded\"/>"
                            + "<h4>" + response.payload[i].sourcePlaceName + "</h4>"
                            + "<h3 style=\"color:#2FC5CC\"> Distance: " + response.payload[i].distance + "Duration :" + response.payload[i].duration + "</h3>");
                }
                $('#dayList').append("<img src=\"images/routeplan/" + response.payload[response.payload.length - 1].destinationLatitude + ".jpg\" style=\"width:70px;height:70px\" class=\"img-rounded\"/>"
                        + "<h4>" + response.payload[response.payload.length - 1].destinationPlaceName + "</h4>");
            }
        }));
    }

}

/**
 * method to generate alternative route andadd to the database
 * @returns {undefined}
 */
function viewAlgo()
{
    //var routeInfo = {tourName: "my tour"};//get this from session
    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'ALTERNATIVEROUTEGEN'}, function (response) {
    }));
}
//$('#viewtourroutebutton').empty();
/*$('#tourMapMessage').append(" <div class=\"col-lg-3\"><h4>Select Your Preferred Route Plan</h4></div>"
 + "<div class=\"col-lg-3\">"
 + " <div class=\"funkyradio\">"
 + " <div class=\"funkyradio-success\">"
 + "  <input type=\"checkbox\" name=\"checkbox\" id=\"radio1\" onchange=\"displayPremium()\" checked/>"
 + " <label for=\"radio1\" style=\"background-color:#ffffff\"><font size=\"4\">Deafault Route</font></label>"
 + " </div>"
 + " </div>"
 + "</div>"
 + "<div class=\"col-lg-3\">"
 + "<div class=\"funkyradio\">"
 + "<div class=\"funkyradio-danger\">"
 + "<input type=\"checkbox\" name=\"checkbox\" id=\"radio3\" onchange=\"displayPremium()\"/>"
 + "<label for=\"radio3\" style=\"background-color:#ffffff\"><font size=\"4\">Customized Route</font></label>"
 + "</div>"
 + " </div>"
 + "</div>"
 );*/

/* $('#premium').empty();
 $('#premium').append("<div class=\"alert alert-success\" style=\"height:60px\">"
 + "<p> Your CREATED Tour Plan fits with your TOUR DURATION with 0" + premiumDays + " DAYS...!</p>"
 + "<br/><br/>"
 + "</div>");
 $('#viewtourroutebutton').empty();
 $('#viewtourroutebutton').append("<button onclick=\"goToSummaryPage()\" class=\"btn btn-primary btn-sm text-center pull-right\" style=\"align:center\">Continue</button>)");
 }*/

/**
 * draw alternative route to the map
 * @returns {undefined}
 */
function drawAlternativeRoute()
{
    //var routeInfo = {tourId: "my tour"};//get from session
    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'DRAWALTERNATIVEROUTE'}, function (response) {

        if (response.code === 200)
        {
            var directionsService = new google.maps.DirectionsService();
            directionsDisplay = new google.maps.DirectionsRenderer({
                polylineOptions: {
                    strokeColor: '#6173F4',
                    strokeOpacity: 0.8,
                    strokeWeight: 4
                }});
            var start;
            var end;
            if (response.payload.length === 1)
            {
                start = new google.maps.LatLng(response.payload[0].sourceLatitude, response.payload[0].sourceLongitude);
                end = new google.maps.LatLng(response.payload[0].destinationLatitude, response.payload[0].destinationLongitude);

                directionsDisplay.setMap(map);

                var request = {
                    origin: start,
                    destination: end,
                    optimizeWaypoints: true,
                    travelMode: google.maps.TravelMode.DRIVING,
                };
                directionsService.route(request, function (response, status) {
                    if (status === google.maps.DirectionsStatus.OK) {

                        directionsDisplay.setDirections(response);

                        var route = response.routes[0];
                        var summaryPanel = document.getElementById('route1');
                        summaryPanel.innerHTML = '';
                        // For each route, display summary information.
                        for (var i = 0; i < route.legs.length; i++) {
                            var routeSegment = i + 1;
                            summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                                    '</b><br>';
                            summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
                            summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
                            summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
                        }
                    }
                });
            } else
            {
                start = new google.maps.LatLng(response.payload[0].sourceLatitude, response.payload[0].sourceLongitude);
                end = new google.maps.LatLng(response.payload[response.payload.length - 1].destinationLatitude, response.payload[response.payload.length - 1].destinationLongitude);

                var waypts = [];
                for (var i = 1; i <= response.payload.length - 2; i++)
                {
                    var w1 = new google.maps.LatLng(response.payload[i].sourceLatitude, response.payload[i].sourceLongitude);
                    var item = {
                        location: w1,
                        stopover: true
                    };
                    waypts.push(item);
                }

                directionsDisplay.setMap(map);

                var request = {
                    origin: start,
                    destination: end,
                    waypoints: waypts,
                    optimizeWaypoints: true,
                    travelMode: google.maps.TravelMode.DRIVING,
                };
                directionsService.route(request, function (response, status) {
                    if (status === google.maps.DirectionsStatus.OK) {
                        directionsDisplay.setDirections(response);

                        var route = response.routes[0];
                        var summaryPanel = document.getElementById('route1');
                        summaryPanel.innerHTML = '';
                        // For each route, display summary information.
                        for (var i = 0; i < route.legs.length; i++) {
                            var routeSegment = i + 1;
                            summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                                    '</b><br>';
                            summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
                            summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
                            summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
                        }
                    }
                });
            }

            /* var alternativeDays = response.payload[response.payload.length - 1].date;
             alternativeDays = 2;
             $('#alternative').empty();
             $('#alternative').append("<div class=\"alert alert-success\" style=\"height:60px\">"
             + "<p> Your CREATED Tour Plan fits with your TOUR DURATION with 0" + alternativeDays + " DAYS...!</p>"
             + "<br/><br/>"
             + "</div>");*/
            var noOfDays = response.payload[response.payload.length - 1].date;
            $('#tourMapMessage').empty();
            $('#tourMapMessage').append("<div class=\"col-md-7 fh5co-service\">"
                    + "<h3 class=\"text-info\">Your Tour Plan Now Fits With Your Tour Duration.</h3>"
                    + "<p>Created Tour Plan fits with Your Tour Duration of <font size=\"5\"> 0" + noOfDays + " DAYS </font>.</p>"
                    + "</div>"
                    + "<div class=\"col-md-5 fh5co-service\">"
                    + "<div class=\"row\">"
                    + "<br/>"
                    + "<div class=\"col-md-6\"><a href=\"getTheApp.jsp\" class=\"btn btn-info btn-sm pull-right\">Use This</a></div>"
                    + "<div class=\"col-md-6\"><a href=\"#\" onclick=\"drawRoute()\" class=\"btn btn-info btn-sm pull-right\">View Previous Tour Plan</a>"
                    + "</div>"
                    + "</div>"
                    + "</div>");

            $('#sidePanel').empty();
            $('#sidePanel').append("<div class=\"icon colored-2\" id=\"dayNo\" style=\"background-color:#6173F4;color:#ffffff\"></div>"

                    + "<div class=\"person\" id=\"dayList\">"
                    + "</div>");

            //round day images
            $('#dayOptions').empty();
            for (var i = 0; i <= noOfDays; i++) {
                //var dayImage="charter"+i+".png";
                $('#dayOptions').append("<div class=\"col-md-1\">"
                        + "<a href=\"#body\" id=\"" + i + "\" onclick=\"showSelectedAlternativeRouteMap('" + i + "')\">"
                        + "<img src=\"images/routeplan/blueDay" + i + ".png\" alt=\"charter\" style=\"width:90px;height:90px\">"
                        + " </a></div>");
            }
        }

        //side information panel
        $('#dayNo').empty();
        $('#dayNo').append("<span><font size=\"4\">ALL DAYS</font></span>");
        $('#dayList').empty();
        for (var i = 0; i < response.payload.length; i++)
        {
            $('#dayList').append("<img src=\"images/routeplan/" + response.payload[i].sourceLatitude + ".jpg\" style=\"width:70px;height:70px\" class=\"img-rounded\"/>"
                    + "<h4>" + response.payload[i].sourcePlaceName + "</h4>"
                    + "<h3 style=\"color:#2FC5CC\"> Distance: " + response.payload[i].distance + "Duration :" + response.payload[i].duration + "</h3>");
        }
        $('#dayList').append("<img src=\"images/routeplan/" + response.payload[response.payload.length - 1].destinationLatitude + ".jpg\" style=\"width:70px;height:70px\" class=\"img-rounded\"/>"
                + "<h4>" + response.payload[response.payload.length - 1].destinationPlaceName + "</h4>");

    }));
}

/**
 * show alternative route according to the selected route map from the drop down
 * @param {type} value
 * @returns {undefined}
 */
function showSelectedAlternativeRouteMap(value)
{

    if (value === "0")
    {
        //alert("value is 0");
        initialize();
        drawAlternativeRoute();
    } else {
        var routeInfo = {date: value};//get tourId from the session
        $.when($.post('/tourbuddy/EntityFacade', {cmd: 'SELECTEDALTERNATIVEROUTE', data: JSON.stringify(routeInfo)}, function (response) {

            console.log(response);

            if (response.code === 200)
            {
                var mapProp = {
                    center: new google.maps.LatLng(6.9271, 79.8612),
                    zoom: 12,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                };
                map2 = new google.maps.Map(document.getElementById("gmap"), mapProp);

                var directionsService = new google.maps.DirectionsService();
                var directionsDisplay = new google.maps.DirectionsRenderer({
                    polylineOptions: {
                        strokeColor: '#E52B50',
                        strokeOpacity: 0.8,
                        strokeWeight: 4
                    }});
                var start;
                var end;
                if (response.payload.length === 1)//if only one edge is returned
                {
                    start = new google.maps.LatLng(response.payload[0].sourceLatitude, response.payload[0].sourceLongitude);
                    end = new google.maps.LatLng(response.payload[0].destinationLatitude, response.payload[0].destinationLongitude);

                    directionsDisplay.setMap(map2);

                    var request = {
                        origin: start,
                        destination: end,
                        optimizeWaypoints: true,
                        travelMode: google.maps.TravelMode.DRIVING,
                    };
                    directionsService.route(request, function (response, status) {
                        if (status === google.maps.DirectionsStatus.OK) {
                            directionsDisplay.setDirections(response);

                            /*var route = response.routes[0];
                             var summaryPanel = document.getElementById('route1');
                             summaryPanel.innerHTML = '';
                             // For each route, display summary information.
                             for (var i = 0; i < route.legs.length; i++) {
                             var routeSegment = i + 1;
                             summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                             '</b><br>';
                             summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
                             summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
                             summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
                             }*/
                        }
                    });
                }
                if (response.payload.length > 1)//if more than one edge is returned
                {
                    start = new google.maps.LatLng(response.payload[0].sourceLatitude, response.payload[0].sourceLongitude);
                    end = new google.maps.LatLng(response.payload[response.payload.length - 1].destinationLatitude, response.payload[response.payload.length - 1].destinationLongitude);

                    var waypts = [];
                    for (var i = 1; i <= response.payload.length - 1; i++)
                    {
                        var w1 = new google.maps.LatLng(response.payload[i].sourceLatitude, response.payload[i].sourceLongitude);
                        var item = {
                            location: w1,
                            stopover: true
                        };
                        waypts.push(item);
                    }
                    directionsDisplay.setMap(map2);

                    var request = {
                        origin: start,
                        destination: end,
                        waypoints: waypts,
                        optimizeWaypoints: true,
                        travelMode: google.maps.TravelMode.DRIVING,
                    };
                    directionsService.route(request, function (response, status) {
                        if (status === google.maps.DirectionsStatus.OK) {

                            directionsDisplay.setDirections(response);

                            /*var route = response.routes[0];
                             var summaryPanel = document.getElementById('route1');
                             summaryPanel.innerHTML = '';
                             // For each route, display summary information.
                             for (var i = 0; i < route.legs.length; i++) {
                             var routeSegment = i + 1;
                             summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                             '</b><br>';
                             summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
                             summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
                             summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
                             }*/
                        }
                    });
                }
                $('#specificRoute').empty();
                // $('#specificRoute').append(" <h3> DAY 0"+value+" ROUTE MAP</h3>"
                //  +"");
                $('#dayNo').empty();
                $('#dayNo').append("<span><font size=\"5\">DAY 0" + value + "</font></span>");
                $('#dayList').empty();

                for (var i = 0; i < response.payload.length; i++)
                {
                    $('#dayList').append("<img src=\"images/routeplan/" + response.payload[i].sourceLatitude + ".jpg\" style=\"width:70px;height:70px\" class=\"img-rounded\"/>"
                            + "<h4>" + response.payload[i].sourcePlaceName + "</h4>"
                            + "<h3 style=\"color:#2FC5CC\"> Distance: " + response.payload[i].distance + "Duration :" + response.payload[i].duration + "</h3>");
                }
                $('#dayList').append("<img src=\"images/routeplan/" + response.payload[response.payload.length - 1].destinationLatitude + ".jpg\" style=\"width:70px;height:70px\" class=\"img-rounded\"/>"
                        + "<h4>" + response.payload[response.payload.length - 1].destinationPlaceName + "</h4>");
            }
        }));
    }

}


/**
 * display route according to the selected type from checkboxes
 * premium or alternative
 * @returns {undefined}
 */
function displayPremium()
{
    var premium = document.getElementById("radio1");
    var alternative = document.getElementById("radio3");

    if (premium.checked && alternative.checked)
    {
        initialize();
        drawRouteCheckBox();
        drawAlternativeRoute();
    } else if (premium.checked && !alternative.checked)
    {
        initialize();
        drawRouteCheckBox();
    } else if (!premium.checked && alternative.checked)
    {
        initialize();
        drawAlternativeRoute();
    } else {
        initialize();
    }
}

/**
 * draw premium route when select from checkbox
 * @returns {undefined}
 */
function drawRouteCheckBox()
{
    var to = "my tour";
    var tourInfo = {tourId: to};
    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'DRAWROUTE', data: JSON.stringify(tourInfo)}, function (response) {

        console.log(response);

        if (response.code === 200)
        {
            routeResponse = response.payload;

            var directionsService = new google.maps.DirectionsService();
            var directionsDisplay = new google.maps.DirectionsRenderer({
                polylineOptions: {
                    strokeColor: '#E52B50',
                    strokeOpacity: 0.8,
                    strokeWeight: 4
                }});

            var start = new google.maps.LatLng(response.payload[0].destinationLatitude, response.payload[0].destinationLongitude);
            var end = new google.maps.LatLng(response.payload[response.payload.length - 1].destinationLatitude, response.payload[response.payload.length - 1].destinationLongitude);

            var waypts = [];
            for (var i = 1; i < response.payload.length - 1; i++)
            {
                var w1 = new google.maps.LatLng(response.payload[i].destinationLatitude, response.payload[i].destinationLongitude);
                var item = {
                    location: w1,
                    stopover: true
                };
                waypts.push(item);
            }

            directionsDisplay.setMap(map);

            var request = {
                origin: start,
                destination: end,
                waypoints: waypts,
                optimizeWaypoints: true,
                travelMode: google.maps.TravelMode.DRIVING,
            };
            directionsService.route(request, function (response, status) {
                if (status === google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(response);

                    var route = response.routes[0];
                    var summaryPanel = document.getElementById('route1');
                    summaryPanel.innerHTML = '';
                    // For each route, display summary information.
                    for (var i = 0; i < route.legs.length; i++) {
                        var routeSegment = i + 1;
                        summaryPanel.innerHTML += '<b>Route Segment: ' + routeSegment +
                                '</b><br>';
                        summaryPanel.innerHTML += route.legs[i].start_address + ' to ';
                        summaryPanel.innerHTML += route.legs[i].end_address + '<br>';
                        summaryPanel.innerHTML += route.legs[i].distance.text + '<br><br>';
                    }
                }
            });
        }
    }));
}

/**
 * display summary page
 * @returns {undefined}
 */
function goToSummaryPage()
{
    var premium = document.getElementById("radio1");
    var alternative = document.getElementById("radio3");

    var seletedRoute = null;

    if (!premium.checked && !alternative.checked)
    {

        alert("Please select One of the Day Plan Available!");
    } else if (premium.checked && alternative.checked)
    {
        alert("Please select Only one of the Day Plans Available!");
    } else {
        if (premium.checked)
        {
            seletedRoute = "premium";
        }
        if (alternative.checked)
        {
            seletedRoute = "alternative";
        }
        var routeInfo = {tourName: "my tour", selectedRoute: seletedRoute};

        $.when($.post('/tourbuddy/EntityFacade', {cmd: 'ADDSELECTEDROUTE', data: JSON.stringify(routeInfo)}, function (response) {

            console.log(response);

            window.location = "/tourbuddy/tourPlanSum.jsp";
        }));
    }
}

function updateTour(noOfDays)
{
    var tourInfo={endDate: noOfDays};
    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'UPDATETOURDATES', data: JSON.stringify(tourInfo)}, function (response) {

        console.log(response);

        if (response.code === 200)
        {
                 window.location = "/tourbuddy/toursummary.jsp";
        }
    }));
}