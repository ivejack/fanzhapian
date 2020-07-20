<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/13
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>阅读文章</title>
    <link type="text/css" rel="stylesheet" href="static/css/essayContent.css">
    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="static/js/utils.js"></script>
    <script type="text/javascript" src="static/js/essay.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        var id = getUrlParam("essayid");
        getOneEssay(id);
    })
</script>

<body>

   <div class="div_1 ">
     <div class="div_1_2">标题</div><hr/>
   </div>

   <div class="div_2">内容</div>

   <div class="r">
       <button class="btn btn-primary btn-ghost btn-shine" onclick="addTheck();">
           <span style="font-size: 20px;font-weight: bold">举报</span>
       </button>
   </div>

</body>
</html>
