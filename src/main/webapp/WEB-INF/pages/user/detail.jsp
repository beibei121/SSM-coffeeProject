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
<title>修改会员页面</title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/moment-with-locales.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript" src="${path}/js/jQuery.validate/jquery.validate.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
</head>
<body>
     <div class="admin_center">
         <div class="col-md-10 right_mu">
             <div>
             <div>
             <div class="col-sm-3"></div>
             <div class="col-sm-6">
             <h3 class="text-center page_tit">会员详情</h3>
             <div class="c_div_css">
                 <span class="c_tit_css">用户头像：</span>
                 <div class="c_right_css">
                     <img style="width: 200px; margin-bottom: 10px;" src="images/${user.picture}" />
                 </div>
             </div>
             <div class="c_div_css" id="usernameDiv">
                 <span class="c_tit_css">用户名：</span>
                 <div class="c_right_css">
                     ${user.username}
                 </div>
             </div>

             <div class="c_div_css">
                 <span class="c_tit_css">真实姓名：</span>
                 <div class="c_right_css">
                     ${user.name}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">性别：</span>
                 <div class="c_right_css">
                     ${user.sex}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">生日：</span>
                 <div class="c_right_css">
                     ${user.birthday}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">地址：</span>
                 <div class="c_right_css">
                     ${user.address}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">邮箱：</span>
                 <div class="c_right_css">
                     ${user.email}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">联系方式：</span>
                 <div class="c_right_css">
                     ${user.phone}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">余额：</span>
                 <div class="c_right_css">
                     ${user.money}
                 </div>
             </div>
             <div class="text-center">
                 <button class="button1" onclick="javascript:history.back()"><span class="span_1">返&nbsp;&nbsp;回</span></button>
             </div>

        </div>
      <div class="col-sm-3"></div>
   </div>
  </div>
 </div>
</div>
</body>
</html>

