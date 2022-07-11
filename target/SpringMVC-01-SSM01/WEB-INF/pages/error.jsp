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
<title>异常跳转页</title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
<script type="text/javascript" src="${path}/js/admin/coffeetype.js"></script>
</head>
<body>
     <div class="admin_center">
         <div class="col-md-10 right_mu" style="text-align: center;">
             <h3 style="text-align: center;font-size: 20px;">系统出现异常，请联系管理人员</h3>
             <img src="images/error.jpg" style="width: 300px;height: 300px;background-color: #F0F3F4;">
             <c:if test="${errorMsg eq null}">
                 <h4 style="text-align: center;font-size: 18px;color: red;">该功能尚未开通！！！</h4>
             </c:if>
             <c:if test="${errorMsg ne null}">
                 <h4 style="text-align: center;font-size: 18px;color: red;">${errorMsg}</h4>
             </c:if>
     </div>
   </div>
 </body>
</html>

