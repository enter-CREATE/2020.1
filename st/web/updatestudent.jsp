<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/17
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <style>
        form{
            width: 50%;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<div class="container">

    <form action="/st/studentcrud" method="post">
        <div class="form-group">
            <label for="name">姓名</label>
            <input type="text" class="form-control" name="name" value="${student.name}" id="name" placeholder="请输入姓名" readonly>
        </div>
        <div class="form-group">
            <label for="sex">性别</label>
            <input type="text" class="form-control" name="sex" value="${student.sex}" id="sex" placeholder="请输入性别">
        </div>

        <div class="form-group">
            <label for="id">学号</label>
            <input type="text" class="form-control" name="id" value="${student.id}" id="id" placeholder="请输入学号">
        </div>
        <div class="form-group">
            <label for="age">年龄</label>
            <input type="number" class="form-control" name="age" value="${student.age}" id="age" placeholder="请输入年龄">
        </div>
        <input type="hidden" name="operator" value="update">

        <button type="submit" class="btn btn-danger form-control">修改</button>
    </form>
<%--<form action="/st/updatestudent" method="post">--%>
<%--    <p>姓名: <input type="text" name="name"></p>--%>
<%--    <p>性别: <input type="text" name="sex"></p>--%>
<%--    <p>学号: <input type="text" name="id"></p>--%>
<%--    <p>年龄: <input type="number" name="age"></p>--%>
<%--    <p><input type="submit" value="修改"></p>--%>
<%--</form>--%>
</div>
</body>
</html>
