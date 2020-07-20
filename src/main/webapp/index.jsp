<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/7/8
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面hushuo</title>
    <link type="text/css" rel="stylesheet" href="static/css/index.css">

    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>

    <script type="text/javascript" src="static/js/userJS.js"></script>

</head>


<body class="main_div">
<div class="big">
    <div class="logo"></div>
    <form id="loginForm">
        <div class="loginform">
            <div class="top">登录</div>
            <div class="main">
                <div class="input">&nbsp;&nbsp;&nbsp;账&nbsp;&nbsp;号
                    <input type="text" name="loginname"
                           class="input_username_password">
                </div>
                <div class="input">&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;码
                    <input type="password" name="password"
                           class="input_username_password">
                </div>

                <div class="loginbutton">
                    <input type="button" value="立即登录"
                           class="loginbutton_input" onclick="loginuser()">
                </div>
                <div class="loginAdmin_return">
                    <input type="button" value="后台管理" onclick="adminuser()" class="loginAdmin_input">
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
