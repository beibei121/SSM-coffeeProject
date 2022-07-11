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
<title>添加咨询页面</title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
    <script type="text/javascript" src="${path}/js/admin/coffeenews.js"></script>
</head>
<body>
     <div class="admin_center">
         <div class="col-md-10 right_mu">
             <div>
                 <div>
                 <div class="col-sm-3"></div>
                 <div class="col-sm-6">
                 <h3 class="text-center page_tit">新增咖啡咨询</h3>
                 <form method="post" id="form" class="form-horizontal" enctype="multipart/form-data"
                       action="javascript:add()">
             <div class="c_div_css">
                 <span class="c_tit_css">咨询图片：</span>
                 <div class="c_right_css">
                     <input type="file" name="photo" id="photo" required class="form-control"/>
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">咨询标题：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="title" value="" />
                 </div>
             </div>

             <div class="c_div_css">
                 <span class="c_tit_css">咨询内容：</span>
                 <div class="c_right_css">
                     <textarea required name="content" class="form-control"></textarea>
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

