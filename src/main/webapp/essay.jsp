<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/13
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>浏览文章</title>
    <link type="text/css" rel="stylesheet" href="static/css/essay.css">
    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="static/js/essay.js"></script>
</head>
<script type="text/javascript" >
    $(function () {
        getTEssayList();
    })
</script>
<body>
<div class="br div_1">
    <div class="br div_big">
        <div class="div_3  fs mt">欢迎你，${username}</div>
        <div class="div_4 bgc mt"><a href="#" class="fsw tdec" onclick="getTEssayList()">查询</a></div>
        <div class="br div_2 mt"><input type="text" id="essaySearch" placeholder="请输入要查找的文章标题" class="fsh input"></div>
        <div class="div_5 ">
            <div class="div_5_Diamonds bgc"></div>
            <div class="fss">热门文章</div>
        </div>
        <!--第一行快速入口-->
        <div class="div_6 ">

        </div>

        <!--数据框-->
        <div class="div_7">
            <!--数据显示-->
            <div class="div_7_2 ">
                <table style="border-spacing: 0;border-collapse: collapse">
                    <tr>
                        <td class="div_td  textac"><a href="" class="tdec">央视揭露刷单兼职</a></td>
                        <td class="div_td  textar"><a href="" class="tdec">16:30</a></td>
                    </tr>
                </table>
            </div>
            <!--数据显示结束-->
            <!--文章大咖-->
            <div class="div_7_1 ">
                <div class="div_7_1_1 "></div>
                <div class=" div_7_1_2">文章大咖</div>
                <div class="div_7_1_3 ">简介：跟着大咖们一起学习反诈知识！</div>
            </div>
            <!--文章大咖-->

        </div>
        <!--文章数据框结束-->
        <hr class="hr"/>

        <form>
            <input type="hidden" name="pageNow" value="1">
        </form>

        <div class="div_option">
            <ul id="page">
            </ul>
        </div>
    </div>
</div>
    <div class="r">
    <button class="z"><span onclick="window.location.href='publishEssay.jsp';">发表文章</span></button>
    </div>
</body>
</html>
