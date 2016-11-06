/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getSeason(hemisphere, dateString) {

    var date = new Date(dateString);

    var month = (date.getMonth() + 1);
    var season = null;
    if (hemisphere === 'N') {
        switch (month) {
            case 1:
            case 2:
            case 12:
                season = "Winter";
                break;
            case 3:
            case 4:
            case 5:
                season = "Spring";
                break;
            case 6:
            case 7:
            case 8:
                season = 'Summer';
                break;
            case 9:
            case 10:
            case 11:
                season = 'Autum';
                break;
        }
    }else{
        switch (month) {
            case 1:
            case 2:
            case 12:
                season = "Summer";
                break;
            case 3:
            case 4:
            case 5:
                season = "Autum";
                break;
            case 6:
            case 7:
            case 8:
                season = 'Winter';
                break;
            case 9:
            case 10:
            case 11:
                season = 'Spring';
                break;
        }
    }
    return season; 
}
