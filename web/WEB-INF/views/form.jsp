<%--
  Created by IntelliJ IDEA.
  User: 13646
  Date: 2019/7/10
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <c:if test="${requestScope.book==null}">
        <title>添加图书</title>
    </c:if>
    <c:if test="${requestScope.book != null}">
        <title>修改图书</title>
    </c:if>
    <link rel="stylesheet" href="${path}/static/css/bootstrap.min.css"/>
    <script type="text/javascript" src="${path}/static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("input:submit").click(function () {
                var data = $("form").serialize();
                $.ajax({
                    url:"${path}/book",
                    type:"post",
                    data:data,
                    success:function (res) {
                        if (res.success){
                            location = "${path}/books";
                        } else{
                            alert("失败");
                        }
                    }
                });
                return false;
            });
        });
    </script>
</head>
<body class="container">
<c:if test="${requestScope.book==null}">
    <h1>添加图书</h1>
</c:if>
<c:if test="${requestScope.book != null}">
    <h1>修改图书</h1>
</c:if>

<form role="form" action="#" method="post">
    <c:if test="${requestScope.book != null}">
        <%--        requst.getAtrribute("book.bookId")--%>
        <input type="hidden" name="bookId" value="${requestScope.book.bookId}">
        <input type="hidden" name="_method" value="put">
    </c:if>
    <div class="form-group">
        <label for="name">名称</label>
        <input value="${requestScope.book.name}" type="text" class="form-control" name="name" id="name"
               placeholder="请输入名称">
    </div>
    <div class="form-group">
        <label for="author">作者</label>
        <input value="${requestScope.book.author}" type="text" class="form-control" name="author"
               id="author"
               placeholder="请输入作者">
    </div>
    <div class="form-group">
        <label for="price">价格</label>
        <input value="${requestScope.book.price}" type="text" class="form-control" name="price" id="price"
               placeholder="请输入价格">
    </div>
    <input class="btn btn-primary" type="submit" value="提交">
</form>
</body>
</html>
