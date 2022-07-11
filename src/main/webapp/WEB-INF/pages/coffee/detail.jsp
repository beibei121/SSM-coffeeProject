<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" isELIgnored="false" %>
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
<title>咖啡详细页面</title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
</head>
<body>
     <div class="admin_center">
       <div class="col-md-10 right_mu">
         <div>
           <div>
            <div class="col-sm-3"></div>
             <div class="col-sm-6">
                 <h4 class="text-center page_tit">咖啡详细信息</h4>
             <div class="c_div_css">
                 <span class="c_tit_css">咖啡图片：</span>
                 <div class="c_right_css">
                     <img style="width: 100px;height: 100px;margin-bottom: 10px;" src="images/${coffee.picture}" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">咖啡名称：</span>
                 <div class="c_right_css">
                     ${coffee.name}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">咖啡类型：</span>
                 <div class="c_right_css">
               <p>${coffee.coffeetype.name}</p>
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">价格：</span>
                 <div class="c_right_css">
                     ${coffee.price}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">库存：</span>
                 <div class="c_right_css">
                     ${coffee.num}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">净含量：</span>
                 <div class="c_right_css">
                     ${coffee.netweight}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">保质期：</span>
                 <div class="c_right_css">
                     ${coffee.qualitydate}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">口味：</span>
                 <div class="c_right_css">
               <p>${coffee.coffeeTaste.name}</p>
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">品牌：</span>
                 <div class="c_right_css">
                     ${coffee.brand}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">储藏方法：</span>
                 <div class="c_right_css">
                     ${coffee.storage}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">咖啡简介：</span>
                 <div class="c_right_css text_area">
                     ${coffee.detail}
                 </div>
             </div>
             <div class="text-center">
                     <button  onclick="javascript:history.back()"  class="button1" type="button"><span class="span_1">返&nbsp;&nbsp;回</span></button>
             </div>
            </div>
            <div class="col-sm-3"></div>
        </div>
      </div>
   </div>
   </div>
</body>
</html>

