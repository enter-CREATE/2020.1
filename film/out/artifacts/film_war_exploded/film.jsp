<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/11/3
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>电影信息库</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        table {
            background-color: #d4d4d4;
        }

        td, th {
            text-align: center;
        }

        .header {
            height: 60px;
            background-color: #23527c;
        }

        .welcome {
            text-align: right;
            line-height: 60px;
            font-size: 18px;
            color: white;
            margin-right: 32px;
        }

        .welcome a:hover {
            color: crimson !important;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <p class="welcome" style="float: left;margin-left: 42px">首页</p>
        <p class="welcome" style="float: left;margin-left: 42px">
            <a href="addfilm.jsp" style="text-decoration: none;color: white">添加</a>
        </p>
        <p class="welcome">欢迎您：${user.nickname}</p>
    </div>

    <table class="table table-striped">
        <tr>
            <th>电影序号</th>
            <th>图片</th>
            <th>电影名</th>
            <th>风格</th>
            <th>评价人数</th>
            <th>评分</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${films}" var="film">
            <tr>
                <td>${film.id}</td>
                <td><img src="${film.tinyImg}" alt="" width="48px"></td>
                <td>${film.ukName}</td>
                <td>${film.nickName}</td>
                <td>${film.attackPower}</td>
                <td>${film.handHard}</td>
                <td>
                    <button class="btn btn-primary" onclick="updateHero(${film.id})">修改</button>
                    <button class="btn btn-primary" onclick="delHero(${film.id})">删除</button>
                </td>
            </tr>
        </c:forEach>

        <script>

            function updateHero(id) {
                location.href = "/filminfo/film?operator=selectbyid&id=" + id;
            }

            function delHero(id) {
                // confirm 弹出对话框，单继是否确定删除，如果点击了确定，即返回true
                if (confirm("确定要删除吗？")) {
                    // 返回true就执行删除操作
                    location.href = "/filminfo/film?operator=delete&id=" + id;
                }
            }
        </script>
    </table>
</div>


</body>
</html>
