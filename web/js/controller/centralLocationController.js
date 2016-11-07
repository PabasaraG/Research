/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.locationCount = 0;
window.locationCount = 0;
window.no = 0;
window.color1 = "success";
window.color11 = "info";
window.color111 = "danger";
window.color = color1;
$(document).ready(function () {
    displayCentralLocs();
});

function displayCentralLocs() {

    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'GETCENTRALLOCS'}, function (response) {
        var catMap = response.payload;

        $("#catList").empty();
        $.each(catMap, function (category, locationList) {
            //alert(category)
            $("#catList").append("<div class=\"about-us  wow fadeInDown\">\n" +
                    "                    <!-- Title -->\n" +
                    "                    <div class=\"row\">\n" +
                    "                        <div class=\"col-lg-12\">\n" +
                    "<a href=\"#tourBuddy\" class=\"btn btn-success btn-block\" style=\"width:1180px;height:40px\">" + category + "</a>" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                    <!-- /.row -->\n" +
                    "                    <!-- Page Features -->\n" +
                    "                    <div class=\"row text-center\">\n");
            $.each(locationList, function (id, item) {
                locationCount++;

                $("#catList").append("<div class=\"col-lg-3\">\n" +
                        "    <br/><a onclick=\"displayDetailModal('modal1')\" class=\"btn btn-primary btn-sm\" style=\"background-color:#6173F4;width:260px\" id=\"modal1\">" + item.locationName + "</a>\n" +
                        "    <div class=\"funkyradio\">\n" +
                        "        <div class=\"funkyradio-danger\">\n" +
                        "            <input type=\"checkbox\" name=\"checkbox\" id=" + locationCount + " value=\"" + item.locId + "\">\n" +
                        "            <label for=" + locationCount + " style=\"background-color:#01BFF3\">\n" +
                        "                <img src=\"images/accomms/" + item.image + "\" class=\"media-object\" alt=\"places\" style = \"width:300px; height:270px;\">\n" +
                        "            </label>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</div>");
            });

            $("#catList").append("</div>");

        });
    }));

}

function sendSelectedPlaces() {

    var places = new Array();
    var place_list;
    for (var i = 1; i <= locationCount; i++) {
        var loc = document.getElementById(i);
        if (loc.checked) {
            var name = loc.value;
            places.push(name);
            place_list = place_list + "," + name;
            alert(name);
        }

    }
    if (places === null)
    {
        alert("Please Select a Place to Continue!");
    }
    var new_plc_list = place_list.substring(10);
    var tName = "my tour";//get this from session -var tName = document.getElementById("tourName").innerHTML;
    var selected_accom = {selectedLocs: new_plc_list};

    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'ADDSELECTEDLOCS', data: JSON.stringify(selected_accom)}, function (response) {
        console.log(response);
        if (response.code === 200)
        {
            //startRouteGenerator();//start route generator algorithm
            window.location = "/tourbuddy/selectAccommodation.jsp";
        }
    }));
}


