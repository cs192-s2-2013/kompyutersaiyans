function Add(){
    $("#tblData tbody").append(
        "<tr>"+
        "<td><input type='text'/></td>"+
        "<td><input type='text'/></td>"+
        "<td><button class='btnSave'>Save</button><button class='btnDelete'>Delete</button></td>"+
        "</tr>");
     
        $(".btnSave").bind("click", Save);     
        $(".btnDelete").bind("click", Delete);
};

function Save(){
    var par = $(this).parent().parent(); //tr
    var tdName = par.children("td:nth-child(1)");
    var tdInfo = par.children("td:nth-child(2)");
    var tdButtons = par.children("td:nth-child(3)");
 
    tdName.html(tdName.children("input[type=text]").val());
    tdInfo.html(tdInfo.children("input[type=text]").val());
    tdButtons.html("<button class='btnEdit'>Edit</button><button class='btnDelete'>Delete</button>");
 
    $(".btnEdit").bind("click", Edit);
    $(".btnDelete").bind("click", Delete);
};

function Edit(){
    var par = $(this).parent().parent(); //tr
    var tdName = par.children("td:nth-child(1)");
    var tdInfo = par.children("td:nth-child(2)");
    var tdButtons = par.children("td:nth-child(3)");
 
    tdName.html("<input type='text' id='txtName' value='"+tdName.html()+"'/>");
    tdInfo.html("<input type='text' id='txtInfo' value='"+tdInfo.html()+"'/>");
    tdButtons.html("<button class='btnSave'>Save</button>");
 
    $(".btnSave").bind("click", Save);
    $(".btnEdit").bind("click", Edit);
    $(".btnDelete").bind("click", Delete);
};

function Delete(){
    var par = $(this).parent().parent(); //tr
    par.remove();
};

$(function(){
    //Add, Save, Edit and Delete functions code
    $(".btnEdit").bind("click", Edit);
    $(".btnDelete").bind("click", Delete);
    $("#btnAdd").bind("click", Add);
});