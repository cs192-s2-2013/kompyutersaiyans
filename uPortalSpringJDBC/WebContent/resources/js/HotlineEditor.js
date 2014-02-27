function Add(){
    $("#tblData tbody").append(
        "<tr>"+
        "<td><input type='text'/></td>"+
        "<td><input type='text'/></td>"+
        "<td><input type='text'/></td>"+
        "<td><button class='btnSave'>Save</button><button class='btnDelete'>Delete</button></td>"+
        "</tr>");
     
        $(".btnSave").bind("click", Save);     
        $(".btnDelete").bind("click", Delete);
};

function Save(){
    var par = $(this).parent().parent(); //tr
    var tdID = par.children("td:nth-child(1)");
    var tdName = par.children("td:nth-child(2)");
    var tdInfo = par.children("td:nth-child(3)");
    var tdButtons = par.children("td:nth-child(4)");
 
    //id = tdID.children("input[type=text]").val();
    //name = tdName.children("input[type=text]").val();
    //info = tInfo.children("input[type=text]").val();
    
    tdID.html(tdID.children("input[type=text]").val());
    tdName.html(tdName.children("input[type=text]").val());
    tdInfo.html(tdInfo.children("input[type=text]").val());
    tdButtons.html("<button class='btnEdit'>Edit</button><button class='btnDelete'>Delete</button>");
 
    $(".btnEdit").bind("click", Edit);
    $(".btnDelete").bind("click", Delete);

    //update database
    $.post("/updateHotline",{ id: "8", name: "hello", info: "12345*3245"});
    
    $.ajax({
    	  type: "POST",
    	  url: "/updateHotline",
    	  data: { id: "8", name: "hello", info: "12345*3245"},
    	  dataType: "text"
    	});
};

function Edit(){
    var par = $(this).parent().parent(); //tr
    var tdID = par.children("td:nth-child(1)");
    var tdName = par.children("td:nth-child(2)");
    var tdInfo = par.children("td:nth-child(3)");
    var tdButtons = par.children("td:nth-child(4)");

    tdID.html("<input type='text' id='txtID' value='"+tdID.html()+"'/>");
    tdName.html("<input type='text' id='txtName' value='"+tdName.html()+"'/>");
    tdInfo.html("<input type='text' id='txtInfo' value='"+tdInfo.html()+"'/>");
    tdButtons.html("<button class='btnSave'>Save</button>");
 
    $(".btnSave").bind("click", Save);
    $(".btnEdit").bind("click", Edit);
    $(".btnDelete").bind("click", Delete);
};

function Delete(){
    var par = $(this).parent().parent(); //tr
    var tdID = par.children("td:nth-child(1)");
    par.remove();
};

$(function(){
    //Add, Save, Edit and Delete functions code
    $(".btnEdit").bind("click", Edit);
    $(".btnDelete").bind("click", Delete);
    $("#btnAdd").bind("click", Add);
});