//查询消息
function getTFriendNewsList() {
    var pageNum = $("input[name='pageNow']").val();
    $.ajax("getTFriendNewsList",{
        data: {"pageNum":pageNum},
        type:"post",
        success:function (rel) {
            var trs="";
            $(rel.list).each(function () {
                console.log(rel);
                trs+="<tr>";
                trs+="<td img></td>";
                trs+="<td class=\"z3\">"+this.applyIds.username+"</td>";
                trs+="<td class=\"z3\">"+(this.applyIds.sex==1?'男':'女')+"</td>";
                trs+="<td class=\"z3\">"+this.applyIds.loginname+"</td>";
                trs+="<td class=\"z3\">"+this.message+"</td>";

                trs+= "<td style=\"color:#48ea6e;margin-right:20px;font-size:30px;font-weight:bold\">" +
                    "<span onclick='gotoNews("+this.id+");'>√</span>"
                trs+= "<td style=\"color:#fa6e6e;font-size:30px;font-weight:bold\">" +
                    "<span onclick='delNews("+this.id+");'>×</span>";

                trs+="</tr>";

            })
            $("table").html(trs);

        //分页
        var lis ="";
        lis += "<li class=\"div_floor_siez\"><p  onclick=\"toPage(1)\">首页</p></li>" ;
        lis += "<li class=\"div_floor_siez\"><p  onclick=\"toPage("+rel.pages+")\">尾页</p></li>" ;
        lis += "<li class=\"div_floor_siez\"><p  onclick=\"toPage("+((rel.pageNum-1)<1?rel.pages:(rel.pageNum-1))+")\">上一页</p></li>" ;
        lis += "<li class=\"div_floor_siez\"><p  onclick=\"toPage("+((rel.pageNum+1)>rel.pages?1:(rel.pageNum+1))+")\">下一页</p></li>" ;
        $("#page").html(lis);
        }
    })
}

function gotoNews() {
    var data = $("#ccc").serialize();
    $.ajax("gotoNews",{
        data:data,
        type: "post",
        success:function (rel) {
            if (rel){
                window.alert("Vitory!");
            }else {
                window.alert("Defeat！");
            }
            getTFriendNewsList();
        }
    })
}

function delNews(id) {
    $.ajax("delNews",{
        data:{"id":id},
        type: "post",
        success:function (rel) {
            if (rel){
                window.alert("Vitory");
            }else {
                window.alert("Defeat");
            }
            getTFriendNewsList();
        }
    })
}