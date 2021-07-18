<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="../../static/css/style_detail.css">
</head>
<body>
<div class="search">
    <form action="/bookshelf/select">
        <input type="text" name="delicacy_detail">
        <button type="submit">搜索</button>
    </form>
</div>
<div class="box">
    <#list bookshelfList as bookshelf>
        <table class="table">
            <td><img src="${bookshelf.image}" alt="">
                <div>
                    <p>书名：</p>
                    <a href="http://localhost:8888/bookshelf/select?bookName=${bookshelf.bookName}">${bookshelf.bookName}</a>
                    <p>
                        &nbsp;&nbsp;<p>作者：</p>${bookshelf.author}
                        &nbsp;&nbsp;<p>出版社：</p>${bookshelf.publishing}&nbsp;&nbsp;
                        <p>编号：</p>${bookshelf.bookId}<br>
                        &nbsp;&nbsp;&nbsp;&nbsp;<p>简介：</p>${bookshelf.introduction}
                    </p>
                </div>
                <button type="submit">添加</button>
                <button type="submit">删除</button>
            </td>
        </table>
    </#list>
</div>
</body>
</html>