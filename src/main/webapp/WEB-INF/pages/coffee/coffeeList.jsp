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
                 <form method="post" name="searchform"  class="form-horizontal" enctype="multipart/form-data" action="adminCoffee/selectAllCoffeeByPage">
                 <label class="label_css">咖啡名称：</label>
                 <div class="input-group nav_search">
                     <input type="text" name="coffeename" class="form-control" placeholder="请输入咖啡名称">
                 </div>
                 <label class="label_css">咖啡类型：</label>
                 <div class="input-group nav_search">
                     <select name="coffeetypeobj.coffeetypeid" class="form-control">
                         <option value="0">-请选择咖啡类型-</option>
                         <c:forEach items="${coffeetype}" var="coffeetype">
                             <option value="${coffeetype.coffeetypeid}">${coffeetype.coffeetypename}</option>
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
                 <a href="adminCoffee/toAddCoffee" class="button1"
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
         <c:forEach items="${allCoffeeList}" var="coffee">
         <tr>
         <td><img  src="${coffee.pic}" alt="咖啡图片" width="120" height="100"></td>
         <td>${coffee.coffeename}</td>
         <td>${coffee.coffeetypeobj.coffeetypename}</td>
         <td>${coffee.price}</td>
         <td>${coffee.num}</td>
         <td>${coffee.netweight}</td>
         <td>${coffee.qualitydate}</td>
         <td>${coffee.tasteobj.tastename}</td>
         <td>${coffee.brand}</td>
         <td>${coffee.storage}</td>
                    <td class="btn_list">
                         <a  href="adminCoffee/toUpdateCoffee?coffeeid=${coffee.coffeeid}" class="button3 btn-info"><span class="glyphicon glyphicon-pencil"></span>修改</a>
                         <a href="adminCoffee/deleteCoffee?coffeeid=${coffee.coffeeid}" onClick="return confirm('确定删除?');" class="button3 btn-warning"><span class="glyphicon glyphicon-trash"></span>删除</a>
                         <a  href="adminCoffee/detailCoffee?coffeeid=${coffee.coffeeid}"  class="button3 btn-danger"><span class="glyphicon glyphicon-chevron-right"></span>查看</a>
                    </td>
                   </tr>
                 </c:forEach>
                 <c:if test="${msg!=null&&msg!=''}">
                     <tr>
                         <td style="vertical-align: middle" colspan="11"><font color="red">${msg}</font></td>
                     </tr>
                 </c:if>
             </table>
          </div>
       </div>
             <div class="text-center">
                 <ul class="pagination">
                 <li <c:if test="${pageCur==1 }"> class="disabled"</c:if>>
                     <c:if test="${pageCur!=1 }">
                         <a href="adminCoffee/selectAllCoffeeByPage?pageCur=${pageCur-1}"><span>上一页</span></a>
                     </c:if> <c:if test="${pageCur==1 }">
                         <span>上一页</span>
                     </c:if></li>
                 <c:forEach var="i" begin="1" end="${totalPage}" step="1">
                     <c:if test="${pageCur==i }">
                         <li class="active"><span>${i}</span></li>
                     </c:if>
                     <c:if test="${pageCur!=i }">
                         <li><a href="adminCoffee/selectAllCoffeeByPage?pageCur=${i}">${i}</a></li>
                     </c:if>
                 </c:forEach>
                 <li <c:if test="${pageCur==totalPage }"> class="disabled"</c:if>>
                 <c:if test="${pageCur==totalPage }">
                     <span>下一页</span>
                 </li>
                 </c:if>
                 <c:if test="${pageCur!=totalPage }">
                     <a href="adminCoffee/selectAllCoffeeByPage?pageCur=${pageCur+1 }">下一页</a>
                     </li>
                 </c:if>
                 </ul>
             </div>
         </div>
     </div>
   </div>
 </body>
</html>

