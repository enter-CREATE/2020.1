<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/19
  Time: 20:57
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

    <form action="/justweb/herocrud" method="post">
        <div class="form-group">
            <label for="uk_name">名称</label>
            <input type="text" class="form-control" name="uk_name" id="uk_name" placeholder="请输入名称">
        </div>
        <div class="form-group">
            <label for="nickname">昵称</label>
            <input type="text" class="form-control" name="nickname"  id="nickname" placeholder="请输入昵称">
        </div>

        <div class="form-group">
            <label for="ting_img">图片地址</label>
            <input type="text" class="form-control" name="ting_img" id="ting_img" placeholder="请输入昵称">
        </div>
        <div class="form-group">
            <label for="hand_hard">上手难度</label>
            <input type="number" class="form-control" name="hand_hard"  id="hand_hard" placeholder="请输入上手难度">
        </div>
        <input type="hidden" name="operator" value="update">

        <button type="submit" class="btn btn-danger form-control">修改</button>
    </form>


    <%--   <form action="/justweb/updatehero" method="post">
           <p>名称：<input type="text" name="uk_name"></p>
           <p>昵称：<input type="text" name="nickname"></p>
           <p>图片地址：<input type="text" name="ting_img"></p>
           <p>上手难度：<input type="number" max="10" name="hand_hard"></p>
           <!-- submit是一个按钮，当点击这个按钮的时候，会跳转到form中action对应的地址 -->
           <p><input type="submit" value="修改"></p>
       </form>--%>
</div>

</body>
</html>
