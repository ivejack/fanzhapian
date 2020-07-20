<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/7/17
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>题库管理</title>
    <link type="text/css" rel="stylesheet" href="../static/css/teststorage.css"/>
    <script type="text/javascript" src="../static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../static/js/teststorage.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        getAllTestStorage();
    })
</script>
<body>

<form id="testForm">
    <div class="div_4 bgc mt" style="margin-right: 365px;"><span class="fsw tdec" onclick="openForm(this,-1)">新增</span></div>
    <div style="margin-right: 350px;">
        <div class="div_4 bgc mt"><span class="fsw tdec" onclick="getAllTestStorage()">查询</span></div>
        <div class="br div_2 mt"><input type="text" name="question" id="essaySearch" placeholder="请输入要查询的字段" class="fsh input"></div>
    </div>
    <input name="pageNum" type="hidden" value="1">
</form>
<div id="hot">
    <span class="xf_title" style="width: 1190px;margin-bottom: 20px;font-weight: bold;font-size: 20px">题库管理</span>
<table align="center" border= 1px solid black;>
    <thead style="color:#c7c7c7">
        <th>序号</th>
        <th>题目</th>
        <th>答案</th>
        <th>解析</th>
        <th>操作</th>
    </thead>
    <tbody></tbody>
</table>
</div>
<div id="page">
    <span>首页</span>
    <span>尾页</span>
    <span>上一页</span>
    <span>下一页</span>
</div>
<form id="addForm">
    <div id="titleForm">新增题目</div>
    <input type="hidden" name="id" />
    题目：<input type="text" name="question"/><br>
    答案:
    <select name="answer">
        <option value="对">对</option>
        <option value="错">错</option>
    </select><br>
    解析：<input type="text" name="analysis" /><br>
    <button onclick="saveorupdate()">提交</button>
    <button>关闭</button>
</form>
</body>
</html>
