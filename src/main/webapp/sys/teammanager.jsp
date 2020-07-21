<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/7/17
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>团队管理</title>
    <link type="text/css" rel="stylesheet" href="../static/css/teststorage.css"/>
    <script type="text/javascript" src="../static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../static/js/team.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        getTeamList();
    })
</script>
<body>
<form id="testForm">
    <div style="margin-right: 350px;">
        <div class="div_4 bgc mt"><span class="fsw tdec" onclick="getTeamList()">查询</span></div>
        <div class="br div_2 mt"><input type="text" name="name" id="essaySearch" placeholder="请输入要查询的字段" class="fsh input"></div>
        <input name="pageNum" type="hidden" value="1">
    </div>
</form>

<div id="hot">
    <span class="xf_title" style="width: 1190px;margin-bottom: 20px;font-weight: bold;font-size: 20px">团队管理</span>
    <table>
        <thead style="color:#c7c7c7">
        <th>序号</th>
        <th>团队名称</th>
        <th>创建人</th>
        <th>操作</th>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td><span>删除</span></td>
        </tr>
        </tbody>

    </table>
</div>
<div id="page">
    <span>首页</span><span>尾页</span><span>上一页</span><span>下一页</span>
</div>
</body>
</html>
