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
<title>修改咖啡页面</title>
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
                 <h4 class="text-center page_tit">修改咖啡</h4>
                 <form method="post" class="form-horizontal" enctype="multipart/form-data"
                       action="admin/Coffee/updateCoffee">
              <input type="hidden"  name="id" value="${coffee.id}"/>
              <input type="hidden"  name="picture" value="${coffee.picture}"/>
                     <div class="c_div_css">
                 <span class="c_tit_css">咖啡图片：</span>
                 <div class="c_right_css">
                     <img style="width: 200px; margin-bottom: 10px;" src="images/${coffee.picture}" />
                     <input type="file" name="picImage"  class="form-control" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">咖啡名称：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="name" value="${coffee.name}" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">咖啡类型：</span>
                 <div class="c_right_css">
                     <select name="coffeetypeId" required class="form-control">
                         <option value="">-请选择咖啡类型-</option>
                         <c:forEach items="${coffeetypeList}" var="coffeetype">
                           <option  <c:if test="${coffee.coffeetype.id==coffeetype.id}">selected='selected'</c:if>  value="${coffeetype.id}">${coffeetype.name}</option>
                         </c:forEach>
                     </select>
                 </div>
            </div>
             <div class="c_div_css">
                <span class="c_tit_css">价格：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="price" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')" value="${coffee.price}" />
                 </div>
             </div>
             <div class="c_div_css">
                <span class="c_tit_css">库存：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="num" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')" value="${coffee.num}" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">净含量：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="netweight" value="${coffee.netweight}" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">保质期：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="qualitydate" value="${coffee.qualitydate}" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">口味：</span>
                 <div class="c_right_css">
                     <select name="tasteId" required class="form-control">
                         <option value="">-请选择口味-</option>
                         <c:forEach items="${coffeeTasteList}" var="taste">
                           <option  <c:if test="${coffee.coffeeTaste.id==taste.id}">selected='selected'</c:if>  value="${taste.id}">${taste.name}</option>
                         </c:forEach>
                     </select>
                 </div>
            </div>
             <div class="c_div_css">
                 <span class="c_tit_css">品牌：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="brand" value="${coffee.brand}" />
                 </div>
             </div>
             <div class="c_div_css">
                 <span class="c_tit_css">储藏方法：</span>
                 <div class="c_right_css">
                     <input type="text" class="form-control" required name="storage" value="${coffee.storage}" />
                 </div>
             </div>
             <div class="c_div_css">
                 <label class="c_tit_css">咖啡简介：</label>
                 <div class="c_right_css">
                     <textarea required name="detail" class="form-control" >${coffee.detail}</textarea>
                 </div>
             </div>
             <div class="text-center">
                 <button type="submit" class="button1"><span class="span_1">修&nbsp;&nbsp;改</span></button>
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

