$(document).ready(function() {
    // 用户名是否被注册
    jQuery.validator.addMethod("isRegister", function(value, element) {
        var isRegi = false;
        if(''!=value){
            var user=new Object();
            user.username=value;
            console.log(user);
            //ajax
            $.ajax({
                //请求方式  同步 false  异步true
                async:false,
                //请求方式
                type : "POST",
                //请求地址
                url : path+"admin/user/isRegister",
                //数据，json字符串,
                //返回值的类型
                dataType: "json",
                data : user,
                //请求成功
                success : function(result) {
                    console.log("访问成功！！！");
                    console.log(result);
                    if(result.code==0){
                        isRegi = true;
                    }
                },
                //请求失败，包含具体的错误信息
                error : function(e){
                    console.log("访问失败！！！");
                    console.log(e.status);
                    console.log(e.responseText);
                }

            });
        }
        return this.optional(element)||isRegi;
    }, "该用户名称已经被注册。");

    // 手机号码验证
    jQuery.validator.addMethod("isPhone", function(value, element) {
        var length = value.length;
        return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/.test(value));
    }, "请正确填写您的手机号码。");

    // 电话号码验证
    jQuery.validator.addMethod("isTel", function(value, element) {
        var tel = /^(\d{3,4}-)?\d{7,8}$/g; // 区号－3、4位 号码－7、8位
        return this.optional(element) || (tel.test(value));
    }, "请正确填写您的电话号码。");
    // 匹配密码，以字母开头，长度在6-12之间，必须包含数字和特殊字符。
    jQuery.validator.addMethod("isPwd", function(value, element) {
        var str = value;
        if (str.length < 6 || str.length > 18)
            return false;
        if (!/^[a-zA-Z]/.test(str))
            return false;
        if (!/[0-9]/.test(str))
            return false;
        return this.optional(element) || /[^A-Za-z0-9]/.test(str);
    }, "以字母开头，长度在6-12之间，必须包含数字和特殊字符。");

    $("#form").validate({
        errorElement : 'span',
        errorClass : 'help-block',
        rules : {
            photo : {
                required : true
            },
            username : {
                required : true,
                isRegister : true
            },
            email : {
                required : true,
                email : true
            },
            password : {
                required : true,
                isPwd : true
            },
            password2 : {
                required : true,
                isPwd : true,
                equalTo : "#password"
            },
            phone : {
                required : true,
                isPhone : true
            },
            tel : {
                isTel : true
            },
            address : {
                minlength : 10
            },
            name :"required",
            money:"required",
            sex  :"required"
        },
        messages : {
            photo : {
                required : "请选择头像图片"
            },
            username : {
                required : "请输入用户名"
            },
            email : {
                required : "请输入Email地址",
                email : "请输入正确的email地址"
            },
            password : {
                required : "请输入密码",
                minlength : jQuery.format("密码不能小于{0}个字 符")
            },
            password2 : {
                required : "请输入确认密码",
                minlength : "确认密码不能小于5个字符",
                equalTo : "两次输入密码不一致不一致"
            },
            phone : {
                required : "请输入手机号码"
            },
            tel : {
                required : "请输入座机号码"
            },
            address : {
                required : "请输入家庭地址",
                minlength : jQuery.format("家庭地址不能少于{0}个字符")
            },
            name : "请输入姓名",
            money: "请输入账户金额",
            sex:"请输入性别"
        },
        //跟一个函数，可以自定义错误放到哪里。
        errorPlacement : function(error, element) {
            element.next().remove();
            element.after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
            element.closest('.c_right_css').append(error);
        },
        //可以给未通过验证的元素加效果、闪烁等。
        highlight : function(element) {
            $(element).closest('.c_right_css').addClass('has-error has-feedback');
        },
        success : function(label) {
            var el=label.closest('.c_div_css').find("input");
            el.next().remove();
            el.after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
            label.closest('.c_div_css').removeClass('has-error').addClass("has-feedback has-success");
            label.remove();
        },
        //成功后调用的资源
        submitHandler: function(form) {
            if($("#birthday").val()==null || $("#birthday").val()==''){
                alert("生日不能为空");
                return;
            }
            form.submit();
        }
    });

    //绑定日期插件
    $('#datetimepicker1').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });
    //系统初始化当前页面时   把日期初始化到今天
    var d = new Date();
    var year = d.getFullYear();
    var month = d.getMonth();
    var date = d.getDate();
    $('#birthday').val(year+'-'+zeroFill(month)+'-'+zeroFill(date));
});

/**
 * 补零的方法
 * @param num
 * @returns {string}
 */
function zeroFill(num) {
    if(num<10){
        return '0'+num;
    }else {
        return ''+num;
    }
}
