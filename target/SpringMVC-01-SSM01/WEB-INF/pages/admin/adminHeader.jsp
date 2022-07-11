<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("path",path);
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
<style>
    .aa:hover {
        background-color: #435764!important;
    }
</style>
</head>
<body>
 <div class="admin_header">
     <div class="col-sm-12 top_nav">
         <nav class="navbar" role="navigation">
             <div class="container-fluid">
                 <div class="navbar-header">
                     <a class="navbar-brand admin_logo" href="javascript:void(0);">
                        &nbsp;咖啡销售网站
                     </a>
                 </div>
                 <div class="top_a">
                     <ul class="nav navbar-nav navbar-right">
                         <li><a href="javascript:void(0);" class="aa">管理员</a></li>
                         <li role="separator" class="divider"></li>
                         <li><a href="admin/exit" target="_parent" class="aa">退出登录</a></li>
                     </ul>
                 </div>
               </div>
            </nav>
         </div>
       </div>
   </body>
</html>

