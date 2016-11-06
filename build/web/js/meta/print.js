function printDiv(data, title) {
    var mywindow = window.open('', title, '');
    mywindow.document.write('<html><head><title>' + title + '</title>');
    mywindow.document.write("<link href=\"/magellanpro/assets/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" />\n" +
            "        <style>\n" +
            "            .rate{text-align: right;}\n" +
            "\n" +
            "            .table-borderedbottom > thead > tr > th,\n" +
            "            .table-borderedbottom > tbody > tr > th,\n" +
            "            .table-borderedbottom > tfoot > tr > th,\n" +
            "            .table-borderedbottom > thead > tr > td,\n" +
            "            .table-borderedbottom > tbody > tr > td,\n" +
            "            .table-borderedbottom > tfoot > tr > td {\n" +
            "                border: 1px solid #dddddd;\n" +
            "                border-right-width:0px;\n" +
            "                border-left-width:0px;\n" +
            "            }\n" +
            "        </style>");
    mywindow.document.write('</head><body >');
    mywindow.document.write($(data).html());
    mywindow.document.write('</body></html>');

    mywindow.document.close(); // necessary for IE >= 10
    mywindow.focus(); // necessary for IE >= 10

    mywindow.print();
    mywindow.close();

    return true;
}