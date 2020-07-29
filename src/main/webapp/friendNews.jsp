<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/21
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>消息处理</title>
    <link type="text/css" rel="stylesheet" href="static/css/friend.css"/>
    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="static/js/friendNews.js"></script>
</head>
<script type="text/javascript" >
    $(function () {
        getTFriendNewsList();
    })
</script>
<body>
<div class="middle ">
    <div class="middle_1 ">
        <div align="center" class="z1">
            <div class="z2">
                <font  style="color: #65a2fd;border: 1px solid #65a2fd;border-radius: 10%;padding: 5px 40px"><a onclick="window.location.href='friendNews.jsp'" id="z7">消息列表</a></font><p/>
                <font  color="#808080"><a onclick="window.location.href='myFriend.jsp'">好友列表</a></font><p/>
                <font  color="#808080"><a onclick="window.location.href='addFriend.jsp'">添加好友</a></font><p/>
            </div>
            <div class="z3">
                <span style="position:fixed;top:165px;left:780px">姓名</span>
                <span style="position:fixed;top:165px;left:980px">性别</span>
                <span style="position:fixed;top:165px;left:1180px">账号</span>
                <span style="position:fixed;top:165px;left:1380px">内容</span>
                <span style="position:fixed;top:165px;left:1580px">操作</span>
            </div>
            <table>
                <tbody>
                <tr>
                    <td class="z3"></td>
                    <td class="z3"></td>
                    <td class="z3"></td>
                    <td class="z3"></td>
                    <td class="z3"></td>
                </tr>
                </tbody>
            </table>
            <input type="hidden" name="applyId">
            <input type="hidden" name="replyId">


        </div>
    </div>
    <div class="div_option">
        <ul id="page">
        </ul>
    </div>

</div>


</body>
</html>
