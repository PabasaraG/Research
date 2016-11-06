
window.locationCount = 0;
window.locationCount = 0;
window.no = 0;
$(document).ready(function () {
    displayaccoms();
});

function displayaccoms()
{

    //var cat_type = {category: accom_category};

    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'GETACCOMS'}, function (response) {
        console.log(response);
        if (response.code === 200)
        {
            $('#location').empty();
            var locationResponse = response.payload;
            $('#location').append("<div class=\"row\">");
            $.each(locationResponse, function (id, item) {
                locationCount++;
                no++;
                var locname = "locationName" + 1;
                $('#location').append("<div class=\"col-lg-3\">"
                        + "<br/><a onclick=\"displayDetailModal('" + item.locationName + "')\" class=\"btn btn-primary btn-sm\" style=\"background-color:#6173F4;width:270px\" id=" + locname + ">"
                        + item.locationName
                        + "\n"
                        + "</a>"
                        + " <div class=\"funkyradio\">"
                        + "<div class=\"funkyradio-danger\">"
                        + " <input type=\"checkbox\" name=\"checkbox\" id=" + locationCount + " value=" + item.locId + ">"
                        + "<label for=" + locationCount + " style=\"background-color:#01BFF3\">"
                        + " <img src=\"images/accomms/" + item.image + "\" class=\"media-object\" alt=\"Heritage\" style = \"width:290px; height:270px;\">"
                        + " </label>"
                        + " </div>"
                        + " </div>"
                        + "</div>");
            });
            if ((locationCount % 4) === 0)
            {
                var br = document.createElement("br");

                $('#location').append("</div><br/><br/>"
                        + "<div class=\"row\">");
                $('#location').append(br);
                $('#location').append(br);
                $('#location').append(br);

            }
            $('#topmessage').empty();
            $('#topmessage').append("<h4 class=\"text-primary\">Displaying Accommodations for Accommodation Type<a href=\"register.jsp\" style=\"color:#3367D6\"> " + response.payload[0].category + "</a></h4>"
                    + "<p>To change the Accommodation Type of your tour <a href=\"#\" data-toggle=\"modal\" data-target=\"#changeBudgetRangeModal\"><font size=\"3\">Please Click Here!</font></a></p>"
                    );

        }
    }));
}

/*
 * method to display the accommodation list according to the selected category
 * @returns {undefined}
 */
function displayLocations()
{
    var accom_category = document.getElementById("category").options[document.getElementById("category").selectedIndex].value;

    var cat_type = {category: accom_category};

    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'GETLOCATIONS', data: JSON.stringify(cat_type)}, function (response) {
        console.log(response);
        if (response.code === 200)
        {
            $('#location').empty();
            var locationResponse = response.payload;
            $('#changeBudgetRangeModal').modal('hide');
            $('#location').append("<div class=\"row\">");
            $.each(locationResponse, function (id, item) {
                locationCount++;
                no++;
                var locname = "locationName" + 1;
                $('#location').append("<div class=\"col-lg-3\">"
                        + "<br/><a onclick=\"displayDetailModal('" + item.locationName + "')\" class=\"btn btn-primary btn-sm\" style=\"background-color:#6173F4;width:270px\" id=" + locname + ">"
                        + item.locationName
                        + "\n"
                        + "</a>"
                        + " <div class=\"funkyradio\">"
                        + "<div class=\"funkyradio-danger\">"
                        + " <input type=\"checkbox\" name=\"checkbox\" id=" + locationCount + " value=" + item.locId + ">"
                        + "<label for=" + locationCount + " style=\"background-color:#01BFF3\">"
                        + " <img src=\"images/accomms/" + item.image + "\" class=\"media-object\" alt=\"Heritage\" style = \"width:290px; height:270px;\">"
                        + " </label>"
                        + " </div>"
                        + " </div>"
                        + "</div>");
            });
            if ((locationCount % 4) === 0)
            {
                var br = document.createElement("br");

                $('#location').append("</div><br/><br/>"
                        + "<div class=\"row\">");
                $('#location').append(br);
                $('#location').append(br);
                $('#location').append(br);

            }
            $('#topmessage').empty();
            $('#topmessage').append("<h4 class=\"text-primary\">Displaying Accommodations for Accommodation Type<a href=\"register.jsp\" style=\"color:#3367D6\"> " + accom_category + "</a></h4>"
                    + "<p>To change the Accommodation Type of your tour <a href=\"#\" data-toggle=\"modal\" data-target=\"#changeBudgetRangeModal\"><font size=\"3\">Please Click Here!</font></a></p>"
                    );

        }
    }));
}

