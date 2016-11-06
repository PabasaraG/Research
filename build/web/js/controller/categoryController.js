/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.locationCount = 0;

$(document).ready(function () {

    var type = getParameterByName('type');
    if (type == "survey") {
        //display loding image
        $("#loading").append("Loading...");
        loadSurvey().done(function () {
            $("#loading").empty();
            //remove loding image
        });
    } else {
        //display loding image
        $("#loading").append("Loading...");
        loadTwitter().done(function () {
            //remove loding image
            $("#loading").empty();
        });
    }
});

function loadSurvey() {
    var dfrd1 = $.Deferred();
    var q1 = getParameterByName('q1');
    var q2 = getParameterByName('q2');
    var q3 = getParameterByName('q3');
    var q4 = getParameterByName('q4');
    var q5 = getParameterByName('q5');
    var q6 = getParameterByName('q6');
    var q7 = getParameterByName('q7');
    var q8 = getParameterByName('q8');

    var surveyInfo = {q1: q1, q2: q2, q3: q3, q4: q4, q5: q5, q6: q6, q7: q7, q8: q8};

    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'GETSURVEY', data: JSON.stringify(surveyInfo)}, function (response) {
        var catMap = response.payload;

        $("#catList").empty();
        $.each(catMap, function (category, locationList) {
       
            $("#catList").append("<div class=\"about-us  wow fadeInDown\">\n" +
                    "                    <!-- Title -->\n" +
                    "                    <div class=\"row\">\n" +
                    "                        <div class=\"col-lg-12\">\n" +
                    "                            <h3 style=\" color:#2eb8b8 \"> " + category + "</h3>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                    <!-- /.row -->\n" +
                    "                    <!-- Page Features -->\n" +
                    "                    <div class=\"row text-center\">\n");
            $.each(locationList, function (id, item) {
                locationCount++;

                $("#catList").append("<div class=\"col-lg-3\">\n" +
"    <br/><a onclick=\"displayDetailModal('"+item.lname+"')\"  class=\"btn btn-primary btn-sm\" style=\"background-color:#6173F4;width:260px\" id=\"modal1\">"+item.lname+"</a>\n" +
"    <div class=\"funkyradio\">\n" +
"        <div class=\"funkyradio-danger\">\n" +
"            <input type=\"checkbox\" name=\"checkbox\" id="+locationCount + " value=\""+item.lname+"\">\n" +
"            <label for=" + locationCount + " style=\"background-color:#01BFF3\">\n" +
"                <img src=\"images/" + item.limage + "\" class=\"media-object\" alt=\"places\" style = \"width:300px; height:270px;\">\n" +
"            </label>\n" +
"        </div>\n" +
"    </div>\n" +
"</div>");
            });
            dfrd1.resolve();
            $("#catList").append("</div>");
        });
    }));
    return dfrd1.promise();
}

function loadTwitter() {
    var dfrd1 = $.Deferred();
    //get from twitter
    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'GETTWITTER'}, function (response) {
        var catMap = response.payload;

        $("#catList").empty();
        $.each(catMap, function (category, locationList) {
            alert(category)
            $("#catList").append("<div class=\"about-us  wow fadeInDown\">\n" +
                    "                    <!-- Title -->\n" +
                    "                    <div class=\"row\">\n" +
                    "                        <div class=\"col-lg-12\">\n" +
                    "                            <h3 style=\" color:#2eb8b8 \"> " + category + "</h3>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                    <!-- /.row -->\n" +
                    "                    <!-- Page Features -->\n" +
                    "                    <div class=\"row text-center\">\n");
            $.each(locationList, function (id, item) {
                locationCount++;
                $("#catList").append("<div class=\"col-lg-3\">\n" +
"    <br/><a onclick=\"displayDetailModal('"+item.lname+"')\"  class=\"btn btn-primary btn-sm\" style=\"background-color:#6173F4;width:260px\" id=\"modal1\">"+item.lname+"</a>\n" +
"    <div class=\"funkyradio\">\n" +
"        <div class=\"funkyradio-danger\">\n" +
"            <input type=\"checkbox\" name=\"checkbox\" id="+locationCount + " value=\""+item.lname+"\">\n" +
"            <label for=" + locationCount + " style=\"background-color:#01BFF3\">\n" +
"                <img src=\"images/" + item.limage + "\" class=\"media-object\" alt=\"places\" style = \"width:300px; height:270px;\">\n" +
"            </label>\n" +
"        </div>\n" +
"    </div>\n" +
"</div>");
            });
            dfrd1.resolve();
            $("#catList").append("</div>");
        });
    }));
    return dfrd1.promise();
}

function getSelectedPlaces() {

    var places = new Array();
    var place_list;
    for (var i = 1; i <= locationCount; i++) {
        var loc = document.getElementById(i);
        if (loc.checked) {
            var name = loc.value;
            places.push(name);
            place_list = place_list + "," + name;
            
        }
       
    }
    if(places===null)
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

function displayDetailModal(loc1)
{

    var loc_name = {lname: loc1};

    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'GETSELECTEDLOCATIONS', data: JSON.stringify(loc_name)}, function (response) {

        console.log(response);

        var res = response.payload[0]

        $("#moreDetailModal").modal();
        document.getElementById("accomTitle").innerHTML = res.lname;
        document.getElementById("locname").innerHTML = res.lname;
        document.getElementById("cat").innerHTML = res.lcategory;
        document.getElementById("des").innerHTML = res.ldescription;
        document.getElementById("accom_img").src = "images/" + res.limage + "";
    }));
}