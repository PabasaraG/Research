
function formatDate(date) {
    if (!isValidDate(date)) {
        date = new Date();
    }
//    var strDateTime = date.split("T");
//    var strDate = strDateTime[0];
//
//    var arrDate = strDate.split("-");

    var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}

function formatTime(date) {
    if (!isValidDate(date)) {
        date = new Date();
    }
    var strDateTime = date.split("T");
    var strTime = strDateTime[1];


    var newDate;
    var arrTime = strTime.split(":");
    newDate = arrTime[0] + "H" + arrTime[1];

    return newDate;

}

function formatDateTime(date) {
    var d = new Date(date),
            month = '' + (d.getMonth() + 1),
            day = '' + d.getDate(),
            year = d.getFullYear(),
            hour = '' + d.getHours(),
            min = '' + d.getMinutes();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;
    if (hour.length < 2)
        hour = '0' + hour;
    if (min.length < 2)
        min = '0' + min;
    if (hour.length < 1)
        min = '00' + hour;
    if (min.length < 1)
        min = '00' + min;

//    var strDateTime = date.split("T");
//    var strDate = strDateTime[0];
//    var strTime = strDateTime[1];
//
//    var arrDate = strDate.split("-");
//    var arrTime = strTime.split(":");

    var newDate = year + "-" + month + "-" + day + "T" + hour + ":" + min + ":00";
    return newDate;
}
function formatDateForPicker(date) {
    if (!isValidDate(date)) {
        date = new Date();
    }
    var strDateTime = date.split("T");
    var strDate = strDateTime[0];

    var arrDate = strDate.split("-");

//    var d = new Date(date),
//            month = '' + (d.getMonth() + 1),
//            day = '' + d.getDate(),
//            year = d.getFullYear();
//
//    if (month.length < 2)
//        month = '0' + month;
//    if (day.length < 2)
//        day = '0' + day;

    return [arrDate[0], arrDate[1], arrDate[2]].join('-');
}

function formatDateForPickerByYMD(year, month, day) {
    month = month.toString();
    day = day.toString();
    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;
    return [year, month, day].join('-');
}

function formatDateTimeForPicker(date) {

    if (!isValidDate(date)) {
        date = new Date();
    }
    var strDateTime = date.split("T");
    var strDate = strDateTime[0];
    var strTime = strDateTime[1];

    var arrDate = strDate.split("-");

    var newDate;
    if (typeof strTime != 'undefined') {
        var arrTime = strTime.split(":");
        newDate = arrDate[0] + "-" + arrDate[1] + "-" + arrDate[2] + " " + arrTime[0] + ":" + arrTime[1];

    } else {
        newDate = arrDate[0] + "-" + arrDate[1] + "-" + arrDate[2] + " 00:00";
    }


//    var d = new Date(Date.UTC(arrDate[0],arrDate[1],arrDate[2],arrTime[0],arrTime[1],arrTime[2])),
//            month = '' + (d.getMonth() + 1),
//            day = '' + d.getDate(),
//            year = d.getFullYear(),
//            hour = '' + d.getHours(),
//            min = '' + d.getMinutes();
//
//    if (month.length < 2)
//        month = '0' + month;
//    if (day.length < 2)
//        day = '0' + day;
//    if (hour.length < 2)
//        hour = '0' + hour;
//    if (min.length < 2)
//        min = '0' + min;
//    if (hour.length < 1)
//        min = '00' + hour;
//    if (min.length < 1)
//        min = '00' + min;

    return newDate;
}

function isValidDate(value) {
    var dateWrapper = new Date(value);
    return !isNaN(dateWrapper.getDate());
}

function formatDateMonth(date) {
//    var d = new Date(date),
//            month = '' + (d.getMonth() + 1),
//            day = '' + d.getDate()
//
//    if (month.length < 2)
//        month = '0' + month;
//    if (day.length < 2)
//        day = '0' + day;

    var strDateTime = date.split("T");
    var strDate = strDateTime[0];

    var arrDate = strDate.split("-");

    return [arrDate[1], arrDate[2]].join('/');
}

/**
 * To Dashboard Arrival Depature
 * @param {type} datetime
 * @returns time string
 */
function timeToString(datetime) {
    var time = datetime.time;
    var hour = '' + time.hour;
    var min = '' + time.minute;

    if (hour.length < 2)
        hour = '0' + hour;
    if (min.length < 2)
        min = '0' + min;

    return  hour + ":" + min;
}

function dateForSummaryPages(date) {

    if (!isValidDate(date)) {
        date = new Date();
    }
    var strDateTime = date.split("T");
    var strDate = strDateTime[0];
    var strTime = strDateTime[1];

    var arrDate = strDate.split("-");

    var newDate;
    newDate = arrDate[0] + "-" + arrDate[1] + "-" + arrDate[2];
    return newDate;

}