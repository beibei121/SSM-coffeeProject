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
<title>评论列表页</title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/moment-with-locales.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript" src="${path}/js/jQuery.validate/jquery.validate.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>

<script type="text/javascript" src="${path}/js/admin/commonts.js"></script>
</head>
<body>
     <div class="admin_center">
         <div class="col-md-10 right_mu">
             <div  class="show_c">
                 <div>
              <div class="option_div">
                 <form method="post" id="form" name="searchform"  class="form-horizontal" enctype="multipart/form-data"
                       action="admin/comments/selectAllCommentsByPage">
                 <label class="label_css">会员名称：</label>
                 <div class="input-group nav_search">
                     <!--分页数据-->
                     <input type="hidden" name="nowPage" id="nowPage" value="${nowPage}">
                     <!--指令当前是搜索还是跳转-->
                     <input type="hidden" name="key" id="key" value="search">
                     <input type="text" id="userName" name="userName" value="${userName}" class="form-control" placeholder="请输入会员名称">
                 </div>
                 <label class="label_css">咖啡名称：</label>
                 <div class="input-group nav_search">
                     <input type="text" id="coffeeName" name="coffeeName" value="${coffeeName}" class="form-control" placeholder="请输入咖啡名称">
                 </div>
                 <label class="label_css">评论内容：</label>
                 <div class="input-group nav_search">
                     <input type="text" id="content" name="content" value="${content}" class="form-control" placeholder="请输入评论内容">
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

                 <div style="width: 100%;height: 30px;margin-top: 20px;text-align: left!important;">

                     <div style="position: absolute;left: 20px;z-index: 1001;width:110px;padding-top: 5px;">评论日期：从</div>
                     <div class="input-group date" id="datetimepicker1" style="position: absolute;z-index: 1000;left: 110px;width:250px;">
                         <input name="startTime" style="width: 260px;height: 30px;" type="text" id="startTime" value="${startTime}"/>
                         <span class="input-group-addon" style="height: 25px;!important;">
                                <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                     </div>

                     <div style="position: absolute;left: 415px;z-index: 1001;width:110px;padding-top:5px;">到</div>
                     <div class="input-group date" id="datetimepicker2" style="position: absolute;z-index: 1000;left: 435px;width:250px;">
                         <input name="endsTime" style="width: 260px;height: 30px;" type="text" id="endsTime" value="${endsTime}"/>
                         <span class="input-group-addon" style="height: 25px;!important;">
                             <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                     </div>

                 </div>

             </form>
           </div>
         </div>
           <hr>
              <div class="main_css">
                 <div class="add_div">
                     <a href="admin/comments/toAddCoffeeComment" class="button1"
                        style="margin-left: 20px;">
                         <span class="span_1 "><span class="glyphicon glyphicon-plus"></span>添&nbsp;&nbsp;加</span>
                     </a>
                 </div>
           <div class="table-responsive table_div">
                 <table class="table text-center">
                   <thead>
                     <tr>
                         <th>会员</th>
                         <th>咖啡</th>
                         <th width="30%">评论内容</th>
                         <th>评论时间</th>
                         <th width="30%">操作</th>
                     </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${castPageUtil.currentDataList}" var="comments">
                     <tr>
                         <td>${comments.coffeeUser.name}</td>
                         <td>${comments.coffee.name}</td>
                         <td>${comments.content}</td>
                         <td>${comments.addtime}</td>
                         <td class="btn_list">
                             <a href="javascript:del(${comments.id})" onClick="return confirm('确定删除?');" class="button3 btn-warning"><span class="glyphicon glyphicon-trash"></span>删除</a>
                             <a  href="admin/comments/detailComments?id=${comments.id}"  class="button3 btn-danger"><span class="glyphicon glyphicon-chevron-right"></span>查看</a>
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

