<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" isELIgnored="false"%>
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
<title>添加咖啡页面</title>
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
                 <h3 class="text-center page_tit">新增咖啡</h3>
                 <form method="post" modelAttribute="coffee" class="form-horizontal" enctype="multipart/form-data" action="adminCoffee/addCoffee">
             <div class="c_div_css">
                 <span class="c_tit_css">咖啡图片：</span>
                 <div class="c_right_css">
                     <input type="file" name="picImage" required class="form-control" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">咖啡名称：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="coffeename" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">咖啡类型：</span>
                 <div class="c_right_css">
                     <select name="coffeetypeobj.coffeetypeid" required class="form-control">
                         <option value="">-请选择咖啡类型-</option>
                         <c:forEach items="${coffeetype}" var="coffeetype">
                             <option value="${coffeetype.coffeetypeid}">${coffeetype.coffeetypename}</option>
                         </c:forEach>
                     </select>
                 </div>
            </div>
             <div class="c_div_css">
                 <span class="c_tit_css">价格：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="price" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">库存：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="num" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">净含量：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="netweight" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">保质期：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="qualitydate" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">口味：</span>
                 <div class="c_right_css">
                     <select name="tasteobj.tasteid" required class="form-control">
                         <option value="">-请选择口味-</option>
                         <c:forEach items="${taste}" var="taste">
                             <option value="${taste.tasteid}">${taste.tastename}</option>
                         </c:forEach>
                     </select>
                 </div>
            </div>
             <div class="c_div_css">
                 <span class="c_tit_css">品牌：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="brand" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">储藏方法：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="storage" value="" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">咖啡简介：</span>
                 <div class="c_right_css">
                     <textarea required name="detail" class="form-control"></textarea>
                 </div>
             </div>
             <div class="text-center">
                 <button type="submit" class="button1"><span class="span_1">添&nbsp;&nbsp;加</span></button>
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

