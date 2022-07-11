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
</head>
<body>
     <div class="admin_center">
         <div class="col-md-2 left_mu">
             <div class="panel-group">
                 <div class="panel_css">
                   <div class="main_ul">

                      <ul class="nav navbar-nav">
                         <li class="dropdown">
                             <ul class="dropdown-menu">
                                     <li><a target="main" href="admin/user/selectAllUserByPage"><span class="glyphicon glyphicon-th"></span>会员管理<span class="right_i"> &gt;</span></a></li>
                                     <li><a target="main" href="admin/Coffee/selectAllCoffeeBypage"><span class="glyphicon glyphicon-th"></span>咖啡管理<span class="right_i"> &gt;</span></a></li>
                                     <li><a target="main" href="admin/Coffeetype/selectAllCoffeetypeByPage"><span class="glyphicon glyphicon-th"></span>咖啡类型管理<span class="right_i"> &gt;</span></a></li>
                                     <li><a target="main" href="admin/orders/selectAllOrdersByPage"><span class="glyphicon glyphicon-th"></span>订单管理<span class="right_i"> &gt;</span></a></li>
                                     <li><a target="main" href="admin/comments/selectAllCommentsByPage"><span class="glyphicon glyphicon-th"></span>评论管理<span class="right_i"> &gt;</span></a></li>
                                     <li><a target="main" href="admin/Taste/selectAllTasteByPage"><span class="glyphicon glyphicon-th"></span>口味管理<span class="right_i"> &gt;</span></a></li>
                                     <li><a target="main" href="admin/coffeenews/selectAllCoffeenewsByPage"><span class="glyphicon glyphicon-th"></span>咖啡资讯管理<span class="right_i"> &gt;</span></a></li>
                             </ul>
                          </li>
                        </ul>
                      </div>
                    </div>
                  </div>
                 </div>
               </div>
            </body>
          </html>

