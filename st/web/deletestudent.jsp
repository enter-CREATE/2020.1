<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/17
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" id="delete" name="delete" placeholder="请输入姓名">
<button onclick="del()">删除</button>
<script>
    function del() {
        var del = document.getElementById("delete");
        var value = del.value;

        window.location.href = "/st/delstudent?name=" + value + "&operator=delete";
    }

</script>
</body>
</html>
