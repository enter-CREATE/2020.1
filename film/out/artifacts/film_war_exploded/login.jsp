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
    <title>电影信息管理系统</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        form {
            width: 480px;
            margin: 0 auto;
            margin-top: 64px;
        }

        button[type="submit"] {
            margin-top: 32px;
        }

        #tip {
            color: red;
            font-weight: bold;
            float: right;
            font-size: 14px;
        }

        body {
            background-color: lightskyblue;
            background-image: url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1604425047830&di=ff99082ea5faba2340836d9364fea363&imgtype=0&src=http%3A%2F%2Fbpic.588ku.com%2Fback_pic%2F03%2F71%2F44%2F3457b7f53cc91ab.jpg");
            background-size: 100%, 100%;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="/filminfo/login" method="post" onsubmit="return checkPhone()">
        <div class="form-group">
            <label for="phone" style="color: #c9302c">账号</label> <span id="tip"></span>
            <input type="text" class="form-control" name="phone" id="phone" placeholder="请输入账号">
        </div>
        <div class="form-group">
            <label for="pwd" style="color: #c9302c">密码</label>
            <input type="password" class="form-control" name="pwd" id="pwd" placeholder="请输入密码">
        </div>

        <button type="submit" class="btn btn-danger form-control">登录</button>
    </form>
    <script>

        function checkPhone() {
            var phone = document.getElementById("phone");
            var phoneNum = phone.value
            var span = document.getElementById("tip")
            // 判断手机号是否合法    通过正则表达式判断手机号是否正确
            if (!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(phoneNum))) {
                span.innerHTML = "手机号输入有误，请重新输入";
                return false;
            }
            span.innerHTML = "";
            return true;
        }
    </script>


</div>


</body>
</html>
