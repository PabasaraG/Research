/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.locationCount = 0;

function getselecteditems()
{
    var q1;
    var q2;
    var q3;
    var q4;
    var q5;
    var q6;
    var q7;
    var q8;

    if (document.getElementById('radio1').checked) {
        q1 = document.getElementById('radio1').value;

    }
    if (document.getElementById('radio2').checked) {
        q1 = document.getElementById('radio2').value;

    }
    if (document.getElementById('radio3').checked) {
        q1 = document.getElementById('radio3').value;

    }
    if (document.getElementById('radio4').checked) {
        q1 = document.getElementById('radio4').value;

    }
    if (document.getElementById('radio5').checked) {
        q1 = document.getElementById('radio5').value;

    }
    if (document.getElementById('radio6').checked) {
        q1 = document.getElementById('radio6').value;

    }
    if (document.getElementById('radio7').checked) {
        q2 = document.getElementById('radio7').value;

    }
    if (document.getElementById('radio8').checked) {
        q2 = document.getElementById('radio8').value;

    }
    if (document.getElementById('radio9').checked) {
        q2 = document.getElementById('radio9').value;
     //   alert(q2);
    }
    if (document.getElementById('radio10').checked) {
        q2 = document.getElementById('radio10').value;
     //   alert(q2);
    }
    if (document.getElementById('radio11').checked) {
        q2 = document.getElementById('radio11').value;
      //  alert(q2);
    }
    if (document.getElementById('radio12').checked) {
        q2 = document.getElementById('radio12').value;
       // alert(q2);
    }
    if (document.getElementById('radio13').checked) {
        q3 = document.getElementById('radio13').value;
       // alert(q3);
    }
    if (document.getElementById('radio14').checked) {
        q3 = document.getElementById('radio14').value;
      //  alert(q3);
    }
    if (document.getElementById('radio15').checked) {
        q3 = document.getElementById('radio15').value;
     //   alert(q3);
    }
    if (document.getElementById('radio16').checked) {
        q3 = document.getElementById('radio16').value;
      //  alert(q3);
    }
    if (document.getElementById('radio17').checked) {
        q4 = document.getElementById('radio17').value;
     //   alert(q4);
    }
    if (document.getElementById('radio18').checked) {
        q4 = document.getElementById('radio18').value;
     //   alert(q4);
    }
    if (document.getElementById('radio19').checked) {
        q4 = document.getElementById('radio19').value;
      //  alert(q4);
    }
    if (document.getElementById('radio20').checked) {
        q4 = document.getElementById('radio20').value;
       // alert(q4);
    }
    if (document.getElementById('radio21').checked) {
        q4 = document.getElementById('radio21').value;
      //  alert(q4);
    }
    if (document.getElementById('radio22').checked) {
        q4 = document.getElementById('radio22').value;
     //   alert(q4);
    }
    if (document.getElementById('radio23').checked) {
        q5 = document.getElementById('radio23').value;
     //   alert(q5);
    }
    if (document.getElementById('radio24').checked) {
        q5 = document.getElementById('radio24').value;
      //  alert(q5);
    }
    if (document.getElementById('radio25').checked) {
        q5 = document.getElementById('radio25').value;
     //   alert(q5);
    }
    if (document.getElementById('radio26').checked) {
        q5 = document.getElementById('radio26').value;
      //  alert(q5);
    }
    if (document.getElementById('radio27').checked) {
        q5 = document.getElementById('radio27').value;
        alert(q5);
    }
    if (document.getElementById('radio28').checked) {
        q5 = document.getElementById('radio28').value;
     //   alert(q5);
    }
    if (document.getElementById('radio29').checked) {
        q6 = document.getElementById('radio29').value;
      //  alert(q6);
    }
    if (document.getElementById('radio30').checked) {
        q6 = document.getElementById('radio30').value;
       // alert(q6);
    }
    if (document.getElementById('radio31').checked) {
        q6 = document.getElementById('radio31').value;
       // alert(q6);
    }
    if (document.getElementById('radio32').checked) {
        q6 = document.getElementById('radio32').value;
       // alert(q6);
    }
    if (document.getElementById('radio33').checked) {
        q6 = document.getElementById('radio33').value;
       // alert(q6);
    }
    if (document.getElementById('radio34').checked) {
        q7 = document.getElementById('radio34').value;
       // alert(q7);
    }
    if (document.getElementById('radio35').checked) {
        q7 = document.getElementById('radio35').value;
      //  alert(q7);
    }
    if (document.getElementById('radio36').checked) {
        q7 = document.getElementById('radio36').value;
     //   alert(q7);
    }
    if (document.getElementById('radio37').checked) {
        q7 = document.getElementById('radio37').value;
     //   alert(q7);
    }
    if (document.getElementById('radio38').checked) {
        q7 = document.getElementById('radio38').value;
     //   alert(q7);
    }
    if (document.getElementById('radio39').checked) {
        q7 = document.getElementById('radio39').value;
     //   alert(q7);
    }
    if (document.getElementById('radio40').checked) {
        q8 = document.getElementById('radio40').value;
        alert(q8);
    }
    if (document.getElementById('radio41').checked) {
        q8 = document.getElementById('radio41').value;
      //  alert(q8);
    }
    if (document.getElementById('radio42').checked) {
        q8 = document.getElementById('radio42').value;
     //   alert(q8);
    }
    if (document.getElementById('radio43').checked) {
        q8 = document.getElementById('radio43').value;
    //    alert(q8);
    }
    window.location.href = "category.jsp?type=survey&q1=" + q1 + "&q2=" + q2 + "&q3=" + q3 + "&q4=" + q4 + "&q5=" + q5 + "&q6=" + q6 + "&q7=" + q7 + "&q8=" + q8;
}

