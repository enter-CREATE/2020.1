<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/31
  Time: 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加英雄信息</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        from{
            width: 50%;
            margin: 0 auto;
            background-color: rgba(82,88,99,0.3);
        }
        body{
            background-image: url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1604132624127&di=6f5bdd4bc8c8eb07f9628c608d72af10&imgtype=0&src=http%3A%2F%2Fatt.gamefy.cn%2F201208%2F134379086734805.jpg");
            background-size: 100%,100%;
        }
        label{
            color:blue;
            font-size: 20px;
            line-height: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 style="text-align: center;margin-bottom: 36px;color: darkcyan">添加英雄</h1>
    <form action="/lolhero/hero?operator=add" class="form-horizontal" method="post">
    <div class="form-group">
        <label for="ukname" class="col-sm-2 control-label">名称</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="ukname" id="ukname" placeholder="请输入英雄名称">
        </div>
    </div>

    <div class="form-group">
        <label for="nickname" class="col-sm-2 control-label">昵称</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="nickname" id="nickname" placeholder="请输入昵称">
        </div>
    </div>

    <div class="form-group">
        <label for="img" class="col-sm-2 control-label">图片地址</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="tinyimg" id="img" placeholder="请输入图片地址">
        </div>
    </div>

    <div class="form-group">
        <label for="ak" class="col-sm-2 control-label">攻击力</label>
        <div class="col-sm-10">
            <input type="number" class="form-control" name="attackpower" id="ak" placeholder="请输入攻击力">
        </div>
    </div>

    <div class="form-group">
        <label for="hh" class="col-sm-2 control-label">上手难度</label>
        <div class="col-sm-10">
            <input type="number" class="form-control" max="10" name="handhard" id="hh" placeholder="请输入上手难度">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary">添加</button>
        </div>
    </div>
</form>
</div>
</body>
</html>
