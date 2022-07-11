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
<title>咨询列表页</title>
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
             <div  class="show_c">
                 <div>
              <div class="option_div">
                 <form method="post" id="form" class="form-horizontal" enctype="multipart/form-data" action="admin/coffeenews/selectAllCoffeenewsByPage">
                 <!--分页数据-->
                 <input type="hidden" name="nowPage" id="nowPage" value="${nowPage}">
                 <!--指令当前是搜索还是跳转-->
                 <input type="hidden" name="key" id="key" value="search">
                 <label class="label_css">咨询标题：</label>
                 <div class="input-group nav_search">
                     <input type="text" name="title" id="title" value="${title}" class="form-control" placeholder="请输入咨询标题">
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
                 <a href="admin/coffeenews/toAddCoffeenews" class="button1"
                 style="margin-left: 20px;"
                 ><span class="span_1 "><span class="glyphicon glyphicon-plus"></span>添&nbsp;&nbsp;加</span></a>
                 </div>
           <div class="table-responsive table_div">
                 <table class="table text-center">
                   <thead>
                     <tr>
                         <th>咨询图片</th>
                         <th width="30%">咨询标题</th>
                         <th>发布时间</th>
                         <th width="30%">操作</th>
                     </tr>
            </thead>
           <tbody>
         <c:forEach items="${castPageUtil.currentDataList}" var="coffeenews">
         <tr>
         <td><img  src="images/${coffeenews.picture}" alt="咖啡图片" width="120" height="100"></td>
         <td>${coffeenews.title}</td>
         <td>${coffeenews.addtime}</td>
         <td class="btn_list">
             <a  href="admin/coffeenews/toUpdateCoffeenews?id=${coffeenews.id}" class="button3 btn-info"><span class="glyphicon glyphicon-pencil"></span>修改</a>
             <a href="javascript:del(${coffeenews.id})" onClick="return confirm('确定删除?');" class="button3 btn-warning"><span class="glyphicon glyphicon-trash"></span>删除</a>
             <a  href="admin/coffeenews/detailCoffeenews?id=${coffeenews.id}"  class="button3 btn-danger"><span class="glyphicon glyphicon-chevron-right"></span>查看</a>
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

