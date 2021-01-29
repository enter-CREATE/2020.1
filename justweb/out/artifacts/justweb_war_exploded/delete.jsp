<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/19
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" id="delete" name="delete" placeholder="请输入名称">
<!-- onclick="del()" 当点击删除按钮的时候会执行del函数 -->
<button onclick="del()">删除</button>
<script>
    // del函数
    function del(){
        // 根据名称删除英雄
        // 1.获取输入的名称信息 -- 获取input输入框
        var del = document.getElementById("delete");
        // 获取input输入框中输入的值
        var value = del.value;
        // 跳转到DeleteServlet去执行删除功能
        // get方式传参
        window.location.href = "/justweb/herocrud?ukName=" + value + "&operator=delete";
    }
</script>

</body>
</html>
