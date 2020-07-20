<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/13
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>反诈小考</title>
    <link type="text/css" rel="stylesheet" href="static/css/exam.css">
    <script type="text/javascript" src="static/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="static/js/exam.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        getTestList();
    })
</script>
<body>
<div class="test_middle">
    <div class="test_middle_1">
        <div class="test_middle_top">当前进行:反诈宣传小测试>></div>
        <div class="test_middle_title"><span class="title_1">反诈宣传考试</span>
            <span class="title_2">(剩余考试时间:
                <span class="title_3" style="color: #65A2FD" id="time">*</span>分钟)</span></div>

        <script>
            window.onload = function(){
                var time = {
                    init: function() {
                        var oTime=document.getElementById("time");
                        var h='0' + 1;
                        var m=59;
                        var s=59;
                        oTime.innerHTML="02 : 00 : 00";

                        //进行倒计时显示
                        var time = setInterval(function(){
                            --s;
                            if(s<0){
                                --m;
                                s=59;
                            }
                            if(m<0){
                                --h;
                                m=59
                            }
                            if(h<0){
                                s=0;
                                m=0;
                            }
                            // 判断当时分秒小于10时补0
                            function checkTime(i){
                                if (i < 10) {
                                    i = '0' + i
                                }
                                return i;
                            }
                            s = checkTime(s);
                            m = checkTime(m);
                            oTime.innerHTML=h+" : "+m+" : "+s;
                        },1000);
                    }
                }
                time.init();
            }
        </script>


        <div class="judge">

        </div>
        <div class="test_middle_button">
            <div class="test_middle_button_1" onclick="gobackTest()">提交试卷</div>
            <div class="test_middle_button_2" onclick="window.location.href='main.jsp'">关闭试卷</div>
        </div>
    </div>
</div>
</body>
</html>
