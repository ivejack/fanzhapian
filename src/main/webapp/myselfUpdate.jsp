<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/14
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息修改</title>
    <link rel="stylesheet" href="static/css/myselfUpdate.css"/>
    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="static/js/myself.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        date();
    })
</script>
<body>
<div class="main">
    <div class="title">
        <p class="titlecontext">当前位置：我的信息>修改信息</p>
    </div>
    <i class="headimg"></i>
    <form class="myself" id="myselfForm">
        <div class="flag1"><span class="formtext">姓名</span><input class="forminput" type="text"  name="name"  value=""></div>
        <div class="flag1"><span class="formtext">密码</span><input class="forminput" type="text" name="password" value=""></div>
        <div class="flag1"><span class="formtext">性别</span>
            <select name="sex"  class="forminput">
                <option value="0">男</option>
                <option value="1">女</option>
            </select></div>
        <div class="flag1"><span class="formtext">出生日期</span>
            <select name="year"  class="forminput2"></select><span class="flag2">年</span>
            <select name="month"  class="forminput2"></select><span class="flag2">月</span>
            <select name="day"  class="forminput2"></select><span class="flag2">日</span></div>
        <div class="flag1">
        <input type="button" value="确认修改" class="submit" onclick="updatemyself()"></div>
    </form>
</div>
</body>
</html>
