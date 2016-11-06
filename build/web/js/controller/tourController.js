/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.locationCount = 0;

function addTour()
{
   
    var tourName = $('#tname').val();
    var startDate = $('#tstartdate').val();
    var endDate = $('#tenddate').val();
   // var startDate = formatDateTime(sDate);
   // var endDate = formatDateTime(eDate);
    var accType = $('#tacc').val();
    var budgetRange = $('#tbudget').val();
    var travelType=$('#travel').val();

    var tourInfo = {tourName: tourName, startDate: startDate, endDate: endDate, accType: accType, budgetRange: budgetRange,travelType: travelType};

    $.when($.post('/tourbuddy/EntityFacade', {cmd: 'ADD_TOUR', data: JSON.stringify(tourInfo)}, function (response) {
//        addingSuccess(response);
//        loadDriverTable();
     //   console.log(response);
     //   goToCountry(country);
    }));
}

