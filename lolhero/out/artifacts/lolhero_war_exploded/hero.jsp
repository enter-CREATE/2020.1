<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/24
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>英雄资料库</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        table{
            background-color: #d4d4d4;
        }
        td,th{
            text-align: center;
        }
        .header{
            height: 60px;
            background-color: #23527c;
        }
        .welcome{
            text-align: right;
            line-height: 60px;
            font-size: 18px;
            color: white;
            margin-right: 32px;
        }
        .welcome a:hover{
            color: crimson !important;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="header">
        <p class="welcome" style="float: left;margin-left: 42px">首页</p>
        <p class="welcome" style="float: left;margin-left: 42px">
            <a href="addhero.jsp" style="text-decoration: none;color: white">添加</a>
        </p>
        <p class="welcome">欢迎您：${user.nickname}</p>
    </div>

<table class="table table-striped">
    <tr>
        <th>英雄序号</th>
        <th>图片</th>
        <th>名称</th>
        <th>昵称</th>
        <th>攻击力</th>
        <th>上手难度</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${heroes}" var="hero">
    <tr>
        <td>${hero.id}</td>
        <td><img src="${hero.tinyImg}" alt="" width="48px"></td>
        <td>${hero.ukName}</td>
        <td>${hero.nickName}</td>
        <td>${hero.attackPower}</td>
        <td>${hero.handHard}</td>
        <td>
            <button class="btn btn-primary" onclick="updateHero(${hero.id})">修改</button>
            <button class="btn btn-primary" onclick="delHero(${hero.id})">删除</button>
        </td>
    </tr>
    </c:forEach>

    <script>

        function updateHero(id) {
            location.href = "/lolhero/hero?operator=selectbyid&id=" + id;
        }
        function delHero(id) {
            // confirm 弹出对话框，单继是否确定删除，如果点击了确定，即返回true
            if(confirm("确定要删除吗？")){
                // 返回true就执行删除操作
                location.href = "/lolhero/hero?operator=delete&id=" + id;
            }
        }
    </script>
</table>
</div>
</body>

</html>
