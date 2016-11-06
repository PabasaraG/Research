/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function addingSuccess(response)
{
    $('#msg').empty();
    switch (response.code) {
        case 200:
            var result = response.payload;
            switch (result.code) {
                case 201:
                    $('#msg').html("<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n" +
                            "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                            "  <strong>Success!</strong> " + result.message + ".\n" +
                            "</div>");
                    window.scrollTo(0, 0);
                    $('#btnUpdate').show();
                    $('#btnAdd').hide();
                    break;
                case 500:
                    $('#msg').html("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n" +
                            "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                            "  <strong>Internal Error!</strong> " + result.message + ".\n" +
                            "</div>");
                    window.scrollTo(0, 0);
                    break;
                case 404:
                case 405:
                    $('#msg').html("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n" +
                            "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                            "  <strong>Error!</strong> " + result.message + ".\n" +
                            "</div>");
                    window.scrollTo(0, 0);
                    break;
            }
            break;
        case 201:
            $('#msg').html("<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n" +
                    "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                    "  <strong>Success!</strong> " + response.message + ".\n" +
                    "</div>");
            window.scrollTo(0, 0);
            $('#btnUpdate').show();
            $('#btnAdd').hide();
            break;
        case 404 :
        case 400 :
        case 406 :
        case 405 :
            $('#msg').html("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n" +
                    "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                    "  <strong>Error!</strong> " + response.message + ".\n" +
                    "</div>");
            window.scrollTo(0, 0);
            break;
        case 500:
            $('#msg').html("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n" +
                    "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                    "  <strong>Internal Error!</strong> " + response.message + ".\n" +
                    "</div>");
            window.scrollTo(0, 0);
            break;
    }

}

function updatingSuccess(response)
{
    $('#msg').empty();
    switch (response.code) {
        case 200:
            var result = response.payload;
            switch (result.code) {
                case 202:
                    $('#msg').html("<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n" +
                            "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                            "  <strong>Success!</strong> " + result.message + ".\n" +
                            "</div>");
                    window.scrollTo(0, 0);
                    break;
                case 500:
                    $('#msg').html("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n" +
                            "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                            "  <strong>Internal Error!</strong> " + result.message + ".\n" +
                            "</div>");
                    window.scrollTo(0, 0);
                    break;
                case 404 :
                case 405:
                    $('#msg').html("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n" +
                            "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                            "  <strong>Error!</strong> " + result.message + ".\n" +
                            "</div>");
                    window.scrollTo(0, 0);
                    break;
            }
            break;
        case 202:
            $('#msg').html("<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n" +
                    "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                    "  <strong>Success!</strong> " + response.message + ".\n" +
                    "</div>");
            window.scrollTo(0, 0);
            break;
        case 404 :
        case 400 :
        case 406 :
        case 405 :
            $('#msg').html("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n" +
                    "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                    "  <strong>Error!</strong> " + response.message + ".\n" +
                    "</div>");
            window.scrollTo(0, 0);
            break;
        case 500:
            $('#msg').html("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n" +
                    "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                    "  <strong>Internal Error!</strong> " + response.message + ".\n" +
                    "</div>");
            window.scrollTo(0, 0);
            break;
    }

}

function invalidInputs()
{
    $('#msg').html("<div class=\"alert alert-warning alert-dismissible\" role=\"alert\">\n" +
            "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
            "  <strong>Error!</strong> Invalid Inputs.\n" +
            "</div>");
    window.scrollTo(0, 0);
}

function gettingSuccess(response) {

    //need to be implemente
}

function successMsgTour(response){
    $('#msg').empty();
        switch (response.code) {
            case 200:
            case 203:
            case 202:
            case 201:
                $('#msg').html("<div class=\"alert alert-success alert-dismissible\" role=\"alert\">\n" +
                        "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                        "  <strong>Success!</strong> " + response.message + ".\n" +
                        "</div>");

                $('#btnAdd').hide();
                $('#btnUpdate').show();
                $('#btnNext').show();

                break;
            case 404:
            case 406:
            case 500:
                $('#msg').html("<div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n" +
                        "  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n" +
                        "  <strong>Error!</strong> " + response.message + ".\n" +
                        "</div>");
                window.scrollTo(0, 0);
                break;
        }
}
