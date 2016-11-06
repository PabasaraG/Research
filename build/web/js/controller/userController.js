/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
});

/**
 * user login
 * @returns {undefined}
 */
function login()
{
    var username = $('#username').val();
    var password = $('#password').val();

    if (username.length === 0 || password.length === 0)
    {
        document.getElementById("validationmsg").innerHTML = "<h5 style=\"color:red\"><strong>Please Enter Your Username and Password to SignIn!</strong></h5><br/><br/>";
    }
    else {
        var loginInfo = {username: username, password: password};

        $.when($.post('/tourbuddy/Login', {cmd: 'LOGIN', data: JSON.stringify(loginInfo)}, function (response) {

            console.log(response);

            if (response.code === 200)
            {
                window.location = "/tourbuddy/home.jsp";
            }
            else
            {

                document.getElementById("validationmsg").innerHTML = "<h5 style=\"color:red\"><b>Please Enter a valid Username and Password!</b></h5>";
            }
        }));
    }
}

/**
 * user registration
 * @returns {undefined}
 */
function register()
{
    var firstName = $('#firstName').val();
    var lastName = $('#lastName').val();
    var email = $('#email').val();
    var atpos = email.indexOf("@");
    var dotpos = email.lastIndexOf(".");

    var password = $('#password').val();
    var confirmPassword = $('#confirmPassword').val();

    var coun = document.getElementById("country");
    var country = coun.options[coun.selectedIndex].value;

    var day = document.getElementById("bDay");
    var bDay = day.options[day.selectedIndex].value;
    var month = document.getElementById("bMonth");
    var bMonth = month.options[month.selectedIndex].value;
    var year = document.getElementById("bYear");
    var bYear = year.options[year.selectedIndex].value;

    var gender;
    var termsConditions = false;
    if (document.getElementById('radio1').checked) {
        gender = document.getElementById('radio1').value;
        //alert(gender);
    }
    else if (document.getElementById('radio3').checked) {
        gender = document.getElementById('radio3').value;
        //alert(gender);
    }
    else
    {
        gender = null;
        //alert(gender);
    }

    if (document.getElementById('checkbox1').checked) {
        termsConditions = true;
    }

    var birthDay = bDay + bMonth + bYear;
    var userImage = "userImage.png";

    if (firstName !== null && lastName !== null && email !== null && password !== null && confirmPassword !== null && country !== null && gender !== null && birthDay !== null)
    {
        if (password === confirmPassword)
        {
            if (country !== "Select Your Country")
            {
                if (termsConditions === true)
                {
                    if (bDay !== "Day" && bMonth !== "Month" && bYear !== "Year")
                    {
                        if (atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length)
                        {
                            document.getElementById("validationmsg").innerHTML = "<h5 style=\"color:red;pading-left:20px\"><b>Please Enter a VALID Email Address!</b></h5><br/>";

                        }
                        else {

                            var registerInfo = {username: email, password: password, firstname: firstName, lastname: lastName, birthdate: birthDay, gender: gender, country: country, userImage: userImage};

                            $.when($.post('/tourbuddy/register', {cmd: 'REGISTER', data: JSON.stringify(registerInfo)}, function (response) {

                                console.log(response);
                                if (response.code === 200)
                                {
                                    window.location = "/tourbuddy/home.jsp";
                                }
                                else
                                {
                                    alert("User Registration Failed!");
                                }
                            }));
                        }
                    }
                    else
                    {
                        document.getElementById("validationmsg").innerHTML = "<h5 style=\"color:red;pading-left:20px\"><b>Please select your BirthDate!</b></h5><br/>";

                    }
                }
                else
                {
                    document.getElementById("validationmsg").innerHTML = "<h5 style=\"color:red;pading-left:20px\"><b>Please accept our TERMS & CONDITIONS!</b></h5><br/>";

                }
            }
            else {
                document.getElementById("validationmsg").innerHTML = "<h5 style=\"color:red;pading-left:20px\"><b>Please select your Country!</b></h5><br/>";

            }
        }
        else {
            document.getElementById("validationmsg").innerHTML = "<h5 style=\"color:red;pading-left:20px\"><b>Password and Confirm Password should be equal!</b></h5><br/>";

        }
    }
    else {
        document.getElementById("validationmsg").innerHTML = "<h5 style=\"color:red;pading-left:20px\"><b>Please fill all the fields!</b></h5><br/>";

    }
}

function addReview()
{
    var review = $('#review').val();
    

    if (review.length === 0)
    {
        alert("Enter a Review to add");
    }
    else {
        var loginInfo = {username: username, password: password};

        $.when($.post('/tourbuddy/Login', {cmd: 'LOGIN', data: JSON.stringify(loginInfo)}, function (response) {

        }));
    }
}