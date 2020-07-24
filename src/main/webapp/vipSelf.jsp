<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/14
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="static/js/myself.js"></script>
<html>
<script type="text/javascript">
    $(function () {
        getMySelf();
    })
</script>
<head>
    <title>会员信息</title>
    <link rel="stylesheet" href="static/css/vipSelf.css"/>
</head>
<body>
<div class="main">
    <div class="left_menu">
        <div class="left_menu_title">VIP信息</div>
        <i class="head_img"></i>
        <ul class="myinfo">
            <li>姓名：${username}</li>
            <li>积分：${score}</li>
            <li>发表文章：*</li>
            <li>注册时间：${startTime}</li>
            <li><div class="submitbtn" onclick="window.location.href='vipSelfUpdate.jsp';" >修改信息</div></li>
                </ul>
    </div>
    <div class="right_menu">
        <div class="right_menu_title">考试概况</div>
        <table class="right_context" cellpadding="0" cellspacing="0">

        </table>
    </div>
</div>
</body>
</html>
