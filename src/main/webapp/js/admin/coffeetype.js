function add() {
    var name = $("#name").val();
    var coffeetype = new Object();
    coffeetype.name = name;
    console.log(coffeetype);

    //使用ajax技术实现登陆
    $.ajax({
            url:path+"admin/Coffeetype/addCoffeetype",
            data:coffeetype,
            method:"post",
            dataType:"json",
            success:function (data) {
                console.log("访问咖啡类型添加成功了");
                console.log(data);
                if (data.code==0){
                    //成功
                    location.href = path + "admin/Coffeetype/selectAllCoffeetypeByPage"

                }else {
                    //失败
                    $("#errorMsg").text(data.msg );
                }
            },
            error:function (data) {
                console.log("访问咖啡类型添加失败了");
                console.log(data);
            }
        }
    );
}

function update() {
    var name = $("#name").val();
    var id = $("#coffeetypeid").val();
    var coffeetype = new Object();
    coffeetype.name = name;
    coffeetype.id = id;
    console.log(coffeetype);

    //使用ajax技术实现登陆
    $.ajax({
            url:path+"admin/Coffeetype/updateCoffeetype",
            data:coffeetype,
            method:"post",
            dataType:"json",
            success:function (data) {
                console.log("访问咖啡类型修改成功了");
                console.log(data);
                if (data.code==0){
                    //成功
                    location.href = path + "admin/Coffeetype/selectAllCoffeetypeByPage"

                }else {
                    //失败
                    $("#errorMsg").text(data.msg );
                }
            },
            error:function (data) {
                console.log("访问咖啡类型修改失败了");
                console.log(data);
            }
        }
    );
}

function del(id) {
    var coffeetype = new Object();
    coffeetype.id = id;
    console.log(coffeetype);

    //使用ajax技术实现登陆
    $.ajax({
            url:path+"admin/Coffeetype/deleteCoffeetypeById",
            data:coffeetype,
            method:"post",
            dataType:"json",
            success:function (data) {
                console.log("访问咖啡类型删除成功了");
                console.log(data);
                if (data.code==0){
                    //成功
                    location.href = path + "admin/Coffeetype/selectAllCoffeetypeByPage"

                }else {
                    //失败
                    alert(data.msg);
                }
            },
            error:function (data) {
                console.log("访问咖啡类型删除失败了");
                console.log(data);
            }
        }
    );
}

//导出所有数据
function exportAllData() {
    location.href = path+"admin/Coffeetype/exportAllData";
}

//导出当前页数据
function exportCurrData() {
    var name =$("#name").val();
    var nowPage = $("#nowPage").val();
    console.log("导出当前页数据：name = "+name+", nowPage = "+nowPage);
    location.href=path+"admin/Coffeetype/exportCurrData?nowPage="+nowPage+"&name="+name;
}