/**
 * get selected accommodation and send to the tour table
 * also get all the selected places and accommodation and run the algorithm
 * @returns {undefined}
 */
function getSelectedAccommodations() {

    var accommodations = new Array();
    var accom_list;
    for (var i = 1; i <= locationCount; i++) {
        var loc = document.getElementById(i);
        if (loc.checked) {
            var name = loc.value;
            accommodations.push(name);
            accom_list = accom_list + "," + name;
        }
    }
    if (accommodations === null)
    {
        alert("Please Select a Accommodation to Continue!");
    }
    var new_accom_list = accom_list.substring(10);
    var tName = "my tour";//get this from session -var tName = document.getElementById("tourName").innerHTML;
    var selected_accom = { selectedAccom: new_accom_list};

    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'ADDSELECTEDACCOM', data: JSON.stringify(selected_accom)}, function (response) {
        console.log(response);
        if (response.code === 200)
        {
            $('#topsection').empty();
            $('#topsection').append("<div><font size=\"4\">Please Wait...........!</font></div>"
                    + "<div id=\"myProgress\" class=\"col-md-7\" style=\"height:20px\">"
                    + "<div id=\"myBar\" ></div>"
                    + "</div>"

                    );
            move();
            startRouteGenerator().done(function () {
                $('#topmessage').empty();
                window.location = "/tourbuddy/tourroute.jsp";
            });//start route generator algorithm
        }
    }));
}
//progress bar
function move() {
    var elem = document.getElementById("myBar");
    var width = 0.5;
    var id = setInterval(frame, 80);
    function frame() {
        if (width >= 100) {
            clearInterval(id);
        } else {
            width++;
            elem.style.width = width + '%';
        }
    }
}

/**
 * start route generator method
 * @returns {undefined}
 */
function startRouteGenerator()
{
    var deferred = $.Deferred();
    tourname = "my tour";//get this from session - var tourname = document.getElementById("tourName").innerHTML;
    var tour_name = {tourName: tourname};
    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'ROUTEGEN'}, function (response) {
        deferred.resolve();
    }));
    return deferred.promise();
}
/**
 * display checkbox options for default route and alternative route
 * @returns {undefined}
 */
function displayCheck()
{
    var id = "chck1";
    for (var i = 0; i <= 3; i++)
    {
        $('#location').append("<div class=\"funkyradio\"><div class=\"funkyradio-danger\"><input type=\"checkbox\" name=\"checkbox\" id=" + id + " value=" + id + "/>\n\
                                <label for=\"chck1\"><a href=\"index.html\">Dalada Maligawa</a></label></div></div>");
    }
   // alert(document.getElementById("chck1").value);
}

/**
 * function to display detailed Modal of accommodation when click on the 
 * accommodation name from the list of accommodations that is displaying
 * @param {type} loc1
 * @param {type} des
 * @returns {undefined}
 */
function displayDetailModal(loc1)
{

    var loc_name = {locationName: loc1};

    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'GETSELECTEDLOCATION', data: JSON.stringify(loc_name)}, function (response) {

        console.log(response);

        var res = response.payload[0];

        $("#moreDetailModal").modal();
        document.getElementById("accomTitle").innerHTML = res.locationName;
        document.getElementById("locname").innerHTML = res.locationName;
        document.getElementById("cat").innerHTML = res.category;
        document.getElementById("add").innerHTML = res.address;
        document.getElementById("no").innerHTML = res.contactNo;
        document.getElementById("des").innerHTML = res.description;
        document.getElementById("accom_img").src = "images/accomms/" + res.image + "";
    }));
}