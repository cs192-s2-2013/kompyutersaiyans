function Add(){
    $("#tblData tbody").append(
        "<tr>"+
        "<td><input type='text'/></td>"+
        "<td><input type='text'/></td>"+
        "<td colspan='2'><img src= <c:url value = '/resources/images/save.png'/> class='btnSave'><img src=src= <c:url value = '/resources/images/delete.png'/> class='btnDelete'/></td>"+
        "</tr>");
     
        $(".btnSave").bind("click", Save);     
        $(".btnDelete").bind("click", Delete);
};

function Save(){
    var par = $(this).parent().parent(); //tr
    var tdName = par.children("td:nth-child(1)");
    var tdInfo = par.children("td:nth-child(2)");
    var tdButtons = par.children("td:nth-child(4)");
 
    tdName.html(tdName.children("input[type=text]").val());
    tdPhone.html(tdPhone.children("input[type=text]").val());
    tdButtons.html("<img src=<c:url value = '/resources/images/delete.png'/> class='btnDelete'/><img src=<c:url value = '/resources/images/edit.png'/> class='btnEdit'/>");
 
    $(".btnEdit").bind("click", Edit);
    $(".btnDelete").bind("click", Delete);
};

