function getActiveStatus(val) {

    if (val === 0) {
        return "INACTIVE";
    } else if (val === 1) {
        return "ACTIVE&nbsp;&nbsp;&nbsp;&nbsp;";
    } else if (val === -1) {
        return "DEACTIVE";
    }
}

function setActiveStaus(id, status)
{
    $('#modalStatusId').val(id);
    $('#modalStatusCurrent').val(status);
    $('#myModal').show();
}

function changeActiveStaus(type)
{
    var modalStatusId = $('#modalStatusId').val();
    var currentStatus = $('#modalStatusCurrent').val();
    var comment = $('#modalStatusComment').val();
    var newStatus = $('#modalStatusType').val();
    //cmd => VEHICLE,VEHICLE_OWNER,AGENT,AGENT_OPERAROR,DRIVER,GUIDE,HOTEL
    $.when($.post('/magellanpro/pages/ChangeActiveStatus', {id: modalStatusId, currentStatus: currentStatus, comment: comment, newStatus: newStatus, cmd: type}, function (response) {
        $('#myModal').modal('hide');
        bootbox.alert(response.message, function () {
             location.reload();
        });

    }));
}
