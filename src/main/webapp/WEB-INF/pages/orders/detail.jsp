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
<title>订单详情页面</title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" type="text/css" href="${path}/css/admin/admin_css.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/moment-with-locales.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript" src="${path}/js/jQuery.validate/jquery.validate.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
</head>
<body>
<div class="admin_center">
    <div class="col-md-10 right_mu">
        <div>
            <div>
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <h4 class="text-center page_tit">订单详细信息</h4>
                    <div class="c_div_css">
                        <span class="c_tit_css">地址：</span>
                        <div class="c_right_css">
                            <p>${orders.coffeeAddress.addressname}</p>
                        </div>
                    </div>
                    <div class="c_div_css">
                        <span class="c_tit_css">联系电话：</span>
                        <div class="c_right_css">
                            <p>${orders.coffeeAddress.phone}</p>
                        </div>
                    </div>
                    <div class="c_div_css">
                        <span class="c_tit_css">联系人：</span>
                        <div class="c_right_css">
                            <p>${orders.coffeeAddress.linkman}</p>
                        </div>
                    </div>
                    <div class="c_div_css">
                        <span class="c_tit_css">状态：</span>
                        <div class="c_right_css">
                            ${orders.status}
                        </div>
                    </div>
                    <div class="c_div_css">
                        <span class="c_tit_css">会员：</span>
                        <div class="c_right_css">
                            <p>${orders.coffeeUser.name}</p>
                        </div>
                    </div>
                    <div class="table-responsive table_div">
                        <table class="table text-center">
                            <thead>
                            <tr>
                                <th>咖啡</th>
                                <th>图片</th>
                                <th>数量</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${orders.ordersDetailList}" var="orderdetail">
                            <tr>
                                <td>${orderdetail.coffee.name}</td>
                                <td><img src="images/${orderdetail.coffee.picture}" style="width:100px;height:100px;"/></td>
                                <td>${orderdetail.num}</td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div class="text-center">
                        <button  onclick="javascript:history.back()"  class="button1" type="button"><span class="span_1">返&nbsp;&nbsp;回</span></button>
                    </div>
                </div>
                <div class="col-sm-3"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

