//考试题目
function getTestList() {
    $.ajax("getTestList",{
        data:"post",
        success:function (rel) {
            // console.log(rel);
            var judge="";
            $(rel).each(function (i) {
                judge += "<div class=\"judge\">";
                judge += "<span class=\"exercises_1\">"+(i+1)+","+this.question+"</span></br>";
                judge += "<input type=\"hidden\" name=id"+(i+1)+" value="+this.id+">";
                judge += "<span class=\"judge_1\"><input type=\"radio\" name="+(i+1)+" value=\"对\">对</span>";
                judge += "<span class=\"judge_1\"><input type=\"radio\" name="+(i+1)+" value=\"错\">错</span>";
                judge += "</div>";
            })
            $(".judge").html(judge);
        }
    })
}

//考试成绩提交
function gobackTest() {
    var ids = new Array();
    var ans = new Array();
    for (var i=0;i<10;i++){
        ans[i] = $("input[name="+(i+1)+"]:checked").val();
        ids[i] = $("input[name=id"+(i+1)+"]").val();
    }
    // console.log(ans);
    // console.log(ids);
    $.ajax("saveTest",{
        data: {"ids":ids,"ans":ans},
        type:"post",
        traditional:true,
        success:function (rel) {
            var message = confirm("你的考试成绩是"+rel);
            window.location.href="main.jsp";
        }
    })
}