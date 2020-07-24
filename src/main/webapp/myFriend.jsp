<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/17
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的好友</title>
    <link type="text/css" rel="stylesheet" href="static/css/friend.css"/>
    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="static/js/friend.js"></script>
</head>
<script type="text/javascript" >
    $(function () {
        getTFriendList();
    })
</script>
<body>
<div class="middle ">
    <div class="middle_1 ">
        <div align="center" class="z1" style="height: 550px;margin: 0 auto;position: relative">
            <div class="z2">
                <font  color="#808080"><a onclick="window.location.href='friendNews.jsp'">消息列表</a></font><p/>
                <font  style="color: #65a2fd;border: 1px solid #65a2fd;border-radius: 10%;padding: 5px 40px"><a onclick="window.location.href='myFriend.jsp'" id="z7">好友列表</a></font><p/>
                <font  color="#808080"><a onclick="window.location.href='addFriend.jsp'">添加好友</a></font><p/>
            </div>
            <form action="" method="post">
                <div class="z3">
                    <span style="position:fixed;top:165px;left:780px">姓名</span>
                    <span style="position:fixed;top:165px;left:1040px">性别</span>
                    <span style="position:fixed;top:165px;left:1300px">账号</span>
                    <span style="position:fixed;top:165px;left:1550px">操作</span>
                </div>
                <table style="margin-left:-50px;line-height:60px;">
                        <tr>
                            <td class="z3"></td>
                            <td class="z3"></td>
                            <td class="z3"></td>
                            <td class="z3"></td>
                        </tr>
                </table>
            </form>
        </div>
    </div>

    <div class="div_option">
        <ul id="page">
        </ul>
    </div>

</div>
</body>
</html>
