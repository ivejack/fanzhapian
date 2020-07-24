//查询陌生人
function getTAddFriendList() {
    var pageNum = $("input[name='pageNow']").val();
    $.ajax("getTAddFriendList",{
        data: {"pageNum":pageNum},
        type:"post",
        success:function (rel) {
            console.log(rel);
            var trs="";
            $(rel.list).each(function () {
                trs+="<tr>";
                trs+="<td img></td>";
                trs+="<td class=\"z3\">"+this.userId.username+"</td>";
                trs+="<td class=\"z3\">"+(this.userId.sex==1?'男':'女')+"</td>";
                trs+="<td class=\"z3\">"+this.userId.loginname+"</td>";
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