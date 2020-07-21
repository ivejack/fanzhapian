<%--
  Created by IntelliJ IDEA.
  User: Hasee
  Date: 2020/7/21
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>我的团队</title>
    <link type="text/css" rel="stylesheet" href="static/css/teststorage.css"/>
    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="static/js/team.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        getMyTeamPeople();
        getMyProject();
        getProjectList();
    })
</script>
<body>

<div id="hot">
    <span class="xf_title" style="width: 1190px;margin-bottom: 20px;font-weight: bold;font-size: 20px">成员信息</span>
    <table>
        <thead style="color:#c7c7c7">
        <th>序号</th>
        <th>成员姓名</th>
        <th>成员年龄</th>
        <th>成员性别</th>
        <th>成员电话</th>
        <th>操作</th>
        </thead>
        <tbody id="table1">
        <tr>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td>1</td>
            <td><span>删除</span></td>
        </tr>
        </tbody>
    </table>
<br>
    <span class="xf_title" style="width: 1190px;margin-bottom: 20px;font-weight: bold;font-size: 20px">我的项目</span>
    <table>
        <thead style="color:#c7c7c7">
        <th>序号</th>
        <th>项目名称</th>
        <th>操作</th>
        </thead>
        <tbody id="table2">
        <tr>
            <td>1</td>
            <td>1</td>
            <td><span>删除</span></td>
        </tr>
        </tbody>
    </table>
    <form id="testForm">
        <div style="margin-right: 350px;">
            <div class="div_4 bgc mt"><span class="fsw tdec" onclick="getProjectList()">查询</span></div>
            <div class="br div_2 mt"><input type="text" name="name" id="essaySearch" placeholder="请输入要查询的字段" class="fsh input"></div>
            <input name="pageNum" type="hidden" value="1">
        </div>
    </form>
    <span class="xf_title" style="width: 1190px;margin-bottom: 20px;font-weight: bold;font-size: 20px">项目列表</span>
    <table>
        <thead style="color:#c7c7c7">
        <th>序号</th>
        <th>项目名称</th>
        <th>操作</th>
        </thead>
        <tbody id="table3">
        <tr>
            <td>1</td>
            <td>1</td>
            <td><span>添加</span></td>
        </tr>
        </tbody>
    </table>
    <div id="page">
        <span>首页</span><span>尾页</span><span>上一页</span><span>下一页</span>
    </div>
</div>
</body>
</html>
