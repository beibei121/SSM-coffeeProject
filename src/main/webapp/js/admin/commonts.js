$(document).ready(function() {
    //绑定日期插件
    $('#datetimepicker1').datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        locale: moment.locale('zh-cn')
    });
    $('#datetimepicker2').datetimepicker({
        format: 'YYYY-MM-DD HH:mm:ss',
        locale: moment.locale('zh-cn')
    });
});

function del(id) {
    var comments=new Object();
    comments.id=id;
    console.log(comments);
    //使用ajax技术去实现登录
    $.ajax({
        url:path+"admin/comments/deleteCommentsById",
        data:comments,
        method:"post",
        dataType:"json",
        success:function(data){
            console.log("访问评论删除成功了");
            console.log(data);
            if(data.code==0){
                //成功
                location.href=path+"admin/comments/selectAllCommentsByPage"
            }else{
                //失败
                alert(data.msg);
            }
        },
        error:function (data) {
            console.log("访问评论删除失败了");
            console.log(data);
        }
    });
}
function add(id) {
    var comments=new Object();
    comments.id=id;
    console.log(comments);
    //使用ajax技术去实现登录
    $.ajax({
        url:path+"admin/comments/addComments",
        data:comments,
        method:"post",
        dataType:"json",
        success:function(data){
            console.log("访问评论添加成功了");
            console.log(data);
            if(data.code==0){
                //成功
                location.href=path+"admin/comments/selectAllCommentsByPage"
            }else{
                //失败
                alert(data.msg);
            }
        },
        error:function (data) {
            console.log("访问评论添加失败了");
            console.log(data);
        }
    });
}
