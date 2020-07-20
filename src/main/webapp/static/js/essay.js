//查询所有文章，模糊，分页
function getTEssayList() {
    var title = $("#essaySearch").val();
    var pageNum = $("input[name='pageNow']").val();
    $.ajax("getTEssayList",{
        data: {"title":title,"pageNum":pageNum},
        type:"post",
        success:function (rel) {
            //console.log(rel);
            var divs="";
            var trs="";
            $(rel.list).each(function () {
                divs+="<div class=\"div_6_1\" onclick=\"window.location.href='essayContent.jsp?essayid=" + this.id+ "';\">";
                divs+="<div class=\"div_6_1_imgDiv \"></div>";
                divs+="<div class=\"div_fs \">"+this.title+"</div>";
                divs+="<div class=\"div_fs \">";
                divs+="<div class=\"div_6_a \">作者："+this.user.username+"</div>";
                divs+="</div>";
                divs+="</div>";

                trs+="<tr>";
                trs+="<td class=\"div_td  textac\"><a href=\"#\" onclick=\"window.location.href='essayContent.jsp?essayid=" + this.id+ "';\" class=\"tdec\">"+this.title+"</a></td>";
                trs+="<td class=\"div_td  textar\"><a href=\"#\" onclick=\"window.location.href='essayContent.jsp?essayid=" + this.id+ "';\" class=\"tdec\">"+this.createtime+"</a></td>";
                trs+="</tr>";

            })
            $(".div_6").html(divs);
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

function toPage(page) {
   var dd = $("input[name='pageNow']").val(page);
   //console.log(dd.val());
   getTEssayList();
}

//单个查询
function getOneEssay(id) {
    $.ajax("getOneEssay",{
        data:{"id":id},
        type: "post",
        success:function (rel) {
            //console.log(rel);
            $(".div_1_2").text(rel.title);
            $(".div_2").text(rel.content);
        }
    })

}


//举报
function addTheck() {
    var id = getUrlParam("essayid");
     //alert(id);
    $.ajax("addTheck",{
        data:{"id":id},
        type:"post",
        success:function (rel) {
            // console.log(rel);
            if (rel){
                window.confirm("举报成功！！！");
            }else {
                window.confirm("举报失败！！！")
            }
            window.location.href="main.jsp";
        }
    })

}

//发表文章
function publishEssay() {
    var data = $("#publishEssay").serialize();
    // console.log(data);
    $.ajax("publishEssay",{
        data:data,
        type:"post",
        success:function (rel) {
            if (rel){
                confirm("已发表，待审核");
                window.location.href='main.jsp';
            }else {
                confirm("发表失败，请重新发表！！！");
                window.location.reload();
            }
        }
    })
}

//后台管理
function getTEssayByLikeAndPageManager() {
    var title = $("#essaySearch").val();
    var pageNum = $("input[name='pageNum']").val();
    $.ajax("getTEssayByLikeAndPageManager",{
        data: {"title":title,"pageNum":pageNum},
        type:"post",
        success:function (rel) {
            console.log(rel);
            var trs ="";
            var pages="";
            $(rel.list).each(function (i) {
                trs+=" <tr>";
                trs+="<td>"+(i+1)+"</td>";
                trs+="<td>"+this.user.username+"</td>";
                trs+="<td>"+this.title+"</td>";
                trs+="<td>"+this.content+"</td>";
                trs+="<td>"+(this.statu==1?'已发表':'未发表')+"</td>";
                trs+="<td>"+this.createtime+"</td>";
                if(this.statu==1){
                    trs+="<td><span onclick='updOrdel(this,"+ this.id +")'>不发表</span></td>";
                }else {
                    trs+="<td><span onclick='updOrdel(this,"+ this.id +")'>发表</span></td>";
                }
                trs+="</tr>";
            })
            $("tbody").html(trs);
            pages +="<span onclick='toPages(1)'>首页</span>";
            pages +="<span onclick='toPages("+rel.pages+")'>尾页</span>";
            pages +="<span onclick='toPages("+((rel.pageNum-1)<1?rel.pages:(rel.pageNum-1))+")'>上一页</span>";
            pages +="<span onclick='toPages("+((rel.pageNum+1)>rel.pages?1:(rel.pageNum+1))+")'>下一页</span>";
            $("#page").html(pages);
        }
    })
}

function toPages(page) {
    var dd = $("input[name='pageNum']").val(page);
    //console.log(dd.val());
    getTEssayByLikeAndPageManager();
}

function updOrdel(e,id) {
    // console.log(e.innerText);
    $.ajax("updOrdel",{
        data:{"id":id,"statu":e.innerText},
        type:"post",
        success:function (rel) {
            if(e.innerText=="发表"){
                if (rel){
                    confirm("发表成功");
                }else {
                    confirm("发表失败");
                }
            }else {
                if (rel){
                    confirm("不发表成功");
                }else {
                    confirm("不发表失败");
                }
            }
            getTEssayByLikeAndPageManager();
        }
    })
}