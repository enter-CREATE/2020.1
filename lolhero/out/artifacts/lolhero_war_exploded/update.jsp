<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/31
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新英雄信息</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        form{
            width: 50%;
            margin: 0 auto;
        }
        body{
            background-image: url("http://img1.gtimg.com/gamezone/pics/hv1/117/191/2156/140242722.jpg");
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

    <h1 style="text-align: center;margin-bottom: 36px;color: #ec971f">修改英雄</h1>

    <form action="/lolhero/hero?operator=update" class="form-horizontal" method="post">

        <div class="form-group">
            <label for="id" class="col-sm-2 control-label">编号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="${hero.id}" name="code" id="id" readonly>
            </div>
        </div>

        <div class="form-group">
            <label for="ukname" class="col-sm-2 control-label">名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="${hero.ukName}" name="ukname" id="ukname" placeholder="请输入英雄名称">
            </div>
        </div>
        <div class="form-group">
            <label for="nickname" class="col-sm-2 control-label">昵称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="${hero.nickName}" name="nickname" id="nickname" placeholder="请输入昵称">
            </div>
        </div>

        <div class="form-group">
            <label for="img" class="col-sm-2 control-label">图片地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" value="${hero.tinyImg}" name="tinyimg" id="img" placeholder="请输入图片地址">
            </div>
        </div>

        <div class="form-group">
            <label for="ak" class="col-sm-2 control-label">攻击力</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" value="${hero.attackPower}" name="attackpower" id="ak" placeholder="请输入攻击力">
            </div>
        </div>

        <div class="form-group">
            <label for="hh" class="col-sm-2 control-label">上手难度</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" value="${hero.handHard}" max="10" name="handhard" id="hh" placeholder="请输入上手难度">
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
