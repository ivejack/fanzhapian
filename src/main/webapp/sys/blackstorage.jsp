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
    <title>黑库管理</title>
    <link type="text/css" rel="stylesheet" href="../static/css/teststorage.css"/>
    <script type="text/javascript" src="../static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../static/js/blackStorage.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        getPageTBlack();
    })
</script>
<body>
<form id="testForm">
    <div style="margin-right: 350px;">
        <div class="div_4 bgc mt" style="margin-right: 365px;"><span class="fsw tdec" onclick="openForm(this,-1)">新增</span></div>
        <div class="div_4 bgc mt"><span class="fsw tdec" onclick="getPageTBlack()">查询</span></div>
        <div class="br div_2 mt"><input type="text" name="typecontent" id="essaySearch" placeholder="请输入要查询的字段" class="fsh input"></div>
        <input name="pageNum" type="hidden" value="1">
    </div>
</form>

<div id="hot">
    <span class="xf_title" style="width: 1190px;margin-bottom: 20px;font-weight: bold;font-size: 20px">黑库管理</span>
    <table>
        <thead style="color:#c7c7c7">
        <th>序号</th>
        <th>黑库嫌疑信息</th>
        <th>黑库类别</th>
        <th>操作</th>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td><span>修改</span> <span>删除</span></td>
        </tr>
        </tbody>

    </table>
</div>
<div id="page">
    <span>首页</span><span>尾页</span><span>上一页</span><span>下一页</span>
</div>
<form id="addForm">
    <div id="titleForm">新增黑库</div>
    <input type="hidden" name="id" />
    黑库嫌疑信息：<input type="text" name="message"/><br>
    黑库类别：<input type="text" name="typecontent" /><br>
    <button onclick="saveorupdate()">提交</button>
    <button>关闭</button>
</form>
</body>
</html>
