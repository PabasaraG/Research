Date.prototype.addDays = function(days) {
    var dat = new Date(this.valueOf())
    dat.setDate(dat.getDate() + days);
    return dat;
}

/**
 * Get Full Date Array.
 * @param {Date} startDate
 * @param {Date} stopDate
 * @returns {Array|getFulDatesArray.dateArray}
 */
function getFulDatesArray(startDate, stopDate) {
    var dateArray = new Array();
    var currentDate = startDate;
    while (currentDate <= stopDate) {
        dateArray.push(currentDate)
        currentDate = currentDate.addDays(1);
    }
    return dateArray;
}

/**
 * Get Full Date to Dropdown.
 * @param {Date} startDate
 * @param {Date} stopDate
 * @returns {String} opton list to select tag with value = formatDate(date) and Text like SAT AUG 01 2015
 */
function getFulDatesDropDown(startDate, stopDate) {
    var dateSelect = "";
    var currentDate = startDate;
    while (currentDate <= stopDate) {
        dateSelect += "<option value=\"" + formatDate(new Date(currentDate)) + "\">" + new Date(currentDate).toDateString() + "</option>";
        currentDate = currentDate.addDays(1);
    }
    return dateSelect;
}

/**
 * Get Date to Dropdown.
 * @param {Date} startDate
 * @param {Date} stopDate
 * @returns {String} opton list to select tag with value = formatDate(date) and Text = date
 */
function getDatesDropDown(startDate, stopDate) {
    var dateSelect = "";
    var currentDate = startDate;
    while (currentDate <= stopDate) {
        dateSelect += "<option value=\"" +  formatDate(new Date(currentDate)) + "\">" +  new Date(currentDate).getDate() + "</option>";
        currentDate = currentDate.addDays(1);
    }
    return dateSelect;
}

/**
 * Get Date and Month to Dropdown.
 * @param {Date} startDate
 * @param {Date} stopDate
 * @returns {String} opton list to select tag with value = formatDate(date) and Text = month/date
 */
function getDateMonthDropDown(startDate, stopDate) {
    var dateSelect = "";
    var currentDate = startDate;
    while (currentDate <= stopDate) {
        dateSelect += "<option value=\"" +  formatDate(new Date(currentDate)) + "\">" +  (new Date(currentDate).getMonth() + 1) + "/" +  new Date(currentDate).getDate() + "</option>";
        currentDate = currentDate.addDays(1);
    }
    return dateSelect;
}

/**
 * Get Date/Month/Year to Dropdown.
 * @param {Date} startDate
 * @param {Date} stopDate
 * @returns {String} opton list to select tag with value = formatDate(date) and Text = year/month/date
 */
function getDateMonthYearDropDown(startDate, stopDate) {
    var dateSelect = "";
    var currentDate = startDate;
    while (currentDate <= stopDate) {
        dateSelect += "<option value=\"" +  formatDate(new Date(currentDate)) + "\">" +  (new Date(currentDate).getFullYear()) + "/" +  (new Date(currentDate).getMonth() + 1) + "/" +  new Date(currentDate).getDate() + "</option>";
        currentDate = currentDate.addDays(1);
    }
    return dateSelect;
}