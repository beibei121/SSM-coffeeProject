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
<title>口味列表页</title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
<script type="text/javascript" src="${path}/js/admin/taste.js"></script>
</head>
<body>
     <div class="admin_center">
         <div class="col-md-10 right_mu">
             <div  class="show_c">
                 <div>
              <div class="option_div">
                 <form method="post" id="form" name="searchform"  class="form-horizontal" enctype="multipart/form-data"
                       action="admin/Taste/selectAllTasteByPage">
                 <label class="label_css">口味名称：</label>
                 <div class="input-group nav_search">
                     <!--分页数据-->
                     <input type="hidden" name="nowPage" id="nowPage" value="${nowPage}">
                     <!--指令当前是搜索还是跳转-->
                     <input type="hidden" name="key" id="key" value="search">
                     <input type="text" id="name" name="name" value="${name}" class="form-control" placeholder="请输入口味名称">
                 </div>
                 <button type="submit" class="button1" title="搜索">
                     <span class="span_1"><span class="glyphicon glyphicon-search"></span> 搜索</span>
                 </button>
                 <button type="button" class="button1" title="导出所有数据" onclick="exportAllData()">
                     <span class="span_1"><span class="glyphicon glyphicon-download"></span> 导出所有数据</span>
                 </button>
                 <button type="button" class="button1" title="导出当前页数据" onclick="exportCurrData()">
                     <span class="span_1"><span class="glyphicon glyphicon-download"></span> 导出当前页数据</span>
                 </button>
             </form>
           </div>
         </div>
           <hr>
              <div class="main_css">
                 <div class="add_div">
                     <a href="admin/Taste/toAddCoffeeTaste" class="button1"
                        style="margin-left: 20px;">
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
                    <c:forEach items="${castPageUtil.currentDataList}" var="coffeeTaste">
                     <tr>
                         <td>${coffeeTaste.id}</td>
                         <td>${coffeeTaste.name}</td>
                         <td class="btn_list">
                             <a  href="admin/Taste/toUpdateCoffeeTaste?id=${coffeeTaste.id}" class="button3 btn-info"><span class="glyphicon glyphicon-pencil"></span>修改</a>
                             <a href="javascript:del(${coffeeTaste.id})" onClick="return confirm('确定删除?');" class="button3 btn-warning"><span class="glyphicon glyphicon-trash"></span>删除</a>
                             <a  href="admin/Taste/detailCoffeeTaste?id=${coffeeTaste.id}"  class="button3 btn-danger"><span class="glyphicon glyphicon-chevron-right"></span>查看</a>
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

