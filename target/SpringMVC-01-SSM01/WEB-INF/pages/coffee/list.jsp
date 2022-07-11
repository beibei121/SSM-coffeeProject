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
<title>咖啡列表页</title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
</head>
<body>
     <div class="admin_center">
         <div class="col-md-10 right_mu">
             <div  class="show_c">
                 <div>
              <div class="option_div">
                 <form method="post" id="form" class="form-horizontal" enctype="multipart/form-data"
                       action="admin/Coffee/selectAllCoffeeBypage">
                 <!-- 分页数据 -->
                 <input type="hidden" id="nowPage" name="nowPage" value="${nowPage}">
                 <!--指定是跳转还是搜索-->
                 <input type="hidden" id="key" name="key" value="search">

                 <label class="label_css">咖啡名称：</label>
                 <div class="input-group nav_search">
                     <input type="text" name="name" id="name" value="${name}" class="form-control" placeholder="请输入咖啡名称">
                 </div>
                 <label class="label_css">咖啡类型：</label>
                 <div class="input-group nav_search">
                     <select name="coffeetypeId" class="form-control">
                         <option value="">-请选择咖啡类型-</option>
                         <c:forEach items="${coffeetypeList}" var="coffeetype">
                             <c:if test="${coffeetype.id eq coffeetypeId}">
                                 <option value="${coffeetype.id}" selected>${coffeetype.name}</option>
                             </c:if>
                             <c:if test="${coffeetype.id ne coffeetypeId}">
                                 <option value="${coffeetype.id}">${coffeetype.name}</option>
                             </c:if>
                         </c:forEach>
                     </select>
                 </div>
                 <label class="label_css">咖啡口味名称：</label>
                 <div class="input-group nav_search">
                     <select name="tasteId" class="form-control">
                         <option value="">-请选择咖啡口味类型-</option>
                         <c:forEach items="${coffeeTasteList}" var="coffeeTaste">
                             <c:if test="${coffeeTaste.id eq coffeetypeId}">
                                 <option value="${coffeeTaste.id}" selected>${coffeeTaste.name}</option>
                             </c:if>
                             <c:if test="${coffeeTaste.id ne coffeetypeId}">
                                 <option value="${coffeeTaste.id}">${coffeeTaste.name}</option>
                             </c:if>
                         </c:forEach>
                     </select>
                 </div>
                 <button type="submit" class="button1" title="搜索">
                     <span class="span_1"><span class="glyphicon glyphicon-search"></span> 搜索</span>
                 </button>
             </form>
           </div>
         </div>
           <hr>
              <div class="main_css">
                 <div class="add_div">
                 <a href="admin/Coffee/toAddCoffee" class="button1"
                 style="margin-left: 20px;"
                 ><span class="span_1 "><span class="glyphicon glyphicon-plus"></span>添&nbsp;&nbsp;加</span></a>
                 </div>
           <div class="table-responsive table_div">
                 <table class="table text-center">
                   <thead>
                     <tr>
                 <th>咖啡图片</th>
                 <th>咖啡名称</th>
                 <th>咖啡类型</th>
                 <th>价格</th>
                 <th>库存</th>
                 <th>净含量</th>
                 <th>保质期</th>
                 <th>口味</th>
                 <th>品牌</th>
                 <th>储藏方法</th>
                 <th width="30%">操作</th>
             </tr>
            </thead>
           <tbody>
         <c:forEach items="${castPageUtil.currentDataList}" var="coffee">
         <tr>
         <td><img  src="images/${coffee.picture}" alt="咖啡图片" width="120" height="100"></td>
         <td>${coffee.name}</td>
         <td>${coffee.coffeetype.name}</td>
<%--         <td>${coffee.coffeetypeName}</td>--%>
         <td>${coffee.price}</td>
         <td>${coffee.num}</td>
         <td>${coffee.netweight}</td>
         <td>${coffee.qualitydate}</td>
         <td>${coffee.coffeeTaste.name}</td>
<%--         <td>${coffee.tasteName}</td>--%>
         <td>${coffee.brand}</td>
         <td>${coffee.storage}</td>
                    <td class="btn_list">
                         <a  href="admin/Coffee/toUpdateCoffee?id=${coffee.id}" class="button3 btn-info"><span class="glyphicon glyphicon-pencil"></span>修改</a>
                         <a href="admin/Coffee/deleteCoffee?id=${coffee.id}" onClick="return confirm('确定删除?');" class="button3 btn-warning"><span class="glyphicon glyphicon-trash"></span>删除</a>
                         <a  href="admin/Coffee/detailCoffee?id=${coffee.id}"  class="button3 btn-danger"><span class="glyphicon glyphicon-chevron-right"></span>查看</a>
                    </td>
                   </tr>
                 </c:forEach>
           </tbody>
             </table>
          </div>
       </div>
            <%@include file="../admin/castpage.jsp"%>
         </div>
     </div>
   </div>
 </body>
</html>

