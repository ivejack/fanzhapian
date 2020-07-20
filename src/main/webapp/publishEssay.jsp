<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/16
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文章发表</title>
    <link type="text/css" href="static/css/publishEssay.css" rel="stylesheet">
    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="static/js/essay.js"></script>
</head>
<body>
<div class="div_one br">
<form id="publishEssay">
    <!--发表文章-->
    <div class="div_6 ">
        <div class="div_6_2">
            发表文章
        </div>
        <hr/>
        <div class="div_6_3 ">
            <div class="div_6_3_1 ">文章标题</div>
            <div class="div_6_3_1 ">文章内容</div>
        </div>
        <div class="div_6_4 ">
            <input name="title" type="text" placeholder="请输入文章标题..." class="input">
        </div>

        <textarea name="content" rows="18" cols="110" class="div_6_5"> </textarea>

        <div class="div_3 ">
            <div class="div_3_1 bgc marr">
                <!--单击事件发表文章-->
                <span onclick="publishEssay()" class=" f_span font_size">发表文章</span>
            </div>
        </div>
    </div>
</form>
    <!--发表文章结束-->
</div>

</body>
</html>
