<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/21
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>附加信息发送</title>
    <link type="text/css" rel="stylesheet" href="static/css/friend.css"/>
    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="static/js/sendFriendNews.js"></script>
</head>
<script type="text/javascript" >
    $(function () {
        getSendFriendNewsList();
    })
</script>
<body>
<div class="middle ">
    <div class="middle_1 ">
        <div align="center" class="z1" style="height: 550px;margin:0 auto;position: relative">
            <div class="z2">
                <font  color="#808080"><a onclick="window.location.href='friendNews.jsp'">消息列表</a></font><p/>
                <font  color="#808080"><a onclick="window.location.href='myFriend.jsp'">好友列表</a></font><p/>
                <font  style="color: #65a2fd;border: 1px solid #65a2fd;border-radius: 10%;padding: 5px 40px"><a onclick="window.location.href='addFriend.jsp'" id="z7">添加好友</a></font><p/>
            </div>
            <form id="thisform">
                <div class="z5">

                </div>
                <div class="z6 zc" style="position: absolute;top: 120px;left: 450px;">

                </div>

                <div class="z6" style="position: absolute;top: 100px;left: 650px;">
                    请输入附加信息：
                </div>
                <div style="position: absolute;top: 130px;left: 650px;">
                    <textarea cols="70" rows="5"  name="message"></textarea>
                </div>
                <input type="hidden" name="applyId" value="1">
                <input type="hidden" name="replyId" value="1">
                <button type="button" style="position:absolute;right:120px;top:220px; " onclick="sendNews()">添加好友</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
