<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    //num  就是页数
    function jumpPage(num) {
        //数据传递给nowPage这个隐藏域
        document.getElementById("nowPage").value = num;
        //判断是否为跳转 跳转就给key的值赋值味 jump
        document.getElementById("key").value = "jump";
        //提交表单
        document.getElementById("form").submit();
    }
</script>

<div class="text-center">
    <ul class="pagination">
        <li <c:if test="${castPageUtil.nowPage==1 }"> class="disabled"</c:if>>
            <c:if test="${castPageUtil.nowPage!=1 }">
                <a href="javascript:jumpPage(${castPageUtil.homePage})"><span>首页</span></a>
            </c:if> <c:if test="${castPageUtil.nowPage==1 }">
            <span>首页</span>
        </c:if></li>
        <li <c:if test="${castPageUtil.nowPage==1 }"> class="disabled"</c:if>>
            <c:if test="${castPageUtil.nowPage!=1 }">
                <a href="javascript:jumpPage(${castPageUtil.upPage})"><span>上一页</span></a>
            </c:if> <c:if test="${castPageUtil.nowPage==1 }">
            <span>上一页</span>
        </c:if></li>
        <c:forEach var="i" begin="1" end="${castPageUtil.totalPage}" step="1">
            <c:if test="${castPageUtil.nowPage==i }">
                <li class="active"><span>${i}</span></li>
            </c:if>
            <c:if test="${castPageUtil.nowPage!=i }">
                <li><a href="javascript:jumpPage(${i})">${i}</a></li>
            </c:if>
        </c:forEach>
        <li <c:if test="${castPageUtil.nowPage==castPageUtil.totalPage }"> class="disabled"</c:if>>
            <c:if test="${castPageUtil.nowPage==castPageUtil.totalPage }">
            <span>下一页</span>
        </li>
        </c:if>
        <c:if test="${castPageUtil.nowPage!=castPageUtil.totalPage }">
            <a href="javascript:jumpPage(${castPageUtil.nextPage })">下一页</a>
            </li>
        </c:if>
    </ul>
</div>
</body>
</html>
