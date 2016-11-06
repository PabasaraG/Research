/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validateNIC(pinputId, pmsgId) {

    var inputId = '#' + pinputId;
    var msgId = '#' + pmsgId;
    var re = /^[0-9]{9}[vVxX]$/;

    var nic = $(inputId).val();

    if (!re.test(nic)) {
        $(msgId).html("<div><span class=\"label label-danger\">Invalid NIC (eg : 123456789v)</span></div>");
        return false;
    } else {
        $(msgId).html("");
        return true;
    }
}

function validatePhone(pinputId, pmsgId) {
    var result = true;
    var inputId = '#' + pinputId;
    var msgId = '#' + pmsgId;

    var number = $(inputId).val();
    var numberPattern = /\d+/g;

    if (number.length > 0) {
        number = (number.match(numberPattern)).toString().replace(/,/g, "");
        if (number.length < 15 && (!isNaN(parseFloat(number)) && isFinite(number)) && (0 < number < 99999999999999)) {
            $(inputId).val(number);
            $(msgId).html("");
            result = true;
        }
        else {
            $(msgId).html("<div><span class=\"label label-danger\">Phone number must be less than 15 digits</span></div>");
            result = false;
        }
    }
    return result;
}

function requiredField(pinputId, pmsgId) {

    var inputId = '#' + pinputId;
    var msgId = '#' + pmsgId;

    var text = $(inputId).val();

    if (text == "" || text == null || text == " ") {
        $(msgId).html("<div><span class=\"label label-danger\">Required..</span></div>");
        return false;
    }
    else {
        $(msgId).html("");
        return true;
    }
}

function isNumber(pinputId, pmsgId) {
    var inputId = '#' + pinputId;
    var msgId = '#' + pmsgId;

    var n = $(inputId).val();
    if (!isNaN(parseFloat(n)) && isFinite(n))
    {
        $(msgId).html("");
        return true;
    } else {
        $(msgId).html("<div><span class=\"label label-danger\">Should be a number..</span></div>");
        return false;
    }
}

function isSelect(pinputId, pmsgId) {
    var inputId = '#' + pinputId;
    var msgId = '#' + pmsgId;

    var n = $(inputId).val();
    if ($(inputId).val() != '-1')
    {
        $(msgId).html("");
        return true;
    } else {
        $(msgId).html("<div><span class=\"label label-danger\">You must select..</span></div>");
        return false;
    }
}

function validateEmail(pinputId, pmsgId)
{

    var inputId = '#' + pinputId;
    var msgId = '#' + pmsgId;
    var re = / ^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$/;

    var nic = $(inputId).val();

    if (!re.test(nic)) {
        $(msgId).html("");
        return true;
    }
    else {
        $(msgId).html("<div ><span class=\"label label-danger\">invalid email</span></div>");
        return false;
    }
}

function checkForEmptyPhoneNumber(number) {



    if (number == "" || number == null || number == " ") {
        return 0;
    }
    else {
        var numberPattern = /\d+/;
        number = (number.match(numberPattern)).toString().replace(/,/g, "");
        return number;
    }


}

function postalCodeValidator(pinputId, pmsgId)
{
    var result = true;

    var inputId = '#' + pinputId;
    var msgId = '#' + pmsgId;

    var pcode = $(inputId).val();
    var distCode = pcode.substring(0, 2);
    var areaCode = pcode.substring(2);

    var code = ["00", "01", "10", "11", "12", "20", "21", "22", "30", "31", "32", "40", "41", "42", "43", "50", "51", "60", "61",
        "70", "71", "80", "81", "82", "90", "91"];


    if (pcode.length > 0) {
        length = code.length;
        for (i = 0; i < length; i++)
        {
            if ((code[i] === distCode) && (areaCode >= 000 && areaCode <= 990))
            {
                result = true;
                break;
            }
            else {
                result = false;
            }
        }
    }

    if (result) {
        $(msgId).html("");
    } else {
        $(msgId).html("<div ><span class=\"label label-danger\">invalid postal code</span></div>");
    }
    return result;
}

function validateLocalPhone(pinputId, pmsgId) {
    var result = true;
    var inputId = '#' + pinputId;
    var msgId = '#' + pmsgId;

    var number = $(inputId).val();
    number = number.replace(/[^\d]/g, '');
    var numberPattern = /^(0[0-9]{9})|([0-9]{9})/g;

    if (number.length > 0) {
        number = (number.match(numberPattern)).toString().replace(/,/g, "");
        if (11 > number.length && (!isNaN(parseFloat(number)) && isFinite(number))) {
            $(inputId).val(number);
            $(msgId).html("");
            result = true;
        }
        else {
            $(msgId).html("<div><span class=\"label label-danger\">Phone number must be 10 digits<br/>eg:0xx x xxxxxx</span></div>");
            result = false;
        }
    }
    return result;
}

