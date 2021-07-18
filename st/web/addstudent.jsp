<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/17
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/st/studentcrud" method="post" onsubmit="return checkAll()">

    <p>姓名：<input id="name" type="text" name="name"> <span id="uktip" style="color: red"></span></p>
    <p>性别：<input type="text" name="sex"></p>
    <p>学号：<input type="text" name="id"></p>
    <p>年龄：<input id="age" type="number" name="age">
        <span id="numtip" style="color: red"></span>
    </p>

    <!-- 发送一些不需要用户感知或操作的数据 -->
    <input type="hidden" name="operator" value="add">
    <!-- submit是一个按钮，当点击这个按钮的时候，会跳转到form中action对应的地址 -->
    <p><input type="submit" value="添加"></p>
</form>

<script>

    function checkAll() {
        if (!checkName()) {
            return false
        }
        if (!numberCheck()) {
            return false
        }
        return true
    }

    // querySelector
    function checkName() {
        var Name = document.getElementById("name");
        var ukTip = document.getElementById("uktip");
        var NameValue = Name.value;
        console.log(NameValue);
        if (!NameValue) { // 0 '' NULL undefined false   !取反
            ukTip.innerHTML = "名称不能为空";
            return false
        } else if (NameValue.length > 10) {
            ukTip.innerHTML = "名称长度过长";
            return false
        } else {
            ukTip.innerHTML = "";
            return true
        }
    }


    function numberCheck() {
        // HTML 从上向下加载
        // 1. 获取标签元素   2.获取输入得值   3.合法性验证值   4.给出提示
        var element = document.getElementById("age") // 1
        var numtip = document.getElementById("numtip");

        var inputValue = element.value;
        console.log(inputValue)
        if (inputValue >= 1 && inputValue <= 150) {
            numtip.innerHTML = "";
            return true
        }
        numtip.innerHTML = "输入值要介于1-150之间";
        return false;
    }


</script>
<%--<form action="/st/addstudent" method="post">--%>
<%--    <p>姓名: <input type="text" name="name"></p>--%>
<%--    <p>性别: <input type="text" name="sex"></p>--%>
<%--    <p>学号: <input type="text" name="id"></p>--%>
<%--    <p>年龄: <input type="number" name="age"></p>--%>
<%--    <p><input type="submit" value="添加"></p>--%>
<%--</form>--%>
</body>
</html>
