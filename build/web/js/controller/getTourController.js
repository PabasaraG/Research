/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.locationCount = 0;
$(document).ready(function () {

viewTour();
});


function viewTour()
{
     $.when($.post('/tourbuddy/EntityFacade', {cmd: 'GETTOURS'}, function (response) {
        var tourMap = response.payload;
          $("#tours").empty();
                      $.each(tourMap, function (id, item) {
                locationCount++;
                $("#tours").append("<a href=\"#tourBuddy\" class=\"btn btn-primary btn-block\" style=\"width:1200px\">"+"Tour: "+locationCount+"</a>\n" +
"                            <br/>\n" +
"                            <div class=\"panel panel-default\" style=\"width:1200px\">\n" +
"                                <div class=\"panel-body\"> \n" +
"                                   \n" +
"                                    <div class=\"col-md-6\">\n" +
"                                        <p>Tour Name:<label id=\"firstname\" class=\"form-control\" placeholder=\"First Name\" type=\"text\" style=\"height:40px\">"+item.tourName+"</label></p>\n" +
"                                            <p>Start Date:<label id=\"email\" class=\"form-control\" placeholder=\"First Name\" type=\"text\" style=\"height:40px\">"+item.startDate+"</label></p>\n" +
"                                                <p>End Date:<label id=\"birthdate\" class=\"form-control\" placeholder=\"First Name\" type=\"text\" style=\"height:40px\">"+item.endDate+"</label></p>\n" +
"                                                <p>Budget Range:<label id=\"email\" class=\"form-control\" placeholder=\"First Name\" type=\"text\" style=\"height:40px\">"+item.budgetRange+"</label></p>\n" +
"                                                <p>Accommodation Type:<label id=\"birthdate\" class=\"form-control\" placeholder=\"First Name\" type=\"text\" style=\"height:40px\">"+item.accType+"</label></p>\n" +
"                                    </div>\n" +
"                                                    <div class=\"col-md-6\">\n" +
"                                                        <p>Travel Type:<label id=\"lastname\" class=\"form-control\" placeholder=\"First Name\" type=\"text\" style=\"height:40px\">"+item.travelType+"</label></p>\n" +
"                                                            <p>Most Preferred Categories:<label id=\"country\" class=\"form-control\" placeholder=\"First Name\" type=\"text\" style=\"height:40px\">"+item.selectedCategories+"</label></p>\n" +
"                                                                <p>Locations:<label id=\"gender\" class=\"form-control\" placeholder=\"First Name\" type=\"text\" style=\"height:40px\">"+item.selectedLocs+"</label></p>\n" +
"                                                                 <p>Accommodations:<label id=\"email\" class=\"form-control\" placeholder=\"First Name\" type=\"text\" style=\"height:40px\">"+item.selectedAccom+"</label></p>\n" +
"                                                <p>Routes:<label id=\"birthdate\" class=\"form-control\" placeholder=\"First Name\" type=\"text\" style=\"height:40px\">"+item.selectedRoute+"</p>\n" +
"                                                    </div>\n" +
"                                                                    \n" +
"                                                  \n" +
"                                                                    </div>\n" +
"                                                                    </div>");
            });
         
            $("#tours").append("</div>");
            }));
    
}