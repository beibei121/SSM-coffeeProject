<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path",path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_login.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
    <script type="text/javascript" src="${path}/js/admin/admin.js"></script>

</head>
<body>
     <div id="div1" class="container-fluid">
    <div id="div0">
        <h1>咖啡销售网站</h1>
    </div>
    <div class="main_div">
    <form class="form-horizontal" action="javascript:login()" modelAttribute="admin" method="POST" id="formaction">
        <div class="form-group">
            <label for="username" class="col-md-2 control-label col-md-offset-1">账&nbsp;&nbsp;号:</label>
            <div class="input-group col-sm-7">
                <input type="text" class="form-control bord_r" id="username" name="username" placeholder="请输入账号" required>
                <span class="glyphicon form-control-feedback" style="display: none;" aria-hidden="true"></span>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-md-2 control-label col-md-offset-1">密&nbsp;&nbsp;码:</label>
            <div class="col-md-7 input-group">
                <input type="password" class="form-control bord_r" id="password" name="password" placeholder="请输入密码" required>
            </div>
        </div>
         <div class="form-group">
             <div class="col-sm-12" style="text-align: center" id="errorMsg"></div>
         </div>
        <div class="btn_div">
            <div class="col-md-6">
                <button id="login" type="submit" class="btn btn-primary" style="width: 100%;">登&nbsp;&nbsp;录</button>
            </div>
            <div class="col-md-6">
                <button id="reset" type="reset" class="btn btn-primary" style="width: 100%;">重&nbsp;&nbsp;置</button>
            </div>
        </div>
    </form>
    </div>
</div>
   </body>
 </html>

