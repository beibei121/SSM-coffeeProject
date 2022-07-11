<%--
  Created by IntelliJ IDEA.
  User: 86152
  Date: 2021/7/16
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>账户列表</h3>
<table border="1px" cellpadding="0" cellspacing="0" width="30%">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>money</td>
    </tr>
    <c:forEach items="${accountList}" var="a">
        <tr>
            <td>${a.id}</td>
            <td>${a.name}</td>
            <td>${a.money}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
