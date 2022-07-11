<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
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
<title></title>
<link rel="stylesheet" type="text/css" href="${path}/css/bootstrapt/css/bootstrap.css" />
<script type="text/javascript" src="${path}/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${path}/css/bootstrapt/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/js/comm.js"></script>
<style>
a:hover {
	text-decoration: none;
}
</style>
</head>
<FRAMESET border=0 frameSpacing=0 rows="76, *" frameBorder=0>
	<FRAME name=header src="${path}/admin/adminHeader" frameBorder=0 noResize
		scrolling=no>
	<FRAMESET cols="12%, *">
		<FRAME name=menu src="${path}/admin/adminMenu" frameBorder=0 noResize>
		<FRAME name=main src="${path}/admin/adminMain" frameBorder=0 noResize
			scrolling=yes>
	</FRAMESET>
</FRAMESET>
</html>