function setNullForZero(value) {
    var number;
    if (value == 0 || value == 0.0) {
        number = "";
    }
    else {
        number = value;
    }
    return number;
}

function checkForUndefined(value) {
    var result = "";
    if (typeof value != "undefined") {
        result = value;
    } else {
        result = "";
    }
    return result;
}

function checkForUndefinedObject(value) {
    var result = {};
    if (typeof value != "undefined") {
        result = value;
    } else {
        result = {};
    }
    return result;
}

/**
 * Date time validation
 * Accepted format yyyy-mm-dd HH:MM 
 */
function validateDateTime(dtString) {
    var matches = dtString.match(/^(\d{4})(-)(\d{2})(-)(\d{2})[T](\d{2}):(\d{2}):(\d{2})$/);
    ;
    var result = true;

    if (matches === null) {
        result = false;
    } else {
        // now lets check the date sanity
        var year = parseInt(matches[1], 10);
        var month = parseInt(matches[3], 10) - 1; // months are 0-11
        var day = parseInt(matches[5], 10);
        var hour = parseInt(matches[6], 10);
        var minute = parseInt(matches[7], 10);
        var second = parseInt(matches[8], 10);
        var date = new Date(year, month, day, hour, minute, second);
        if (date.getFullYear() !== year
                || date.getMonth() != month
                || date.getDate() !== day
                || date.getHours() !== hour
                || date.getMinutes() !== minute
                || date.getSeconds() !== second
                ) {
            // invalid
            result = false;
        }
    }

    return result;
}

/**
 * Date validation
 * Accepted format yyyy-mm-dd
 */
function validateDate(dtString) {
    var matches = dtString.match(/^(\d{4})(-)(\d{2})(-)(\d{2})$/);
    var result = true;

    if (matches === null) {
        result = false;
    } else {
        // now lets check the date sanity
        var year = parseInt(matches[1], 10);
        var month = parseInt(matches[3], 10) - 1; // months are 0-11
        var day = parseInt(matches[5], 10);
        var date = new Date(year, month, day);
        if (date.getFullYear() !== year
                || date.getMonth() != month
                || date.getDate() !== day
                ) {
            // invalid
            result = false;
        }
    }

    return result;
}
function checkEmptyNumber(number) {
    if (number == "" || number == null || number == " ") {
        return 0;
    } else {
        return number;
    }

}

function isnotDoS(lastAccess) {
    var ttl = 10000;  //TimeToLeave
    return(new Date().getMilliseconds() < (ttl + lastAccess))
}

function formatLocalPhone(text) {
    if (typeof text != 'undefined') {
        text = text.toString();
        if (text == 0 || text == 0.0) {
            text = "";
        }
        else {
            text = text.replace(/(\d\d)(\d\d\d)(\d\d\d\d)\s+/, "$1-$2-$3");
        }
    } else {
        text = "";
    }
    return text;
}

function formatForeignPhone(text) {
    if (typeof text != 'undefined') {
        text = text.toString();
        if (text == 0 || text == 0.0) {
            text = "";
        }
        else {
            text = text.replace(/(\d\d\d)(\d\d\d)(\d\d\d\d)/, "$1-$2-$3");
        }
    } else {
        text = "";
    }
    return text;
}

function stringCapitalize(str) {
    return (str + '').replace(/^([a-z])|\s+([a-z])/g, function($1) {
        return $1.toUpperCase();
    });
}

function formatPhoneLocal(obj) {
    if (typeof obj !== 'undefined') {

        var numbers = obj.toString();
        numbers = numbers.replace(/\D/g, ''),
                char = {0: '', 2: '-', 5: '-'};
        obj = '';
        for (var i = 0; i < numbers.length; i++) {
            obj += (char[i] || '') + numbers[i];
        }
        if(numbers.length === 1){
            return "";
        }
    }
    return obj;
}

function formatPhoneForeign(obj) {
    if (typeof obj !== 'undefined') {

        var numbers = obj.toString();
        numbers = numbers.replace(/\D/g, ''),
                char = {0: '', 2: '-', 5: '-'};
        obj = '';
        for (var i = 0; i < numbers.length; i++) {
            obj += (char[i] || '') + numbers[i];
        }
        if(numbers.length === 1){
            return "";
        }
    }
    return obj;
}