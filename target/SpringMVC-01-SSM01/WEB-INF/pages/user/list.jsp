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
<title>用户列表页</title>
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
                 <form method="post" id="form" name="searchform"  class="form-horizontal" enctype="multipart/form-data"
                       action="admin/user/selectAllUserByPage">
                 <label class="label_css">用户名称：</label>
                 <div class="input-group nav_search">
                     <!--分页数据-->
                     <input type="hidden" name="nowPage" id="nowPage" value="${nowPage}">
                     <!--指令当前是搜索还是跳转-->
                     <input type="hidden" name="key" id="key" value="search">
                     <input type="text" id="username" name="username" value="${username}" class="form-control" placeholder="请输入用户名称">
                 </div>
                 <label class="label_css">性别类型：</label>
                 <div class="input-group nav_search">
                     <select name="sex" class="form-control">
                         <option value="">-请选择性别类型-</option>
                         <option value="男" <c:if test="${sex eq '男'}">selected</c:if> >男</option>
                         <option value="女" <c:if test="${sex eq '女'}">selected</c:if>>女</option>
                     </select>
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
                     <a href="admin/user/toAddUser" class="button1"
                        style="margin-left: 20px;">
                         <span class="span_1 "><span class="glyphicon glyphicon-plus"></span>添&nbsp;&nbsp;加</span>
                     </a>
                 </div>
           <div class="table-responsive table_div">
                 <table class="table text-center">
                   <thead>
                     <tr>
                         <th>序号</th>
                         <th>用户名</th>
                         <th>姓名</th>
                         <th>性别</th>
                         <th>联系方式</th>
                         <th>邮箱</th>
                         <th>生日</th>
                         <th>余额</th>
                         <th width="30%">操作</th>
                     </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${castPageUtil.currentDataList}" var="user">
                     <tr>
                         <td>${user.id}</td>
                         <td>${user.username}</td>
                         <td>${user.name}</td>
                         <td>${user.sex}</td>
                         <td>${user.phone}</td>
                         <td>${user.email}</td>
                         <td>${user.birthday}</td>
                         <td>${user.money}</td>
                         <td class="btn_list">
                             <a  href="admin/user/toUpdateUser?id=${user.id}" class="button3 btn-info"><span class="glyphicon glyphicon-pencil"></span>修改</a>
                             <a href="admin/user/deleteUser?id=${user.id}" onClick="return confirm('确定删除?');" class="button3 btn-warning"><span class="glyphicon glyphicon-trash"></span>删除</a>
                             <a  href="admin/user/detailUser?id=${user.id}"  class="button3 btn-danger"><span class="glyphicon glyphicon-chevron-right"></span>查看</a>
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

