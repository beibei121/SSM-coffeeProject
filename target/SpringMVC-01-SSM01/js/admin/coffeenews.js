function add(){
    //我们需要把form表单作为参数提交给ajax  ajax负责把数据传递给控制器
    //javascript原生的js对象
    var js_form = document.getElementById("form");
    //jquery对象 如何去获得原生js
    var jq_form_js = $("#form")[0];//[0]把前面的jquery对象转换成JavaScript对象
    var form = new FormData(jq_form_js);
    //使用ajax技术去实现登录
    $.ajax({
        url:path+"admin/coffeenews/addCoffeenews",
        data:form,
        method:"post",
        dataType:"json",
        contentType:false,
        cache:false,
        processData:false,//必须false才会避开jQuery对 formdata 的默认处理,原生XMLHttpRequest会对 formdata 进行正确的处理
        success:function(data){
            console.log("访问咖啡咨询添加成功了");
            console.log(data);
            if(data.code==0){
                //成功
                location.href=path+"admin/coffeenews/selectAllCoffeenewsByPage"
            }else{
                //失败
                $("#errorMsg").text(data.msg);
            }
        },
        error:function (data) {
            console.log("访问咖啡咨询添加失败了");
            console.log(data);
        }
    });
}

function update(){
//我们需要把form表单作为参数提交给ajax  ajax负责把数据传递给控制器
    //javascript原生的js对象
    var js_form = document.getElementById("form");
    //jquery对象 如何去获得原生js
    var jq_form_js = $("#form")[0];//[0]把前面的jquery对象转换成JavaScript对象
    var form = new FormData(js_form);
    //使用ajax技术去实现登录
    $.ajax({
        url:path+"admin/coffeenews/updateCoffeenews",
        data:form,
        method:"post",
        dataType:"json",
        contentType:false,
        cache:false,
        processData:false,//必须false才会避开jQuery对 formdata 的默认处理,原生XMLHttpRequest会对 formdata 进行正确的处理
        success:function(data){
            console.log("访问咖啡咨询修改成功了");
            console.log(data);
            if(data.code==0){
                //成功
                location.href=path+"admin/coffeenews/selectAllCoffeenewsByPage"
            }else{
                //失败
                $("#errorMsg").text(data.msg);
            }
        },
        error:function (data) {
            console.log("访问咖啡咨询修改失败了");
            console.log(data);
        }
    });
}

function del(id) {
    var data = new Object();
    data.id=id;
    console.log(data);
    //使用ajax技术去实现删除
    $.ajax({
        url:path+"admin/coffeenews/deleteCoffeenewsById",
        data:data,
        method:"post",
        dataType:"json",
        success:function(data){
            console.log("访问咖啡咨询逻辑删除成功了");
            console.log(data);
            if(data.code==0){
                //成功
                location.href=path+"admin/coffeenews/selectAllCoffeenewsByPage  "
            }else{
                //失败
                $("#errorMsg").text(data.msg);
            }
        },
        error:function (data) {
            console.log("访问咖啡咨询逻辑删除失败了");
            console.log(data);
        }
    });

}