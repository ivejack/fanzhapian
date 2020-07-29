//查询所有好友消息
function getSendFriendNewsList() {
   var id  = getUrlParam("id");
    $.ajax("getonefriendtouser",{
        data: {"id":id},
        type:"post",
        success:function (rel) {
            console.log(rel)
            var divs="";
            $(rel).each(function () {
                $("input[name='userid']").val(this.id);
                divs+="<div class='zc'>用户名："+this.username+"</div>";
                divs+="<div class='zc'>性别："+(this.sex==1?'男':'女')+"</div>";
                divs+="<div class='zc'>账号："+this.loginname+"</div>";
            })
            $(".zc").html(divs);
        }
    })
}

function sendNews() {
    var data = $("#thisform").serialize();
    // console.log(data)
    $.ajax("sendNews",{
        data:data,
        type: "post",
        success:function (rel) {
            confirm("申请已发送！");
            window.location.href='myFriend.jsp';
        }
    })
}

