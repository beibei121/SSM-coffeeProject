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
<title>订单列表页</title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
<%--<script type="text/javascript" src="${path}/js/admin/orders.js"></script>--%>
</head>
<body>
     <div class="admin_center">
         <div class="col-md-10 right_mu">
             <div  class="show_c">
                 <div>
              <div class="option_div">
                 <form method="post" id="form" name="searchform"  class="form-horizontal" enctype="multipart/form-data" action="admin/orders/selectAllOrdersByPage">
                 <label class="label_css">联系电话：</label>
                 <div class="input-group nav_search">
                     <!--分页数据-->
                     <input type="hidden" name="nowPage" id="nowPage" value="${nowPage}">
                     <!--指令当前是搜索还是跳转-->
                     <input type="hidden" name="key" id="key" value="search">
                     <input type="text" id="phone" name="phone" value="${phone}" class="form-control" placeholder="请输入联系方式">
                 </div>
                 <label class="label_css">联系人：</label>
                 <div class="input-group nav_search">
                     <input type="text" id="linkman" name="linkman" value="${linkman}" class="form-control" placeholder="请输入联系人">
                 </div>
                 <label class="label_css">会员：</label>
                 <div class="input-group nav_search">
                     <input type="text" id="userName" name="userName" value="${userName}" class="form-control" placeholder="请输入会员">
                 </div>
                 <label class="label_css">状态：</label>
                 <div class="input-group nav_search">
                     <select name="status" class="form-control">
                         <option value="">-请选择订单状态-</option>
                         <option value="未付款" <c:if test="${status eq '未付款'}">selected</c:if> >未付款</option>
                         <option value="已付款" <c:if test="${status eq '已付款'}">selected</c:if> >已付款</option>
                         <option value="已发货" <c:if test="${status eq '已发货'}">selected</c:if> >已发货</option>
                         <option value="已收货" <c:if test="${status eq '已收货'}">selected</c:if> >已收货</option>
                         <option value="待评价" <c:if test="${status eq '待评价'}">selected</c:if> >待评价</option>
                         <option value="已完成" <c:if test="${status eq '已完成'}">selected</c:if> >已完成</option>
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
                     <button style="margin-left: 20px;" type="button" class="button1" title="导出所有数据" onclick="exportAllData()">
                         <span class="span_1"><span class="glyphicon glyphicon-download"></span> 导出所有数据</span>
                     </button>
                     <button type="button" class="button1" title="导出当前页数据" onclick="exportCurrData()">
                         <span class="span_1"><span class="glyphicon glyphicon-download"></span> 导出当前页数据</span>
                     </button>
                 </div>
           <div class="table-responsive table_div">
                 <table class="table text-center">
                   <thead>
                     <tr>
                         <th width="30%">地址</th>
                         <th>联系方式</th>
                         <th>联系人</th>
                         <th>状态</th>
                         <th>会员</th>
                         <th width="30%">操作</th>
                     </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${castPageUtil.currentDataList}" var="orders">
                     <tr>
                         <td>${orders.coffeeAddress.addressname}</td>
                         <td>${orders.coffeeAddress.phone}</td>
                         <td>${orders.coffeeAddress.linkman}</td>
                         <td>${orders.status}</td>
                         <td>${orders.coffeeUser.name}</td>
                         <td class="btn_list">
                             <c:if test="${orders.status eq '未付款'}">
                                 <a href="admin/orders/deleteUser?id=${orders.id}" onClick="return confirm('确定删除?');" class="button3 btn-warning"><span class="glyphicon glyphicon-trash"></span>取消订单</a>
                                 <a href="admin/orders/deleteUser?id=${orders.id}" onClick="return confirm('确定删除?');" class="button3 btn-info"><span class="glyphicon glyphicon-pencil"></span>编辑订单</a>
                             </c:if>
                             <c:if test="${orders.status eq '已付款'}">
                                 <a  href="admin/orders/toDeliver?id=${orders.id}" onClick="return confirm('确定发货吗?');" class="button3 btn-success"><span class="glyphicon glyphicon-plane"></span>发货</a>
                             </c:if>
                             <c:if test="${orders.status eq '已发货' || orders.status eq '已收货' || orders.status eq '待评价' ||orders.status eq '已完成'}">
                                 <a  href="admin/orders/detailOrders?id=${orders.id}"  class="button3 btn-danger"><span class="glyphicon glyphicon-chevron-right"></span>查看</a>
                             </c:if>
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

