<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path",path);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>添加会员页面</title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/moment-with-locales.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript" src="${path}/js/jQuery.validate/jquery.validate.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
<script type="text/javascript" src="${path}/js/admin/userAdd.js"></script>
<script type="text/javascript" src="${path}/js/Calendar.js"></script>
</head>
<body>
     <div class="admin_center">
         <div class="col-md-10 right_mu">
             <div>
                 <div>
                 <div class="col-sm-3"></div>
                 <div class="col-sm-6">
                 <h3 class="text-center page_tit">新增会员</h3>
                 <form method="post" id="form" class="form-horizontal" enctype="multipart/form-data"
                       action="admin/user/addUser" <%--onsubmit="return validateAddForm();"--%>>
             <div class="c_div_css">
                 <span class="c_tit_css">用户头像：</span>
                 <div class="c_right_css">
                     <input type="file" id="photo" name="photo" required class="form-control" />
                 </div>
             </div>
             <div class="c_div_css" id="usernameDiv">
                 <span class="c_tit_css">用户名：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control"  name="username" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">密码：</span>
                 <div class="c_right_css">
                     <input type="password" class="form-control" required id="password" name="password" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">确认密码：</span>
                 <div class="c_right_css">
                     <input type="password" class="form-control" required id="password2" name="password2" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">真实姓名：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="name" id="name" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">性别：</span>
                 <div class="c_right_css">
                     <select name="sex" id="sex" required class="form-control">
                         <option value="">-请选择性别-</option>
                         <option value="男">男</option>
                         <option value="女">女</option>
                     </select>
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css" style="margin-top: 14px!important;">生日：</span>
                 <div class="c_right_css">
                     <div class="input-group date" id="datetimepicker1" style="position: absolute;z-index: 1000;">
                         <input name="birthday" class="form-control" type="text" id="birthday"/>
                         <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                         </span>
                     </div>
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">地址：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="address" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">邮箱：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="email" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">联系方式：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="phone" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">余额：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="money" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')" value="" />
                 </div>
             </div>
             <div class="text-center">
                 <button type="submit"  class="button1"><span class="span_1">添&nbsp;&nbsp;加</span></button>
                 <button type="reset" class="button1"><span class="span_1">重&nbsp;&nbsp;置</span></button>
             </div>
         </form>
        </div>
      <div class="col-sm-3"></div>
   </div>
  </div>
 </div>
</div>
</body>
</html>

