//登陆
function loginuser() {
    var data = $("#loginForm").serialize();
    // console.log(data);
    $.ajax("login.action",{
        data:data,
        type:"post",
        success:function (rel) {
            if (rel.flag==false){
                confirm("用户名密码错误，请重新登陆");
                window.location.reload();
            }else {
                confirm("欢迎进入");
                window.location.href="main.jsp";
            }
        }
    })
}

//后台登陆
function adminuser() {
    var data = $("#loginForm").serialize();
    $.ajax("admin.action",{
        data:data,
        type:"post",
        success:function (rel) {
            if (rel.flag ==false || rel.flags == false){
                confirm("用户名密码错误或无权限登录，请重新登陆");
                window.location.reload();
            }else {
                confirm("欢迎进入");
                window.location.href="sys/admin.jsp";
            }
        }
    })
}

//用户管理
function usermanager() {
   var data = $("#testForm").serialize();
   $.ajax("usermanager",{
       data:data,
       type: "post",
       success:function (rel) {
            // console.log(rel);
           var trs ="";
           var pages="";
           $(rel.records).each(function (i) {
               trs+=" <tr>";
               trs+="<td>"+(i+1)+"</td>";
               trs+="<td>"+this.username+"</td>";
               trs+="<td>"+this.loginname+"</td>";
               trs+="<td>"+this.password+"</td>";
               trs+="<td>"+this.phone+"</td>";
               trs+="<td>"+(this.sex==0?'男':'女')+"</td>";
               trs+="<td>"+getAge(this.birthday)+"</td>";
               trs+="<td>"+(this.statu==0?'注销':'启用')+"</td>";
               trs+="<td>"+this.startTime+"</td>";
               trs+="<td>"+this.endTime+"</td>";
               if (this.statu==0){
                   trs+="<td><span onclick=\"updOrdel(this,"+this.id+")\" >启用</span>";
               }else {
                   trs+="<td><span onclick=\"updOrdel(this,"+this.id+")\" >注销</span>";
               }
               trs+="</tr>";
           })
           $("tbody").html(trs);
           pages +="<span onclick='toPage(1)'>首页</span>";
           pages +="<span onclick='toPage("+rel.pages+")'>尾页</span>";
           pages +="<span onclick='toPage("+((rel.current-1)<1?rel.pages:(rel.current-1))+")'>上一页</span>";
           pages +="<span onclick='toPage("+((rel.current+1)>rel.pages?1:(rel.current+1))+")'>下一页</span>";
           $("#page").html(pages);
       }
   })
}
//分页
function toPage(pageNum) {
    $("input[name='pageNum']").val(pageNum);
    usermanager();
}
//注销，启用
function updOrdel(e,id) {
    $.ajax("userUpdOrdel",{
        data:{"id":id,"statu":e.innerText},
        type:"post",
        success:function (rel) {
            if(e.innerText=="启用"){
                if (rel){
                    confirm("启用成功");
                }else {
                    confirm("启用失败");
                }
            }else {
                if (rel){
                    confirm("注销成功");
                }else {
                    confirm("注销失败");
                }
            }
            usermanager();
        }
    })
}