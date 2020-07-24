<%--
  Created by IntelliJ IDEA.
  User: Cc
  Date: 2020/7/17
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>积分兑好礼</title>
    <link type="text/css" href="static/css/score.css"  rel="stylesheet">
    <script type="text/javascript" src="static/js/score.js"></script>
    <script type="text/javascript" src="static/js/myself.js"></script>
</head>
<script type="text/javascript">
    $(function () {
        getMySelf();
    })
</script>
<body>
    <div style="background-image: url('img/money.png')" class="div_1" onclick="money()">

    </div>
    <div style="background-image: url('img/money.png')" class="div_2" onclick="money()">

    </div>
    <div style="background-image: url('img/money.png')" class="div_3" onclick="money()">

    </div>
    <div style="background-image: url('img/money.png')" class="div_4" onclick="money()">

    </div>

    <div class="score">
        尊贵的VIP用户：${username}&nbsp;&nbsp;
        &nbsp;&nbsp;您的积分还剩余：${score}
    </div>

</body>
</html>
