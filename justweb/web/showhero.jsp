<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/10/19
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <img src="/justweb/img/add.png" alt="" onclick="addHero()">

    <script>
        function addHero() {
            location.href = "addhero.jsp"
        }
    </script>

    <!-- table 将要显示的内容包起来 -->
    <table class="table table-hover  table-bordered">

        <!-- 列标题 -->
        <tr>
            <th>图片</th>
            <th>昵称</th>
            <th>名称</th>
            <th>上手难度</th>
            <th>操作</th>
        </tr>
        <!-- heros里面对应的是对象  每一次遍历得到的是一个hero对象
            前一个例子得到的都是字符串，所以跟这个地方法写法不一样
         -->
        <c:forEach items="${heros}" var="hero">
            <tr>
                <td><img src="${hero.ting_img}" alt=""></td>
                <td>${hero.nickname}</td>
                <td>${hero.uk_name}</td>
                <td>${hero.hand_hard}</td>
                <td>
                    <button onclick="updateHero('${hero.uk_name}')">修改</button>
                    <button onclick="delhero('${hero.uk_name}')">删除</button>
                </td>
            </tr>
        </c:forEach>
        <script>

            function updateHero() {
                location.href = "/justweb/herocrud?uk_name=" + ukName + "&operator=selectbyukname";
            }

            function delhero(uk_name) {
                if (confirm("确认要删除吗")) {
                    window.location.href = "/justweb/herocrud?uk_name=" + ukName + "&operator=delete";
                }
            }
        </script>

        <%--   <%--%>
        <%--         // 直接写java代码  alt+enter->import class  导包--%>
        <%--        List<Hero> heroList = (List<Hero>) session.getAttribute("heros");--%>
        <%--        for (int i = 0; i < heroList.size(); i++) {  // for循环大括号开始--%>
        <%--    %>--%>

        <!-- 一次循环一行数据 -->
        <%--    <tr>--%>
        <%--        <td><img src="<%=heroList.get(i).getTinyImg()%>" alt=""></td>--%>
        <%--        <td><%=heroList.get(i).getNickname()%>--%>
        <%--        </td>--%>
        <%--        <td><%=heroList.get(i).getUkName()%>--%>
        <%--        </td>--%>
        <%--        <td><%=heroList.get(i).getHandHard()%>--%>
        <%--        </td>--%>
        <%--    </tr>--%>

        <%--    <%}// for循环大括号结束%>--%>

    </table>

</div>
</body>
</html>
