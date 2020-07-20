//加载考试信息
//加载积分信息
//加载用户信息
function getMySelf() {
    $.ajax("myself",{
        type:"post",
        success:function (rel) {
            // console.log(rel.user);
            // console.log(rel.vip);
            // console.log(rel.test);
            var trs="";
            trs += " <tr class=\"right_context_frist\"><th>试卷序号</th><th></th><th>分数</th></tr>";
            $(rel.test).each(function (i) {
                trs += "<tr><td>"+i+"</td><td></td><td>"+this.grade+"</td></tr>";
            })
            $(".right_context").html(trs);
            if(rel.vip!=null){
                $("#score").text("积分:"+rel.vip.score);
            }else {
                $("#score").text("积分:0");
            }
            $("#count").text("文章发表总数："+rel.count);
        }
    })
}

//修改信息
//日期设置
function date() {
    var nowyear = new Date().getFullYear();
    //年
    var year="";
    for (var i= nowyear;i>nowyear-100;i--){
        year += "<option value="+i+" class=\"forminput2\">"+i+"</option>";
    }
    $("select[name='year']").html(year);
    //月
    var month="";
    for (var i= 1;i<=12;i++){
        month += "<option value="+i+" class=\"forminput2\">"+i+"</option>";
    }
    $("select[name='month']").html(month);
    //日
    var day="";
    for (var i= 1;i<=31;i++){
        day += "<option value="+i+" class=\"forminput2\">"+i+"</option>";
    }
    $("select[name='day']").html(day);
}

//修改信息
function updatemyself() {
    var data = $("#myselfForm").serialize();
    //姓名，密码，性别，出生日期
    var name = $("input[name='name']").val();
    var pwd = $("input[name='password']").val();
    var sex = $("select[name='sex']:optional").val();
    var year = $("select[name='year']:optional").val();
    var month = $("select[name='month']:optional").val();
    var day = $("select[name='day']:optional").val();
    var time = year+"-"+month+"-"+day;

    // var map ={"name":name,"pwd":pwd,"sex":sex,"time":time};
    // console.log(map);
    $.ajax("updatemyself",{
        data:{"name":name,"pwd":pwd,"sex":sex,"time":time},
        type:"post",
        success:function (rel) {
            if (rel==true){
                window.confirm("修改成功！请重新登陆！！！")
                window.location.href='index.jsp';
            }else {
                window.confirm("修改失败！请重新修改！！！")
                window.location.reload();
            }
        }
    })
}