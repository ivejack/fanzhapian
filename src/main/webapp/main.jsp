<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/9
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>反诈宣传</title>
    <link type="text/css" rel="stylesheet" href="static/css/main.css">
    <script type="text/javascript" src="static/js/main.js"></script>
    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="static/js/blackStorage.js"></script>
</head>
<body>
<div class="w1280  mar_auto" style="height: auto">
    <!--轮播图模块-->
    <div class="carousel w1280">
        <!--左侧菜单-->
        <div class="carousel_menu">
            <ul>
                <li style="border: none;height:30px;"></li>
                <li><span></span><p><a href="exam.jsp">反诈小考&gt;&gt;</a></p></li>
                <li><span></span><p><a href="essay.jsp">文章专栏&gt;&gt;</a></p></li>
                <li><span></span><p><a href="vip.jsp">会员入口&gt;&gt;</a></p></li>
                <li><span></span><p><a href="myself.jsp">我的&gt;&gt;</a></p></li>
            </ul>
        </div>
        <!--轮播图-->
        <div id="carousel_img" onmousemove="stop()" onmouseout="startCar()">
            <!--图片-->
            <c:if test="${img >0 }"><div class="carousel_img_div show" style="background-image: url('img/1.jpg')"></div></c:if>
            <c:if test="${img >1 }"><div class="carousel_img_div hidden" style="background-image: url('img/2.jpg')"></div></c:if>
            <c:if test="${img >2 }"><div class="carousel_img_div hidden" style="background-image: url('img/3.jpg')"></div></c:if>
            <c:if test="${img >3 }"><div class="carousel_img_div hidden" style="background-image: url('img/4.jpg')"></div></c:if>
            <!---按钮-->
            <div class="carousel_button ">
                <c:if test="${img >0 }"><div class="carousel_button_div" onclick="selexted(0)"><div class="carousel_button_bg hidden"></div></div></c:if>
                <c:if test="${img >1 }"><div class="carousel_button_div" onclick="selexted(1)"><div class="carousel_button_bg show"></div></div></c:if>
                <c:if test="${img >2 }"><div class="carousel_button_div" onclick="selexted(2)"><div class="carousel_button_bg show"></div></div></c:if>
                <c:if test="${img >3 }"><div class="carousel_button_div" onclick="selexted(3)"><div class="carousel_button_bg show"></div></div></c:if>
            </div>
        </div>
    </div>
  </div>
    <!--轮播图模块结束-==============================-->

<!--嫌疑鉴别平台-->
<form id="blackForm">
    <div class="black">
        <div class="input">
            <input type="text" name="blacklist" id="uplaod" class="input_black">
            <input type="button" value="识别" onclick="getblack()" class="loginbutton_input">
        </div>
    </div>
</form>
<!--黑库信息显示区-->
<div id="blackmessage" onclick="$('#blackmessage').hide()">

</div>

<!--用户状态栏-->
  <div class="user">
      当前用户：${username}
      <a href="#" onclick="window.location.href='index.jsp'">【退出】</a>
  </div>

</body>
</html>
