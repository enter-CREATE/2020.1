<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/19
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--numberCheck() 返回true 会触发action跳转
    numberCheck() 返回false 不会触发action跳转-->
<form action="/justweb/herocrud" method="post" onsubmit="return checkAll()">

    <p>名称：<input id="uk_name" type="text" name="uk_name"> <span id="uktip" style="color: red"></span></p>
    <p>昵称：<input type="text" name="nickname"></p>
    <p>图片地址：<input type="text" name="ting_img"></p>
    <p>上手难度：<input id="hand_hard" type="number" name="hand_hard">
        <span id="numtip" style="color: red"></span>
    </p>

    <!-- 发送一些不需要用户感知或操作的数据 -->
    <input type="hidden" name="operator" value="add">
    <!-- submit是一个按钮，当点击这个按钮的时候，会跳转到form中action对应的地址 -->
    <p><input type="submit" value="添加"></p>
</form>

<script>

    function checkAll(){
        if(!checkUkName()){
            return false
        }
        if(!numberCheck()){
            return false
        }
        return true
    }

    // querySelector
    function checkUkName(){
        var ukName =document.getElementById("uk_name")
        var ukTip = document.getElementById("uktip")
        var ukNameValue = ukName.value // 得到输入的ukName
        console.log(ukNameValue)
        if(!ukNameValue) { // 0 '' NULL undefined false   !取反
            ukTip.innerHTML = "名称不能为空"
            return false
        } else if(ukNameValue.length > 10) {
            ukTip.innerHTML = "名称长度过长"
            return false
        } else {
            ukTip.innerHTML = ""
            return true
        }
    }


    function numberCheck(){
        // HTML 从上向下加载
        // 1. 获取标签元素   2.获取输入得值   3.合法性验证值   4.给出提示
        var element = document.getElementById("hand_hard") // 1
        var numtip = document.getElementById("numtip");

        var inputValue = element.value;
        console.log(inputValue)
        if(inputValue >=1 && inputValue <=10){
            numtip.innerHTML = "";
            return true // 介于1-10之间
        }
        numtip.innerHTML = "输入值要介于1-10之间";
        return false;
    }


</script>
</body>
</html>
