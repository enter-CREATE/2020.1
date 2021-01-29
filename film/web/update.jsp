<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/11/3
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新电影信息</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        form{
            width: 50%;
            margin: 0 auto;
        }
        body{
            background-image: url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1604425047852&di=3d1a4ee61bd67500ba07da03e126d2ca&imgtype=0&src=http%3A%2F%2Fbpic.588ku.com%2Fback_pic%2F03%2F65%2F76%2F6457aee3f438015.jpg");
            background-size: 100%,100%;
        }
        label{
            color:blue;
            font-size: 17px;
            line-height: 20px;
        }
    </style>
</head>
<body>
<div class="container">

    <h1 style="text-align: center;margin-bottom: 36px;color: #ec971f">修改电影信息</h1>

    <form action="/filminfo/film?operator=update" class="form-horizontal" method="post">

        <div class="form-group">
            <label for="id" class="col-sm-2 control-label">编号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="${film.id}" name="code" id="id" readonly>
            </div>
        </div>

        <div class="form-group">
            <label for="ukname" class="col-sm-2 control-label">电影名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="${film.ukName}" name="ukname" id="ukname" placeholder="请输入电影名称">
            </div>
        </div>
        <div class="form-group">
            <label for="nickname" class="col-sm-2 control-label">风格</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="${film.nickName}" name="nickname" id="nickname" placeholder="请输入风格">
            </div>
        </div>

        <div class="form-group">
            <label for="img" class="col-sm-2 control-label">图片地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="${film.tinyImg}" name="tinyimg" id="img" placeholder="请输入图片地址">
            </div>
        </div>

        <div class="form-group">
            <label for="ak" class="col-sm-2 control-label">评价人数</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" value="${film.attackPower}" name="attackpower" id="ak" placeholder="请输入评价人数">
            </div>
        </div>

        <div class="form-group">
            <label for="hh" class="col-sm-2 control-label">评分</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" value="${film.handHard}" max="10" name="handhard" id="hh" placeholder="请输入评分">
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">修改</button>
            </div>
        </div>
    </form>
</div>


</body>
</html>
