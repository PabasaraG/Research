/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(window).load(function () {
    mymethod();
});
/**
 * display information in summary page
 * @returns {undefined}
 */
function mymethod()
{
    //var sroute = document.getElementById("selectedRoute").innerHTML;
    //alert(sroute);

    //var tourInfo = {tourId: "my tour", pathType: sroute};
    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'GETSUM'}, function (response) {
        console.log(response);
        if (response.code === 200)
        {
            $('#ruk').empty();
            $('#ruk').append("<div class=\"row\">"
                    + "<div class=\"col-md-12 section-heading text-center\">"
                    + " <h2 class=\"to-animate\">Tour Summary</h2>"
                    + "<div class=\"row\">"
                    + " <div class=\"col-md-8 col-md-offset-2 to-animate\">"
                    + " <h3>Your Tour Starts On <b>" + response.payload[0].startDate + "</b>.</h3>"
                    + "<h3>Your Tour Ends On <b>" + response.payload[0].endDate + "</b>.</h3>"
                    + "<a href=\"getTheApp.jsp\" class=\"btn btn-primary btn-sm\">Done</a>"
                    + "</div>"
                    + "</div>"
                    + "<div class=\"row\">"
                    + "</div>"
                    + "</div>"
                    + "</div>"
                    + "<div class=\"row\">"
                    + " <div class=\"col-md-12\">"
                    + " <div class=\"box to-animate\">"
                    + "  <div class=\"icon colored-1\"><span><i class=\"icon-mustache\"></i></span></div>"
                    + "<div class=\"row\">"
                    + "  <div class=\"col-md-4\">"
                    + "    <h3 class=\"text-left\">TOUR DETAILS</h3>"
                    + "  <div class=\"text-left\">"
                    + "    <p>Tour Name :<b>" + response.payload[0].tourName + "</b></p>"
                    + "  <p>Start Date :<b>" + response.payload[0].startDate + "</b></p>"
                    + "<p>End Date :<b>" + response.payload[0].endDate + "</b></p>"
                    + "<p>Budget Range :<b>" + response.payload[0].budgetRange + "</b></p>"
                    + "<p>Accommodation Type:<b>" + response.payload[0].accType + "</b></p>"
                    + "<p>Travelling Type :<b>" + response.payload[0].travelType + "</b></p>"
                    + "<p>Predicted Categories :<b>" + response.payload[0].selectedCategories + "</b></p>"
                    + "</div>"
                    + "</div>"
                    + "<div class=\"col-md-4\">"
                    + "  <h3 class=\"text-left\">SELECTED DESTINATIONS</h3>"
                    + "<div class=\"text-left\">"
                    + "  <p>Day 01 :</p>"
                    + "</div>"
                    + "</div>"
                    + "<div class=\"col-md-4\">"
                    + "  <h3 class=\"text-left\">SELECTED ACCOMMODATION</h3>"
                    + "<div class=\"text-left\">"
                    + "</div>"
                    + "  </div>"
                    + "</div>"
                    + "</div>"
                    + "</div>"
                    + "</div>");


        }
    }));
}
/*
 *  $('#san').empty();
 for(var i=0;i<response.payload.length;i++)
 {
 
 $('#san').append("<a href=\"#\" class=\"btn btn-primary btn-sm\">"+response.payload[i].destinationPlaceName+"</a><br/><br/>");
 
 }
 */

function mymethod2()
{

    $('#ruk').empty();
    $('#ruk').append("<div class=\"row\">"
            + "<div class=\"col-md-12 section-heading text-center\">"
            + " <h2 class=\"to-animate\">Tour Summary</h2>"
            + "<div class=\"row\">"
            + " <div class=\"col-md-8 col-md-offset-2 to-animate\">"
            + " <h3>Your Tour Starts On <b></b>.</h3>"
            + "<h3>Your Tour Ends On <b></b>.</h3>"
            + "<a href=\"#\" class=\"btn btn-primary btn-sm\">Done</a>"
            + "</div>"
            + "</div>"
            + "<div class=\"row\">"
            + "</div>"
            + "</div>"
            + "</div>"
            + "<div class=\"row\">"
            + " <div class=\"col-md-12\">"
            + " <div class=\"box to-animate\">"
            + "  <div class=\"icon colored-1\"><span><i class=\"icon-mustache\"></i></span></div>"
            + "<div class=\"row\">"
            + "  <div class=\"col-md-4\">"
            + "    <h3 class=\"text-left\">TOUR DETAILS</h3>"
            + "  <div class=\"text-left\">"
            + "    <p>Tour Name :</p>"
            + "  <p>Start Date :</p>"
            + "<p>End Date :</p>"
            + "<p>Budget Range :</p>"
            + "<p>Accommodation Type:</p>"
            + "<p>Travelling Type :</p>"
            + "</div>"
            + "</div>"
            + "<div class=\"col-md-4\">"
            + "  <h3 class=\"text-left\">SELECTED DESTINATIONS</h3>"
            + "<div class=\"text-left\">"
            + "  <p>Day 01 :</p>"
            + "</div>"
            + "</div>"
            + "<div class=\"col-md-4\">"
            + "  <h3 class=\"text-left\">SELECTED ACCOMMODATION</h3>"
            + "<div class=\"text-left\">"
            + "</div>"
            + "  </div>"
            + "</div>"
            + "</div>"
            + "</div>"
            + "</div>");
}