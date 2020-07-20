<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/15
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文章发表审核</title>
    <link type="text/css" rel="stylesheet" href="../static/css/check.css">
    <script type="text/javascript" src="../static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="../static/js/check.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        getCheckPublishEssay();
    })
</script>
<body>
<div class="xx1 ">
    <div class="xx11 ">
        <div class="header">
            <div class="header_left br">文章发表审核</div>
        </div>
        <div class="share">
            <span style="float: right; font-size: 18px;">以实为准，客观公正！</span>
        </div>
        <div class="cx br">
            <form id="checkForm">
                <input type="hidden" name="pageNow" value="1">
                <span style="float: left;margin-left: 15px;margin-top: 15px;">
                    标&nbsp;题：<input type="text" name="title"
                                    style="border:1px solid skyblue;width: 300px; height: 25px;border-radius: 5px; color: #A9A9A9;"
                                    placeholder="请输入标题">
                </span>
                <%--                <span style="float: right; margin-top: 15px;margin-right: 90px;">--%>
                <%--                    时&nbsp;间：<input type="text" value="请输入时间区间" style="width:190px;height: 25px;border-radius: 5px;border:1px solid skyblue;color: #A9A9A9">--%>
                <%--                    ---%>
                <%--                    <input type="text"  value="请输入时间区间" style="width:190px;height: 25px;border-radius: 5px;border:1px solid skyblue;color: #A9A9A9;">--%>
                <%--                </span>--%>
                <span style="float: left;margin-left: 15px;margin-top: 15px;">
                    审核状态：
                    <select name="statu" style="border:1px solid skyblue;width: 302px; height: 25px;border-radius: 5px;">
                        <option style="color: #A9A9A9" value="-1">请选择</option>
                        <option value="0">未审核</option>
                        <option value="1">已审核</option>
                    </select>
                </span>
                <span style="float: left;margin-left: 15px;margin-top: 15px;">
                    审核结果：
                    <select name="result" style="border:1px solid skyblue;width: 302px; height: 25px;border-radius: 5px;">
                        <option style="color: #A9A9A9" value="-1">请选择</option>
                        <option value="1">审核不通过</option>
                        <option value="2">审核通过</option>
                    </select>
                </span>
                <div class="an" style="position: absolute;top: 55px;left: 460px;"><button type="reset">重置</button></div>
                <div class="an" style="position: absolute;top: 55px;left: 540px;" onclick="getCheckPublishEssay()">查询</div>
            </form>
            <div class="cxk">


            </div>
        </div>
    </div>
</div>

</body>
</html>
