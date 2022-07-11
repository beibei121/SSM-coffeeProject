function login() {
    var username = $("#username").val();
    var passowrd = $("#password").val();
    var admin = new Object();
    admin.username = username;
    admin.password = passowrd;
    console.log(admin);

    //使用ajax技术实现登陆
    $.ajax({
        url:path+"/adminLogin",
        data:admin,
        method:"post",
        dataType:"json",
        success:function (data) {
            console.log("访问成功了");
            console.log(data);
            if (data.code==0){
                //成功
                location.href = path + "admin/adminIndex"

            }else {
                //失败
                $("#errorMsg").text(data.msg );
            }
        },
        error:function (data) {
            console.log("访问失败了");
            console.log(data);
        }
        }
    )
}