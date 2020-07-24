function share() {
    var pageNum = $("input[name='pageNow']").val();
    $.ajax("getTFriendList",{
        data: {"pageNum":pageNum},
        type:"post",
        success:function (rel) {
            console.log(rel)
            var divs="";
            var divss="";
            $(rel.list).each(function () {

                divs+="<div class=\"z5\" style=\"position:relative;top:-50px;left:100px\"> VIP>添加好友>添加 "+ this.userId.username+ "</div>";

                divss+="<div class=\"zc\">";
                divss+="<div class=\"zc\" style=\"padding:10px\">"+this.userId.username+"</div>";
                divss+="<div class=\"zc\" style=\"padding:10px\">"+this.userId.loginname+"</div>";
                divss+="<div class=\"zc\" style=\"padding:10px\">"+(this.userId.sex==1?'男':'女')+"</div>";
                divss+="</div>";
                $("input[name='replyId']").val(this.userId.id);
            })

            $(".z5").html(divs);
            $(".zc").html(divss);
        }
    })
}

function sendNews() {
    var data = $("#thisform").serialize();
    $.ajax("sendNews",{
        data:data,
        type: "post",
        success:function (rel) {
            alert("分享已发送！");
            window.location.href='myFriend.jsp';
        }
    })
}

