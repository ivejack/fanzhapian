<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/21
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加好友</title>
    <link type="text/css" rel="stylesheet" href="static/css/friend.css"/>
    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="static/js/addFriend.js"></script>
</head>
<script type="text/javascript" >
    $(function () {
        getTAddFriendList();
    })
</script>
<body>

<div class="middle ">
    <div class="middle_1 ">
        <div align="center" class="z1" style="height: 550px;margin: 0 auto;position: relative">
            <div class="z2">
                <font  color="#808080"><a onclick="window.location.href='friendNews.jsp'">消息列表</a></font><p/>
                <font  color="#808080"><a onclick="window.location.href='myFriend.jsp'">好友列表</a></font><p/>
                <font  style="color: #65a2fd;border: 1px solid #65a2fd;border-radius: 10%;padding: 5px 40px"><a onclick="window.location.href='addFriend.jsp'" id="z7">添加好友</a></font><p/>
            </div>
            <form id="testForm">
                <div style="position: fixed;left: 450px;top:200px;">
                <div class="div_4 bgc mt"><a href="#" class="fsw tdec" onclick="getTAddFriendList()">查询</a></div>
                <div class="br div_2 mt"><input type="text" placeholder="请输入要查找的用户" name="username" class="fsh input"></div>
                </div>
                <input type="hidden" name="pageNum" value="1">
            </form>
            <table style="width: 500px;height: 400px;">
                <thead>
                <th>姓名</th>
                <th>性别</th>
                <th>账号</th>
                <th>操作</th>
                </thead>

                <tbody>
                <tr>
                    <td class="z3">1</td>
                    <td class="z3">1</td>
                    <td class="z3">1</td>
                    <td>
                        <span style="white-space:nowrap;" onclick="window.location.href='sendFriendNews.jsp'" style="color: white">添加TA</span>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="div_option">
                <ul id="page">
                </ul>
            </div>
        </div>
    </div>
</div>


</body>
</html>
