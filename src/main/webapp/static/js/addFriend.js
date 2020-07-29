//查询陌生人
function getTAddFriendList() {
    var data =$("#testForm").serialize();
    $.ajax("getTAddFriendList",{
        data: data,
        type:"post",
        success:function (rel) {
            // console.log(rel);
            var trs="";
            $(rel.records).each(function () {
                trs+="<tr>";
                trs+="<td class=\"z3\">"+this.username+"</td>";
                trs+="<td class=\"z3\">"+(this.sex==1?'男':'女')+"</td>";
                trs+="<td class=\"z3\">"+this.loginname+"</td>";
                trs+="<td class=\"z3\" onclick='addfriend("+this.id+")'>添加</td>";
                trs+="</tr>";
            })
            $("tbody").html(trs);
            //分页
            var lis ="";
            lis += "<li class=\"div_floor_siez\"><p  onclick=\"toPage(1)\">首页</p></li>" ;
            lis += "<li class=\"div_floor_siez\"><p  onclick=\"toPage("+rel.pages+")\">尾页</p></li>" ;
            lis += "<li class=\"div_floor_siez\"><p  onclick=\"toPage("+((rel.current-1)<1?rel.pages:(rel.current-1))+")\">上一页</p></li>" ;
            lis += "<li class=\"div_floor_siez\"><p  onclick=\"toPage("+((rel.current+1)>rel.pages?1:(rel.current+1))+")\">下一页</p></li>" ;
            $("#page").html(lis);
        }
    })
}
//分页
function toPage(pageNum) {
    $("input[name='pageNum']").val(pageNum);
    getTAddFriendList();
}
//
function addfriend(id) {
    window.location.href="sendFriendNews.jsp?id="+id;
}