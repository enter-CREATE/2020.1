<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.cx.jdbc.Student" %>
<%@ page import="java.util.List" %><%--
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
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <img src="/st/img/add.png" alt="" onclick="addStudent()">

    <script>
        function addHero() {
            location.href = "addstudent.jsp"
        }
    </script>

    <table class="table table-hover table-bordered">
        <tr>
            <th>学号</th>
            <th>性别</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.sex}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>
                    <button onclick="updateAtudent('${student.name}')">修改</button>
                    <button onclick="delstudent('${student.name}')">删除</button>
                </td>
            </tr>
        </c:forEach>
        <script>

            function updateStudent() {
                location.href = "/jst/studentcrud?name=" + Name + "&operator=selectbyName";
            }

            function delStudent(name) {
                if (confirm("确认要删除吗")) {
                    window.location.href = "/st/studentcrud?name=" + Name + "&operator=delete";
                }
            }
        </script>

        <%--        <tr>--%>
        <%--            <th>姓名</th>--%>
        <%--            <th>性别</th>--%>
        <%--            <th>学号</th>--%>
        <%--            <th>年龄</th>--%>
        <%--        </tr>--%>

        <%--        <%--%>
        <%--            List<Student> studentList = (List<Student>) session.getAttribute("students");--%>
        <%--            for (int i = 0; i <studentList.size() ; i++) {--%>
        <%--        %>--%>

        <%--        <tr>--%>
        <%--            <td><%=studentList.get(i).getName()%></td>--%>
        <%--            <td><%=studentList.get(i).getSex()%></td>--%>
        <%--            <td><%=studentList.get(i).getId()%></td>--%>
        <%--            <td><%=studentList.get(i).getAge()%></td>--%>
        <%--        </tr>--%>

        <%--        <%}   %>--%>

    </table>
</div>
</body>
</html>
