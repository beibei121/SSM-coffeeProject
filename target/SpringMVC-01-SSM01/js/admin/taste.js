function add() {
    var name=$("#name").val();
    var taste=new Object();
    taste.name=name;
    console.log(taste);
    //使用ajax技术去实现登录
    $.ajax({
        url:path+"admin/Taste/addCoffeeTaste",
        data:taste,
        method:"post",
        dataType:"json",
        success:function(data){
            console.log("咖啡口味添加成功了");
            console.log(data);
            if(data.code==0){
                //成功
                location.href=path+"admin/Taste/selectAllTasteByPage"
            }else{
                //失败
                $("#errorMsg").text(data.msg);
            }
        },
        error:function (data) {
            console.log("咖啡口味添加失败了");
            console.log(data);
        }
    });
}

function update(){
    var id=$("#tasteid").val();
    var name=$("#name").val();
    var taste=new Object();
    taste.id=id;
    taste.name=name;
    console.log(taste);
    //使用ajax技术去实现登录
    $.ajax({
        url:path+"admin/Taste/updateCoffeeTaste",
        data:taste,
        method:"post",
        dataType:"json",
        success:function(data){
            console.log("访问口味修改成功了");
            console.log(data);
            if(data.code==0){
                //成功
                location.href=path+"admin/Taste/selectAllTasteByPage"
            }else{
                //失败
                $("#errorMsg").text(data.msg);
            }
        },
        error:function (data) {
            console.log("访问口味修改失败了");
            console.log(data);
        }
    });
}

function del(id) {
    var taste=new Object();
    taste.id=id;
    console.log(taste);
    //使用ajax技术去实现登录
    $.ajax({
        url:path+"admin/Taste/deleteCoffeeTasteById",
        data:taste,
        method:"post",
        dataType:"json",
        success:function(data){
            console.log("访问口味删除成功了");
            console.log(data);
            if(data.code==0){
                //成功
                location.href=path+"admin/Taste/selectAllTasteByPage"
            }else{
                //失败
                alert(data.msg);
            }
        },
        error:function (data) {
            console.log("访问口味删除失败了");
            console.log(data);
        }
    });
}

//导出所有数据
function exportAllData(){
    location.href=path+"admin/Taste/exportAllData";
}

//导出当前页数据  exportCurrData
function exportCurrData(){
    var name=$("#name").val();
    var nowPage=$("#nowPage").val();
    console.log("导出当前页数据：name="+name+",nowPage="+nowPage);
    location.href=path+"admin/Taste/exportCurrData?nowPage="+nowPage+"&name="+name;
}
