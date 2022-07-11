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
<title>咖啡类型列表页</title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
<script type="text/javascript" src="${path}/js/admin/coffeetype.js"></script>
</head>
<body>
     <div class="admin_center">
         <div class="col-md-10 right_mu">
             <div  class="show_c">
                 <div>
              <div class="option_div">
                 <form method="post" name="searchform"  class="form-horizontal" enctype="multipart/form-data" id="form"
                       action="admin/Coffeetype/selectAllCoffeetypeByPage">
                 <label class="label_css">咖啡类型名称：</label>
                 <div class="input-group nav_search">
                     <!-- 分页数据 -->
                     <input type="hidden" id="nowPage" name="nowPage" value="${nowPage}">
                     <!--指定是跳转还是搜索-->
                     <input type="hidden" id="key" name="key" value="search">
                     <input type="text" id="name" name="name" value="${name}" class="form-control" placeholder="请输入咖啡类型名称">
                 </div>
                 <button type="submit" class="button1" title="搜索">
                     <span class="span_1"><span class="glyphicon glyphicon-search"></span> 搜索</span>
                 </button>

                 <button type="button" class="button1" title="导出所有数据" onclick="exportAllData()">
                     <span class="span_1"><span class="glyphicon glyphicon-download"></span>导出所有数据</span>
                 </button>

                 <button type="button" class="button1" title="导出当前页数据" onclick="exportCurrData()">
                     <span class="span_1"><span class="glyphicon glyphicon-download"></span>导出当前页数据</span>
                 </button>
             </form>
           </div>
         </div>
           <hr>
              <div class="main_css">
                 <div class="add_div">
                     <a href="/admin/Coffeetype/toAddCoffeetype" class="button1" style="margin-left: 20px;">
                         <span class="span_1 "><span class="glyphicon glyphicon-plus"></span>添&nbsp;&nbsp;加</span>
                     </a>
                 </div>
           <div class="table-responsive table_div">
                 <table class="table text-center">
                   <thead>
                     <tr>
                         <th>序号</th>
                         <th>咖啡类型名称</th>
                         <th width="30%">操作</th>
                     </tr>
                </thead>
           <tbody>
         <c:forEach items="${castPageUtil.currentDataList}" var="coffeetype">
         <tr>
                 <td>${coffeetype.id}</td>
                 <td>${coffeetype.name}</td>
                <td class="btn_list">
                     <a  href="admin/Coffeetype/toUpdateCoffeetype?id=${coffeetype.id}" class="button3 btn-info"><span class="glyphicon glyphicon-pencil"></span>修改</a>
                     <a href="javascript:del(${coffeetype.id})" onClick="return confirm('确定删除?');" class="button3 btn-warning"><span class="glyphicon glyphicon-trash"></span>删除</a>
                     <a  href="admin/Coffeetype/detailCoffee?coffeeid=${coffeetype.id}"  class="button3 btn-danger"><span class="glyphicon glyphicon-chevron-right"></span>查看</a>
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

