<%--
  Created by IntelliJ IDEA.
  User: 13646
  Date: 2019/7/10
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>图书列表</title>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css">
    <script type="text/javascript" src="${path}/static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        function  del(e) {
            var bookId = $(e).parent().parent().children(":first").text();
            var rs = confirm("是否确定删除？");
            if (rs){
                $.ajax({
                    url:"${path}/book/"+bookId,
                    type:"post",
                    data:{
                        _method:"delete"
                    },
                    success:function (res) {
                        if (res.success) {
                            $(e).parent().parent().remove();
                        }else{
                            alert("删除失败！");
                        }
                    }
                });
                return false;
            }
        };
    </script>
</head>
<body class="container">
<h1>图书列表</h1>
<a class="btn btn-primary" href="${path}/book">添加</a>
<table class="table table-striped">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>作者</th>
        <th>价格</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.books}" var="book">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td>
                <a class="btn btn-primary" href="${path}/book/${book.bookId}">修改</a>
                <a class=" btn btn-danger" href="javascript:void (0)" onclick="del(this)">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
