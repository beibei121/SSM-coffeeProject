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
<title>咨询详细信息页面</title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
<script type="text/javascript" src="${path}/js/admin/coffee.js"></script>
</head>
<body>
     <div class="admin_center">
         <div class="col-md-10 right_mu">
           <div>
             <div>
               <div class="col-sm-3"></div>
                 <div class="col-sm-6">
                 <h4 class="text-center page_tit">咨询详细信息</h4>
             <div class="c_div_css">
                 <span class="c_tit_css">咨询图片：</span>
                 <div class="c_right_css">
                     <img style="width: 200px; margin-bottom: 10px;" src="images/${coffeenews.picture}" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">咨询标题：</span>
                 <div class="c_right_css">
                     ${coffeenews.title}
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">咨询添加时间：</span>
                 <div class="c_right_css">
                    ${coffeenews.addtime}
                 </div>
            </div>
             <div class="c_div_css">
                <span class="c_tit_css">咨询内容：</span>
                 <div class="c_right_css">
                     ${coffeenews.content}
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

