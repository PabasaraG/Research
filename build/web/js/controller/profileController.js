/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * add profile information to db
 * @returns {undefined}
 */
function addProfileInfo()
{
    var firstName = $('#firstname').val();
    var lastName = $('#lastname').val();
    var email = $('#email').val();
    var coun = document.getElementById("country");
    var country = coun.options[coun.selectedIndex].value;

    var day = document.getElementById("bDay");
    var bDay = day.options[day.selectedIndex].value;
    var month = document.getElementById("bMonth");
    var bMonth = month.options[month.selectedIndex].value;
    var year = document.getElementById("bYear");
    var bYear = year.options[year.selectedIndex].value;

    var gender;
    if (document.getElementById('radio1').checked) {
        gender = document.getElementById('radio1').value;
        alert(gender);
    }
    else if (document.getElementById('radio3').checked) {
        gender = document.getElementById('radio3').value;
        alert(gender);
    }
    else
    {
        gender = "";
        alert(gender);
    }
    //taking profile info
    var areYou;
    if (document.getElementById('student').checked) {
        areYou = document.getElementById('student').value;
        alert(areYou);
    }
    else if (document.getElementById('worker').checked) {
        areYou = document.getElementById('worker').value;
        alert(areYou);
    }
    else if (document.getElementById('both').checked) {
        areYou = document.getElementById('both').value;
        alert(areYou);
    }
    else if (document.getElementById('retired').checked) {
        areYou = document.getElementById('retired').value;
        alert(areYou);
    }
    else
    {
        areYou = "";
        alert(areYou);
    }

    var relationship;
    if (document.getElementById('single').checked) {
        relationship = document.getElementById('single').value;
        //alert(areyou);
    }
    else if (document.getElementById('married').checked) {
        relationship = document.getElementById('married').value;
        //(areyou);
    }
    else if (document.getElementById('complicated').checked) {
        relationship = document.getElementById('complicated').value;
        //alert(areyou);
    }
    else
    {
        relationship = "";
        //alert(areyou);
    }

    var religious;
    if (document.getElementById('buddhist').checked) {
        religious = document.getElementById('buddhist').value;
        //alert(areyou);
    }
    else if (document.getElementById('christian').checked) {
        religious = document.getElementById('christian').value;
        //(areyou);
    }
    else if (document.getElementById('muslim').checked) {
        religious = document.getElementById('muslim').value;
        //alert(areyou);
    }
    else if (document.getElementById('hindu').checked) {
        religious = document.getElementById('hindu').value;
        //alert(areyou);
    }
    else
    {
        religious = "";
        //alert(areyou);
    }
    var aboutMe = $('#aboutMe').val();

    //taking values of interests tab
    var concern;
    if (document.getElementById('transportation').checked) {
        concern = document.getElementById('transportation').value;
        //alert(areyou);
    }
    else if (document.getElementById('accommodation').checked) {
        concern = document.getElementById('accommodation').value;
        //(areyou);
    }
    else if (document.getElementById('foods').checked) {
        concern = document.getElementById('foods').value;
        //alert(areyou);
    }
    else if (document.getElementById('entertainment').checked) {
        concern = document.getElementById('entertainment').value;
        //alert(areyou);
    }
    else
    {
        concern = "";
        //alert(areyou);
    }
    var travelFor;
    if (document.getElementById('leisure').checked) {
        travelFor = document.getElementById('leisure').value;
        //alert(areyou);
    }
    else if (document.getElementById('business').checked) {
        travelFor = document.getElementById('business').value;
        //(areyou);
    }
    else if (document.getElementById('makenewfriends').checked) {
        travelFor = document.getElementById('makenewfriends').value;
        //alert(areyou);
    }
    else if (document.getElementById('visitnewplaces').checked) {
        travelFor = document.getElementById('visitnewplaces').value;
        //alert(areyou);
    }
    else
    {
        travelFor = "";
        //alert(areyou);
    }
    var visitedBefore;
    if (document.getElementById('yes').checked) {
        visitedBefore = document.getElementById('yes').value;
        //alert(areyou);
    }
    else if (document.getElementById('no').checked) {
        visitedBefore = document.getElementById('no').value;
        //(areyou);
    }
    else
    {
        visitedBefore = "";
        //alert(areyou);
    }
    var challenging;
    if (document.getElementById('qualityofservice').checked) {
        challenging = document.getElementById('qualityofservice').value;
        //alert(areyou);
    }
    else if (document.getElementById('reliability').checked) {
        challenging = document.getElementById('reliability').value;
        //(areyou);
    }
    else if (document.getElementById('languagedifficulties').checked) {
        challenging = document.getElementById('languagedifficulties').value;
        //(areyou);
    }
    else if (document.getElementById('price').checked) {
        challenging = document.getElementById('price').value;
        //(areyou);
    }
    else
    {
        challenging = "";
        //alert(areyou);
    }
    var reason;
    if (document.getElementById('fun').checked) {
        reason = document.getElementById('fun').value;
        //alert(areyou);
    }
    else if (document.getElementById('visitrelativesandfriends').checked) {
        reason = document.getElementById('visitrelativesandfriends').value;
        //(areyou);
    }
    else if (document.getElementById('religiousreasons').checked) {
        reason = document.getElementById('religiousreasons').value;
        //(areyou);
    }
    else if (document.getElementById('restandrelaxation').checked) {
        reason = document.getElementById('restandrelaxation').value;
        //(areyou);
    }
    else
    {
        reason = "";
        //alert(areyou);
    }
    var often;
    if (document.getElementById('onceinayear').checked) {
        often = document.getElementById('onceinayear').value;
        //alert(areyou);
    }
    else if (document.getElementById('onceinamonth').checked) {
        often = document.getElementById('onceinamonth').value;
        //(areyou);
    }
    else
    {
        often = "";
        //alert(areyou);
    }
    var birthDay = bDay + bMonth + bYear;
    var personalInfo = {username: email, firstname: firstName, lastname: lastName, birthdate: birthDay, gender: gender, country: country};

    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'UPDATEUSER', data: JSON.stringify(personalInfo)}, function (response) {

        console.log(response);
        // goToCountry(country);
        if (response.code === 200)
        {
            //session.setAttribute("email",email)
            alert("Incorrect Email or Password!");
        }
        else
        {
            //session.setAttribute("email",email)
            //window.location = "/tourbuddy/index.jsp?email=$('#email').val();";
            alert("Incorrect Email or Password!");
            //document.getElementById("validationmsg").innerHTML = "<h5>An error occured while registering the user.Please try again later!</h5><br/><br/>";
        }
    }));

    var profileInfo = {username: email, areYou: areYou, relationship: relationship, religious: religious, aboutMe: aboutMe, concern: concern, travelFor: travelFor, visitedBefore: visitedBefore, challenging: challenging, reason: reason, often: often};

    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'ADDUPDATEPROFILE', data: JSON.stringify(profileInfo)}, function (response) {

        console.log(response);
        if (response.code === 200)
        {
            alert("Successfully Saved your Details!");
        }
        else
        {
            alert("Incorrect Email or Password!");
        }
    }));
}

